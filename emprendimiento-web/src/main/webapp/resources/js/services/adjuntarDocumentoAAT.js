/* global context */

$(function () {
    $('.selectpicker').selectpicker();
    $("#btnSeleccionarEmprendimiento").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            seleccionarEmprendimiento();

        }
    });

//    $("#btnSeleccionarEmprendimiento").on("click", seleccionarEmprendimiento);
    $("#btnGuardarDocumento").on("click", guardarDocumento);
    $("body").on("contextmenu", function (e) {
        return false;
    });
    $("#btn-Cancelar").on('click', function (e) {
        e.preventDefault();
        location.replace(context + "/");
    });
//    $('#tableData').DataTable({
//        language: datatableLanguageEs
//    });
});

function seleccionarEmprendimiento() {
    var emprendimientoId = $("#emprendimientoId").val();
    $.get(context + "/adjuntarDocumentoAAT",
            {emprendimientoId: emprendimientoId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Adjuntar Documento");
    });
}

function adjuntarDocumento(idTemaRutaAAT, nombreTemaModalAdjuntar, descripcionDocumento) {
    $("#idTemaRutaAAT").val(idTemaRutaAAT);
    $("#nombreTemaModalAdjuntar").val(nombreTemaModalAdjuntar);
    $("#descripcionDocumento").val(descripcionDocumento);
    $("#modalAdjuntarDocumento").modal("show");
}

function verDocumento(id) {
    $.get(context + "/verDocumentoTemaRutaAAT",
            {id: id}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Ver Documento");
    });
}

function guardarDocumento() {
    var temaRutaAATId = $("#idTemaRutaAAT").val();
    var descDocumento = $("#descripcionDocumento").val();
    var documentoTema = document.getElementById("documentoTema");

    if (descDocumento) {
        if (documentoTema.files.length === 0) {
            swal({
                title: "Adjuntar Documentos Asistencia Técnica",
                text: _mensajes.documentoObligatorio,
                type: "error",
                confirmButtonText: "Aceptar",
            });
//            bootbox.alert("Es obligatorio diligenciar documento");
        } else {
            var file = documentoTema.files[0];
            if (file.type === 'application/pdf') {
                if (file.size > 5242880) {
                    swal({
                        title: "Adjuntar Documentos Asistencia Técnica",
                        text: _mensajes.file5mb,
                        type: "error",
                        confirmButtonText: "Aceptar",
                    });
//                    bootbox.alert("El archivo no debe superar 5MB");
                } else {
                    var formData = new FormData();
                    formData.append("documentoTemaRutaAAT", file);
                    formData.append("descDocumento", descDocumento);
                    $.ajax({
                        url: context + "/adjuntarDocumentoAAT/" + temaRutaAATId,
                        data: formData,
                        type: "POST",
                        enctype: "multipart/form-data",
                        contentType: false,
                        processData: false,
                        cache: false,
                        success: function (result) {
                            $("#documentoTema").val('');
                            $("#modalAdjuntarDocumento").modal("hide");
//                            bootbox.alert(result);
                            swal({
                                title: "Adjuntar Documentos Asistencia Técnica",
                                text: _mensajes.cargaFinalizada,
                                type: "info",
                                confirmButtonText: "Aceptar",
                            }, function () {
                                var emprendimientoId = $("#idEmprendimiento").val();
                                $.get(context + "/adjuntarDocumentoAAT",
                                        {emprendimientoId: emprendimientoId}, function (data) {
                                    $("#body_content").html(data);
                                    $("#idPage").html("Adjuntar Documento");
                                });
                            });
                        }
                    });
                }
            } else {
                swal({
                    title: "Adjuntar Documentos Asistencia Técnica",
                    text: _mensajes.soloPDF,
                    type: "error",
                    confirmButtonText: "Aceptar",
                });
//                bootbox.alert("Solo se permiten documentos con extensión PDF");
            }
        }
    } else {
        swal({
            title: "Adjuntar Documentos Asistencia Técnica",
            text: _mensajes.documentoObligatorio,
            type: "error",
            confirmButtonText: "Aceptar",
        });
//        bootbox.alert("Es obligatorio diligenciar descripción del documento");
    }
}
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    location.replace(context + "/");

});