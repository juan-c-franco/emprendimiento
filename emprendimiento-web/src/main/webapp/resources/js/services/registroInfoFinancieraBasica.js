/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(function () {
    var total = parseInt($("#montoAFinanciar").val().replace(/\u200E/g, '') !== "" ? $("#montoAFinanciar").val().replace(/\u200E/g, '') : "0") + parseInt($("#recursosPropios").val().replace(/\u200E/g, '') !== "" ? $("#recursosPropios").val().replace(/\u200E/g, '') : "0");
//    $('#capitalTotal').val(total);
    $("#montoAFinanciar").change(function () {
        var total = parseInt($("#montoAFinanciar").val().replace(/\u200E/g, '') !== "" ? $("#montoAFinanciar").val().replace(/\u200E/g, '') : "0") + parseInt($("#recursosPropios").val().replace(/\u200E/g, '') !== "" ? $("#recursosPropios").val().replace(/\u200E/g, '') : "0");
        $('#capitalTotal').val(total);
    });

    $("#recursosPropios").change(function () {
        var total = parseInt($("#montoAFinanciar").val().replace(/\u200E/g, '') !== "" ? $("#montoAFinanciar").val().replace(/\u200E/g, '') : "0") + parseInt($("#recursosPropios").val().replace(/\u200E/g, '') !== "" ? $("#recursosPropios").val().replace(/\u200E/g, '') : "0");
        $('#capitalTotal').val(total);
    });
//    var total = parseInt($("#montoAFinanciar").val()) + parseInt($("#recursosPropios").val());
    $('#capitalTotal').val(total);
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
    var montofinanciacions = $("#montoAFinanciar").val();
    var idtipofinanciacion = $("#tipoFinanciacion").val();
    var cuotaspactadasS = $("#cuotasPactadas").val();
    var tasaintertess = $("#interes").val();
    var recursospropiosae = $("#recursosPropios").val();
    var empleosporgenerar = $("#empleosXGenerar").val();
    var capitaltrabajo = $("#capitalTrabajo").val();
    var mesespuntoequilibrio = $("#mesesEquilibrio").val();
    var capitaltotal = $("#capitalTotal").val();
    var idEmprendimiento = $("#idEmprendimiento").val();
    var idFuncionario = $("#idFuncionario").val();
    var Aprobado = $("input[name='inlineRadioOptions']:checked").val();
    if (montofinanciacions !== "" && idtipofinanciacion !== "" && cuotaspactadasS !== "" && tasaintertess !== ""
            && recursospropiosae !== "" && empleosporgenerar !== "" && capitaltrabajo !== "" && mesespuntoequilibrio !== ""
            && capitaltotal !== "") {

        $(".preloader").fadeIn();
        $.post(context + "/registroInfoFinancieraBasica",
                {Aprobado: Aprobado, montofinanciacions: montofinanciacions, idtipofinanciacion: idtipofinanciacion,
                    cuotaspactadasS: cuotaspactadasS, tasaintertess: tasaintertess, recursospropiosae: recursospropiosae,
                    empleosporgenerar: empleosporgenerar, capitaltrabajo: capitaltrabajo, mesespuntoequilibrio: mesespuntoequilibrio,
                    capitaltotal: capitaltotal, idFuncionario: idFuncionario, idEmprendimiento: idEmprendimiento}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Registro Informacion Financiera");
            $(".preloader").fadeOut();
        });

    } else {
        alert("Por favor diligencie todos los campos");
        return false;
    }
}
function cancelar() {

    $.get(context + "/infoFinancieraBasica", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro inicial");
    });

}
