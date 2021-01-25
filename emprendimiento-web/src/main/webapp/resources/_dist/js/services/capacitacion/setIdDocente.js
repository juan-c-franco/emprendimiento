var iddocente = -1;
var idsede = -1;
var idcapacitacion = -1;
var idoferente = -1;

function cargarDatosPagina() {
    $(".preloader").fadeIn();
    url = $("#url").val();
    $("#body_content").load(context + url);
}


jQuery(document).ready(function () {
    $(".preloader").fadeOut();
    $('.selectpicker').selectpicker();

    $('#btnConsulta').on('click', function (e) {
        e.preventDefault();
        if (!validationFormErrors(e, "#loadFrame")) {
            $("#btnConsulta").prop("disabled", true);
            cargarDatosPagina();
            $("#btnConsulta").prop("disabled", false);
        }
    });

    jQuery("select[name='idoferente']").change(function () {
        $(".preloader").fadeIn();
        jQuery.ajax({
            type: "GET",
            url: context + "/getSedesPorOferente",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            async: false,
            data: {idoferente: $("#idoferente").val()},
            success: function (result, status, xhr) {
                $(".preloader").fadeOut();
                if (result.status == "1") {
                    $("#idsede").empty();
                    if (result.sedes.length <= 0) {
                        $("#idsede").append($("<option></option>").text("No hay sedes vinculados"));
                        $("#idsede").prop("disabled", true);
                        return false;
                    }
                    $("#idsede").append($("<option value =''' selected> -- Seleccione Sede -- </option>"));
                    jQuery.each(result.sedes, function (i, item) {

                        $("#idsede").append($('<option>', {
                            value: item.id,
                            text: item.nombre
                        }));
                    });
                    idoferente = jQuery("select[name='idoferente']").val();
                    $("#idsede").prop("disabled", false);
                } else {
                    $("#idsede").append($("<option></option>").text("Error cargando sedes"));
                    $("#idsede").prop("disabled", true);
                }
            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Selección de Docente",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    $(".preloader").fadeOut();
                    $("#idsede").append($("<option></option>").text("Error cargando sedes"));
                    $("#idsede").prop("disabled", true);
                }
            }
        });
        $('.selectpicker').selectpicker('refresh');

    }

    );


    jQuery("select[name='iddocente']").change(function () {
        iddocente = jQuery("select[name='iddocente']").val();
    }
    );

    jQuery("select[name='idsede']").change(function () {
        idsede = jQuery("select[name='idsede']").val();
    }
    );

    jQuery("select[name='idcapacitacion']").change(function () {
        idcapacitacion = jQuery("select[name='idcapacitacion']").val();
    }
    );


});