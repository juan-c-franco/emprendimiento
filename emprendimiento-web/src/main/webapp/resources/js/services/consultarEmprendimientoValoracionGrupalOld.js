/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var index = 0;
$(function () {

    $("#btnFuncionarios").on("click", cargarFuncionarios);
    $("#btnConsulta").on("click", consulta);
    $("#buscarPor").on("change", function () {
        var buscarPor = $("#buscarPor").val();
        if (buscarPor === '0') {
            $("#documento").prop('hidden', true);
            $("#nombreEmprendimiento").prop('hidden', true);

        }
        if (buscarPor === '1') {
            $("#documento").prop('hidden', false);
            $("#nombreEmprendimiento").prop('hidden', true);

        }
        if (buscarPor === '2') {
            $("#documento").prop('hidden', true);
            $("#nombreEmprendimiento").prop('hidden', false);

        }

    });
    $("#btnDoc").on("click", function () {
        var buscarPor = $("#buscarPor").val();
        if (buscarPor === '0') {
            alert("Por favor elija con que parametro quiere buscar el emprendimiento");
            return false;
        }
        if (buscarPor === '1') {
            buscarxDoc();
        }
        if (buscarPor === '2') {
            buscar();
        }
    });


});




function buscar() {

    var nombreEmprendimiento = $("#nombreEmprendimiento").val();
    var idfuncionario = $("#idfuncionario").val();
    var idcajacompensacion = $("#idcajacompensacion").val();
    if (nombreEmprendimiento === "") {
        alert("Por favor agregue un nombre");
        return false;
    }
    $.get(context + "/getEmprendimientoPorNombre",
            {nombreEmprendimiento: nombreEmprendimiento,
                idfuncionario: idfuncionario, idcajacompensacion: idcajacompensacion},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Beneficiarios");
            });
}

function buscarxDoc() {

    var documento = $("#documento").val();
    var idfuncionario = $("#idfuncionario").val();
    var idcajacompensacion = $("#idcajacompensacion").val();
    if (documento === "") {
        alert("Por favor agregue un Numero de documento");
        return false;
    }
    $.get(context + "/getEmprendimientoPorDoc",
            {documento: documento,
                idfuncionario: idfuncionario, idcajacompensacion: idcajacompensacion},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Emprendimientos");
            });
}
function cargarFuncionarios() {
    var idcajacompensacion = $("#idcajacompensacion").val();


    $.post(context + "/valoracionGrupal", {idcajacompensacion: idcajacompensacion},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Valoracion Individual");
            });

}
function consulta() {
    var idcajacompensacion = $("#idcajacompensacion").val();
    var idfuncionario = $("#idfuncionario").val();


    $.post(context + "/valoracionGrupal", {idcajacompensacion: idcajacompensacion, idfuncionario: idfuncionario},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Valoracion Individual");
            });

}

