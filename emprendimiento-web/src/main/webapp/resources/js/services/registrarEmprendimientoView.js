beneficiario = [];
var indexResult = 0;
var indexAgenda = 0;
var response = {};
var divHijo = "#divFormalizado";
var maxLength = 500;
$(function () {

    $("select[name='tEmprendimiento']").on('change', function () {
        if (this.value === "2") {
            $("#siFormalizado").prop("checked", true);
            $("#noFormalizado").prop("disabled", true);
            divHijo = "#divFormalizado";
            $("#divNoEstablecido").hide();
            $("#divFormalizado").show();
        } else {
            $("#noFormalizado").prop("disabled", false);
        }
    });

    $('#observaciones').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#chars').text(length);
    });
    $('.selectpicker').selectpicker();
    $('#paises').multiSelect({
        selectableHeader: "<label class='custom-header'>Lista de Paises</label>",
        selectionHeader: "<label class='custom-header'>Paises Seleccionados</label>"
    });

    $('#registrar').on('click', function (e) {
        $("#registrar").prop("disabled", true);
        var validationErrorBasicos = validationFormErrors(e, "#basicos");
        var validationErrorSelector = validationFormErrors(e, "#divSelector");
        var validationErrorHijo = validationFormErrors(e, divHijo);
        if (!(validationErrorBasicos || validationErrorSelector || validationErrorHijo)) {
            swal({
                title: "Registrar Emprendimiento",
                text: _mensajes.seguroRegistrarEmprendimiento,
                type: "info",
                showCancelButton: true,
                cancelButtonText: "No",
                confirmButtonText: "Si",
                closeOnConfirm: false,
            }, function () {
                $("#registrar").prop("disabled", true);
                regEmprendimiento();
                $("#registrar").prop("disabled", false);
            });
        } else {
            swal({
                title: "Registrar Emprendimiento",
                text: _mensajes.verificarCampos,
                type: "error",
                confirmButtonText: "Aceptar",
            });
        }
        $("#registrar").prop("disabled", false);
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
    $('input[type=radio][name=formalizado]').change(function () {
        if (this.value == 'si') {
            divHijo = "#divFormalizado";
            $("#divNoEstablecido").hide();
            $("#divFormalizado").show();
        } else if (this.value == 'no') {
            divHijo = "#divNoEstablecido";
            $("#divFormalizado").hide();
            $("#divNoEstablecido").show();
        }
    });
    jQuery("select[name='departamento']").change(function () {
        jQuery.ajax({
            type: "GET",
            url: context + "/getMunicipiosPorDepartamento",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            async: false,
            data: {iddepartamento: $("#departamento").val()},
            success: function (result, status, xhr) {
                $("#municipio").empty();
                if (result.status == "0") {
                    $("#municipio").append($("<option></option>").text("No hay municipios vinculados"));
                    $("#municipio").attr("disabled", true);
                    return false;
                }

                jQuery.each(result.municipios, function (i, item) {
                    $("#municipio").append($('<option>', {
                        value: item.id,
                        text: item.nombre
                    }));
                });
                $("#municipio").attr("disabled", false);
            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Registrar Emprendimiento",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    $("#municipio").append($("<option></option>").text("Error cargando municipios"));
                    $("#municipio").attr("disabled", true);
                }
            }
        });
        $('.selectpicker').selectpicker('refresh');
    }
    );
    $(".preloader").fadeOut();
});
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function moverOpcionesSeleccionada(de, a) {
    $("#" + de + " option:selected").each(function () {
        $("#" + a).append(this);
    });
}

