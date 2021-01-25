/* global context, moment, FullCalendar, bootbox */

var args;
var idSession;
var temasPendientes = [];
$(function () {
    $("#btnValidarDisponibilidad").on("click", validarDisponibilidad);
    $("#btnSeleccionarCaja").on("click", seleccionarCaja);

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
                    refrescarModalAgendamiento();
                    $("#modalAgendamiento").modal("show");
                    $('#consultarBeneficiario').on('click', function (e) {
                        e.preventDefault();
                        $("#consultarBeneficiario").prop("disabled", true);
                        if (!validationFormErrors(e, "#divConsulta")) {
                            consultarBeneficiario($("#numeroDocumento").val());
                        }
                        $("#consultarBeneficiario").prop("disabled", false);
                    });
                    $('#agendarSesionAAT').on('click', function (e) {
                        e.preventDefault();
                        $("#agendarSesionAAT").prop("disabled", true);
                        if (!validationFormErrors(e, "#modalAgendamiento")) {
                            agendarSesionAAT(idSession, $("#temaAATId").val(), $("#idEmprendimiento").val(), function (respuesta) {
                                if (respuesta.status == "1") {
                                    swal({
                                        title: "Agendar Sesión",
                                        text: _mensajes.programarSesionAATOK,
                                        type: "success",
                                        confirmButtonText: "Aceptar"
                                    }, function () {
                                        $(".preloader").fadeIn();
                                        location.replace(context + "/");
                                    });
                                    calendar.unselect();
                                } else {
                                    swal({
                                        title: "Agendar Sesión",
                                        text: respuesta.descripcion,
                                        type: "error",
                                        confirmButtonText: "Aceptar"
                                    });
                                }
                            });
                        }
                        $("#agendarSesionAAT").prop("disabled", false);
                    });
                }
            });
            calendar.render();
        });
    }
    $(".preloader").fadeOut();
});

