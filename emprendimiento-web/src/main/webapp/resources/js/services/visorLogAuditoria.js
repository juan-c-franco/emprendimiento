$(function () {

    $('.setDay').datetimepicker({
        format: "YYYY-MM-DD",
        locale: 'es',
        maxDate: new Date(),
        icons: {
            time: "fa fa-clock-o",
            date: "fa fa-calendar",
            left: "fa fa-arrow-up",
            rigth: "fa fa-arrow-down"
        }
    });


    $('#tableData').DataTable({
        language: datatableLanguageEs
    });

    $("#btnFiltro").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            buscarLog();

        }
    });

});

function buscarLog() {

    var fechaI = $("#fechaI").val();
    var fechaF = $("#fechaF").val();

    if (fechaI <= fechaF) {

        $(".preloader").fadeIn();
        $.get(context + "/getLogXFechas",
                {fechaI: fechaI, fechaF: fechaF}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Log de Auditoría");
            $(".preloader").fadeOut();
        });
    } else {
        swal({
            title: "Log de Auditoría",
            text: _mensajes.fechaInicialMenor,
            type: "error",
            confirmButtonText: "Aceptar"
        });
    }
}
