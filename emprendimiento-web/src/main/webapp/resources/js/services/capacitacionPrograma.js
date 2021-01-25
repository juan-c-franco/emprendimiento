/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $(".preloader").fadeOut();
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
});
$(".btn-modificar").on('click', function (e) {
    e.preventDefault();
    var id = $(this).data('index');
    modificarCapacitacion(id);
});
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();
});
$("#btn-agregar").on('click', function () {
    $(".preloader").fadeIn();
    $.get(context + "/registroCapacitacion", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Capacitación");
        $(".preloader").fadeOut();
    });

});

function modificarCapacitacion(id) {
    $(".preloader").fadeIn();
    $.get(context + "/modificarCapacitacion", {idcapacitacionprograma: id}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Editar Capacitación");
        $(".preloader").fadeOut();
    });
}

