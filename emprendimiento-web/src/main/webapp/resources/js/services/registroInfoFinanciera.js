/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('.selectpicker').selectpicker();
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valida");

        if (!validationError) {

            registrarInfo();

        }
    });
    $("#btn-Cancelar").on("click", cancelar);
//    $("#btnRegistro").on("click", registrarInfo);

});

function registrarInfo() {
    var montoA = $("#montoA").val();
    var idtipofinanciacion = $("#tipoFinanciacion").val();
    var cuotaspactadasa = $("#cuotaspactadasa").val();
    var tasainteresa = $("#tasainteresa").val();
    var identidadfinanciera = $("#identidadfinanciera").val();
    var idEmprendimiento = $("#idEmprendimiento").val();
    var idFuncionario = $("#idFuncionario").val();
    var idfinanciacion = $("#idfinanciacion").val();

    $(".preloader").fadeIn();
    if (idfinanciacion === "") {
        $.post(context + "/registroInfoFinanciera",
                {montoA: montoA, idtipofinanciacion: idtipofinanciacion, cuotaspactadasa: cuotaspactadasa,
                    tasainteresa: tasainteresa, identidadfinanciera: identidadfinanciera, idFuncionario: idFuncionario,
                    idEmprendimiento: idEmprendimiento}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Registro Informacion Financiera");
            $(".preloader").fadeOut();
        });
    } else {
        $.post(context + "/registroInfoFinanciera",
                {montoA: montoA, idtipofinanciacion: idtipofinanciacion, cuotaspactadasa: cuotaspactadasa,
                    tasainteresa: tasainteresa, identidadfinanciera: identidadfinanciera, idFuncionario: idFuncionario,
                    idEmprendimiento: idEmprendimiento, idfinanciacion: idfinanciacion}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Registro Informacion Financiera");
            $(".preloader").fadeOut();
        });
    }



}
function cancelar() {

    $.get(context + "/infoFinanciera", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Financiero");
    });

}
