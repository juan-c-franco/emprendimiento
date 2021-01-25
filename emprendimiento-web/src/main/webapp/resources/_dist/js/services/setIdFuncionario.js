idfuncionario = 0;
idcajacompensacion = 0;
function cargarDatosPagina() {
    $(".preloader").fadeIn();
    grupo = $("#grupo").val();
    idbeneficiario = $("#idbeneficiario").val();
    url = $("#url").val();
    idcajacompensacion = $("#idcajacompensacion").val();
    idfuncionario = $("#idfuncionario").val();
    $("#body_content").load(context + url, {idcajacompensacion: idcajacompensacion,
        idfuncionario: idfuncionario, idbeneficiario: idbeneficiario});
}


jQuery(document).ready(function () {
    $(".preloader").fadeOut();
    $('.selectpicker').selectpicker();

    jQuery("select[name='idcajacompensacion']").change(function () {
        $(".preloader").fadeIn();
        jQuery.ajax({
            type: "GET",
            url: context + "/traerFuncionarios",
            contentType: "application/x-www-form-urlencoded; charset=UTF-8",
            dataType: "json",
            async: false,
            data: {idCaja: $("#idcajacompensacion").val(), grupo: $("#grupo").val()},
            success: function (result, status, xhr) {
                $(".preloader").fadeOut();
                $("#idfuncionario").empty();
                if (!result[0]) {
                    $("#idfuncionario").append($("<option></option>").text("No hay funcionarios vinculados"));
                    $("#idfuncionario").prop("disabled", true);
                    $("#btnConsulta").prop("disabled", true);
                    return false;
                }

                jQuery.each(result, function (i, item) {
                    var texto = "";
                    if (item.primernombre != null)
                        texto += item.primernombre;
                    if (item.segundonombre != null)
                        texto += " " + item.segundonombre;
                    if (item.primerapellido != null)
                        texto += " " + item.primerapellido;
                    if (item.segundoapellido != null)
                        texto += " " + item.segundoapellido;

                    $("#idfuncionario").append($('<option>', {
                        value: item.idfuncionario,
                        text: texto
                    }));
                });
                $("#idfuncionario").prop("disabled", false);
                $("#btnConsulta").prop("disabled", false);

            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Selección de Funcionario",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    $(".preloader").fadeOut();
                    $("#idfuncionario").append($("<option></option>").text("Error cargando funcionarios"));
                    $("#idfuncionario").prop("disabled", true);
                    $("#btnConsulta").prop("disabled", true);
                }
            }
        });
        $('.selectpicker').selectpicker('refresh');

    }

    );


    jQuery("select[name='idfuncionario']").change(function () {
        idfuncionario = jQuery("select[name='idfuncionario']").val();
        $("#btnConsulta").prop("disabled", false);
    }
    );


});

