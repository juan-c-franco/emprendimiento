/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var maxLength = 500;
$(function () {
    $('#descripcion').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#chars').text(length);
    });
    $('.selectpicker').selectpicker();
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");
        if (!validationError) {
            registrarCategoria();
        }
    });
    $("#btn-Cancelar").on("click", cancelar);
});

function registrarCategoria() {
    var nombrecategoria = $("#nombrecategoria").val();
    var porcentajeaprobacion = $("#porcentajeaprobacion").val();
    var calificacionaprobacion = $("#calificacionaprobacion").val();
    var descripcion = $("#descripcion").val();

    $(".preloader").fadeIn();
    $.post(context + "/crearCategoria", {nombrecategoria: nombrecategoria,
        porcentajeaprobacion: porcentajeaprobacion, calificacionaprobacion: calificacionaprobacion, descripcion: descripcion}, function (data) {
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
                title: "Categoría Registrada",
                text: data.descripcion,
                type: "success",
                confirmButtonText: "Ok",
                showCancelButton: false
            }, function (isConfirm) {
                if (isConfirm) {
                    $(".preloader").fadeIn();
                    $("#body_content").load(context + '/categorias');

                }
            });
        } else {
            swal({
                title: "Error Registrando Categoría",
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
    $.get(context + "/categorias", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Categorías");
        $(".preloader").fadeOut();
    });

}


