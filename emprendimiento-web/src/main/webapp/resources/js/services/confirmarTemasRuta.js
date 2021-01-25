/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('.selectpicker').selectpicker();
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
});
$('#botonAgregar').on('click', function (e) {
    e.preventDefault();

    $('#modalComprobar .modal-title').text("Agregar Nuevo Tema a la Ruta");
//    $('#modalComprobar .modal-body').text("Realmente deseas registrar el Beneficiario?");
    $('#btnModalComprobar').text("Agregar Tema");
    $('#modalComprobar').modal("show");
});
$("#btnModalComprobar").on("click", function (e) {

    var validationError = validationFormErrors(e, "#modalComprobar");

    if (!validationError) {

        agregarHoras();

    }
});

$("#btnGuardar").on("click", function (e) {
    var validationError = validationFormErrors(e, "#valida");

    if (!validationError) {

        guardarTemas();

    }
});


function guardarTemas() {
    var temas = $(".temas input");
    var tema = [];
    var hora = [];
    var temasAgregados = [];
    var idruta = $("#idruta").val();
    var idBeneficiario = $("#idBeneficiario").val();
    for (var i = 0; i < temas.length; i++) {
        tema.push($(temas[i]).prop("name"));
        hora.push($(temas[i]).val());
    }
    temasAgregados.push({"tema": tema, "hora": hora});


    $(".preloader").fadeIn();
    $.post(context + "/guardarTemasValoracionInd",
            {idruta: idruta, idBeneficiario: idBeneficiario, temasAgregados: JSON.stringify(temasAgregados)}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Temas de Capacitacion");
        $(".preloader").fadeOut();
    });


}

function agregarHoras() {
    var temas = $(".temas input");
    var temasN = $(".temasN");
    var horaI = $("#horaI").val();

    var temaI = $("#temaI").val();
    var tema = [];
    var hora = [];
    var temasAgregados = [];
    var idruta = $("#idruta").val();
    var idBeneficiario = $("#idBeneficiario").val();
    var noAgrega = 0;
    for (var i = 0; i < temasN.length; i++) {

        if ($(temasN[i]).text() === temaI) {
            swal({
                title: "Tema Existente",
                text: "El tema ya existe",
                type: "warning",
                confirmButtonText: "Ok"
            });
            noAgrega = noAgrega + 1;
        }


    }
    if (noAgrega === 0) {
        var row = "<tr>" +
                "<td ><a class='temasN'>" + temaI + "</a></td>" +
                "<td><a class='temas'><div class='controls'> <input type='NumericTextBox' name=" + temaI + " min='0' class='form-control col-4 only-number' data-name=" + temaI + " value=" + horaI + " required='required' data-validation-required-message='Ingrese la cantidad de horas' disabled/></div></a></td>" +
                "</tr>";
        $('#tableData tr:last').after(row);
    }





    $('#modalComprobar').modal("hide");

}
$("#btn-Cancelar").on("click", function (e) {
    $.get(context + "/valoracionIndividual", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Valoracion Individual");
    });
});

