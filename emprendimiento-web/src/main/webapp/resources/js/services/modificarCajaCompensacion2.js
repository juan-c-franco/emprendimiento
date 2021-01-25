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

            modificarCaja2();

        }
    });

//    $("#btnModificar").on("click", modificarCaja2);
    $("#btn-Cancelar").on("click", cancelar);
});

function modificarCaja2() {

    var idcajacompensacion = $("#idcajacompensacion").val();
    var nombrecajacompensacion = $("#nombrecajacompensacion").val();
    var codigoccf = $("#codigoccf").val();
    var idestadocajacompensacion = $("#idestadocajacompensacion").val();
    var departamento = $("#departamento").val();
//    if (nombrecajacompensacion !== "" && codigoccf !== "") {
    $(".preloader").fadeIn();
    $.post(context + "/modificarCajaCompensacion2", {idcajacompensacion: idcajacompensacion, nombrecajacompensacion: nombrecajacompensacion, codigoccf: codigoccf, idestadocajacompensacion: idestadocajacompensacion,
        departamento: departamento}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Cajas de Compensacion");
        $(".preloader").fadeOut();
    });
//    } else {
//        alert("Por favor diligencie todos los campos");
//        return false;
//    }

}

function cancelar() {
    $(".preloader").fadeIn();
    $.get(context + "/cajasDeCompensacion", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Cajas de Compensacion");
        $(".preloader").fadeOut();
    });

}