$(function () {

    $("#btnGuardarDocumento").on("click", guardarDocumento);
    $("#btnGuardarDocumento3").on("click", guardarDocumento3);
    $("body").on("contextmenu", function (e) {
        return false;
    });
});


function adjuntarDocumento(idTemaRutaAAT, nombreTemaModalAdjuntar, descripcionDocumento) {
    $("#idTemaRutaAAT").val(idTemaRutaAAT);
    $("#nombreTemaModalAdjuntar").val(nombreTemaModalAdjuntar);
    $("#descripcionDocumento").val(descripcionDocumento);
    $("#modalAdjuntarDocumento").modal("show");
}
function adjuntarDocumento3(idPlanAccion) {

    $("#idPlanAccion").val(idPlanAccion);
    $("#modalAdjuntarDocumento3").modal("show");
}

function guardarDocumento() {
    var temaRutaAATId = $("#idTemaRutaAAT").val();
    var descDocumento = $("#descripcionDocumento").val();
    var documentoTema = document.getElementById("documentoTema");

    if (descDocumento) {
        if (documentoTema.files.length === 0) {
            swal({
                title: "Adjuntar Plan de Acción",
                text: _mensajes.documentoObligatorio,
                type: "error",
                confirmButtonText: "Aceptar"
            });
        } else {
            var file = documentoTema.files[0];
            if (file.type === 'application/pdf') {
                if (file.size > 5242880) {
                    swal({
                        title: "Adjuntar Plan de Acción",
                        text: _mensajes.file5mb,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                } else {
                    $("#modalAdjuntarDocumento").modal("hide");
                    swal({
                        title: "Adjuntar Plan de Acción",
                        text: _mensajes.seguroAdjuntarPlanAccion,
                        type: "warning",
                        showCancelButton: true,
                        cancelButtonText: "No",
                        confirmButtonText: "Si",
                        closeOnConfirm: false,
                        showLoaderOnConfirm: true
                    }, function (result) {
                        swal.stopLoading();
                        if (result) {
                            guardarDocumento2();
                        }

                    });
                }
            } else {
                swal({
                    title: "Adjuntar Plan de Acción",
                    text: _mensajes.soloPDF,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    } else {
        swal({
            title: "Adjuntar Plan de Acción",
            text: _mensajes.documentoObligatorio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
    }
}

function guardarDocumento2() {
    var temaRutaAATId = $("#idTemaRutaAAT").val();
    var descDocumento = $("#descripcionDocumento").val();
    var documentoTema = document.getElementById("documentoTema");
    var formData = new FormData();
    var file = documentoTema.files[0];
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
            //$("#modalAdjuntarDocumento2").modal("hide");
            swal({
                title: "Adjuntar Plan de Acción",
                text: result,
                type: "info",
                confirmButtonText: "Aceptar"
            }, function () {
                var emprendimientoId = $("#idEmprendimiento").val();
                $.get(context + "/adjuntarDocumentoAAT",
                        {emprendimientoId: emprendimientoId}, function (data) {
                    $("#body_content").html(data);
                    $("#idPage").html("Adjuntar Documento");
                });
            });
//            bootbox.alert(result);
        }
    });

}

function guardarDocumento3() {
    var emprendimientoId = $("#emprendimientoId").val();
    var documentoPlan = document.getElementById("documentoPlan");
    var idPlanAccion = ($("#idPlanAccion").val() !== "" ? $("#idPlanAccion").val() : -1);
    var idBeneficiario = $("#idBeneficiario").val();
    var idestadoemprendimiento = $("#idestadoEmprendimiento").val();

    if (documentoPlan.files.length === 0) {
        swal({
            title: "Adjuntar Plan de Acción",
            text: _mensajes.documentoObligatorio,
            type: "error",
            confirmButtonText: "Aceptar"
        });

    } else {
        var file = documentoPlan.files[0];
        if (file.type === 'application/pdf') {
            if (file.size > 5242880) {
                swal({
                    title: "Adjuntar Plan de Acción",
                    text: _mensajes.file5mb,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });

            } else {
                var formData = new FormData();
                formData.append("idPlanAccion", idPlanAccion);
                formData.append("documentoPlanAccion", file);
                formData.append("emprendimientoId", emprendimientoId);
                formData.append("idBeneficiario", idBeneficiario);
                formData.append("idestadoemprendimiento", idestadoemprendimiento);
                $.ajax({
                    url: context + "/adjuntarDocumentoPlanAccion",
                    data: formData,
                    type: "POST",
                    enctype: "multipart/form-data",
                    contentType: false,
                    processData: false,
                    cache: false,
                    success: function (result) {
                        $("#documento").val('');
                        $("#modalAdjuntarDocumento3").modal("hide");
                        if (result.status == '1') {
                            swal({
                                title: "Adjuntar Plan de Acción",
                                text: _mensajes.cargaFinalizada,
                                type: "success",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                $(".preloader").fadeIn();
                                $.get(context + "/adjuntarPlanAccion2",
                                        {emprendimientoId: emprendimientoId}, function (data) {
                                    $("#body_content").html(data);
                                    $("#idPage").html("Adjuntar Plan de Acción");
                                    $(".preloader").fadeOut();
                                });
                            });
                        } else {
                            swal({
                                title: "Adjuntar Plan de Acción",
                                text: result.descripcion,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                $(".preloader").fadeIn();
                                $.get(context + "/adjuntarPlanAccion2",
                                        {emprendimientoId: emprendimientoId}, function (data) {
                                    $("#body_content").html(data);
                                    $("#idPage").html("Adjuntar Plan de Acción");
                                    $(".preloader").fadeOut();
                                });
                            });
                        }

                    }
                });

            }
        } else {
            swal({
                title: "Adjuntar Plan de Acción",
                text: _mensajes.soloPDF,
                type: "error",
                confirmButtonText: "Aceptar",
            });

        }
    }
}