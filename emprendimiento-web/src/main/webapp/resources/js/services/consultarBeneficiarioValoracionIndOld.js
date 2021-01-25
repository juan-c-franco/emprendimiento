/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var beneficiario = {};
var index = 0;
$(function () {
    $('.onlyNumber').mask('000000000000000');
    $("#btnFuncionarios").on("click", cargarFuncionarios);
    $("#btnConsulta").on("click", consulta);
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
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
    var idfuncionario = $("#idfuncionario").val();
    var idcajacompensacion = $("#idcajacompensacion").val();
    if (doc === "") {
        alert("Por favor agregue un numero de documento");
        return false;
    }
    if (doc) {
        $.get(context + "/findBeneficiarioXDocValo", {doc: doc, url: "valoracionIndividualAdmin",
            idfuncionario: idfuncionario, idcajacompensacion: idcajacompensacion},
                function (data) {
                    $("#body_content").html(data);
                    $("#idPage").html("Beneficiarios");
                    beneficiario = data.beneficiarios;
                });
    }
}

function buscarXNombreYApellido() {

    var nombre = $("#nombre").val();
    var apellido = $("#apellido").val();
    var idfuncionario = $("#idfuncionario").val();
    var idcajacompensacion = $("#idcajacompensacion").val();
    if (nombre === "") {
        alert("Por favor agregue un nombre");
        return false;
    }
    if (apellido === "") {
        alert("Por favor agregue un apellido");
        return false;
    }
    $.get(context + "/getBeneficiarioPorNombreYApellidoValo",
            {nombre: nombre, apellido: apellido, url: "valoracionIndividualAdmin",
                idfuncionario: idfuncionario, idcajacompensacion: idcajacompensacion},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Beneficiarios");
            });
}
function cargarFuncionarios() {
    var idcajacompensacion = $("#idcajacompensacion").val();


    $.post(context + "/valoracionIndividual", {idcajacompensacion: idcajacompensacion},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Valoracion Individual");
            });

}
function consulta() {
    var idcajacompensacion = $("#idcajacompensacion").val();
    var idfuncionario = $("#idfuncionario").val();


    $.post(context + "/valoracionIndividual", {idcajacompensacion: idcajacompensacion, idfuncionario: idfuncionario},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Valoracion Individual");
            });

}
$(".btn-valorar").on('click', function (e) {
    e.preventDefault();
    var idBeneficiario = $(this).data('index');
    var idFuncionario = $(this).data('index2');
    valorar(idBeneficiario, idFuncionario);
});

function  valorar(idBeneficiario, idFuncionario) {

    $.get(context + "/traerValoracionIndividual", {idBeneficiario: idBeneficiario, idFuncionario: idFuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Valoracion individual");
    });
}

