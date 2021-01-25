/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#btnFuncionarios").on("click", cargarFuncionarios);
    $("#btnConsulta").on("click", consultarSesiones);
    //window.onload= funcion3();

});


function cargarFuncionarios() {
    var idcajacompensacion = $("#idcajacompensacion").val();
    var url = $("#url").val();

    $.post(context + "/url", {idcajacompensacion: idcajacompensacion, url: url},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Sesiones");
            });

}

function consultarSesiones() {
    var idcajacompensacion = $("#idcajacompensacion").val();
    var idfuncionario = $("#idfuncionario").val();

    $.post(context + "/url", {idcajacompensacion: idcajacompensacion,
        idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Sesiones");
    });

}
