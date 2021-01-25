/* global context, bootbox */

$(function () {
    $('.selectpicker').selectpicker();
    $("#btnSeleccionarEmprendimiento").on("click", function (e) {

        var validationError = validationFormErrors(e, "#escogerEmprendimiento");
        if (!validationError) {
            seleccionarEmprendimiento();
        }

    });
    $("#btnGuardarDocumento").on("click", guardarDocumento);
    $("#btnEliminar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#theForm");
        var idDocumentoComite = $(this).data('iddocumento');
//        if (!validationError) {
        eliminarDocumentoComite(idDocumentoComite);
//        }
    });
//    $("#btnEliminar").on("click",eliminarDocumentoComite);
    $("body").on("contextmenu", function (e) {
        return false;
    });
    $("#btn-Cancelar").on('click', function (e) {
        e.preventDefault();
        location.replace(context + "/");
    });
    dTable1 = $('#tableData').DataTable({
        language: datatableLanguageEs
    });
    dTable2 = $('#tableData2').DataTable({
        language: datatableLanguageEs
    });
});
function seleccionarEmprendimiento() {
    var emprendimientoId = $("#emprendimientoId").val();
    $.get(context + "/adjuntarDocumentoComiteAAT",
            {emprendimientoId: emprendimientoId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Adjuntar documento comité");
    });
}

function actualizarDocumentoComite(idDocumentoComite) {
    $("#idDocumentoComiteAAT").val(idDocumentoComite);
    $("#modalAdjuntarDocumento").modal("show");
}

function eliminarDocumentoComite(idDocumentoComite) {


    var emprendimientoId = $("#idEmprendimiento").val();
    if (idDocumentoComite) {
        swal({
            title: "Eliminar Plan de Negocio",
            text: _mensajes.seguroEliminarDocumento,
            type: "warning",
            showCancelButton: true,
            cancelButtonText: "No",
            confirmButtonText: "Si",
            closeOnConfirm: true

        }, function (isConfirm) {

            if (isConfirm) {
                $(".preloader").fadeIn();
                $.post(context + "/eliminarDocumentoComiteAAT", {idDocumentoComite: idDocumentoComite}, function (data) {
                    $(".preloader").fadeOut();
                    loadView('Adjuntar documento comité AAT', context + '/adjuntarDocumentoComiteAAT?' + emprendimientoId);
                    if (typeof data === "string" && data !== "1") {
                        swal({
                            title: "Error Actualizando Módulo",
                            text: _mensajes.sesionExpiro,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            location.replace(context + "/mostrarLogin");
                        });
                    }
                }).fail(function (xhr, status, error) {
                    swal({
                        title: "Adjuntar Documento",
                        text: error,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                });
            }

        });
    }
}

function agregarDocumento() {
    $("#idDocumentoComiteAAT").val('');
    $("#modalAdjuntarDocumento").modal("show");
}

function guardarDocumento() {
    var documentoComiteAATId = $("#idDocumentoComiteAAT").val();
    var documento = document.getElementById("documento");
    var emprendimientoId = $("#idEmprendimiento").val();
    var idBeneficiario = $("#idBeneficiario").val();
    if (documento.files.length === 0) {
        swal({
            title: "Adjuntar Documento Comité Asistencia Técnica",
            text: _mensajes.documentoObligatorio,
            type: "error",
            confirmButtonText: "Aceptar",
        });
//        bootbox.alert("Es obligatorio diligenciar documento");
    } else {
        var file = documento.files[0];
        if (file.type === 'application/pdf') {
            if (file.size > 5242880) {
                swal({
                    title: "Adjuntar Documento Comité Asistencia Técnica",
                    text: _mensajes.file5mb,
                    type: "error",
                    confirmButtonText: "Aceptar",
                });
//                bootbox.alert("El archivo no debe superar 5MB");
            } else {
                var formData = new FormData();
                formData.append("documentoComiteAATId", documentoComiteAATId);
                formData.append("documentoComiteAAT", file);
                formData.append("emprendimientoId", emprendimientoId);
                formData.append("idBeneficiario", idBeneficiario);
                $.ajax({
                    url: context + "/adjuntarDocumentoComiteAAT",
                    data: formData,
                    type: "POST",
                    enctype: "multipart/form-data",
                    contentType: false,
                    processData: false,
                    cache: false,
                    success: function (result) {
                        $("#documento").val('');
                        $("#modalAdjuntarDocumento").modal("hide");
//                        bootbox.alert(result);
                        swal({
                            title: "Adjuntar Documento Comité Asistencia Técnica",
                            text: _mensajes.cargaFinalizada,
                            type: "warning",
                            confirmButtonText: "Aceptar",
                        }, function () {
                            $.get(context + "/adjuntarDocumentoComiteAAT",
                                    {emprendimientoId: emprendimientoId}, function (data) {
                                if (dTable1 != null) {
                                    dTable1.destroy();
                                }
                                if (dTable2 != null) {
                                    dTable2.destroy();
                                }
                                $("#body_content").html(data);
                                $("#idPage").html("Adjuntar documento comité");
                            });
                        });
                    }
                });
            }
        } else {
            swal({
                title: "Adjuntar Documento Comité Asistencia Técnica",
                text: _mensajes.soloPDF,
                type: "error",
                confirmButtonText: "Aceptar",
            });
//            bootbox.alert("Solo se permiten documentos con extensión PDF");
        }
    }
}
