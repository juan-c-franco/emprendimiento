/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $("#btnRegistro").on("click", registrarAsistencia);


});

function registrarAsistencia() {
    var asis = $(".asistencia input");
    var idsesion = $("#idsesion").val();
    var idfuncionario = $("#idfuncionario").val();

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

    $.post(context + "/registroAsistenciasModificadas", {asist: JSON.stringify(asisValues), idsesion: idsesion, idfuncionario: idfuncionario}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Asistencia");
    });
}

//<form:form action="${pageContext.request.contextPath}/registroAsistenciasModificadas" >