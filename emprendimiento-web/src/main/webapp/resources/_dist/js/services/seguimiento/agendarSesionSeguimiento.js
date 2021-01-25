var contador = 0;
var localBeneficiario = beneficiarios;
var idSesion;
beneficiarios = null;
var tiposesion = 4;
var soloProgramadas = 1;
var estadoSesion = 6;
$(function () {

    if (localBeneficiario && localBeneficiario.length != 0 && idfuncionario) {

        loaderSesiones(function (s) {

            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                locale: 'es',
                selectMirror: true, height: 500,
                themeSystem: 'bootstrap4',
                selectable: true,
                StartEditable: false,

                header: {
                    left: 'prev,next today',
                    center: 'title',
                    right: 'month,agendaWeek'
                },
                views: {
                    month: {
                        columnHeaderFormat: {
                            weekday: 'long'
                        }
                    },
                    week: {
                        columnHeaderFormat: {
                            day: '2-digit', weekday: 'long'
                        },
                        titleFormat: {year: 'numeric', month: 'long'}
                    }
                }, events:
                        s,
                eventClick: function (element) {
                    idSesion = element.event.id;
                    swal({
                        title: "Agendar Sesión",
                        text: _mensajes.seguroAgendar,
                        type: "info",
                        showCancelButton: true,
                        cancelButtonText: "No",
                        confirmButtonText: "Si",
                        closeOnConfirm: false,
                    }, function () {
                        asociarBeneficiarios();
                    });
                }
            });
            calendar.render();
        });
    } else {
        swal({
            title: "Agendar Sesión",
            text: _mensajes.parametrosNoValidosAgendarValoracion,
            type: "error",
            confirmButtonText: "Aceptar"
        }, function () {
            location.replace(context + "/");
        });
    }
});

function asociarBeneficiarios() {
    var request = JSON.stringify({idSesion: idSesion, beneficiarios: localBeneficiario,
        tipoSesion: tiposesion, estadoEmprendimiento: estadoSesion});
    jQuery.ajax({
        method: "POST",
        url: context + "/asociarBeneficiariosEvaluacionSeguimiento",
        data: {requestEmp: request},
        //contentType: "application/json",
        dataType: "json",
        async: false,
        success: function (result, status, xhr) {
            if (result.status == "1") {
                swal({
                    title: "Agendar Sesión",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function (isConfirm) {
                    if (isConfirm) {
                        $(".preloader").fadeIn();
                        location.replace(context + "/");
                    }
                });
            } else {
                swal({
                    title: "Agendar Sesión",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function loaderSesiones(s) {
    if (idfuncionario !== "") {
        var sesiones = [];
        jQuery.ajax({
            method: "GET",
            url: context + "/cargarSesiones",
            dataType: "json",
            async: false,
            data: {idFuncionario: idfuncionario, tiposesion: tiposesion,
                todas: soloProgramadas},
            success: function (result, status, xhr) {
                if (result.status == "1") {
                    result = result.sesiones;
                    result.forEach(function (item, index, array) {
                        var sesion = {};
                        sesion.id = Number(array[index].idsesion);
                        sesion.title = "Disponible";
                        sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                        sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                        sesion.className = 'bg-disponible';
                        sesiones.push(sesion);
                    });
                    s(sesiones);
                } else {
                    swal({
                        title: "Programar Sesión",
                        text: result.descripcion,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function (isConfirm) {
                        if (isConfirm) {
                            $(".preloader").fadeIn();
                            location.replace(context + "/");
                        }
                    });
                }
            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Agendar Sesión",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    swal({
                        title: "Agendar Sesión",
                        text: _mensajes.errorAjax,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function (isConfirm) {
                        if (isConfirm) {
                            $(".preloader").fadeIn();
                            location.replace(context + "/");
                        }
                    });
                }
            }
        });
//        $.get(context + "/cargarSesiones", {idFuncionario: idfuncionario, tiposesion: tiposesion,
//            todas: soloProgramadas}, function (data) {
//            data.forEach(function (item, index, array) {
//                var sesion = {};
//                sesion.id = Number(array[index].idsesion);
//                sesion.title = "Disponible";
//                sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
//                sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
//                sesion.className = 'bg-disponible';
//                sesiones.push(sesion);
//            });
//            s(sesiones);
//        });
    }
}