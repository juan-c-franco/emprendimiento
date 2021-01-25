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
    $("#btnAgregarTema").on("click", agregarTema);
    $("#btn-Cancelar").on("click", cancelar);
});

function verPreguntas(idTema) {
    var idHerramienta = $("#idHerramienta").val();
    var idCaja = $("#idCaja").val();
    $(".preloader").fadeIn();
    $.post(context + "/preguntasTemaEvaluacion",
            {idTema: idTema, idHerramienta: idHerramienta, idCaja: idCaja}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Parametrizar Temas herramientas");
        $(".preloader").fadeOut();
    });
}
// <form:form name="formPreguntas_${tema.idtema}" action="${pageContext.request.contextPath}/preguntasTemaEvaluacion" method="POST">
function editarTema(idTema) {
    $(".preloader").fadeIn();
    $.get(context + "/editarTemaEvaluacion",
            {idTemaEvaluacion: idTema}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Editar Tema Evaluacion");
        $(".preloader").fadeOut();
    });
}
// <form:form name="formEditarTema_${tema.idtema}" action="${pageContext.request.contextPath}/editarTemaEvaluacion" method="POST">
function agregarTema() {
    var idHerramienta = $("#idHerramienta").val();
    var idCajaCompensacion = $("#idCaja").val();
    $(".preloader").fadeIn();
    $.post(context + "/agregarTemaEvaluacion",
            {idHerramienta: idHerramienta, idCajaCompensacion: idCajaCompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Agregar Tema Evaluacion");
        $(".preloader").fadeOut();
    });
}
// <form:form name="parametrizarTemasHerramientaForm" action="${pageContext.request.contextPath}/agregarTemaEvaluacion" method="POST">
function borrarTema(idTema) {
    var idHerramienta = $("#idHerramienta").val();
    var idCajaCompensacion = $("#idCaja").val();
    swal({
        title: "Eliminar Tema",
        text: _mensajes.seguroEliminarTema,
        type: "info",
        confirmButtonText: "Si",
        showCancelButton: true,
        cancelButtonText: "No"
    }, function (isConfirm) {
        if (isConfirm) {
            $(".preloader").fadeIn();
            $.post(context + "/borrarTemaEvaluacion",
                    {idTemaEvaluacion: idTema, idHerramienta: idHerramienta, idCajaCompensacion: idCajaCompensacion}, function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Parametrizar Temas herramientas");
                $(".preloader").fadeOut();
            });
        }
    });

}

function cancelar() {
    var tipoHerramienta = null;


    $(".preloader").fadeIn();
    $.post(context + "/seleccionarHerramientaEvaluacion", {tipoHerramienta: tipoHerramienta}
    , function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Seleccionar Herramienta Evaluacion");
        $(".preloader").fadeOut();
    });


}