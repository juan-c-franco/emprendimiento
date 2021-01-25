beneficiario = [];
var response = {};
var lTable;
$(function () {
    $(".preloader").fadeOut();

    lTable = $('.tablaData').DataTable({
        language: datatableLanguageEs,
        columns: [
            {title: "Documento"},
            {title: "Tipo Documento"},
            {title: "Nombres"},
            {title: "Apellidos"},
            {title: "Teléfono"},
            {title: "Correo"},
            {title: "Accion", className: "text-center"}
        ]
    });

    $('input:radio[name=selectBeneficiario]').on('change', function () {

        if (this.value === '1') {
            $('#filtroDocumento').show();
            $('#filtroNombres').hide();
            $('input[name=documento]').prop('required', true);
            $('input[name=pNombre]').prop('required', false);
            $('input[name=pApellido]').prop('required', false);
            $("#mensajes").hide();
            $("#resultBeneficiarios").dataTable().fnClearTable();
        } else {
            $('#filtroDocumento').hide();
            $('#filtroNombres').show();
            $('input[name=documento]').prop('required', false);
            $('input[name=pNombre]').prop('required', true);
            $('input[name=pApellido]').prop('required', true);
            $("#resultBeneficiarios").dataTable().fnClearTable();
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
});


function buscarXDocumento($documento) {
    var dataSet = [];
    var documento = $documento.val();
    if (documento === '')
        return false;
    $("#inputDocumento").val("");
    if (documento) {
        getBeneficiarioDOC(documento);
        if (response.status === "0") {
            errorMsg(response.descripcion);
        } else if (response.status === "1") {
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length === 0) {
                errorMsg(_mensajes.sinResultados2);

            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = [];
                row.push(item.numerodocumento);
                row.push(item.tipodocumentoid.nombredocumento);
                row.push(item.primernombre + " " +
                        (item.segundonombre ? item.segundonombre : ""));
                row.push(item.primerapellido + " " +
                        (item.segundoapellido ? item.segundoapellido : ""));
                row.push(item.telefono);
                row.push(item.email);
                row.push("<button type='button' onclick='valorar(" + item.idbeneficiario + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Valorar'><i class='fas fa-plus-circle'></i></button>");
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
                {title: "Documento"},
                {title: "Tipo Documento"},
                {title: "Nombres"},
                {title: "Apellidos"},
                {title: "Teléfono"},
                {title: "Correo"},
                {title: "Accion", className: "text-center"}
            ]
        });
    }
}


function buscarXNombreApellido($pNombre, $sNombre, $pApellido, $sApellido) {
    var dataSet = [];
    var pNombre = $pNombre.val(),
            sNombre = $sNombre.val(),
            pApellido = $pApellido.val(),
            sApellido = $sApellido.val();
    if (pNombre === '' || pApellido === '')
        return false;
    $("#inputNombre").val("");
    $("#inputNombre2").val("");
    $("#inputApellido").val("");
    $("#inputApellido2").val("");
    if (pNombre && pApellido) {
        getBeneficiarioNombreApellido(pNombre, sNombre, pApellido, sApellido);
        if (response.status === "0") {
            errorMsg(response.descripcion);

        } else if (response.status === "1") {
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length === 0) {
                errorMsg(_mensajes.sinResultados2);
            }
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = [];
                row.push(item.numerodocumento);
                row.push(item.tipodocumentoid.nombredocumento);
                row.push(item.primernombre + " " +
                        (item.segundonombre ? item.segundonombre : ""));
                row.push(item.primerapellido + " " +
                        (item.segundonombre !== null ? item.segundoapellido : ""));
                row.push(item.telefono);
                row.push(item.email);
                row.push("<button type='button' onclick='valorar(" + item.idbeneficiario + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Valorar'><i class='fas fa-plus-circle'></i></button>");
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
                {title: "Documento"},
                {title: "Tipo Documento"},
                {title: "Nombres"},
                {title: "Apellidos"},
                {title: "Teléfono"},
                {title: "Correo"},
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

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}


function  valorar(idBeneficiario) {

    $.get(context + "/traerValoracionIndividual", {idBeneficiario: idBeneficiario,
        idFuncionario: idfuncionario, idcajacompensacion: idcajacompensacion}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Valoracion individual");
    });
}