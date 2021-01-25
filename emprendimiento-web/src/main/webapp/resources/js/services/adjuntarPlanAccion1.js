beneficiario = [];
var response = {};
var lTable;

$(function () {
    $(".preloader").fadeOut();

    lTable = $('.tablaData').DataTable({
        language: datatableLanguageEs,
        columns: [
            {title: "Emprendimiento"},
            {title: "Estado Emprendimiento"},
            {title: "Tipo de Emprendimiento"},
            {title: "Accion", className: "text-center"}
        ]
    });

    $('input:radio[name=selectBeneficiario]').on('change', function () {
        if (this.value === '1') {
            $('#filtroDocumento').show();
            $('#filtroNombres').hide();
            $('input[name=documento]').prop('required', true);
            $('input[name=nombre]').prop('required', false);
            $('#resultBeneficiarios').dataTable().fnClearTable();
            $("#mensajes").hide();

        } else {
            $('#filtroDocumento').hide();
            $('#filtroNombres').show();
            $('input[name=documento]').prop('required', false);
            $('input[name=nombre]').prop('required', true);
            $('#resultBeneficiarios').dataTable().fnClearTable();
            $("#mensajes").hide();
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
            var $nombre = $("input[name=nombre]");
            $nombre.jqBootstrapValidation();
            $nombre.trigger("change.validation", {submitting: true});


            buscarXNombreApellido($nombre);
        }
    });
});


function buscarXDocumento($documento) {
    var dataSet = [];
    var documento = $documento.val();
    if (documento === '')
        return false;
    $("#inputDocumento").val("");
    if (documento) {
        getEmprendimientoPorDoc(documento);
        if (response.status === "0") {
            errorMsg(response.descripcion);
        } else if (response.status === "1") {
            var lbeneficiarios = response.emprendimientos;
            if (lbeneficiarios.length === 0) {
                errorMsg(_mensajes.sinResultados2);
            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = [];
                row.push(item.nombreemprendimiento);
                row.push(item.estadoemprendimiento.nombreestadoemprendimiento);
                row.push(item.tipoemprendimiento.nombretipoemprendimiento);
                row.push("<button type='button' onclick='adjuntar(" + item.idemprendimiento + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='adjuntar'><i class='fas fa-plus-circle'></i></button>");
                dataSet.push(row);
            });

        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
        if (lTable !== null) {
            lTable.destroy();
        }
        lTable = $('.tablaData').DataTable({
            language: datatableLanguageEs,
            data: dataSet,
            columns: [
                {title: "Emprendimiento"},
                {title: "Estado Emprendimiento"},
                {title: "Tipo de Emprendimiento"},
                {title: "Accion", className: "text-center"}
            ]
        });
    }
}


function buscarXNombreApellido($nombre) {
    var dataSet = [];
    var nombreEmprendimiento = $nombre.val();
    if (nombreEmprendimiento === '')
        return false;
    $("#inputEmprendimiento").val("");
    if (nombreEmprendimiento) {
        getEmprendimientoPorNombre(nombreEmprendimiento);
        if (response.status === "0") {
            errorMsg(response.descripcion);
        } else if (response.status === "1") {
            var lbeneficiarios = response.emprendimientos;
            if (lbeneficiarios.length === 0) {
                errorMsg(_mensajes.sinResultados2);
            }
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = [];
                row.push(item.nombreemprendimiento);
                row.push(item.estadoemprendimiento.nombreestadoemprendimiento);
                row.push(item.tipoemprendimiento.nombretipoemprendimiento);
                var estadoPrueba = item.estadoemprendimiento.nombreestadoemprendimiento;
                if (estadoPrueba.includes("El emprendimiento no se encuentra en el estado necesario, estado actual:")) {
                    row.push("");
                } else {
                    row.push("<button type='button' onclick='adjuntar(" + item.idemprendimiento + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='adjuntar'><i class='fas fa-plus-circle'></i></button>");
                }

                dataSet.push(row);

            });

        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
        if (lTable !== null) {
            lTable.destroy();
        }
        lTable = $('.tablaData').DataTable({
            language: datatableLanguageEs,
            data: dataSet,
            columns: [
                {title: "Emprendimiento"},
                {title: "Estado Emprendimiento"},
                {title: "Tipo de Emprendimiento"},
                {title: "Accion", className: "text-center"}
            ]
        });
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
        error: function (xhr, status, error) {
            errorMsg(_mensajes.errorCargaBeneficiario);
        }
    });
}

function getEmprendimientoPorDoc(doc) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientoPorDocSeguimiento",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {documento: doc, idcajacompensacion: idcajacompensacion},
        success: function (result, status, xhr) {
            $("#mensajes").hide();
            response = result;
        },
        error: function (xhr, status, error) {
            errorMsg(_mensajes.errorCargaBeneficiario);
        }
    });
}

function getEmprendimientoPorNombre(nombreEmprendimiento) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientoPorNombreSeguimiento",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {nombreEmprendimiento: nombreEmprendimiento, idcajacompensacion: idcajacompensacion},
        success: function (result, status, xhr) {
            $("#mensajes").hide();
            response = result;
        },
        error: function (xhr, status, error) {
            errorMsg(_mensajes.errorCargaBeneficiario);
        }
    });
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}


function  adjuntar(idEmprendimiento) {
    $(".preloader").fadeIn();
    $.get(context + "/adjuntarPlanAccion2", {emprendimientoId: idEmprendimiento}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Adjuntar Plan de Accion");
        $(".preloader").fadeOut();
    });
}
