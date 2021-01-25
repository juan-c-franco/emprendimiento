/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
});
$(".btn-modificar").on('click', function (e) {
    e.preventDefault();
    var identidadfinanciera = $(this).data('index');
    modificarEntidad(identidadfinanciera);
});
function modificarEntidad(identidadfinanciera) {
    $(".preloader").fadeIn();
    $.get(context + "/modificarEntidadFinanciera", {identidadfinanciera: identidadfinanciera}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Entidades Financieras");
        $(".preloader").fadeOut();
    });
}
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();

});

$("#btn-agregar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    $.get(context + "/registroEntidadFinanciera", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Entidad Financiera");
        $(".preloader").fadeOut();
    });

});