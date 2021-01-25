/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global context, moment, FullCalendar, bootbox */

var args;
var idSession;
var padres;
$(function () {
    $(".preloader").fadeOut();
    $("#btnValidarDisponibilidad").on("click", validarDisponibilidad);
    $("#btnSeleccionarCaja").on("click", seleccionarCaja);
    $("#btnRegistrarAsistencia").on("click", function (e) {
        agregarPadres();
        var validationError = false;
        padres.forEach(function (item) {
            if (validationFormErrors(e, item)) {
                validationError = true;
            }
        });
//        validationError = validationFormErrors(e, "#valora");

        if (!validationError) {
            registrarSesionAAT();
        }
    });
//    $("#btnRegistrarAsistencia").on("click", registrarSesionAAT);

    $("#btnCancelarRegistrarAsistencia").on("click", cancelarRegistrarAsistencia);
    $("body").on("contextmenu", function (e) {
        return false;
    });
//    var idAsistenteTecnico = $("#idAsistenteTecnico").val();
    var idAsistenteTecnico = idfuncionario;
    if (idAsistenteTecnico) {
        loaderSesionesAAT(function (s) {
            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                locale: 'es',
                selectMirror: true,
                contentHeight: 500,
                themeSystem: 'bootstrap4',
                selectable: true,
                StartEditable: false,
                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month, agendaWeek'
                },
                views: {
                    month: {
                        columnHeaderFormat: {
                            weekday: 'long'
                        }
                    },
                    week: {
                        columnHeaderFormat: {
                            day: '2-digit', weekday: 'long'
                        },
                        titleFormat: {year: 'numeric', month: 'long'}
                    }
                },
                events: s, eventClick: function (element) {
                    idSession = element.event.id;
                    var dif = moment(element.event.start) - new Date();
                    var dias = Math.floor(dif / (1000 * 3600 * 24));
                    if (dias >= 0) {
                        alert("No se puede registrar la sesión porqué aún no se lleva acabo");
                    } else {
                        loadSesionAAT();
                        $("#calendar").hide();
                        calendar.unselect();
                    }
                }
            });
            calendar.render();
        });
    }
});
function validarDisponibilidad() {
//    var cajaId = $("#idCajaCompensacion").val();
    var cajaId = idcajacompensacion;
    var asistenteTecnicoId = $("#asistenteTecnicoId").val();
    $(".preloader").fadeIn();
    $.get(context + "/registrarSesionAAT",
            {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Asistente - Registrar Sesión Asistencia Técnica");
        $(".preloader").fadeOut();
    });

}

function seleccionarCaja() {
    var cajaId = $("#cajaId").val();
    $.get(context + "/registrarSesionAAT",
            {cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Caja - Registrar Sesión Asistencia Técnica");
    });
}

