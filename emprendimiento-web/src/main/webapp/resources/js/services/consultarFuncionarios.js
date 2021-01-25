/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $(".preloader").fadeOut();
    $(".selectpicker").selectpicker();
    $("#btnConsulta").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            consultarFuncionarios();

        }
    });
    $("#btn-agregar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            agregarFuncionario();

        }
    });

//    $("#btnConsulta").on("click", consultarFuncionarios);
//    $("#btn-agregar").on("click", agregarFuncionario);
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
});

function consultarFuncionarios() {
    var idcajacompensacion = $("#idcajacompensacion").val();
    $(".preloader").fadeIn();
    $.get(context + "/consultarFuncionarios", {idcajacompensacion: idcajacompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Gestion Usuarios");
        $(".preloader").fadeOut();
    });


}
$(".btn-modificar").on('click', function (e) {
    e.preventDefault();
    var idfuncionario = $(this).data('index');
    modificarFuncionario(idfuncionario);
});

function modificarFuncionario(idfuncionario) {

    $(".preloader").fadeIn();
    $.get(context + "/modificarFuncionario", {idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Modificar Funcionario");
        $(".preloader").fadeOut();
    });


}

function agregarFuncionario() {
    var idcajacompensacion = $("#idcajacompensacion").val();

    $(".preloader").fadeIn();
    $.get(context + "/agregarFuncionario", {idcajacompensacion: idcajacompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Funcionario");
        $(".preloader").fadeOut();
    });


}

$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    location.replace(context + "/");

});
