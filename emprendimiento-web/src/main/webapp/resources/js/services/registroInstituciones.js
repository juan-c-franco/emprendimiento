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
            registrarInstitucion();
        }
    });
    $("#btn-Cancelar").on("click", cancelar);
});

function registrarInstitucion() {
    var nombreInstitucion = $("#nombreInstitucion").val();
    var nit = $("#nit").val();
    var email = $("#email").val();
    var naturalezaJuridica = $("#naturalezaJuridica").val();
    var telefono = $("#telefono").val();
    var origen = $("#origen").val();
    var tipoInstitucion = $("#tipoInstitucion").val();
    var tipoCertificacion = $("#tipoCertificacion").val();
    var estadoAprobacion = $("#estadoAprobacion").val();
    var estado = '1';

    $(".preloader").fadeIn();
    $.post(context + "/crearInstitucionOferente", {nombreInstitucion: nombreInstitucion, nit: nit, email: email,
        naturalezaJuridica: naturalezaJuridica, telefono: telefono, origen: origen, tipoInstitucion: tipoInstitucion, tipoCertificacion: tipoCertificacion,
        estadoAprobacion: estadoAprobacion, estado: estado}, function (data) {
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
                title: "Institución Registrada",
                text: data.descripcion,
                type: "success",
                confirmButtonText: "Ok",
                showCancelButton: false
            }, function (isConfirm) {
                if (isConfirm) {
                    $(".preloader").fadeIn();
                    $("#body_content").load(context + '/institucionesOferentes');

                }
            });
        } else {
            swal({
                title: "Error Registrando Institución",
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
    $.get(context + "/institucionesOferentes", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Instituciones / Oferentes");
        $(".preloader").fadeOut();
    });

}

