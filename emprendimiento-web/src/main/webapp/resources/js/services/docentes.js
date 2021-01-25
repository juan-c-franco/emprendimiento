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
    modificarDocente(id);
});
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();
});
$("#btn-agregar").on('click', function () {
    $(".preloader").fadeIn();
    $.get(context + "/registroDocentes", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Docente");
        $(".preloader").fadeOut();
    });

});

function modificarDocente(id) {
    $(".preloader").fadeIn();
    $.get(context + "/modificarDocente", {iddocente: id}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Editar Docente");
        $(".preloader").fadeOut();
    });
}



