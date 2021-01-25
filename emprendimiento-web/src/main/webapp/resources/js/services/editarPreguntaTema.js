/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#btnGuardar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#theForm");

        if (!validationError) {

            guardar();

        }
    });

//    $("#btnGuardar").on("click", guardar);
    $("#btnCancelar").on("click", cancelar);

});

function guardar() {
    var idPregunta = $("#idPregunta").val();
    var idTema = $("#idTema").val();
    var idHerramienta = $("#idHerramienta").val();
    var idCajaCompensacion = $("#idCajaCompensacion").val();
    var tema = $("#tema").val();
    var herramienta = $("#herramienta").val();
    var textopregunta = $("#textopregunta").val();
    var caja = $("#caja").val();
    if (textopregunta !== "") {
        $(".preloader").fadeIn();
        $.post(context + "/editandoPreguntaTema", {idTema: idTema, idHerramienta: idHerramienta,
            idCajaCompensacion: idCajaCompensacion, caja: caja, tema: tema, herramienta: herramienta, textopregunta: textopregunta, idPregunta: idPregunta}
        , function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Preguntas Tema Evaluacion");
            $(".preloader").fadeOut();
        });
    } else {
        alert("Por favor diligencie todos los campos");
        return false;
    }

}
//<form:form ModelAttribute="PreguntasTemaDTO" action="${pageContext.request.contextPath}/editandoPreguntaTema" method="POST">
function cancelar() {
    var idCaja = $("#idCaja").val();
    var idTema = $("#idTema").val();
    var idHerramienta = $("#idHerramienta").val();

    $(".preloader").fadeIn();
    $.post(context + "/preguntasTemaEvaluacion", {idTema: idTema, idHerramienta: idHerramienta,
        idCaja: idCaja}
    , function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Preguntas Tema Evaluacion");
        $(".preloader").fadeOut();
    });


}
//<form:form action="${pageContext.request.contextPath}/preguntasTemaEvaluacion" method="POST">