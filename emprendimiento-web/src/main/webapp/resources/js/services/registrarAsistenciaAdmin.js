/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('.selectpicker').selectpicker();
    //$("#btnFuncionarios").on("click", cargarFuncionarios);

    $("select[name='idcajacompensacion']").change(function () {
        cargarFuncionarios();
    });

    $("#btnConsulta").on("click", consultarSesiones);
    //window.onload= funcion3();

});


function cargarFuncionarios() {
    var idcajacompensacion = $("#idcajacompensacion").val();

    $.post(context + "/traerSesiones", {idcajacompensacion: idcajacompensacion},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Sesiones");
            });

}

function consultarSesiones() {
    var idcajacompensacion = $("#idcajacompensacion").val();
    var idfuncionario = $("#idfuncionario").val();

    $.post(context + "/traerSesiones", {idcajacompensacion: idcajacompensacion,
        idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Sesiones");
    });

}