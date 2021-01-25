/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


$(function () {

    $('#tableData').DataTable({
        language: datatableLanguageEs,
        bPaginate: false
    });
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            registrarAsistencia();

        }
    });
    $("#btn-Cancelar").on("click", cancelar);
//    $("#btnRegistro").on("click", registrarAsistencia);
    $("#btnRegistro2").on("click", registrarInasistentes);
    validarBoton();

});
function registrarAsistencia() {

//    alert("entro a la funcion");

    var asis = $(".asistencia input");
    var idsesion = $("#idsesion").val();
//    var idfuncionario = $("#idfuncionario").val();

    var asisValues = [];
    var Beneficiario = [];
    var valor = [];
    for (var i = 0; i < asis.length; i++) {
        if ($(asis[i]).is(":checked")) {
            Beneficiario.push($(asis[i]).prop("name"));
            valor.push($(asis[i]).val());
        }
    }
    asisValues.push({"Beneficiario": Beneficiario, "valor": valor});

    $(".preloader").fadeIn();
    $.post(context + "/registroAsistencias", {asist: JSON.stringify(asisValues), idsesion: idSession, idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Asistencia");
        $(".preloader").fadeOut();
    });

}

function registrarInasistentes() {

    $.post(context + "/registroInasistentes", {idsesion: idsesion, idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Inasistentes");
    });
}

function cancelar() {
    $.post(context + "/traerSesiones", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registrar Asistencia");
    });
}

function validarBoton() {

    var idestadosesion = $("#idestadosesion").val();
    if (idestadosesion === "2") {
        document.getElementById("btnRegistro").disabled = true;
    }
}


