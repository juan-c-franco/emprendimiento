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
            modificarModulo();
        }
    });
    $("#btn-Cancelar").on("click", cancelar);
});

function modificarModulo() {
    var nombremodulociclo = $("#nombremodulociclo").val();
    var idcapacitacionprograma = $("#idcapacitacionprograma").val();
    var intensidadhoraria = $("#intensidadhoraria").val();

    $(".preloader").fadeIn();
    $.post(context + "/modificarModuloCiclo", {nombremodulociclo: nombremodulociclo,
        idcapacitacionprograma: idcapacitacionprograma, intensidadhoraria: intensidadhoraria,
        idmodulociclo: idmodulociclo}, function (data) {
        $(".preloader").fadeOut();
        if (data.status === '1') {
            swal({
                title: "Módulo Actualizado",
                text: data.descripcion,
                type: "success",
                confirmButtonText: "Ok",
                showCancelButton: false
            }, function (isConfirm) {
                if (isConfirm) {
                    $(".preloader").fadeIn();
                    $("#body_content").load(context + '/moduloCiclo');

                }
            });
        } else if (typeof data === "string") {
            swal({
                title: "Error Actualizando Módulo",
                text: _mensajes.sesionExpiro,
                type: "error",
                confirmButtonText: "Aceptar"
            }, function () {
                location.replace(context + "/mostrarLogin");
            });
        } else {
            swal({
                title: "Error Actualizando Módulo",
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
    $.get(context + "/moduloCiclo", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Módulo / Ciclo");
        $(".preloader").fadeOut();
    });

}




