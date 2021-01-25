beneficiario = [];
var indexResult = 0;
var indexAgenda = 0;
var response = {};
$(function () {

    if (typeof idBeneficiario !== 'undefined' && idBeneficiario) {
        getBeneficiarioId(idBeneficiario);
        if (response.status == "0") {
            errorMsg(response.descripcion);
        } else if (response.status == "1") {
            $("#mensajes").hide();
            var lbeneficiarios = response.beneficiariosDTO;
            jQuery.each(lbeneficiarios, function (i, item) {
                var telefono = "";
                if (item.telefono != 0) {
                    telefono = item.telefono;
                }
                var row = "<tr id='agendar" + indexAgenda + "'>" +
                        "<td id='idAgenda' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dAgenda'>" + item.numerodocumento + "</td>" +
                        "<td id='tdAgenda'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nAgenda'>" + item.primernombre + " " + (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aAgenda'>" + item.primerapellido + " " + (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tAgenda'>" + telefono + "</td>" +
                        "<td id='eAgenda'>" + item.email + "</td>" +
                        "<td>Beneficiario en sesión</td>" +
                        "</tr>";
                $('#listaBeneficiarios tr:last').after(row);
                indexAgenda += 1;
            });

        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
    }

    $('.dataTablas').DataTable({
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
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length == 0) {
                errorMsg(_mensajes.sinResultados);
            } else {
                successMsg(_mensajes.beneficiariosCargados);
            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
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
                var telefono = "";
                if (item.telefono != 0) {
                    telefono = item.telefono;
                }
                var row = "<tr id='beneficiariosTabla'>" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " + (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " + (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + telefono + "</td>" +
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

function getBeneficiarioId(id) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getBeneficiarioID",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {id: id},
        success: function (result, status, xhr) {
            $("#mensajes").hide();
            response = result;
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
                errorMsg(_mensajes.errorCargaBeneficiario);
            }
        }
    });
}

function agregar(i) {
    var email = $('#eResult' + i).html();
    if (!validateEmail(email)) {
        errorMsg(_mensajes.correoInvalido + email);
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
                "<td align='center'><button type='button' onclick='eliminar(" + indexAgenda + ")' class='btn btn-sm btn-rounded btn-danger' data-toggle='tooltip' data-placement='top' title='Eliminar'><i class='fas fa-trash-alt'></i></button></td>" +
                "</tr>";
        $('#listaBeneficiarios tr:last').after(row);
        indexAgenda += 1;
    }
}

function eliminar(i) {
    $('#agendar' + i).remove();
}

function agendar() {
    var id;
    $('#listaBeneficiarios tr').each(function (a, b) {
        id = $('#idAgenda', b).text();
        if (id != "") {
            beneficiario.push(id);
        }
    });
    if (beneficiario.length == 0) {
        errorMsg(_mensajes.noBeneficiariosSeleccionados);

    } else {
        loadView("Agendar Sesion Valoracion", context + '/agendarSesionValoracion');
    }
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

