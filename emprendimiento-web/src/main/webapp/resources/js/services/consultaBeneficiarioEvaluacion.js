var beneficiarios = [];
var emprendimiento = {};
var emprendimientos = [];
var indexResult = 0;
var estados = ["3", "10"];
var response;
$(function () {
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
//            $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//            $("#mensajes > span").text(response.descripcion);
//            $("#mensajes").show();
        } else if (response.status == "1") {
            emprendimientos = [];
            var lBeneficiarios = response.beneficiariosDTO;
            if (lBeneficiarios.length == 0) {
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
                        "<td id='email" + indexResult + "'>" + item.email + "</td>" +
                        "<td id='empResult" + indexResult + "'>" + emprendimiento.nombreemprendimiento + "</td>" +
                        "<td align='center'><button type='button' onclick='agendar(" + indexResult + ")' " + (emprendimiento.idemprendimiento == null ? "disabled" : "") + " class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Agendar'><i class='fas fa-calendar-check'></i></button></td>" +
                        "</tr>";
                $('#tableData tr:last').after(row);
                indexResult += 1;
                //$("table tbody").append();

            });
            $("#inputDocumento").val("");
        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
//            $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//            $("#mensajes > span").text(_mensajes.respuestaNoReconocida);
//            $("#mensajes").show();
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
//            $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//            $("#mensajes > span").text(response.descripcion);
//            $("#mensajes").show();
        } else if (response.status == "1") {
            emprendimientos = [];
            var lBeneficiarios = response.beneficiariosDTO;
            if (lBeneficiarios.length == 0) {
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
                        "<td id='email" + indexResult + "'>" + item.email + "</td>" +
                        "<td id='empResult" + indexResult + "'>" + emprendimiento.nombreemprendimiento + "</td>" +
                        "<td align='center'><button type='button' onclick='agendar(" + indexResult + ")' " + (emprendimiento.idemprendimiento == null ? "disabled" : "") + " class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Agendar'><i class='fas fa-calendar-check'></i></button></td>" +
                        "</tr>";
                $('#tableData tr:last').after(row);
                indexResult += 1;
                //$("table tbody").append();

            });
            $("#inputApellido").val("");
            $("#inputApellido2").val("");
            $("#inputNombre").val("");
            $("#inputNombre2").val("");
        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
//            $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//            $("#mensajes > span").text(_mensajes.respuestaNoReconocida);
//            $("#mensajes").show();
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

function agendar(i) {
    var email = $('#email' + i).html();
    if (!validateEmail(email)) {
        errorMsg(_mensajes.correoInvalido + email);
//        $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//        $("#mensajes > span").text(_mensajes.correoInvalido + email);
//        $("#mensajes").show();
    } else {
        beneficiarios = [];
        emprendimientos[i].asociadoses.forEach(function (a) {
            beneficiarios.push(a.beneficiario.idbeneficiario);
        });
        loadView("Agendar Sesion Evaluación", context + '/agendarSesionEvaluacion')
    }
}
