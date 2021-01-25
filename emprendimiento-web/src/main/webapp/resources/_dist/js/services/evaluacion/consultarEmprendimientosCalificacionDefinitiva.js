var emprendimientos = [];
var calificaciones = [];
var index = -1;
var indexAgenda = 0;
var response = {};
var idEmprendimiento = -1;
var localSesionComite = idSesioncomite;
idSesioncomite = null;
var maxLength = 500;
$(function () {
    $('#observa').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#chars').text(length);
    });


    $("#btnGuardarDocumento").on("click", function (e) {
        e.preventDefault();
        var validationError = validationFormErrors(e, "#doc");
        if (!validationError) {
            $("#btnGuardarDocumento").prop("disabled", true);
            calificar();
            $("#btnGuardarDocumento").prop("disabled", false);
        }
    });

    $("#tableData").on('click', '.btn-intengrantes', function (e) {
        e.preventDefault();
        var index = $(this).data('index');
        var id = $(this).data('id');
        $('#nombreEmprendimientoEval').text(emprendimientos[index].nombreemprendimiento);
        calificacionIntegrantes(id);
        $('#modalEvaluaciones').modal("show");
    });

    $("#tableData").on('click', '.btn-ver', function (e) {
        e.preventDefault();
        var index = $(this).data('index');
        ver(index);
    });

    $("#tableData").on('click', '.btn-calificar', function (e) {
        e.preventDefault();
        index = $(this).data('index');
        idEmprendimiento = $(this).data('id');
        $('#nombreEmprendimientoCal').text(emprendimientos[index].nombreemprendimiento);
        $('#observa').val(emprendimientos[index].observaciones);
        if (emprendimientos[index].aprobado == "1") {
            $("#siAprobado").prop("checked", true);
        } else if (emprendimientos[index].aprobado == "0") {
            $("#noAprobado").prop("checked", true);
        }
        $('#modalCalificar').modal("show");
    });

    $("#btnGuardar").on("click", guardarCalificacion);

    getEmprendimientosComite(localSesionComite);
    emprendimientos.forEach(function (item) {
        var row = "<tr>" +
                "<td id=idemprendimiento" + indexAgenda + ">" + item.idemprendimiento + "</td>" +
                "<td class='noOverflow' id=nombreemprendimiento" + indexAgenda + ">" + item.nombreemprendimiento + "</td>" +
                "<td id=tipoemprendimiento" + indexAgenda + ">" + item.tipoemprendimiento.nombretipoemprendimiento + "</td>" +
                "<td id=fecharegistro" + indexAgenda + ">" + moment(item.fecharegistro).format('DD-MM-YYYY') + "</td>" +
                "<td align='center' id='aprobado" + indexAgenda + "'><div class='form-group'><div class='controls'><fieldset><div class='custom-control custom-radio'>" +
                "<input id='siAprobado" + indexAgenda + "' type='radio' class='custom-control-input' name='aprobado" + indexAgenda + "' value='1' data-validation-required-message='Seleccione alguna opción' required/><label class='custom-control-label' for='siAprobado" + indexAgenda + "'>Si</label>" +
                "</div></fieldset>" + "<fieldset><div class='custom-control custom-radio'>" +
                "<input id='noAprobado" + indexAgenda + "' type='radio' class='custom-control-input' name='aprobado" + indexAgenda + "' value='0' ><label class='custom-control-label' for='noAprobado" + indexAgenda + "'>No</label>" +
                "</div></fieldset></div></div></td>" +
                "<td align='center'><button type='button' data-index=" + item.idemprendimiento + " class='btn btn-info btn-sm btn-ver btn-rounded' data-toggle='tooltip' data-placement='top' title='Ver Emprendimiento'><i class='fas fa-eye'></i></button>" +
                "<button type='button' data-index=" + indexAgenda + "  data-id=" + item.idemprendimiento + " class='btn btn-success btn-rounded btn-sm btn-intengrantes m-l-5' data-toggle='tooltip' data-placement='top' title='Ver Calificaciones de Integrantes'><i class='fas fa-eye'></i></button>" +
                "<button type='button' data-index=" + indexAgenda + "  data-id=" + item.idemprendimiento + " class='btn btn-warning btn-rounded btn-sm btn-calificar m-l-5' data-toggle='tooltip' data-placement='top' title='Observaciones'><i class='fas fa-check-circle'></i></button></td>" +
                "</tr>";
        $('#tableData tr:last').after(row);
        indexAgenda += 1;
    });
    $(".preloader").fadeOut();
});

