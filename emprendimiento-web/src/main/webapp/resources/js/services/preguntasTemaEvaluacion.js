/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/* global context */
$(function () {
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
    $("#btnAgregar").on("click", agregarPreguntar);
    $("#btnCancelar").on("click", cancelar);
});

function agregarPreguntar() {
    var idTema = $("#idTema").val();
    var idHerramienta = $("#idHerramienta").val();
    var idCajaCompensacion = $("#idCajaCompensacion").val();
    $(".preloader").fadeIn();
    $.post(context + "/agregarPreguntaTema", {idTema: idTema, idHerramienta: idHerramienta,
        idCajaCompensacion: idCajaCompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Agregar Pregunta");
        $(".preloader").fadeOut();
    });
}

function editarPregunta(idPregunta) {
    $(".preloader").fadeIn();
    $.get(context + "/editarPreguntaTema",
            {idPregunta: idPregunta}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Editar Pregunta Tema");
        $(".preloader").fadeOut();
    });
}

//<form:form name="preguntasForm" action="${pageContext.request.contextPath}/agregarPreguntaTema" method="POST">
function cancelar() {
    var tipoHerramienta = $("#tipoHerramienta").val();
    var cajaId = $("#idCajaCompensacion").val();
    $(".preloader").fadeIn();
    $.post(context + "/seleccionarHerramientaEvaluacion",
            {tipoHerramienta: tipoHerramienta, cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Seleccionar Herramiento");
        $(".preloader").fadeOut();
    });
}
//<form:form action="${pageContext.request.contextPath}/seleccionarHerramientaEvaluacion" method="POST">
function borrarPregunta(idPregunta) {

    var idTema = $("#idTema").val();
    var idHerramienta = $("#idHerramienta").val();
    var idCajaCompensacion = $("#idCajaCompensacion").val();
    swal({
        title: "Eliminar Pregunta",
        text: _mensajes.seguroEliminarPregunta,
        type: "info",
        confirmButtonText: "Si",
        showCancelButton: true,
        cancelButtonText: "No"
    }, function (isConfirm) {
        if (isConfirm) {
            $(".preloader").fadeIn();
            $.post(context + "/borrarPreguntaTema",
                    {idPregunta: idPregunta, idTema: idTema, idHerramienta: idHerramienta, idCajaCompensacion: idCajaCompensacion, }, function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Preguntas Tema Evaluación");
                $(".preloader").fadeOut();
            });
        }
    });
}