function validarDisponibilidad() {
    var cajaId = idcajacompensacion;
    var asistenteTecnicoId = idfuncionario;
//    var cajaId = $("#idCajaCompensacion").val();
//    var asistenteTecnicoId = $("#asistenteTecnicoId").val();
    if (asistenteTecnicoId === "") {
        swal({
            title: "Agendar Sesión",
            text: _mensajes.funcionarioObligatorio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
//        bootbox.alert("Funcionario asistente técnico obligatorio");
    } else {
        $.get(context + "/agendarSesionAAT",
                {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Asistente - Agendar Sesión Asistencia Técnica");
        });
    }
}

function seleccionarCaja() {
    var cajaId = $("#cajaId").val();
    $.get(context + "/agendarSesionAAT",
            {cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Caja - Agendar Sesión Asistencia Técnica");
    });
}

function loaderSesionesAAT(s) {
    var sesionesAAT = [];
    var asistenteTecnicoId = idfuncionario;
    jQuery.ajax({
        method: "POST",
        url: context + "/cargarSesionesProgramadasAAT",
        dataType: "json",
        async: false,
        data: {asistenteTecnicoId: asistenteTecnicoId},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result = result.sesionesAATDTO;
                result.forEach(function (item, index, array) {
                    var sesion = {};
                    sesion.id = Number(item.idsesionacompanamientoat);
//            sesion.title = item.ubicacion;
                    sesion.className = 'bg-disponible';
                    sesion.start = moment(new Date(item.fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                    sesion.end = moment(new Date(item.fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                    sesion.title = "Disponible: " + Math.abs((new Date(item.fechafinal) - new Date(item.fechainicio)) / 36e5).toFixed(1) + "h";
                    sesionesAAT.push(sesion);
                });
                s(sesionesAAT);
            } else {
                swal({
                    title: "Programar Sesión",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function (isConfirm) {
                    if (isConfirm) {
                        $(".preloader").fadeIn();
                        location.replace(context + "/");
                    }
                });
            }
        },
        error: function (error) {
            swal({
                title: "Programar Sesión",
                text: _mensajes.errorCargaSesiones,
                type: "error",
                confirmButtonText: "Aceptar"
            }, function (isConfirm) {
                if (isConfirm) {
                    $(".preloader").fadeIn();
                    location.replace(context + "/");
                }
            });
        }
    });
}

function consultarBeneficiario(numeroDocumento) {
    jQuery.ajax({
        type: "POST",
        url: context + "/consultarBeneficiarioAAT",
        dataType: "json",
        async: false,
        data: {numeroDocumento: numeroDocumento},
        success: function (data) {
            $("#temaAATId").empty();
            if (data.status == "1") {
                data = data.asistenciaTecnicaComplex;
                $("#divDatosAgendamiento").attr("hidden", false);
                $("#agendarSesionAAT").attr("hidden", false);
                $("#nombreBeneficiario").val(data.beneficiarioAAT.nombres + ' ' + data.beneficiarioAAT.apellidos);
                $("#emailBeneficiario").val(data.beneficiarioAAT.email);
                $("#celularBeneficiario").val(data.beneficiarioAAT.telefono);
                $("#fechaRegistroBeneficiario").val(data.beneficiarioAAT.fecharegistro);

                $("#idEmprendimiento").val(data.emprendimientoAAT.idemprendimiento);
                $("#nombreEmprendimiento").val(data.emprendimientoAAT.nombreemprendimiento);
                $("#tipoEmprendimiento").val(data.emprendimientoAAT.tipoemprendimiento);
                $("#estadoEmprendimiento").val(data.emprendimientoAAT.estadoemprendimiento);
                $("#fechaRegistroEmprendimiento").val(data.emprendimientoAAT.fecharegistro);

                $("#temaAATId").append("<option value='' selected='selected' label='Seleccione ...'>Seleccione ...</option>");
                $.each(data.temasRutasAAT, function (key, tema) {
                    $("#temaAATId").append('<option value=' + tema.idtemarutaacompanamientoat + '>' + tema.temasevaluacion.nombretema + ' -- (' + tema.cantidadhorasplaneadas + ' horas planeadas)' + ' -- (' + tema.cantidadHorasEjecutadas + ' horas ejecutadas)' + '</option>');
                    var id = tema.idtemarutaacompanamientoat;
                    if (tema.cantidadHorasEjecutadas < tema.cantidadhorasplaneadas) {
                        temasPendientes.push(id);
                    }
                });
            } else {
                $("#divDatosAgendamiento").attr("hidden", true);
                $("#agendarSesionAAT").attr("hidden", true);
                $("#nombreBeneficiario").val('');
                $("#emailBeneficiario").val('');
                $("#celularBeneficiario").val('');
                $("#fechaRegistroBeneficiario").val('');

                $("#idEmprendimiento").val('');
                $("#nombreEmprendimiento").val('');
                $("#tipoEmprendimiento").val('');
                $("#estadoEmprendimiento").val('');
                $("#fechaRegistroEmprendimiento").val('');
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.noResultadosAAT,
                    type: "warning",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.errorCargaBeneficiario,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/");
                });
            }
        }
    });
}

function refrescarModalAgendamiento() {
    $("#numeroDocumento").val('');
    $("#divDatosAgendamiento").attr("hidden", true);
    $("#agendarSesionAAT").attr("hidden", true);
    $("#nombreBeneficiario").val('');
    $("#emailBeneficiario").val('');
    $("#celularBeneficiario").val('');
    $("#fechaRegistroBeneficiario").val('');

    $("#idEmprendimiento").val('');
    $("#nombreEmprendimiento").val('');
    $("#tipoEmprendimiento").val('');
    $("#estadoEmprendimiento").val('');
    $("#fechaRegistroEmprendimiento").val('');
}

function agendarSesionAAT(idSesionAAT, temaAATId, idEmprendimiento, respuestaSW) {
    var ok = false;
    temasPendientes.forEach(function (item) {
        if (item == temaAATId) {
            ok = true;
        }
    });
    if (!ok) {
        swal({
            title: "Agendar Sesión",
            text: _mensajes.horasPlanteadasCumplidas,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }
    jQuery.ajax({
        type: "POST",
        url: context + "/agendarSesionAAT",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idSesionAAT: idSesionAAT, temaAATId: temaAATId, idEmprendimiento: idEmprendimiento},
        success: function (data) {
            $("#modalAgendamiento").modal("hide");
            respuestaSW(data);
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                errorMsg(_mensajes.errorCargaBeneficiario);
            }
        }
    });
}
