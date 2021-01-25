$(function () {
    $(".preloader").fadeOut();
    $("#btnRegistro").on("click", function () {
        if (!$("input,textarea,select").jqBootstrapValidation("hasErrors")) {
            validaPreguntas();
        } else {
            if ($("input[type='checkbox'][name='terminos']:checked").length == 0) {
                swal({
                    title: "Error de Validación",
                    text: "Debe aceptar Terminos y Condiciones",
                    type: "error",
                    confirmButtonText: "Ok",
                    showCancelButton: false

                });
            } else {
                swal({
                    title: "Error de Validación",
                    text: "Hay campos sin diligenciar",
                    type: "error",
                    confirmButtonText: "Ok",
                    showCancelButton: false

                });
            }
        }

    });
});


function validaPreguntas() {
    var preguntas = $(".preguntas input");
    var idBeneficiario = $("#idBeneficiario").val();
    var idEncuesta = $("#idEncuesta").val();

    var respuestas = [];
    var pregunta = [];
    var valor = [];

    for (var i = 0; i < preguntas.length; i++) {

        if ($(preguntas[i]).is(':radio')) {


            if (preguntas[i].checked) {
                pregunta.push($(preguntas[i]).prop("name"));
                valor.push(preguntas[i].value);
            }
        }
    }

    respuestas.push({"pregunta": pregunta, "valor": valor});
    $(".preloader").fadeIn();
    $.post(context + "/crearUsuario", {respuestas: JSON.stringify(respuestas),
        idBeneficiario: idBeneficiario, idEncuesta: idEncuesta}
    , function (data) {
        if (typeof data === "string") {
            swal({
                title: "Error Actualizando Módulo",
                text: _mensajes.sesionExpiro,
                type: "error",
                confirmButtonText: "Aceptar"
            }, function () {
                location.replace(context + "/mostrarLogin");
            });
        }
        if (data.status == "1") {
            $("#mensajes").removeClass("alert-danger alert-success alert-success").addClass("alert-success");
            $("#mensajes > span").text(data.descripcion);
            $("#mensajes").show();
            $("#divEncuesta").hide();
        } else {
            $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
            $("#i").removeClass("fa fa-check-circle").addClass("fas fa-exclamation-circle");
            $("#mensajes > span").text(data.descripcion);
            $("#mensajes").show();
            $("#divEncuesta").hide();
        }
        $(".preloader").fadeOut();
    }
    ).fail(function (xhr, status, error) {
        swal({
            title: "Adjuntar Documento",
            text: error,
            type: "error",
            confirmButtonText: "Aceptar"
        });
    });
}
