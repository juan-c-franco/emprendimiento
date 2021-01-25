/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('.selectpicker').selectpicker();
    $("#btnModificar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            modificarFuncionario();

        }
    });
    $("#btn-Cancelar").on("click", cancelar);
});
$("#numerodocumento").on("keyup", function (e) {
    var idtipodocumento = $("#idtipodocumento").val();
    var numerodocumento = $("#numerodocumento").val();
    if (idtipodocumento === '2' || idtipodocumento === '6' || idtipodocumento === '8') {
        if (!(/^([0-9])*$/.test(numerodocumento))) {
            continuar = false;
            document.getElementById("numerodocumento").style.borderColor = "#e46a76";
            $("#spanNumeroDocumento").text(_mensajes.documentoInvalido);
            document.getElementById("spanNumeroDocumento").style.color = "#e46a76";
        } else {
            document.getElementById("numerodocumento").style.borderColor = "#00c292";
            $("#spanNumeroDocumento").text("");
        }
    } else if (idtipodocumento === '4') {
        if (!(/(^[0-9]+-{1}[0-9]{1})$/.test(numerodocumento))) {
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

function modificarFuncionario() {
    var email = $("#email").val();
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;

    if (re.test(email)) {
        var idfuncionario = $("#idfuncionario").val();
        var idcajacompensacion = $("#idcajacompensacion").val();
        var primernombre = $("#primernombre").val();
        var segundonombre = $("#segundonombre").val();
        var primerapellido = $("#primerapellido").val();
        var segundoapellido = $("#segundoapellido").val();

        var telefono = $("#telefono").val();
        var numerodocumento = $("#numerodocumento").val();
        var idtipodocumento = $("#idtipodocumento").val();
        var id = $("#id").val();
        var idestadofuncionario = $("#idestadofuncionario").val();
        var contrasena = $(".contrasena input").toArray();
        var contrasenaValue;
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

            contrasena.forEach(function (el) {

                if ($(el).is(":checked")) {
                    contrasenaValue = el.value;
                }
            });
            $(".preloader").fadeIn();
            $.post(context + "/modificarFuncionario2", {idcajacompensacion: idcajacompensacion, primernombre: primernombre, segundonombre: segundonombre,
                primerapellido: primerapellido, segundoapellido: segundoapellido, email: email, telefono: telefono, numerodocumento: numerodocumento, idtipodocumento: idtipodocumento, id: id,
                idestadofuncionario: idestadofuncionario, contrasena: contrasenaValue, idfuncionario: idfuncionario}, function (data) {
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
                        title: "Funcionario Actualizado",
                        text: data.descripcion,
                        type: "success",
                        confirmButtonText: "Ok",
                        showCancelButton: false
                    }, function (isConfirm) {
                        if (isConfirm) {
                            $(".preloader").fadeIn();
                            $("#body_content").load(context + '/gestionarCuentas');

                        }
                    });
                } else {
                    swal({
                        title: "Error Actualizando Funcionario",
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

    } else {
        $("#validacionEmail").text("Email no Valido");
    }




}

function cancelar() {
    $(".preloader").fadeIn();
    $.get(context + "/gestionarCuentas", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Cuentas de Usuario");
        $(".preloader").fadeOut();
    });

}