function loaderSesionesAAT(s) {
    var sesionesAAT = [];
//    var asistenteTecnicoId = $("#idAsistenteTecnico").val();
    var asistenteTecnicoId = idfuncionario;
    $.post(context + "/cargarSesionesAgendadasAAT", {asistenteTecnicoId: asistenteTecnicoId}, function (data) {
        data.forEach(function (item) {
            var sesion = {};
            sesion.id = Number(item.idsesionacompanamientoat);
            sesion.title = "Registrar Asistencia";
            sesion.start = moment(new Date(item.fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
            sesion.end = moment(new Date(item.fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
            sesion.className = 'bg-registrar';
            sesionesAAT.push(sesion);
        });
        s(sesionesAAT);
    });
}

function loadSesionAAT() {
//    var cajaId = $("#idCajaCompensacion").val();
    var cajaId = idcajacompensacion;
//    var asistenteTecnicoId = $("#idAsistenteTecnico").val();
    var asistenteTecnicoId = idfuncionario;
    $.post(context + "/consultaSesionAATComplexPorId", {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId, idSesionAAT: idSession}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registrar Sesión Acompañamiento y Asistencia Técnica");
    });
}

function registrarSesionAAT() {
//    var cajaId = $("#idCajaCompensacion").val();
//    var asistenteTecnicoId = $("#idAsistenteTecnico").val();

    var cajaId = idcajacompensacion;
    var asistenteTecnicoId = idfuncionario;
    var observacionesSesion = $("#observacionesSesion").val();
    var asistenciaArray = [];
    var existenCamposRequeridos = observacionesSesion === '' ? true : false;

    $('#idTblBeneficiarios > tbody  > tr').each(function (i, row) {
        var idListaAAT = $(row).find("#listaAATId_" + i).val();
        var idBeneficiario = $(row).find("#beneficiarioId_" + i).val();
        var registraAsistencia = $(row).find('input:radio[name=radioAsistencia_' + i + ']:checked').val();
        var jusInasistencia = $(row).find('input:radio[name=radioJustInAsistencia_' + i + ']:checked').val();
        var asistencia = {idListaAAT: idListaAAT, idBeneficiario: idBeneficiario, radioRs: registraAsistencia, jusInasistencia: jusInasistencia};

        asistenciaArray.push(asistencia);

    });
    var sesionRegistrar = {idSesion: idSession, asistenciaArray: asistenciaArray, observacionesSesion: observacionesSesion};
    $.post(context + "/registrarSesionAAT", {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId, sesionRegistrar: JSON.stringify(sesionRegistrar)}, function (data) {
        if (typeof data === "string") {
            swal({
                title: "Error Actualizando Módulo",
                text: _mensajes.sesionExpiro,
                type: "error",
                confirmButtonText: "Aceptar"
            }, function () {
                location.replace(context + "/mostrarLogin");
            });
        }
        if (data.status === "1") {
            swal({
                title: "Registrar Asistencia",
                text: _mensajes.registrarAsistenciaExito,
                type: "success",
                confirmButtonText: "Aceptar"
            }, function () {
//                $.get(context + "/registrarSesionAAT", {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
                $.get(context + "/registrarSesionAAT", {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
                    $("#body_content").html(data);
                    $("#idPage").html("Asistente - Registrar Sesión Asistencia Técnica");
                });

//                loadView('Registrar Asistencia', context + '/registrarSesionAAT');
            });
        } else {
            swal({
                title: "Registrar Asistencia",
                text: data.descripcion,
                type: "error",
                confirmButtonText: "Aceptar"
            });
        }
//                $("#body_content").html(data);
//                $("#idPage").html("Registrar Sesión Acompañamiento y Asistencia Técnica");
    }).fail(function (xhr, status, error) {
        swal({
            title: "Adjuntar Documento",
            text: error,
            type: "error",
            confirmButtonText: "Aceptar"
        });
    });
}

function cancelarRegistrarAsistencia() {
//    var cajaId = $("#idCajaCompensacion").val();
//    var asistenteTecnicoId = $("#idAsistenteTecnico").val();
    var cajaId = idcajacompensacion;
    var asistenteTecnicoId = idfuncionario;
    $.get(context + "/registrarSesionAAT", {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Asistente - Registrar Sesión Asistencia Técnica");
    });
}

function showJusInasistencia(bShow, id) {
    if (!bShow) {
        $("#idDivJustInasistencias_" + id).attr("hidden", true);
//        $("#idJustInAsistenciaSi_" + id).attr('required', '');
//        $("#idJustInAsistenciaNo_" + id).attr('required', '');
//        $("#idJustInAsistenciaSi_" + id).attr('data-validation-required-message', 'Seleccione una opción');
    } else {
        //$("input:radio[name=radioJustInAsistencia_" + id + "]").prop("checked", false);
        $("#idDivJustInasistencias_" + id).attr("hidden", false);
//        $("#idJustInAsistenciaSi_" + id).removeAttr('required');
//        $("#idJustInAsistenciaNo_" + id).removeAttr('required');
//        $("#idJustInAsistenciaSi_" + id).removeAttr('data-validation-required-message');
    }
}

function agregarPadres() {
    padres = ["#divObservaciones"];
    $('#idTblBeneficiarios .fila').each(function (a, b) {
        padres.push("#asistenciaRow" + a);
        if ($("input[name='radioAsistencia_" + a + "']:checked").val() == 0) {
            padres.push("#justificacionRow" + a);
        }
    });
}

