/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $('.selectpicker').selectpicker();
    $("#btnModificar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            modificarEntidad();

        }
    });
//    $("#btnModificar").on("click",modificarEntidad);
    $("#btn-Cancelar").on("click", cancelar);
});

function modificarEntidad() {
    var identidadesfinanciera = $("#identidadesfinanciera").val();
    var nombreEntidad = $("#nombreentidad").val();
    var descripcion = $("#descripcion").val();
    var estado = $("#estado").val();

    if (nombreEntidad !== "" && descripcion !== "") {
        $(".preloader").fadeIn();
        $.post(context + "/modificarEntidadFinanciera2", {nombreEntidad: nombreEntidad, descripcion: descripcion, estado: estado, identidadesfinanciera: identidadesfinanciera}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Entidades Financieras");
            $(".preloader").fadeOut();
        });

    } else {
        alert("Por favor diligencie todos los campos");
        return false;
    }

}
function cancelar() {
    $(".preloader").fadeIn();
    $.get(context + "/entidadesFinancieras", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Entidades Financieras");
        $(".preloader").fadeOut();
    });

}