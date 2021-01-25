/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            validaPreguntas();

        } else {
            swal({
                title: "Error de Validación",
                text: "Hay campos sin diligenciar",
                type: "error",
                confirmButtonText: "Ok",
                showCancelButton: false

            });
        }

    });

    $("#btn-Cancelar").on("click", function () {
        $.get(context + "/valoracionGrupal", function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Consultar Beneficiario Valoración Grupal");
        });
    });
});

function validaPreguntas() {
    //var preguntas = $("input[name=preguntas]:checked");
    var preguntas = $(".preguntas input");
    var idEmprendimiento = $("#idEmprendimiento").val();
    var respuestas = [];
    var pregunta = [];
    var valor = [];
    var tema = [];
    /*Este bucle me itera por todas las preguntas, pero me da el doble por lo que
     * agregue un i++ adicional al final del for.
     */

    for (var i = 0; i < (preguntas.length); i++) {
//        alert("JC: " + $("input[name=" + $(preguntas[i]).prop("name") + "]:checked").val());
        /*Luego por cada pregunta, selecciono el radio boton de esa pregunta que
         * este checked y agarro su valor y lo coloco en la variable v.
         * Lo que hice fue push de v en valor. Pero no se si esta haciendo bien
         * el push en pregunta y tema.
         */

        var v = $("input[name=" + $(preguntas[i]).prop("name") + "]:checked").val();
        pregunta.push($(preguntas[i]).prop("name"));
        valor.push(v);
//        alert("Valor de respuesta----" + $(preguntas[i]).val());
        tema.push($("#idtema" + i / 2).val());
        //Este es el i++ para avanzar 2 veces por iteracion
        i++;
    }
    respuestas.push({"pregunta": pregunta, "valor": valor, "tema": tema});
//    console.log(JSON.stringify(respuestas));

    $(".preloader").fadeIn();
    $.post(context + "/registrarEncuestaValoracionGrupal", {respuestas: JSON.stringify(respuestas), idEmprendimiento: idEmprendimiento},
            function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Registro Encuesta");
                $(".preloader").fadeOut();
            });

}




