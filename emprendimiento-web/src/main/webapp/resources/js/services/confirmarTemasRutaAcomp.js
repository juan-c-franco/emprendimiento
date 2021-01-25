/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
    $(".selectpicker").selectpicker();

    $("#btnGuardar").on("click", function (e) {
        if ($('#saltarFases').is(":checked")) {
            var validationError = validationFormErrors(e, "#validaSalto");

            if (!validationError) {

                saltarFase();

            }

        } else {
            var validationError = validationFormErrors(e, "#valida");

            if (!validationError) {

                guardarTemas();

            }
        }

    });

    $("#btn-Cancelar").on("click", function () {
        $.get(context + "/valoracionGrupal", function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Consultar Beneficiario Valoración Grupal");
        });
    });
    $('#saltarFases').change(verificarCheck);
    $(verificarCheck);
});


function verificarCheck() {
    if ($('#saltarFases').is(":checked")) {
        $('#idEstadoASaltar').prop('disabled', false);
    } else {
        $('#idEstadoASaltar').prop('disabled', 'disabled');
    }
}

function guardarTemas() {
    var temas = $(".temas input");
    var tema = [];
    var hora = [];
    var idTema = [];
    var temasAgregados = [];
    var idruta = $("#idruta").val();
    var idEmprendimiento = $("#idEmprendimiento").val();
    for (var i = 0; i < temas.length; i++) {

        tema.push($(temas[i]).data('name' + i));
//        tema.push($(this).data('name'+i));
//        tema.push($(temas[i]).prop("name"));
        hora.push($(temas[i]).val());
//        idTema.push($(temas[i]).prop("id"));
        idTema.push($(temas[i]).data('id' + i));

    }
    temasAgregados.push({"tema": tema, "hora": hora, "idTema": idTema});


//    alert(JSON.stringify(temasAgregados));
    $(".preloader").fadeIn();
    $.post(context + "/guardarTemasValoracionGrupal",
            {idruta: idruta, idEmprendimiento: idEmprendimiento, temasAgregados: JSON.stringify(temasAgregados)}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Temas de Capacitacion");
        $(".preloader").fadeOut();
    });


}

function saltarFase() {
    var idEstadoASaltar = $("#idEstadoASaltar").val();
    var idEmprendimiento = $("#idEmprendimiento").val();
    $(".preloader").fadeIn();
    $.post(context + "/rompimientoDeFases",
            {idEstadoASaltar: idEstadoASaltar, idEmprendimiento: idEmprendimiento}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Avanzar Fase");
        $(".preloader").fadeOut();
    });
}
