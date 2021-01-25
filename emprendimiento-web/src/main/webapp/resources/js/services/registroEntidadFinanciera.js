/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $('.selectpicker').selectpicker();
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            registrarEntidad();

        }
    });
    $("#btn-Cancelar").on("click", cancelar);

});
function registrarEntidad() {

    var nombreEntidad = $("#nombreentidad").val();
    var descripcion = $("#descripcion").val();
    var estado = $("#estado").val();
    $(".preloader").fadeIn();
    if (nombreEntidad !== "" && descripcion !== "") {
        $.post(context + "/registrarEntidadFinanciera", {nombreEntidad: nombreEntidad, descripcion: descripcion, estado: estado}, function (data) {
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
  