/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('.selectpicker').selectpicker();
    $("#btnParametrizar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            parametrizar();

        }
    });

//    $("#btnParametrizar").on("click",parametrizar);
    jQuery("select[name='tipoHerramienta']").change(function () {
        parametrizar();
    });
});

function parametrizar() {
    var tipoHerramienta = $("#tipoHerramienta").val();
    var cajaId = $("#cajaId").val();
    $(".preloader").fadeIn();
    $.post(context + "/seleccionarHerramientaEvaluacion",
            {tipoHerramienta: tipoHerramienta, cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Parametrizar temas herramientas");
        $(".preloader").fadeOut();
    });


}

// <form:form name="seleccionarHerramientaValoracion" action="${pageContext.request.contextPath}/seleccionarHerramientaEvaluacion" method="POST">
