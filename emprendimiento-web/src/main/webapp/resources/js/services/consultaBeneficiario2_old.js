/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var beneficiario = {};
var index = 0;
$(function () {
    $('.onlyNumber').mask('000000000000000');
    $("#buscarPor").on("change", function () {
        var buscarPor = $("#buscarPor").val();
        if (buscarPor === '0') {
            $("#documento").prop('hidden', true);
            $("#nombre").prop('hidden', true);
            $("#apellido").prop('hidden', true);
        }
        if (buscarPor === '1') {
            $("#documento").prop('hidden', false);
            $("#nombre").prop('hidden', true);
            $("#apellido").prop('hidden', true);
        }
        if (buscarPor === '2') {
            $("#documento").prop('hidden', true);
            $("#nombre").prop('hidden', false);
            $("#apellido").prop('hidden', false);
        }

    });
    $("#btnDoc").on("click", function () {
        var buscarPor = $("#buscarPor").val();
        if (buscarPor === '0') {
            alert("Por favor elija con que parametro quiere buscar al beneficiario");
            return false;
        }
        if (buscarPor === '1') {
            buscarxDoc();
        }
        if (buscarPor === '2') {
            buscarXNombreYApellido();
        }
    });
});


function buscarxDoc() {
    var doc = $("#documento").val();
    if (doc == "") {
        alert("Por favor agregue un numero de documento");
        return false;
    }
    if (doc) {
        $.get(context + "/findBeneficiarioXDoc", {doc: doc, url: "consultaBeneficiario"}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Beneficiarios");
            beneficiario = data.beneficiarios;
        });
    }
}

function buscarXNombreYApellido() {

    var nombre = $("#nombre").val();
    var apellido = $("#apellido").val();
    if (nombre === "") {
        alert("Por favor agregue un nombre");
        return false;
    }
    if (apellido === "") {
        alert("Por favor agregue un apellido");
        return false;
    }
    $.get(context + "/getBeneficiarioPorNombreYApellido",
            {nombre: nombre, apellido: apellido, url: "consultaBeneficiario"}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Beneficiarios");
        beneficiario = data.beneficiarios;
    });
}
function showModal(i) {
    index = i;
    $("#modalRegistro").modal("show");
}
function regBeneficiario() {
    var nombres = $("#nombres" + index).text();
    var apellidos = $("#apellidos" + index).text();
    var aux = nombres.indexOf(" ");
    var aux2 = apellidos.indexOf(" ");
    beneficiario = {
        numeroDocumento: $("#numerodocumento" + index).text(),
        tipoDocumento: $("#nombredocumento" + index).text(),
        primerNombre: nombres.substring(0, aux),
        segundoNombre: nombres.substring(aux + 1, nombres.length),
        primerApellido: apellidos.substring(0, aux2),
        segundoApellido: apellidos.substring(aux2 + 1, apellidos.length),
        telefonoContacto: $("#telefono" + index).text(),
        correoElectronico: $("#email" + index).text()
    };

    if (beneficiario) {
        jQuery.ajax({
            method: "POST",
            url: context + "/regBeneficiario",
            data: JSON.stringify(beneficiario),
            contentType: "application/json",
            dataType: "json",
            async: false,
            success: function (result, status, xhr) {
                beneficiario = result.beneficiario;
                $("#modalRegistro").modal("hide");
                if (result.status == "2") {
                    bootbox.confirm({
                        message: "Usuario ya existente, ¿Desea realizar la agendamiento?",
                        buttons: {
                            confirm: {
                                label: 'Si',
                                className: 'btn-success'
                            },
                            cancel: {
                                label: 'No',
                                className: 'btn-danger'
                            }
                        },
                        callback: function (result) {
                            if (result) {
                                loadView('Agendar Sesión', context + '/consultarAgendaSensibilizacion');
                            }
                        }
                    });
                } else if (result.status == "1") {
                    bootbox.confirm({
                        message: "Registro Sastisfactorio, ¿Desea realizar la agendamiento?",
                        buttons: {
                            confirm: {
                                label: 'Si',
                                className: 'btn-success'
                            },
                            cancel: {
                                label: 'No',
                                className: 'btn-danger'
                            }
                        },
                        callback: function (result) {
                            if (result) {
                                loadView('Agendar Sesión', context + '/consultarAgendaSensibilizacion');
                            }
                        }
                    });
                } else {
                    alert("Error: " + result.descripcion);
                }
            }
        });
    }

}