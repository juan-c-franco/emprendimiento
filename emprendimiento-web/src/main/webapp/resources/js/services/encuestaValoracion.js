
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
});


function validaPreguntas() {
    var preguntas = $(".preguntas input");
    var idBeneficiario = $("#idBeneficiario").val();
    var respuestas = [];
    var pregunta = [];
    var valor = [];
    var tema = [];
    for (var i = 0; i < (preguntas.length); i++) {
        /*Luego por cada pregunta, selecciono el radio boton de esa pregunta que
         * este checked y agarro su valor y lo coloco en la variable v.
         * Lo que hice fue push de v en valor. Pero no se si esta haciendo bien
         * el push en pregunta y tema.
         */

        var v = $("input[name=" + $(preguntas[i]).prop("name") + "]:checked").val();
        pregunta.push($(preguntas[i]).prop("name"));
        valor.push(v);
        tema.push($("#idtema" + i / 2).val());
        //Este es el i++ para avanzar 2 veces por iteracion
        i++;
    }
    respuestas.push({"pregunta": pregunta, "valor": valor, "tema": tema});

    $(".preloader").fadeIn();
    $.post(context + "/registrarEncuestaValoracion", {respuestas: JSON.stringify(respuestas),
        idBeneficiario: idBeneficiario, idEncuesta: idencuesta},
            function (data) {
                if (data.status === "1") {
                    swal({
                        title: "Registrar Encuesta",
                        text: data.descripcion,
                        type: "success",
                        confirmButtonText: "OK",
                        showCancelButton: false

                    }, function () {

                        $(".preloader").fadeIn();
                        location.replace(context + "/");
                        $(".preloader").fadeOut();

                    });
                } else {
                    swal({
                        title: "Registrar Encuesta",
                        text: data.descripcion,
                        type: "error",
                        confirmButtonText: "OK",
                        showCancelButton: false

                    }, function () {

                        $(".preloader").fadeIn();
                        location.replace(context + "/");
                        $(".preloader").fadeOut();

                    });
                }
                $(".preloader").fadeOut();
            });
}




