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

            registrarCaja();

        }
    });
//   $("#btnRegistro").on("click", registrarCaja);
    $("#btn-Cancelar").on("click", cancelar);
});

function registrarCaja() {
    var nombrecajacompensacion = $("#nombrecajacompensacion").val();
    var codigoccf = $("#codigoccf").val();
    var idestadocajacompensacion = $("#idestadocajacompensacion").val();
    var departamento = $("#departamento").val();

//    if (nombrecajacompensacion !== "" && codigoccf !== "") {

    $(".preloader").fadeIn();
    $.post(context + "/registrarCajaCompensacion",
            {nombrecajacompensacion: nombrecajacompensacion, codigoccf: codigoccf,
                idestadocajacompensacion: idestadocajacompensacion, departamento: departamento}, function (data) {
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

