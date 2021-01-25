var beneficiarios = [];
var emprendimiento = {};
var emprendimientos = [];
var idFormalizado;
var idNoEstablecido;
var index = 0;
var estados = ["6"];
var divHijo;
var maxLength = 500;
$(function () {
    $('#obSeguimiento').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#chars').text(length);
    });

    $('#observacionesR').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#charsR').text(length);
    });

    $('.selectpicker').selectpicker();
    $('#paisesR').multiSelect({
        selectableHeader: "<label class='custom-header'>Lista de Paises</label>",
        selectionHeader: "<label class='custom-header'>Paises Seleccionados</label>"
    });

    $("#rPropios").change(function () {
        var total = parseInt($("#rPropios").val()) + parseInt($("#cTrabajo").val());
        $('#cTotal').val(total);
    });

    $("#cTrabajo").change(function () {
        var total = parseInt($("#rPropios").val()) + parseInt($("#cTrabajo").val());
        $('#cTotal').val(total);
    });

    $('#btnRegistrar').on('click', function (e) {
        e.preventDefault();
        $("#btnRegistrar").prop("disabled", true);
        var validationErrorFinancieros = validationFormErrors(e, "#financiero");
        var validationErrorHijo = validationFormErrors(e, divHijo);
        if (!(validationErrorFinancieros || validationErrorHijo)) {
            swal({
                title: "Registrar Seguimiento",
                text: _mensajes.seguroRegistrarSeguimiento,
                type: "info",
                showCancelButton: true,
                cancelButtonText: "No",
                confirmButtonText: "Si",
                closeOnConfirm: false,
            }, function () {
                guardar();
            });
        } else {
            swal({
                title: "Registrar Seguimiento",
                text: _mensajes.verificarCampos,
                type: "error",
                confirmButtonText: "Aceptar",
            });
        }
        $("#btnRegistrar").prop("disabled", false);
    });

    $('.setDay').datetimepicker({
        format: "YYYY-MM-DD",
        locale: 'es',
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            left: "fa fa-arrow-up",
            rigth: "fa fa-arrow-down"
        }
    });
    var oTable = $('#tableData').DataTable({
        language: datatableLanguageEs
    });

    $('input:radio[name=selectBeneficiario]').on('change', function () {
        if (this.value === '1') {
            $('#filtroDocumento').show();
            $('#filtroNombres').hide();
            $('input[name=documento]').prop('required', true);
            $('input[name=pNombre]').prop('required', false);
            $('input[name=pApellido]').prop('required', false);
            $("#mensajes").hide();
            $("#beneficiariosTabla").remove();
        } else {
            $('#filtroDocumento').hide();
            $('#filtroNombres').show();
            $('input[name=documento]').prop('required', false);
            $('input[name=pNombre]').prop('required', true);
            $('input[name=pApellido]').prop('required', true);
            $("#mensajes").hide();
            $("#beneficiariosTabla").remove();
        }
    });

    $("#btnFiltroBeneficiario").on("click", function (e) {
        e.preventDefault();

        var buscarPor = $("input[name=selectBeneficiario]:checked").val();

        if (buscarPor === '1') {
            var $documento = $("input[name=documento]");
            $documento.jqBootstrapValidation();
            $documento.trigger("change.validation", {submitting: true});

            buscarXDocumento($documento);
        } else {
            var $pNombre = $("input[name=pNombre]");
            var $sNombre = $("input[name=sNombre]");
            $pNombre.jqBootstrapValidation();
            $pNombre.trigger("change.validation", {submitting: true});

            var $pApellido = $("input[name=pApellido]");
            var $sApellido = $("input[name=sApellido]");
            $pApellido.jqBootstrapValidation();
            $pApellido.trigger("change.validation", {submitting: true});

            buscarXNombreApellido($pNombre, $sNombre, $pApellido, $sApellido);
        }
    });

    $('input[type=radio][name=formalizadoR]').change(function () {
        if (this.value == 'si') {
            divHijo = "#divFormalizadoR";
            $("#divNoEstablecidoR").hide();
            $("#divFormalizadoR").show();
        } else if (this.value == 'no') {
            divHijo = "#divNoEstablecidoR";
            $("#divFormalizadoR").hide();
            $("#divNoEstablecidoR").show();
        }
    });

    $('input[type=radio][name=plan]').change(function () {
        if (this.value == 'si') {
            $("#finalizado").prop("checked", false);
            $("#finalizado").prop("disabled", true);
        } else if (this.value == 'no') {
            $("#finalizado").prop("disabled", false);
        }
    });

    jQuery("select[name='departamentoR']").change(function () {
        jQuery.ajax({
            type: "GET",
            url: context + "/getMunicipiosPorDepartamento",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            async: false,
            data: {iddepartamento: $("#departamentoR").val()},
            success: function (result, status, xhr) {
                $("#municipioR").empty();

                if (result.status == "0") {
                    $("#municipioR").append($("<option></option>").text("No hay municipios vinculados"));
                    $("#municipioR").prop("disabled", true);
                    return false;
                }

                jQuery.each(result.municipios, function (i, item) {
                    $("#municipioR").append($('<option>', {
                        value: item.id,
                        text: item.nombre
                    }));
                });
                $("#municipioR").prop("disabled", false);

            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Consulta Beneficiario",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    $("#municipioR").append($("<option></option>").text("Error cargando municipios"));
                    $("#municipioR").prop("disabled", true);
                }
            }
        });
        $('.selectpicker').selectpicker('refresh');
    });

    jQuery.ajax({
        type: "GET",
        url: context + "/getDepartamentos",
        dataType: "json",
        async: false,
        data: {},
        success: function (result, status, xhr) {
            $("#departamentoR").empty();

            if (result.status == "0") {
                $("#departamentoR").append($("<option></option>").text("No hay departamentos registrados"));
                $("#departamentoR").prop("disabled", true);
                return false;
            }

            jQuery.each(result.departamentos, function (i, item) {
                $("#departamentoR").append($('<option>', {
                    value: item.id,
                    text: item.nombre
                }));
            });
            $("#departamentoR").prop("disabled", false);
            $('.selectpicker').selectpicker('refresh');
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                $("#departamentoR").append($("<option></option>").text("Error cargando departamentos"));
                $("#departamentoR").prop("disabled", true);
            }
        }
    });

    jQuery.ajax({
        type: "GET",
        url: context + "/getTiposConstitucionLegal",
        dataType: "json",
        async: false,
        data: {},
        success: function (result, status, xhr) {
            $("#constitucionFR").empty();
            $("#constitucionNR").empty();

            if (result.status == "0") {
                $("#constitucionFR").append($("<option></option>").text("No hay tipos de constitución legal registrados"));
                $("#constitucionFR").prop("disabled", true);
                $("#constitucionNR").append($("<option></option>").text("No hay tipos de constitución legal registrados"));
                $("#constitucionNR").prop("disabled", true);
                return false;
            }

            jQuery.each(result.tipos, function (i, item) {
                $("#constitucionFR").append($('<option>', {
                    value: item.idtipoconstitucionlegal,
                    text: item.nombretipoconstitucionlegal
                }));
                $("#constitucionNR").append($('<option>', {
                    value: item.idtipoconstitucionlegal,
                    text: item.nombretipoconstitucionlegal
                }));
            });
            $("#constitucionFR").prop("disabled", false);
            $("#constitucionNR").prop("disabled", false);
            $('.selectpicker').selectpicker('refresh');
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                $("#constitucionFR").append($("<option></option>").text("Error cargando tipos de constitución legal"));
                $("#constitucionFR").prop("disabled", true);
                $("#constitucionNR").append($("<option></option>").text("Error cargando tipos de constitución legal"));
                $("#constitucionNR").prop("disabled", true);
            }
        }
    });

    jQuery.ajax({
        type: "GET",
        url: context + "/getSectoresProductivos",
        dataType: "json",
        async: false,
        data: {},
        success: function (result, status, xhr) {
            $("#sectorFR").empty();
            $("#sectorNR").empty();

            if (result.status == "0") {
                $("#sectorFR").append($("<option></option>").text("No hay sectores productivos registrados"));
                $("#sectorFR").prop("disabled", true);
                $("#sectorNR").append($("<option></option>").text("No hay sectores productivos registrados"));
                $("#sectorNR").prop("disabled", true);
                return false;
            }

            jQuery.each(result.sectores, function (i, item) {
                $("#sectorFR").append($('<option>', {
                    value: item.idsectorproductivo,
                    text: item.nombresectorproductivo
                }));
                $("#sectorNR").append($('<option>', {
                    value: item.idsectorproductivo,
                    text: item.nombresectorproductivo
                }));
            });
            $("#sectorFR").prop("disabled", false);
            $("#sectorNR").prop("disabled", false);
            $('.selectpicker').selectpicker('refresh');
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                $("#sectorFR").append($("<option></option>").text("Error cargando sectores productivos"));
                $("#sectorFR").prop("disabled", true);
                $("#sectorNR").append($("<option></option>").text("Error cargando sectores productivos"));
                $("#sectorNR").prop("disabled", true);
            }
        }
    });

    jQuery.ajax({
        type: "GET",
        url: context + "/getActividadesInternacionales",
        dataType: "json",
        async: false,
        data: {},
        success: function (result, status, xhr) {
            $("#actividadR").empty();

            if (result.status == "0") {
                $("#actividadR").append($("<option></option>").text("No hay actividades internacionales registrados"));
                $("#actividadR").prop("disabled", true);
                return false;
            }

            jQuery.each(result.actividades, function (i, item) {
                $("#actividadR").append($('<option>', {
                    value: item.idactividadinternacional,
                    text: item.nombreactividadinternacional
                }));
            });
            $("#actividadR").prop("disabled", false);
            $('.selectpicker').selectpicker('refresh');
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                $("#actividadR").append($("<option></option>").text("Error cargando actividades internacionales"));
                $("#actividadR").prop("disabled", true);
            }
        }
    });

    jQuery.ajax({
        type: "GET",
        url: context + "/getPaises",
        dataType: "json",
        async: false,
        data: {},
        success: function (result, status, xhr) {
            $("#paisesR").empty();

            if (result.status == "0") {
                return false;
            }

            jQuery.each(result.paises, function (i, item) {
                $('#paisesR').multiSelect('addOption', {
                    value: item.idpais,
                    text: item.nombrepais,
                    index: i});
            });
            $("#paisesR").prop("disabled", false);

        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            }
        }
    });

    $("#paisesR").multiSelect("refresh");


    $(".preloader").fadeOut();
});


