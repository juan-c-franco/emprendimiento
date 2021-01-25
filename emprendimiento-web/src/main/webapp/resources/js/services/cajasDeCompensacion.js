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
    var idcajacompensacion = $(this).data('index');
    modificarCaja(idcajacompensacion);
});
function modificarCaja(idcajacompensacion) {
    $(".preloader").fadeIn();
    $.get(context + "/modificarCajaCompensacion", {idcajacompensacion: idcajacompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Editar Caja de Compensación");
        $(".preloader").fadeOut();
    });
}

$("#btn-agregar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    $.get(context + "/registroCajaCompensacion", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Caja de Compensación");
        $(".preloader").fadeOut();
    });

});
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();
});
