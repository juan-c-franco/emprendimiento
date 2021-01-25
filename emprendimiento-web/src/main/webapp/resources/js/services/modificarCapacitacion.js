/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('.selectpicker').selectpicker();
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");
        if (!validationError) {
            registrarCapacitacion();
        }
    });
    $("#btn-Cancelar").on("click", cancelar);
});

function registrarCapacitacion() {
    var nombreCapacitacion = $("#nombreCapacitacion").val();
    var idOferenteInstitucion = $("#idOferenteInstitucion").val();
    var categorias = $("#categorias").val();
    var estados = $("#estados").val();


    $(".preloader").fadeIn();
    $.post(context + "/modificarCapacitacionPrograma", {nombrecapacitacionprograma: nombreCapacitacion,
        idoferenteinstitucion: idOferenteInstitucion, idcategoria: categorias,
        idcapacitacionprograma: idcapacitacionprograma, estados: estados}, function (data) {
        $(".preloader").fadeOut();
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
        if (data.status === '1') {
            swal({
                title: "Capacitación Actualizada",
                text: data.descripcion,
                type: "success",
                confirmButtonText: "Ok",
                showCancelButton: false
            }, function (isConfirm) {
                if (isConfirm) {
                    $(".preloader").fadeIn();
                    $("#body_content").load(context + '/capacitacionPrograma');

                }
            });
        } else {
            swal({
                title: "Error Actualizando Capacitación",
                text: data.descripcion,
                type: "error",
                confirmButtonText: "Ok",
                showCancelButton: false

            });
        }
    }).fail(function (xhr, status, error) {
        swal({
            title: "Adjuntar Documento",
            text: error,
            type: "error",
            confirmButtonText: "Aceptar"
        });
    });
}
function cancelar() {
    $(".preloader").fadeIn();
    $.get(context + "/capacitacionPrograma", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Capacitación / Programa");
        $(".preloader").fadeOut();
    });

}