function buscarXDocumento($documento) {
    var documento = $documento.val();
    if (documento === '')
        return false;

    if (documento) {
        getBeneficiarioDOC(documento);
        if (response.status == "0") {
            errorMsg(response.descripcion);
        } else if (response.status == "1") {
            emprendimientos = [];
            var lBeneficiarios = response.beneficiariosDTO;
            if (lBeneficiarios.length == 0) {
                errorMsg(_mensajes.sinResultados);
            } else {
                successMsg(_mensajes.beneficiariosCargados);
            }
            indexResult = 0;
            $("#tableData").find("tr:gt(0)").remove();
            jQuery.each(lBeneficiarios, function (i, item) {
                getEmprendimientoXDOC(item.numerodocumento);
                var telefono = "";
                if (item.telefono != 0) {
                    telefono = item.telefono;
                }
                var row = "<tr id='beneficiariosTabla' >" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " +
                        (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " +
                        (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + telefono + "</td>" +
                        "<td id='email" + index + "'>" + item.email + "</td>" +
                        "<td id='empResult" + indexResult + "'>" + emprendimiento.nombreemprendimiento + "</td>" +
                        "<td align='center'><button type='button' onclick='ver(" + indexResult + ")' " + (emprendimiento.idemprendimiento == null ? "disabled" : "") + " class='btn btn-sm btn-rounded btn-info btn-ver' data-toggle='tooltip' data-placement='top' title='Ver'><i class='fas fa-eye'></i></button>" +
                        "<button type='button' onclick='registrar(" + indexResult + ")' " + (emprendimiento.idemprendimiento == null ? "disabled" : "") + " class='btn btn-sm btn-rounded btn-secondary btn-Registrar' data-toggle='tooltip' data-placement='top' title='Registrar'><i class='fas fa-clipboard-list'></i></button></td>" +
                        "</tr>";
                $('#tableData tr:last').after(row);
                indexResult += 1;

            });
            $("#inputDocumento").val("");
        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
    }
}


function buscarXNombreApellido($pNombre, $sNombre, $pApellido, $sApellido) {
    var pNombre = $pNombre.val(),
            sNombre = $sNombre.val(),
            pApellido = $pApellido.val(),
            sApellido = $sApellido.val();
    if (pNombre === '' || pApellido === '')
        return false;

    if (pNombre && pApellido) {
        getBeneficiarioNombreApellido(pNombre, sNombre, pApellido, sApellido);
        if (response.status == "0") {
            errorMsg(response.descripcion);
        } else if (response.status == "1") {
            emprendimientos = [];
            var lBeneficiarios = response.beneficiariosDTO;
            if (lBeneficiarios.length == 0) {
                errorMsg(_mensajes.sinResultados);
            } else {
                successMsg(_mensajes.beneficiariosCargados);
            }
            indexResult = 0;
            $("#tableData").find("tr:gt(0)").remove();
            jQuery.each(lBeneficiarios, function (i, item) {
                getEmprendimientoXDOC(item.numerodocumento);
                var telefono = "";
                if (item.telefono != 0) {
                    telefono = item.telefono;
                }
                var row = "<tr id='beneficiariosTabla'>" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " +
                        (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " +
                        (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + telefono + "</td>" +
                        "<td id='email" + index + "'>" + item.email + "</td>" +
                        "<td id='empResult" + indexResult + "'>" + emprendimiento.nombreemprendimiento + "</td>" +
                        "<td align='center'><button type='button' onclick='ver(" + indexResult + ")' " + (emprendimiento.idemprendimiento == null ? "disabled" : "") + " class='btn btn-sm btn-rounded btn-info btn-ver' data-toggle='tooltip' data-placement='top' title='Ver'><i class='fas fa-eye'></i></button>" +
                        "<button type='button' onclick='registrar(" + indexResult + ")' " + (emprendimiento.idemprendimiento == null ? "disabled" : "") + " class='btn btn-sm btn-rounded btn-secondary btn-Registrar' data-toggle='tooltip' data-placement='top' title='Registrar'><i class='fas fa-edit'></i></button></td>" +
                        "</tr>";
                $('#tableData tr:last').after(row);
                indexResult += 1;

            });
            $("#inputApellido").val("");
            $("#inputApellido2").val("");
            $("#inputNombre").val("");
            $("#inputNombre2").val("");
        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
    }
}

function getEmprendimientoXDOC(doc) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientoXDOC",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {documento: doc, estados: JSON.stringify(estados),
            idcajacompensacion: idcajacompensacion},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                emprendimiento = result.emprendimientos[0];
            } else {
                emprendimiento.nombreemprendimiento = result.descripcion;
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
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
    emprendimientos.push(emprendimiento);
}

function guardar() {
    var request = {};
    var requestFinanciero = {};
    var url;
    var formalizado = $("input[name=formalizadoR]:checked").val();

    request['idEmprendimiento'] = idEmprendimiento;
    request['idFuncionario'] = idfuncionario;
    request['idcajacompensacion'] = idcajacompensacion;
    request['formalizado'] = formalizado;
    if (formalizado == "si") {
        request['idFormalizado'] = idFormalizado;
        var email = $("#emailR").val();
        if (!validateEmail(email)) {
            swal({
                title: "Consulta Beneficiario",
                text: _mensajes.correoInvalido + email,
                type: "error",
                confirmButtonText: "Aceptar"
            });
            return false;
        } else {
            url = "/registrarFormalizado";
            formalizado = 1;
            var nombreEmpresa = $("#nombreEmpresaR").val();
            var nit = $("#nitR").val();
            var nRegistroMercantil = $("#nRegistroMercantilR").val();
            var nombreRepresentante = $("#nombreRepresentanteR").val();
            var direccion = $("#direccionR").val();
            var telefono = $("#telefonoR").val();
            var municipio = $("#municipioR").val();


            var web = $("#webR").val();
            var constitucion = $("#constitucionFR").val();
            var sector = $("#sectorFR").val();
            var paisesComercializa = [];

            $("#paisesR").each(function () {
                paisesComercializa.push($(this).val());
            });
            var negInternet = $("input[name=negInternetR]:checked").val();
            if (negInternet == "si") {
                negInternet = 1;
            } else {
                negInternet = 0;
            }

            var prodServ = $("#prodServFR").val();
            var fechaRenov = $("#fechaRenovR").val();
            var fechaInicio = $("#fechaInicioR").val();
            var actividad = $("#actividadR").val();
            var empDirectos = $("#empDirectosR").val();
            var empIndirectos = $("#empIndirectosR").val();
            if (moment(fechaInicio) >= new Date()) {
                swal({
                    title: "Registrar Emprendimiento",
                    text: _mensajes.fechaInicioNoPasada,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
                return false;
            }

            if (moment(fechaRenov) < new Date()) {
                swal({
                    title: "Registrar Emprendimiento",
                    text: _mensajes.fechaRenovacionNoPasada,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
                return false;
            }




            request['nombreEmpresa'] = nombreEmpresa;
            request['nit'] = nit;
            request['nRegistroMercantil'] = nRegistroMercantil;
            request['nombreRepresentante'] = nombreRepresentante;
            request['direccion'] = direccion;
            request['telefono'] = telefono;
            request['idmunicipio'] = municipio;
            request['email'] = email;
            request['web'] = web;

            request['constitucion'] = constitucion;
            request['sector'] = sector;

            request['paisesComercializa'] = paisesComercializa;
            request['negInternet'] = negInternet;
            request['prodServ'] = prodServ;
            request['fechaRenov'] = moment(fechaRenov).format('YYYY-MM-DD').toString();
            request['fechaInicio'] = moment(fechaInicio).format('YYYY-MM-DD').toString();
            request['actividad'] = actividad;
            request['empDirectos'] = empDirectos;
            request['empIndirectos'] = empIndirectos;
        }
    } else {
        formalizado = 0;
        url = "/registrarNoEstablecido";
        var constitucionN = $("#constitucionNR").val();
        var sectorN = $("#sectorNR").val();
        var prodServ = $("#prodServNR").val();
        var cuandoInicia = $("#cuandoIniciaR").val();
        var observaciones = $("#observacionesR").val();

        request['idNoEstablecido'] = idNoEstablecido;
        request['constitucion'] = constitucionN;
        request['sector'] = sectorN;
        request['prodServ'] = prodServ;
        request['cuandoInicia'] = cuandoInicia;
        request['observaciones'] = observaciones;
    }


    //Datos Financieros
    requestFinanciero['recursospropiosae'] = $("#rPropios").val();
    requestFinanciero['empleosgenerados'] = $("#empGenerados").val();
    requestFinanciero['empleosporgenerar'] = $("#empPorGenerar").val();
    requestFinanciero['capitaltotal'] = $("#cTotal").val();
    requestFinanciero['capitaltrabajo'] = $("#cTrabajo").val();
    requestFinanciero['mesespuntoequilibrio'] = $("#mEquilibrio").val();
    var plan = $("input[name=plan]:checked").val();
    var finalizado = false;

    if ($("input[name=finalizado]").is(":checked")) {
        finalizado = true;
    }
    if (plan == "si") {
        plan = 1;
    } else {
        plan = 0;
    }

    request['requierePlan'] = plan;
    request['finalizado'] = finalizado;
    request['observacionesS'] = $("#obSeguimiento").val();

    $(".preloader").fadeIn();
    jQuery.ajax({
        method: "POST",
        url: context + "/registrarInformacionSeguimiento",
        dataType: "json",
        async: false,
        data: {requestEmp: JSON.stringify(request),
            requestFinan: JSON.stringify(requestFinanciero)},
        done: function () {
            $(".preloader").fadeOut();
        },
        success: function (result, status, xhr) {
            if (result.status == "1") {
                swal({
                    title: "Registrar Seguimiento",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/");
                });
            } else {
                swal({
                    title: "Registrar Seguimiento",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Registrar Seguimiento",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
    $(".preloader").fadeOut();
}

function ver(i) {
    var emp = emprendimientos[i];
    $("#asociados").empty();
    $('#nombreEmprendimiento').text(emp.nombreemprendimiento);
    $('#tEmprendimiento').text(emp.tipoemprendimiento.nombretipoemprendimiento);
    emp.asociadoses.forEach(function (item) {
        $("#asociados").append("<li>" + item.beneficiario.primernombre + " " +
                item.beneficiario.primerapellido + "</li>");
    });

    if (emp.formalizados.length != 0) {
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

        $("#paises").empty();
        formalizado.paisescomercializas.forEach(function (item) {
            $("#paises").append("<li>" + item.paises.nombrepais + "</li>");
        });

        $("#prodServF").empty();
        formalizado.productoservicioofrece.split(",").forEach(function (item) {
            $("#prodServF").append("<li>" + item + "</li>");
        });

//        $('#prodServF').text(formalizado.productoservicioofrece);
        $('#fechaRenov').text(moment(formalizado.fecharenovacion).format("DD-MM-YYYY"));
        $('#fechaInicio').text(moment(formalizado.fechainiciolabores).format("DD-MM-YYYY"));
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
        $('#cuandoInicia').text(moment(noEstablecido.cuandoinicia).format("DD-MM-YYYY"));
        $('#observaciones').text(noEstablecido.observaciones);
    }
    $('#modalVerEmprendimiento').modal("show");
}

function registrar(i) {
    var emp = emprendimientos[i];
    idEmprendimiento = emp.idemprendimiento;
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
                $('#rPropios').val(financiero.recursospropiosae);
                $('#empGenerados').val(financiero.empleosgenerados);
                $('#empPorGenerar').val(financiero.empleosporgenerar);
                $('#cTotal').val(financiero.capitaltotal);
                $('#cTrabajo').val(financiero.capitaltrabajo);
                $('#mEquilibrio').val(financiero.mesespuntoequilibrio);
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Consulta Beneficiario",
                    text: _mensajes.errorCargaInformacionFinanciera,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });


    $('#nombreEmprendimientoR').text(emp.nombreemprendimiento);
    $('#tEmprendimientoR').text(emp.tipoemprendimiento.nombretipoemprendimiento);
    beneficiarios = [];
    $("#asociadosR").empty();
    emp.asociadoses.forEach(function (item) {
        $("#asociadosR").append("<li>" + item.beneficiario.primernombre + " " +
                item.beneficiario.primerapellido + "</li>");
        beneficiarios.push(item.beneficiario.idbeneficiario);
    });

    idFormalizado = -1;
    idNoEstablecido = -1;
    if (emp.formalizados.length > 0) {
        divHijo = "#divFormalizadoR";
        $("#siFormalizadoR").prop("checked", true);
        $("input[name=formalizadoR]").attr('disabled', true);
        $("#radioFormalizado").hide();
        $("#divNoEstablecido").hide();
        $("#divFormalizado").show();
        var formalizado = emp.formalizados[0];
        idFormalizado = formalizado.idformalizacion;
        $('#nombreEmpresaR').val(formalizado.nombreempresa);
        $('#nitR').val(formalizado.nit);
        $('#nRegistroMercantilR').val(formalizado.numeroregistromercantil);
        $('#nombreRepresentanteR').val(formalizado.representantelegal);
        $('#direccionR').val(formalizado.direccionempresa);
        $('#telefonoR').val(formalizado.telefonoempresa);
        $("#departamentoR").val(formalizado.municipio.departamentos.id);

        $("#municipioR").empty();
        if (formalizado.municipio != null) {
            $("#municipioR").append($('<option>', {
                value: formalizado.municipio.id,
                text: formalizado.municipio.nombre
            }));
            $("#municipioR").val(formalizado.municipio.id);
            $("#municipioR").prop('disabled', false);
        }

        $('#emailR').val(formalizado.emailempresa);
        $('#webR').val(formalizado.sitioweb);

        if (formalizado.tipoconstitucionlegal != null) {
            $('#constitucionFR').val(formalizado.tipoconstitucionlegal.idtipoconstitucionlegal);
        }

        if (formalizado.sectorproductivo != null) {
            $('#sectorFR').val(formalizado.sectorproductivo.idsectorproductivo);
        }

        if (formalizado.negociosinternet == "0") {
            $("#noNegInternetR").prop("checked", true);
        } else {
            $("#siNegInternetR").prop("checked", true);
        }

        var lPaises = [];
        formalizado.paisescomercializas.forEach(function (item) {
            lPaises.push(item.paises.idpais);
        });
        $("#paisesR").val(lPaises);
        $("#paisesR").multiSelect("refresh");

        var tokens = formalizado.productoservicioofrece.split(",");
        tokens.forEach(function (item) {
            $('#prodServFR').tagsinput('add', item);
        });

        $('#fechaRenovR').val(moment(formalizado.fecharenovacion).format("YYYY-MM-DD"));
        $('#fechaInicioR').val(moment(formalizado.fechainiciolabores).format("YYYY-MM-DD"));


        $('#fechaRenovR').datetimepicker({
            format: "YYYY-MM-DD",
            locale: 'es',
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                left: "fa fa-arrow-up",
                rigth: "fa fa-arrow-down"
            }
        });
        $('#fechaInicioR').datetimepicker({
            format: "YYYY-MM-DD",
            locale: 'es',
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                left: "fa fa-arrow-up",
                rigth: "fa fa-arrow-down"
            }
        });

        if (formalizado.actividadinternacional != null) {
            $('#actividadR').val(formalizado.actividadinternacional.idactividadinternacional);
        }

        $('#empDirectosR').val(formalizado.empleosdirectos);
        $('#empIndirectosR').val(formalizado.empleosindirectos);
        $("#divNoEstablecidoR").hide();
        $("#divFormalizadoR").show();
    } else {
        divHijo = "#divNoEstablecidoR";
        var noEstablecido = emp.noestablecidos[0];
        idNoEstablecido = noEstablecido.idnoestablecido;
        $("#noFormalizadoR").prop("checked", true);
        $("#divFormalizado").hide();
        $("#divNoEstablecido").show();

        if (noEstablecido.tipoconstitucionlegal != null) {
            $('#constitucionNR').val(noEstablecido.tipoconstitucionlegal.idtipoconstitucionlegal);
        }

        if (noEstablecido.sectorproductivo != null) {
            $('#sectorNR').val(noEstablecido.sectorproductivo.idsectorproductivo);
        }

        var tokens = noEstablecido.productoservicioofrece.split(",");
        tokens.forEach(function (item) {
            $('#prodServNR').tagsinput('add', item);
        });

        $('#cuandoIniciaR').val(moment(noEstablecido.cuandoinicia).format("YYYY-MM-DD"));
        $('#cuandoIniciaR').datetimepicker({
            format: "YYYY-MM-DD",
            locale: 'es',
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                left: "fa fa-arrow-up",
                rigth: "fa fa-arrow-down"
            }
        });
        $('#observacionesR').text(noEstablecido.observaciones);
        $('#charsR').text(maxLength - noEstablecido.observaciones.length);
        $("#divFormalizadoR").hide();
        $("#divNoEstablecidoR").show();
    }
    $('.selectpicker').selectpicker('refresh');
    $('#modalRegistrarSeguimiento').modal("show");
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function showModal(m) {
    $("#" + m).modal("show");
}

function hideModal(m) {
    $("#" + m).modal("hide");
}