function ver(i) {
    $("#asociados").empty();
    $("#idTblTemasRutaAAT").find("tr:gt(0)").remove();
    $("#tablaDocs").find("tr:gt(0)").remove();
    getEmprendimientoCompleto(i);

    var emp = emprendimiento;
    var tem = temas;
    var docu = documentos;

    temas.forEach(function (item) {
        var row = "<tr>" +
                "<td>" + item.temasevaluacion.nombretema + "</td>" +
                "<td >" + item.cantidadhorasplaneadas + "</td>" +
                "<td>" + item.cantidadHorasEjecutadas + "</td>" +
                "<td>" + (item.cantidadHorasEjecutadas * 100) / item.cantidadhorasplaneadas + "<label>%</label></td>" +
                "<td align='right'center'>" + (item.urldocumentotema !== null && item.urldocumentotema !== '' ? "<a class='btn btn-primary' href='" + context + "/verDocumentoTemaRutaAAT?id=" + item.idtemarutaacompanamientoat + "'>Ver Documento</a>" : "Sin Documento") +
                "</td>" +
                "</tr>";
        $('#idTblTemasRutaAAT tr:last').after(row);

    });

    documentos.forEach(function (item) {
        var row = "<tr>" +
                "<td>" + item.tipodocumentos.nombretipodocumento + "</td>" +
                "<td align='center'>" + "<a class='btn btn-primary' href='" + context + "/verDocumentoComiteAAT?id=" + item.iddocumento + "'>Ver Documento</a>" + "</td>" +
                "</tr>";
        $('#tablaDocs tr:last').after(row);

    });

    jQuery.ajax({
        type: "GET",
        url: context + "/getInfoFinancieraPorIdEmp",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idemprendimiento: emp.idemprendimiento},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                var financiero = result.financiacionDTO;

                $('#montoFinanciacion').text(financiero.montofinanciacions);
                $('#tipoFinanciacion').text(financiero.tipofinanciacionByIdtipofinanciacions.nombretipofinanciacion);
                $('#cuotasFinanciar').text(financiero.cuotaspactadass);
                $('#tasaFinanciar').text(financiero.tasaintertess + "%");
                $('#propiosFinanciar').text(financiero.recursospropiosae);
                $('#empleosFinanciar').text(financiero.empleosporgenerar);
                $('#capitalFinanciar').text(financiero.capitaltrabajo);
                $('#equilibrioFinanciar').text(financiero.mesespuntoequilibrio);
                $('#totalFinanciar').text(financiero.capitaltotal);
            } else {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.errorCargaInformacionFinanciera,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.errorCargaInformacionFinanciera,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });

    $('#nombreEmprendimiento').text(emp.nombreemprendimiento);
    $('#tEmprendimiento').text(emp.tipoemprendimiento.nombretipoemprendimiento);
    emp.asociadoses.forEach(function (item) {
        $("#asociados").append("<li>" + item.beneficiario.primernombre + " " +
                item.beneficiario.primerapellido + "</li>");
    });

    if (emp.formalizados.length > 0) {
        $('#siFormalizado').checked = true;
        $(".noEstablecido").hide();
        $(".formalizado").show();
        var formalizado = emp.formalizados[0];
        $('#formalizado').text("Si");
        $('#nombreEmpresa').text(formalizado.nombreempresa);
        $('#nit').text(formalizado.nit);
        $('#nRegistroMercantil').text(formalizado.numeroregistromercantil);
        $('#nombreRepresentante').text(formalizado.representantelegal);
        $('#direccion').text(formalizado.direccionempresa);
        $('#telefono').text(formalizado.telefonoempresa);
        $('#municipio').text(formalizado.municipios.nombre);
        $('#email').text(formalizado.emailempresa);
        $('#web').text(formalizado.sitioweb);
        $('#constitucionF').text(formalizado.tipoconstitucionlegal.nombretipoconstitucionlegal);
        $('#sectorF').text(formalizado.sectorproductivo.nombresectorproductivo);

        if (formalizado.negociosinternet == "0") {
            $('#negInternet').text("No");
        } else {
            $('#negInternet').text("Si");
        }

        $("#prodServF").empty();
        formalizado.productoservicioofrece.split(",").forEach(function (item) {
            $("#prodServF").append("<li>" + item + "</li>");
        });
        $('#fechaRenov').text(moment(new Date(formalizado.fecharenovacion)).format("DD-MM-YYYY"));
        $('#fechaInicio').text(moment(new Date(formalizado.fechainiciolabores)).format("DD-MM-YYYY"));
        $('#actividad').text(formalizado.actividadinternacional.nombreactividadinternacional);
        $('#empDirectos').text(formalizado.empleosdirectos);
        $('#empIndirectos').text(formalizado.empleosindirectos);
    } else {
        $('#formalizado').text("No");
        $(".formalizado").hide();
        $(".noEstablecido").show();
        var noEstablecido = emp.noestablecidos[0];
        $('#constitucionN').text(noEstablecido.tipoconstitucionlegal.nombretipoconstitucionlegal);
        $('#sectorN').text(noEstablecido.sectorproductivo.nombresectorproductivo);
        $("#prodServN").empty();
        noEstablecido.productoservicioofrece.split(",").forEach(function (item) {
            $("#prodServN").append("<li>" + item + "</li>");
        });
        $('#cuandoInicia').text(moment(new Date(noEstablecido.cuandoinicia)).format("DD-MM-YYYY"));
        $('#observaciones').text(noEstablecido.observaciones);
    }
    $('#modalVerEmprendimiento').modal("show");
}

