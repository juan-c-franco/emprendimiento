/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var maxLength = 450;
$(function () {
    $('#descripcion').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#chars').text(length);
    });

    $("#btnGuardar").on("click", function (e) {
        var idHerramienta = $("#idHerramienta").val();
        if (idHerramienta === '1') {
            var validationError = validationFormErrors(e, "#valora");
        } else {
            var validationError = validationFormErrors(e, "#theForm");
        }

        if (!validationError) {

            guardar();

        }
    });

//    $("#btnGuardar").on("click", guardar);
    $("#btnCancelar").on("click", cancelar);

});

function guardar() {
    var idHerramienta = $("#idHerramienta").val();
    if (idHerramienta === '1') {
        var horasbasico = 3;
        var calificacionbasico = 1;
        var horasintermedio = 2;
        var calificacionintermedio = 2;
        var horasavanzado = 1;
        var calificacionavanzado = 3;
    } else {
        var horasbasico = $("#horasbasico").val();
        var calificacionbasico = $("#calificacionbasico").val();
        var horasintermedio = $("#horasintermedio").val();
        var calificacionintermedio = $("#calificacionintermedio").val();
        var horasavanzado = $("#horasavanzado").val();
        var calificacionavanzado = $("#calificacionavanzado").val();
    }
    var nombretema = $("#nombretema").val();
    var descripcion = $("#descripcion").val();

    var idCajaCompensacion = $("#idCajaCompensacion").val();
    if ((parseInt(horasbasico) > parseInt(horasintermedio)) && (parseInt(horasintermedio) > parseInt(horasavanzado))) {
        if (parseInt(calificacionbasico) < parseInt(calificacionintermedio) && parseInt(calificacionintermedio) < parseInt(calificacionavanzado)) {
            $(".preloader").fadeIn();
            $.post(context + "/guardarTemaEvaluacion", {nombretema: nombretema, idHerramienta: idHerramienta,
                idCajaCompensacion: idCajaCompensacion, descripcion: descripcion, horasbasico: horasbasico,
                calificacionbasico: calificacionbasico, horasintermedio: horasintermedio,
                calificacionintermedio: calificacionintermedio, horasavanzado: horasavanzado, calificacionavanzado: calificacionavanzado}
            , function (data) {
                $("#body_content").html(data);
                $("#idPage").html("Seleccionar Herramienta Evaluacion");
                $(".preloader").fadeOut();
            });
        } else {
            swal({
                title: "Registro Calificación",
                text: _mensajes.registroUmbralCalificaciones,
                type: "error",
                confirmButtonText: "Ok",
                showCancelButton: false,

            });
        }
    } else {
        swal({
            title: "Registro Calificación",
            text: _mensajes.registroHoras,
            type: "error",
            confirmButtonText: "Ok",
            showCancelButton: false,

        });
    }





}

//<form:form ModelAttribute="TemasEvaluacionDTO" action="${pageContext.request.contextPath}/guardarTemaEvaluacion" method="POST">


function cancelar() {
    var tipoHerramienta = $("#tipoHerramienta").val();
    var cajaId = $("#idCajaCompensacion").val();
    $(".preloader").fadeIn();
    $.post(context + "/seleccionarHerramientaEvaluacion",
            {tipoHerramienta: tipoHerramienta, cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Parametrizar temas herramientas");
        $(".preloader").fadeOut();
    });


}
//<form:form action="${pageContext.request.contextPath}/seleccionarHerramientaEvaluacion" method="POST">