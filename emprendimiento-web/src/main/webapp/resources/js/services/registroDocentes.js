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
            registrarDocente();
        }
    });
    $("#btn-Cancelar").on("click", cancelar);
});

$("#numerodocumento").on("keyup", function (e) {
    var idtipodocumento = $("#idtipodocumento").val();
    var numerodocumento = $("#numerodocumento").val();
    if (idtipodocumento === '2' || idtipodocumento === '4' || idtipodocumento === '6' || idtipodocumento === '8') {
        if (!(/^([0-9])*$/.test(numerodocumento))) {
            continuar = false;
            document.getElementById("numerodocumento").style.borderColor = "#e46a76";
            $("#spanNumeroDocumento").text(_mensajes.documentoInvalido);
            document.getElementById("spanNumeroDocumento").style.color = "#e46a76";
        } else {
            document.getElementById("numerodocumento").style.borderColor = "#00c292";
            $("#spanNumeroDocumento").text("");
        }
    } else {
        document.getElementById("numerodocumento").style.borderColor = "#00c292";
        $("#spanNumeroDocumento").text("");
    }

});
$("#idtipodocumento").on("change", function (e) {
    var idtipodocumento = $("#idtipodocumento").val();
    var numerodocumento = $("#numerodocumento").val();
    if (idtipodocumento === '2' || idtipodocumento === '4' || idtipodocumento === '6' || idtipodocumento === '8') {
        if (!(/^([0-9])*$/.test(numerodocumento))) {
            continuar = false;
            document.getElementById("numerodocumento").style.borderColor = "#e46a76";
            $("#spanNumeroDocumento").text(_mensajes.documentoInvalido);
            document.getElementById("spanNumeroDocumento").style.color = "#e46a76";
        } else {
            document.getElementById("numerodocumento").style.borderColor = "#00c292";
            $("#spanNumeroDocumento").text("");
        }
    } else {
        document.getElementById("numerodocumento").style.borderColor = "#00c292";
        $("#spanNumeroDocumento").text("");
    }
});


function registrarDocente() {

    var primernombre = $("#primernombre").val();
    var segundonombre = $("#segundonombre").val();
    var primerapellido = $("#primerapellido").val();
    var segundoapellido = $("#segundoapellido").val();
    var email = $("#email").val();
    var telefono = $("#telefono").val();
    var numerodocumento = $("#numerodocumento").val();
    var idtipodocumento = $("#idtipodocumento").val();


    var continuar = true;
    if (idtipodocumento === '2' || idtipodocumento === '4' || idtipodocumento === '6' || idtipodocumento === '8') {
        if (!(/^([0-9])*$/.test(numerodocumento))) {
            continuar = false;

            document.getElementById("numerodocumento").style.borderColor = "#e46a76";
            $("#spanNumeroDocumento").text(_mensajes.documentoInvalido);
            document.getElementById("spanNumeroDocumento").style.color = "#e46a76";
        } else {
            document.getElementById("numerodocumento").style.borderColor = "#00c292";
            $("#spanNumeroDocumento").text("");
        }
    }
    if (continuar) {
        $(".preloader").fadeIn();
        $.post(context + "/crearDocente", {primernombre: primernombre, segundonombre: segundonombre,
            email: email, telefono: telefono, numerodocumento: numerodocumento, idtipodocumento: idtipodocumento,
            primerapellido: primerapellido, segundoapellido: segundoapellido}, function (data) {
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
                    title: "Docente Registrado",
                    text: data.descripcion,
                    type: "success",
                    confirmButtonText: "Ok",
                    showCancelButton: false
                }, function (isConfirm) {
                    if (isConfirm) {
                        $(".preloader").fadeIn();
                        $("#body_content").load(context + '/docentes');

                    }
                });
            } else {
                swal({
                    title: "Error Registrando Docente",
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
}

function cancelar() {
    $(".preloader").fadeIn();
    $.get(context + "/docentes", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Docentes");
        $(".preloader").fadeOut();
    });

}