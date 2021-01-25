var beneficiario = [];
var index = 0;
var validaciones = [];
var verificacion = [];
//var permiteRegistrar = true;
$(function () {
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
            $("#beneficiariosTabla").remove();
            $("#botonMensaje").remove();

        } else {
            $('#filtroDocumento').hide();
            $('#filtroNombres').show();
            $('input[name=documento]').prop('required', false);
            $('input[name=pNombre]').prop('required', true);
            $('input[name=pApellido]').prop('required', true);
            $("#beneficiariosTabla").remove();
            $("#botonMensaje").remove()
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
    var documento = $documento.val();
    if (documento === '')
        return false;

    $(".preloader").fadeIn();
    $.get(context + "/findBeneficiarioXDoc", {doc: documento, url: "consultaBeneficiario"}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Beneficiarios");
        beneficiario = data.beneficiarios;
        $(".preloader").fadeOut();
        //toastr.success("Buscar Beneficiario", "Beneficiarios encontrados!!.");
    });
}

function buscarXNombreApellido($pNombre, $sNombre, $pApellido, $sApellido) {
    var pNombre = $pNombre.val(),
            sNombre = $sNombre.val(),
            pApellido = $pApellido.val(),
            sApellido = $sApellido.val();
    if (pNombre === '' || pApellido === '')
        return false;

    $(".preloader").fadeIn();

    $.get(context + "/getBeneficiarioPorNombreYApellido",
            {
                pNombre: pNombre,
                sNombre: sNombre,
                pApellido: pApellido,
                sApellido: sApellido,
                url: "consultaBeneficiario"
            }, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Beneficiarios");
        beneficiario = data.beneficiarios;
        $(".preloader").fadeOut();
    });
}

$('.btn-validaciones').on('click', function (e) {
    index = $(this).data('index');
    verificarRequisitos();
});

$('.btn-registrar').on('click', function (e) {
    e.preventDefault();


    swal({
        title: "Registro de Beneficiario",
        text: _mensajes.seguroRegistrarBeneficiario,
        type: "info",
        showCancelButton: true,
        confirmButtonText: "Si",
        cancelButtonText: "No",
        closeOnConfirm: false,
    }, function (isConfirm) {
        if (isConfirm) {
            regBeneficiario();
        }
    });
});

function regBeneficiario() {

    if (beneficiario) {
        jQuery.ajax({
            method: "POST",
            url: context + "/regBeneficiario",
            data: {strBeneficiario: JSON.stringify(beneficiario)},
            //contentType: "application/json",
            dataType: "json",
            async: false,
            success: function (result, status, xhr) {
                beneficiario = result.beneficiario;
                $("#modalVerificacion").modal("hide");
                if (result.status == "2") {
                    swal({
                        title: "Registro de Beneficiario",
                        text: _mensajes.yaExisteBeneficiario,
                        type: "warning",
                        showCancelButton: true,
                        confirmButtonText: "Si",
                        cancelButtonText: "No"
                    }, function (isConfirm) {
                        if (isConfirm) {
                            $(".preloader").fadeIn();
                            loadView('Agendar Sesión', context + '/consultarAgendaSensibilizacion');
                        }
                    });
                } else if (result.status == "1") {
                    swal({
                        title: "Registro de Beneficiario",
                        text: _mensajes.registroBeneficiarioSatisfactorio,
                        type: "success",
                        showCancelButton: true,
                        confirmButtonText: "Si",
                        cancelButtonText: "No"
                    }, function (isConfirm) {
                        if (isConfirm) {
                            $(".preloader").fadeIn();
                            loadView('Agendar Sesión', context + '/consultarAgendaSensibilizacion');
                        }
                    });
                } else {
                    swal({
                        title: "Registro de Beneficiario",
                        text: result.descripcion,
                        type: "error",
                        confirmButtonText: "Aceptar",
                    });
                }
            }
        });
    } else {
        swal({
            title: "Consultar Beneficiario",
            text: _mensajes.beneficiarioNoPuedeRegistrar,
            type: "error",
            confirmButtonText: "Aceptar",
        });
    }
}

function verificarRequisitos() {
    var nombres = $("#nombres" + index).text();
    var apellidos = $("#apellidos" + index).text();
    var aux = nombres.indexOf(" ");
    var aux2 = apellidos.indexOf(" ");
    beneficiario = {
        numeroDocumento: $("#numerodocumento" + index).text(),
        tipoDocumento: $("#nombredocumento" + index).text(),
        primerNombre: nombres.substring(0, aux),
        segundoNombre: nombres.substring(aux + 1, nombres.length),
        primerApellido: apellidos.substring(0, aux2),
        segundoApellido: apellidos.substring(aux2 + 1, apellidos.length),
        telefonoContacto: $("#telefono" + index).text(),
        correoElectronico: $("#email" + index).text()
    };

    if (beneficiario) {
        jQuery.ajax({
            method: "POST",
            url: context + "/verificarRequisitos",
            data: {strBeneficiario: JSON.stringify(beneficiario)},
            //contentType: "application/json",
            dataType: "json",
            async: false,
            success: function (result, status, xhr) {
                if (result.status === "1") {
                    $('#simpc').text(result.simpc);
                    $('#cesante').text(result.cesante);
                    $('#aportes').text(result.aportes);
                    $('#recobro').text(result.recobros);
                    $('#prestaciones').text(result.ultimaPrestacion);

                    if (!result.permiteRegistrar) {
                        $('.btn-registrar').hide();
                        permiteRegistrar = false;
                    } else {
                        permiteRegistrar = true;
                    }

                    $("#modalVerificacion").modal("show");
                } else {
                    swal({
                        title: "Registro de Beneficiario",
                        text: result.descripcion,
                        type: "error",
                        confirmButtonText: "Aceptar",
                    });
                }
            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Registro de Beneficiario",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    swal({
                        title: "Registro de Beneficiario",
                        text: _mensajes.errorAjax,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                }
            }
        });
    }
}