function getEmprendimientosComite(localSesionComite) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientosComitePorIdSesion",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idSesionComite: localSesionComite},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                successMsg(_mensajes.emprendimientosCargados);
                emprendimientos = result.emprendimientos;
                emprendimientos.forEach(function (item) {
                    item['aprobado'] = -1;
                    item['observaciones'] = "";
                });
            } else {
                errorMsg(_mensajes.errorCargaEmprendimiento);
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                errorMsg(_mensajes.errorCargaEmprendimiento);
            }
        }
    });
}

function calificacionIntegrantes(idEmprendimiento) {
    $("#evaluacionesIntegrantes").find("tr:gt(0)").remove();
    jQuery.ajax({
        type: "GET",
        url: context + "/getCalificacionesIntPorEmprendimiento",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idEmprendimiento: idEmprendimiento},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result.evaluaciones.forEach(function (item) {
                    var row = "<tr>" +
                            "<td>" + item[0] + " " + item[1] + "</td>" +
                            "<td>" + (item[2] == 1 ? "<i class='mdi mdi-account-check'></i> Aprobado" : (item[2] == 0 ? " <i class='mdi mdi-account-remove'></i> No Aprobado" : " <i class='mdi mdi-account-alert'></i> Sin calificar")) + "</td>" +
                            "</tr>";
                    $('#evaluacionesIntegrantes tr:last').after(row);
                    indexAgenda += 1;
                });
            } else {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.errorCargaCalificacionesIntegrantesComite,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.errorCargaCalificacionesIntegrantesComite,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function getEmprendimientoCompleto(idemprendimiento) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientoCompleto",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idemprendimiento: idemprendimiento},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                emprendimiento = result.emprendimiento;
                temas = result.temasRutasAAT;
                documentos = result.documentosDTO;
            } else {
                emprendimiento.nombreemprendimiento = "No registra emprendimiento activo para calificar.";
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Calificación Definitiva",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                errorMsg(_mensajes.errorCargaEmprendimiento);
            }

        }
    });

}

function calificar() {
    var documentoTema = document.getElementById("documentoActa");
    var formData = new FormData();
    var l = emprendimientos.length;
    for (var i = 0; i < l; i++) {
        emprendimientos[i].aprobado = $("input[name=aprobado" + i + "]:checked").val();
    }
    formData.append("emprendimientos", JSON.stringify(emprendimientos));
    formData.append("idSesionComite", localSesionComite);
    formData.append("idCaja", idcajacompensacion);
    formData.append("documento", documentoTema.files[0]);
    formData.append("idFuncionario", idfuncionario);

    var allSet = true;
    emprendimientos.forEach(function (item) {
        if (typeof item.aprobado === 'undefined' || item.aprobado === '-1') {
            allSet = false;
        }
    });

    if (allSet) {
        if (documentoTema.files.length === 0) {
            errorMsg(_mensajes.documentoObligatorio);
        } else {
            var file = documentoTema.files[0];
            if (file.type === 'application/pdf') {
                if (file.size > 5242880) {
                    errorMsg(_mensajes.file5mb);
                } else {
                    $(".preloader").fadeIn();
                    jQuery.ajax({
                        type: "POST",
                        url: context + "/calificarEmprendimientoDefinitiva",
                        enctype: "multipart/form-data",
                        contentType: false,
                        processData: false,
                        cache: false,
                        dataType: "json",
                        async: false,
                        data: formData,
                        success: function (result, status, xhr) {
                            $(".preloader").fadeOut();
                            if (result.status == "1") {
                                swal({
                                    title: "Calificación Definitiva",
                                    text: result.descripcion,
                                    type: "success",
                                    confirmButtonText: "Aceptar"
                                }, function () {
                                    $(".preloader").fadeIn();
                                    location.replace(context + "/");
                                });
                            } else {
                                swal({
                                    title: "Calificación Definitiva",
                                    text: result.descripcion,
                                    type: "error",
                                    confirmButtonText: "Aceptar"
                                });
                            }
                        },
                        error: function (error) {
                            if (error.status == 200) {
                                swal({
                                    title: "Calificación Definitiva",
                                    text: _mensajes.sesionExpiro,
                                    type: "error",
                                    confirmButtonText: "Aceptar"
                                }, function () {
                                    location.replace(context + "/mostrarLogin");
                                });
                            } else {
                                swal({
                                    title: "Calificación Definitiva",
                                    text: result.errorCalificandoEmprendimiento,
                                    type: "error",
                                    confirmButtonText: "Aceptar"
                                });
                            }
                        }
                    });
                    $(".preloader").fadeOut();
                }
            } else {
                errorMsg(_mensajes.soloPDF);
            }
        }
    } else {
        errorMsg(_mensajes.calificarContinuar);
    }
}

function guardarCalificacion() {
    emprendimientos[index].observaciones = $('#observa').val();
    $('#modalCalificar').modal("hide");
}
