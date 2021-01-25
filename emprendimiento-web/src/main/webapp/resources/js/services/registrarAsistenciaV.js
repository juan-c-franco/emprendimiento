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
});
$(function () {
    $("#btnRegistro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            registrarAsistencia();

        }
    });
//    $("#btnRegistro").on("click", registrarAsistencia);
//    $("#btnRegistro2").on("click", registrarInasistentes);
    $("#btn-Cancelar").on("click", cancelar);
    validarBoton();

});
function registrarAsistencia() {

//    alert("entro a la funcion");

    var asis = $(".asistencia input");
//    var idsesion = $("#idsesion").val();
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
    $.post(context + "/registroAsistenciasV", {asist: JSON.stringify(asisValues), idsesion: idSession, idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Asistencia");
        $(".preloader").fadeOut();
    });

}
//<form:form action="${pageContext.request.contextPath}/registroAsistencias" >
function registrarInasistentes() {

    var idsesion = $("#idsesion").val();
    var idfuncionario = $("#idfuncionario").val();
    $.post(context + "/registroInasistentes", {idsesion: idsesion, idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Inasistentes");
    });
}

//<form:form action="${pageContext.request.contextPath}/registroInasistentes" >
function validarBoton() {

    var idestadosesion = $("#idestadosesion").val();
    if (idestadosesion === "2") {
        document.getElementById("btnRegistro").disabled = true;
    }
}

function cancelar() {

    $.get(context + "/registrarAsistenciaValoracion", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Cajas de Compensacion");
    });

}


