/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* global context, bootbox */

$(function () {

    $('#consultarEmprendimiento').on('click', function (e) {
        e.preventDefault();
        $("#consultarEmprendimiento").prop("disabled", true);
        if (!validationFormErrors(e, "#consultaAAT")) {
            consultarEmprendimiento($("#numeroDocumento").val(), idfuncionario, idcajacompensacion);
        }
        $("#consultarEmprendimiento").prop("disabled", false);
    });

    $("#btnAprobarAvance").on("click", function () {
        var avanceGrupal = $("#avanceGrupal").val();
        if (avanceGrupal >= 80) {
//        aprobarAvance($("#numeroDocumentoTmp").val(), $("#idemprendimiento").val(), $("#idAsistenteTecnico").val(), function (respuesta) {
            aprobarAvance($("#numeroDocumentoTmp").val(), $("#idemprendimiento").val(),
                    idfuncionario, idcajacompensacion, function (respuesta) {
                        if (respuesta.status === "1") {
                            swal({
                                title: "Consultar Avance",
                                text: _mensajes.aproboConsultaAATOK,
                                type: "success",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                loadView('Consultar avance', context + '/cargarDatosConsultarAvancesAAT');
                            });
                        } else {
                            swal({
                                title: "Consultar Avance",
                                text: respuesta.descripcion,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }
                    });
        } else {
            swal({
                title: "Consultar Avance",
                text: _mensajes.avanceGrupal,
                type: "error",
                confirmButtonText: "Aceptar"
            });
        }

    });
//    $("#consultarEmprendimiento").on("click", function () {
//        consultarEmprendimiento($("#numeroDocumento").val(), idfuncionario, idcajacompensacion);
////        consultarEmprendimiento($("#numeroDocumento").val(), $("#idAsistenteTecnico").val(), $("#idCajaCompensacion").val());
//    });
    $("body").on("contextmenu", function (e) {
        return false;
    });
    $(".preloader").fadeOut();
});
function seleccionarAsistente() {
//    var cajaId = $("#idCajaCompensacion").val();
//    var asistenteTecnicoId = $("#asistenteTecnicoId").val();
    var cajaId = idcajacompensacion;
    var asistenteTecnicoId = idfuncionario;
    if (asistenteTecnicoId === "") {
        swal({
            title: "Consultar Avance",
            text: _mensaje.funcionarioObligatorio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
//        bootbox.alert("Funcionario asistente técnico obligatorio");
    } else {
        $.get(context + "/consultarAvanceAAT",
                {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Consultar avance");
        });
    }
}

function seleccionarCaja() {
    var cajaId = $("#cajaId").val();
    $.get(context + "/consultarAvanceAAT",
            {cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Consultar avance");
    });
}

function consultarEmprendimiento(numeroDocumento, idAsistenteTecnico, idCajaCompensacion) {
    $.post(context + "/consultarAvanceAAT", {numeroDocumento: numeroDocumento, idAsistenteTecnico: idAsistenteTecnico, idCajaCompensacion: idCajaCompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Consultar avance");
        $("#numeroDocumento").val($("#numeroDocumentoTmp").val());
    });
}

function aprobarAvance(numeroDocumento, idemprendimiento, idAsistenteTecnico,
        idcajacompensacion, respuestaSW) {
    if (!docSet) {
        swal({
            title: "Aprobar Avance",
            text: _mensajes.seguroAprobarSinDoc,
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "No",
            confirmButtonText: "Si",
        }, function (isConfirm) {
            if (isConfirm) {
                $("preloader").fadeIn();
                $.post(context + "/aprobarAvanceAAT", {numeroDocumento: numeroDocumento,
                    idemprendimiento: idemprendimiento, idcajacompensacion: idcajacompensacion,
                    idAsistenteTecnico: idAsistenteTecnico}, function (respuesta) {
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
                    respuestaSW(respuesta);
                    $("preloader").fadeOut();
                }).fail(function (xhr, status, error) {
                    swal({
                        title: "Adjuntar Documento",
                        text: error,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                });
            }
        });
    } else {
        $("preloader").fadeIn();
        $.post(context + "/aprobarAvanceAAT", {numeroDocumento: numeroDocumento,
            idemprendimiento: idemprendimiento, idcajacompensacion: idcajacompensacion,
            idAsistenteTecnico: idAsistenteTecnico}, function (respuesta) {
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
            respuestaSW(respuesta);
            $("preloader").fadeOut();
        }).fail(function (xhr, status, error) {
            swal({
                title: "Adjuntar Documento",
                text: error,
                type: "error",
                confirmButtonText: "Aceptar"
            });
        });
    }
}