function regEmprendimiento() {
//hideModal("modalRegistro");
    var request = {};
    var url;
    //var idFuncionario = $("#idFuncionario").val();
    //var idcajacompensacion = $("#idcajacompensacion").val();
    var nombreEmprendimiento = $("#nombreEmprendimiento").val();
    var tEmprendimiento = $("#tEmprendimiento").val();
    var formalizado = $("input[name=formalizado]:checked").val();
    request['idFuncionario'] = idfuncionario;
    request['idcajacompensacion'] = idcajacompensacion;
    request['nombreEmprendimiento'] = nombreEmprendimiento;
    request['tEmprendimiento'] = tEmprendimiento;
    request['formalizado'] = formalizado;
    if (formalizado == "si") {
        var email = $("#email").val();
        if (!validateEmail(email)) {
            swal({
                title: "Registrar Emprendimiento",
                text: _mensajes.correoInvalido + email,
                type: "error",
                confirmButtonText: "Aceptar"
            });
            //hideModal("modalRegistro");
            return false;
        } else {
            url = "/registrarFormalizado";
            formalizado = 1;
            var nombreEmpresa = $("#nombreEmpresa").val();
            var nit = $("#nit").val();
            var nRegistroMercantil = $("#nRegistroMercantil").val();
            var nombreRepresentante = $("#nombreRepresentante").val();
            var direccion = $("#direccion").val();
            var telefono = $("#telefono").val();
            var municipio = $("#municipio").val();
            var web = $("#web").val();
            var constitucion = $("#constitucionF").val();
            var sector = $("#sectorF").val();
            var paisesComercializa = [];
            $("#paises").each(function () {
                paisesComercializa.push($(this).val());
            });
            var negInternet = $(".negInternet:checked").val();
            if (negInternet == "si") {
                negInternet = 1;
            } else {
                negInternet = 0;
            }

            var prodServ = $("#prodServF").val();
            var fechaRenov = $("#fechaRenov").val();
            var fechaInicio = $("#fechaInicio").val();
            var actividad = $("#actividad").val();
            var empDirectos = $("#empDirectos").val();
            var empIndirectos = $("#empIndirectos").val();
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
            if (moment(fechaInicio) >= new Date()) {
                swal({
                    title: "Registrar Emprendimiento",
                    text: _mensajes.fechaInicioNoPasada,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
                //hideModal("modalRegistro");
                return false;
            }

            if (moment(fechaRenov) < new Date()) {
                swal({
                    title: "Registrar Emprendimiento",
                    text: _mensajes.fechaRenovacionNoPasada,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
                //hideModal("modalRegistro");
                return false;
            }

        }
    } else {
        formalizado = 0;
        url = "/registrarNoEstablecido";
        var constitucionN = $("#constitucionN").val();
        var sectorN = $("#sectorN").val();
        var prodServ = $("#prodServN").val();
        var cuandoInicia = $("#cuandoInicia").val();
        var observaciones = $("#observaciones").val();
        request['constitucion'] = constitucionN;
        request['sector'] = sectorN;
        request['prodServ'] = prodServ;
        request['cuandoInicia'] = cuandoInicia;
        request['observaciones'] = observaciones;
    }
    generarListaBeneficiarios();
    if (beneficiario.length == 0) {
        swal({
            title: "Registrar Emprendimiento",
            text: _mensajes.noBeneficiariosSeleccionados,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    } else {
        request['beneficiarios'] = beneficiario;
    }

    jQuery.ajax({
        method: "POST",
        url: context + url,
        dataType: "json",
        async: false,
        data: {requestEmp: JSON.stringify(request)},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                swal({
                    title: "Registrar Emprendimiento",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/");
                });
            } else {
                swal({
                    title: "Registrar Emprendimiento",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Registrar Emprendimiento",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Registrar Emprendimiento",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function buscarXDocumento($documento) {
    var documento = $documento.val();
    if (documento === '')
        return false;
    if (documento) {
        getBeneficiarioDOC(documento);
        if (response.status == "0") {
            errorMsg(response.descripcion);
            $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
            $("#mensajes > span").text(response.descripcion);
            $("#mensajes").show();
        } else if (response.status == "1") {
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length == 0) {
                errorMsg(_mensajes.sinResultados);
//                $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//                $("#mensajes > span").text(_mensajes.sinResultados);
//                $("#mensajes").show();
            } else {
                successMsg(_mensajes.beneficiariosCargados);
//                $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-success");
//                $("#mensajes > span").text(_mensajes.beneficiariosCargados);
//                $("#mensajes").show();
            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = "<tr id='beneficiariosTabla'>" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " +
                        (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " +
                        (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + item.telefono + "</td>" +
                        "<td id='eResult" + indexResult + "'>" + item.email + "</td>" +
                        "<td align='center'><button type='button' onclick='agregar(" + indexResult + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Agregar'><i class='fas fa-plus-circle'></i></button></td>" +
                        "</tr>";
                $('#resultBeneficiarios tr:last').after(row);
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
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length == 0) {
                errorMsg(_mensajes.sinResultados);
            } else {
                successMsg(_mensajes.beneficiariosCargados);
            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = "<tr id='beneficiariosTabla' >" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " + (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " + (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + item.telefono + "</td>" +
                        "<td id='eResult" + indexResult + "'>" + item.email + "</td>" +
                        "<td align='center'><button type='button' onclick='agregar(" + indexResult + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Agregar'><i class='fas fa-plus-circle'></i></button></td>" +
                        "</tr>";
                $('#resultBeneficiarios tr:last').after(row);
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

function agregar(i) {
    var email = $('#eResult' + i).html();
    if (!validateEmail(email)) {
        errorMsg(_mensajes.correoInvalido + email);
        $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
        $("#mensajes > span").text(_mensajes.correoInvalido + email);
        $("#mensajes").show();
    } else if (yaAgendado(email)) {
        warningMsg(_mensajes.yaExisteCorreoElectronico + email);
    } else {
        var row = "<tr id='agendar" + indexAgenda + "'>" +
                "<td id='idAgenda' hidden>" + $('#idResult' + i).html() + "</td>" +
                "<td id='dAgenda'>" + $('#dResult' + i).html() + "</td>" +
                "<td id='tdAgenda'>" + $('#tdResult' + i).html() + "</td>" +
                "<td id='nAgenda'>" + $('#nResult' + i).html() + "</td>" +
                "<td id='aAgenda'>" + $('#aResult' + i).html() + "</td>" +
                "<td id='tAgenda'>" + $('#tResult' + i).html() + "</td>" +
                "<td id='eAgenda'>" + $('#eResult' + i).html() + "</td>" +
                "<td align='center'><input type='radio' name='lider' value='" + $('#idResult' + i).html() + "' checked='checked'></td>" +
                "<td align='center'><button type='button' onclick='eliminar(" + indexAgenda + ")' class='btn btn-sm btn-rounded btn-danger' data-toggle='tooltip' data-placement='top' title='Eliminar'><i class='fas fa-trash-alt'></i></button></td>" +
                "</tr>";
        $('#listaBeneficiarios tr:last').after(row);
        indexAgenda += 1;
    }
}

function eliminar(i) {
    $('#agendar' + i).remove();
}

function generarListaBeneficiarios() {
    beneficiario = [];
    var idLider = $('input[name=lider]:checked').val();
    $('#listaBeneficiarios tr').each(function (a, b) {
        id = $('#idAgenda', b).text();
        if (id != "") {
            if (id == idLider) {
                beneficiario.splice(0, 0, id);
            } else {
                beneficiario.push(id);
            }
        }
    });
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function yaAgendado(email) {
    var id;
    var result = false;
    $('#listaBeneficiarios tr').each(function (a, b) {
        id = $('#eAgenda', b).text();
        if (id == email) {
            result = true;
        }
    });
    return result;
}


