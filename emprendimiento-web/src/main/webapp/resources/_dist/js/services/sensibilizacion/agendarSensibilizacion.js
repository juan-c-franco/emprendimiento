var localBeneficiario = beneficiario;
beneficiario = null;
var tiposesion = 1;
var soloProgramadas = 1;
$(function () {

    $('#btnAgendar').on('click', function (e) {
        e.preventDefault();
        if (!validationFormErrors(e, "#modalSesion")) {
            $("#btnAgendar").prop("disabled", true);
            asociarBeneficiario();
            $("#btnAgendar").prop("disabled", false);
        }
    });

    if (localBeneficiario) {
        if (!validateEmail()) {
            swal({
                title: "Agendar Sesión",
                text: _mensajes.correoInvalido + localBeneficiario.email,
                type: "error",
                confirmButtonText: "Aceptar"
            }, function () {
                loadView('Consultar Beneficiario', context + '/consultaBeneficiario');
            });
        }
        loaderSesiones(function (s) {

            var calendarEl = document.getElementById('calendar');
            var calendar = new FullCalendar.Calendar(calendarEl, {
                editable: true,
                eventLimit: true, // allow "more" link when too many events
                locale: 'es',
                selectMirror: true,
                contentHeight: 500,
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
                },
                events:
                        s,
                eventClick: function (element) {
                    $("#numerodocumento").val(localBeneficiario.numerodocumento);
                    $("#nombres").val(localBeneficiario.primernombre + " " + (localBeneficiario.segundonombre != null ? localBeneficiario.segundonombre : ""));
                    $("#apellidos").val(localBeneficiario.primerapellido + " " + (localBeneficiario.segundoapellido != null ? localBeneficiario.segundoapellido : ""));
                    $("#email").val(localBeneficiario.email !== "" ? localBeneficiario.email : "Sin Correo");
                    $("#fecha").val(moment(element.event.start).format("DD/MM/YYYY").toString());
                    $("#fechaInicio").val(moment(element.event.start).format("kk:mm").toString());
                    $("#fechaFinal").val(moment(element.event.end).format("kk:mm").toString());
                    $("#modalSesion").modal("show");
                    $("#idSesion").val(element.event.id);
                }
            });
            calendar.render();
        });
        $(".preloader").fadeOut();
    } else {
        swal({
            title: "Agendar Sesión",
            text: _mensajes.noBeneficiario,
            type: "error",
            confirmButtonText: "Aceptar"
        }, function () {
            loadView('Consultar Beneficiario', context + '/consultaBeneficiario');
        });
    }
});

function asociarBeneficiario() {
    var idSesion = $("#idSesion").val();
    jQuery.ajax({
        method: "POST",
        url: context + "/asociarBeneficiarioSensibilizacion",
        dataType: "json",
//        async: true,
        async: false,
        data: {idSesion: idSesion, idBeneficiario: localBeneficiario.idbeneficiario,
            email: localBeneficiario.email},
        beforeSend: function () {
//            toastr.info("Su sesión está siendo agendada.");
            $(".preloader").fadeIn();
            $("#modalSesion").modal("hide");
//            loadView('Consultar Beneficiario', context + '/consultaBeneficiario');
        },
        complete: function () {
            $(".preloader").fadeOut();
        },
        success: function (result, status, xhr) {
            $("#modalSesion").modal("hide");
            if (result.status == "1") {
//                toastr.success("Sesion agendada exitosamente!");
//                return false;
                swal({
                    title: "Agendar Sesión",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    $(".preloader").fadeIn();
                    loadView('Consultar Beneficiario', context + '/consultaBeneficiario');
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
                }, function (isConfirm) {
                    if (isConfirm) {
                        $(".preloader").fadeIn();
                        location.replace(context + "/");
                    }
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
                        sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                        sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                        jQuery.ajax({
                            method: "GET",
                            url: context + "/getAsistentesSesion",
                            dataType: "json",
                            async: false,
                            data: {idsesion: Number(array[index].idsesion)},
                            success: function (result, status, xhr) {
                                var cuposDisponibles = 0;
                                if (result.asistenciaDTO)
                                    cuposDisponibles = item.maxAsistentes - result.asistenciaDTO.length;
                                else
                                    cuposDisponibles = item.maxAsistentes;
                                sesion.title = "Cupos: " + cuposDisponibles.toString();
                                if (cuposDisponibles > 0) {
                                    sesion.className = 'bg-disponible';
                                    sesiones.push(sesion);
                                }
                            }
                        });
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
                        title: "Programar Sesión",
                        text: _mensajes.errorCargaSesiones,
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
    }
}

function validateEmail() {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    if (!re.test(String(localBeneficiario.email).toLowerCase())) {
        return false;
    }
    return true;
}

