/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $("#btnRegistro").on("click", validaPreguntas);

});


function validaPreguntas() {
    var preguntas = $(".preguntas input");
    var idBeneficiario = $("#idBeneficiario").val();

    var respuestas = [];
    var pregunta = [];
    var valor = [];
    for (var i = 0; i < preguntas.length; i++) {
        if ($(preguntas[i]).is(":checked")) {
            pregunta.push($(preguntas[i]).prop("name"));
            valor.push($(preguntas[i]).val());

        }
    }
    respuestas.push({"pregunta": pregunta, "valor": valor});
    $(".preloader").fadeIn();
    $.post(context + "/registrarEncuestaValoracion", {respuestas: JSON.stringify(respuestas), idBeneficiario: idBeneficiario},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Registro Encuesta");
                $(".preloader").fadeOut();
            });
}
