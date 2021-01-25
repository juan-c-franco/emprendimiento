var contador = 0;
var localEmprendimientos = idEmprendimientos;
var localNEmprendimientos = nEmprendimientos;
idEmprendimientos = null;
nEmprendimientos = null;
var soloProgramadas = 0;
var estadoSesion = 6;
var idSession;
var lTable;
var sesionComite;
$(function () {

    $('#btnActualizar').on('click', function (e) {
        e.preventDefault();
        if (!validationFormErrors(e, "#modalOpciones")) {
            $("#btnActualizar").prop("disabled", true);
            actualizarSesion();
            $("#btnActualizar").prop("disabled", false);
        }
    });

    if (localEmprendimientos && localEmprendimientos.length != 0 && idfuncionario) {
        $('#editDay').datetimepicker({
            format: "YYYY-MM-DD",
            locale: 'es',
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                left: "fa fa-arrow-up",
                rigth: "fa fa-arrow-down"
            }
        });
        $('.editHora').datetimepicker({
            format: 'HH:mm',
            useCurrent: false, //Important! See issue #1075
            icons: {
                time: "fa fa-clock-o",
                date: "fa fa-calendar",
                up: "fa fa-arrow-up",
                down: "fa fa-arrow-down"
            }
        });

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
                }, events: s,
                select: function (arg) {
                    args = arg;
                    var horaInicio = arg.startStr;
                    var horaFin = arg.endStr;
                    var dia = moment(horaInicio).format("YYYY-MM-DD");
                    if (new Date() >= new Date(dia)) {
                        swal({
                            title: "Agendar Sesion Comité",
                            text: _mensajes.sesionesPasado,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    } else {
                        $("#programDay").val(moment(horaInicio).format("YYYY-MM-DD"));
                        if (arg.view.type === 'agendaWeek') {
                            $("#horaInicio").val(moment(horaInicio).format('YYYY-MM-DD kk:mm'));
                            $("#horaFin").val(moment(horaFin).format('YYYY-MM-DD kk:mm'));
                            $("#horaFin").prop("disabled", true);
                            $("#horaInicio").prop("disabled", true);
                        } else {
                            $("#horaInicio").val("");
                            $("#horaFin").val("");
                            $("#horaFin").prop("disabled", false);
                            $("#horaInicio").prop("disabled", false);
                        }
                        $("#emprendimientosComite").empty();
                        localNEmprendimientos.forEach(function (item) {
                            $("#emprendimientosComite").append("<li>" + item + "</li>");
                        });
                        $("#modalProgramacion").modal("show");
                        $('#programar').on('click', function (e) {
                            e.preventDefault();
                            var validationError = validationFormErrors(e, "#modalProgramacion");
                            if (!validationError) {
                                if (args === arg) {
                                    if (arg.view.type === 'month') {
                                        horaInicio = arg.startStr + "T" + $("#horaInicio").val() + ":00";
                                        horaFin = arg.startStr + "T" + $("#horaFin").val() + ":00";
                                    }
                                    $("#programar").prop("disabled", true);
                                    guardaProgramacion($("#ubicacionComite").val(), moment(horaInicio).format('YYYY-MM-DD kk:mm'),
                                            moment(horaFin).format('YYYY-MM-DD kk:mm'));
                                    $("#programar").prop("disabled", false);
                                    calendar.unselect();
                                }
                            }
                        }
                        );
                    }
                },
                eventClick: function (element) {
                    idSession = element.event.id;
                    estadoSesion = element.event.title;
                    loadEditar();
                    $("#modalOpciones").modal("show");
                }
            });
            calendar.render();

            $('#horaInicio').datetimepicker({format: 'HH:mm', icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa  fa-arrow-up",
                    down: "fa fa-arrow-down",
                }});
            $('#horaFin').datetimepicker({
                format: 'HH:mm',
                useCurrent: false, //Important! See issue #1075
                icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa fa-arrow-up",
                    down: "fa fa-arrow-down",
                }
            });
        });
    } else {
        swal({
            title: "Agendar Sesión Comité",
            text: _mensajes.parametrosNoValidosAgendarLiderComite,
            type: "error",
            confirmButtonText: "Aceptar"
        }, function () {
            location.replace(context + "/");
        });
    }
});

function guardaProgramacion(ubicacion, fechaInicial, fechafin) {
    if (!verificarHoras()) {
        return false;
    }

    jQuery.ajax({
        method: "POST",
        url: context + "/guardarSesionComite",
        dataType: "json",
        async: false,
        data: {ubicacion: ubicacion, fechaInicial: fechaInicial.toString(),
            fechaFinal: fechafin.toString(), idFuncionario: idfuncionario,
            strEmprendimientos: JSON.stringify(localEmprendimientos)},
        success: function (result, status, xhr) {
            $("#modalProgramacion").modal("hide");
            if (result.status == "1") {
                swal({
                    title: "Agendar Sesión Comité",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    loadView('Agendar Sesión Comité', context + '/cargarDatosSesionComiteEvaluacion');
                });

            } else {
                swal({
                    title: "Agendar Sesión Comité",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Sesión Comité",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Sesión Comité",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function loaderSesiones(s) {
    var sesiones = [];
    jQuery.ajax({
        method: "GET",
        url: context + "/cargarSesionesComite",
        dataType: "json",
        async: false,
        data: {idFuncionario: idfuncionario, todas: soloProgramadas},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result = result.sesiones;
                result.forEach(function (item, index, array) {
                    var sesion = {};
                    sesion.id = Number(array[index].idsesioncomite);
                    sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                    sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                    if (new Date(array[index].fechainicio) < new Date() && (item.estadosesion.idestadosesion == 1 || item.estadosesion.idestadosesion == 4)) {
                        sesion.title = "Pendiente Calificación";
                        sesion.className = 'bg-registrar';
                    } else if (item.estadosesion.idestadosesion == 3) {
                        sesion.title = "Cancelada";
                        sesion.className = 'bg-cancelada';
                    } else if (item.estadosesion.idestadosesion == 4) {
                        sesion.title = "Reservada";
                        sesion.className = 'bg-reservada';
                    } else if (item.estadosesion.idestadosesion == 2) {
                        sesion.title = "Culminada";
                        sesion.className = 'bg-culminada';
                    } else {
                        sesion.title = "Disponible";
                        sesion.className = 'bg-disponible';
                    }
                    sesiones.push(sesion);
                });
                s(sesiones);
            } else {
                swal({
                    title: "Agendar Sesion Comité",
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
                    title: "Agendar Sesión Comité",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Sesion Comité",
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

function loadEditar() {
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Pendiente Calificacion") {
        swal({
            title: "Agendar Sesión Comité",
            text: _mensajes.noCambiosSesion,
            type: "warning",
            confirmButtonText: "Aceptar"
        });
        //bootbox.alert("No se puede cambiar el estado de esta sesion.");
        $(".noCambios").attr("disabled", true);
    } else if (estadoSesion == "Disponible") {
        $(".noCambios").attr("disabled", false);
        $(".liberar").attr("disabled", true);
    } else {
        $(".noCambios").attr("disabled", false);
    }

    sesionComite = null;
    jQuery.ajax({
        method: "GET",
        url: context + "/consultaSesionComiteXId",
        dataType: "json",
        async: false,
        data: {idSesion: idSession},
        success: function (result, status, xhr) {
            sesionComite = result;
            var dif = Math.abs(moment(result.fechainicio) - new Date());
            var dias = Math.floor(dif / (1000 * 3600 * 24));
            if (dias < 1) {
                $("#modalOpciones").modal("hide");
                $(".modal-backdrop").remove();
                $(".noCambios").attr("disabled", true);
                $(".liberar").attr("disabled", true);
                swal({
                    title: "Agendar Sesión Comité",
                    text: _mensajes.noCambios24h,
                    type: "warning",
                    confirmButtonText: "Aceptar"
                });
            }
            $("#editDay").val(moment(result.fechainicio).format("YYYY-MM-DD"));
            $("#editHoraInicio").val(moment(result.fechainicio).format("kk:mm"));
            $("#editHoraFinal").val(moment(result.fechafinal).format("kk:mm"));
            $("#editUbicacionComite").val(result.ubicacion);
            $("#editEmprendimientosComite").empty();
            if (sesionComite != null) {
                sesionComite.evaluacionemprendimientoses.forEach(function (item) {
                    $("#editEmprendimientosComite").append("<li>" + item.emprendimiento.nombreemprendimiento + "</li>");
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Sesión Comité",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Sesión Comité",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function actualizarSesion() {
    if (!verificarHorasEditar()) {
        return false;
    }

    $("#modalOpciones").modal("hide");
    var dia = $("#editDay").val();
    var horaInicial = $("#editHoraInicio").val();
    var horaFinal = $("#editHoraFinal").val();
    if (idSession) {
        swal({
            title: "Agendar Sesión Comité",
            text: _mensajes.seguroActualizar,
            type: "info",
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
            closeOnConfirm: false
        }, function (isConfirm) {
            if (isConfirm) {
                $.ajax({
                    method: "PUT",
                    url: context + "/actualizarSesionComite",
                    data: JSON.stringify({
                        fechainicio: moment(dia + " " + horaInicial + "").valueOf(),
                        fechafin: moment(dia + " " + horaFinal + "").valueOf(),
                        idSesion: idSession, idestadosesion: 4, idfuncionario: idfuncionario
                    }),
                    async: false,
                    contentType: "application/json",
                    success: function (result, status, xhr) {
                        if (result.status == "1") {
                            $("#modalProgramacion").modal("hide");
                            swal({
                                title: "Agendar Sesión Comité",
                                text: result.descripcion,
                                type: "success",
                                confirmButtonText: "Aceptar",
                            }, function () {
                                $(".preloader").fadeIn();
                                loadView('Agendar Sesion Comité', context + '/cargarDatosSesionComiteEvaluacion');
                            });
                        } else {
                            swal("Agendar Sesion Comité", result.descripcion, "error");
                        }
                    },
                    error: function (error) {
                        if (error.status == 200) {
                            swal({
                                title: "Agendar Sesión Comité",
                                text: _mensajes.sesionExpiro,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                location.replace(context + "/mostrarLogin");
                            });
                        } else {
                            swal({
                                title: "Agendar Sesión Comité",
                                text: _mensajes.errorAjax,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }
                    }
                });
            }
        });
    }
}

function eliminarSesion() {
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Registrar Asistencia") {
        swal({
            title: "Agendar Sesión Comité",
            text: _mensajes.noCambiosSesion,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    swal({
        title: "Agendar Sesión Comité",
        text: _mensajes.seguroCancelar,
        type: "info",
        showCancelButton: true,
        confirmButtonText: "Si",
        cancelButtonText: "No",
        closeOnConfirm: false
    }, function (isConfirm) {
        if (isConfirm) {
            jQuery.ajax({
                method: "POST",
                url: context + "/eliminarSesionComite",
                dataType: "json",
                async: false,
                data: {idSesion: idSession},
                success: function (result, status, xhr) {
                    $("#modalOpciones").modal("hide");
                    $(".modal-backdrop").remove();
                    if (result.status == "1") {
                        swal({
                            title: "Agendar Sesión Comité",
                            text: result.descripcion,
                            type: "success",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            $(".preloader").fadeIn();
                            loadView('Agendar Sesion Comité', context + '/cargarDatosSesionComiteEvaluacion');
                        });
                    } else {
                        swal({
                            title: "Agendar Sesión Comité",
                            text: result.descripcion,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }

                },
                error: function (error) {
                    if (error.status == 200) {
                        swal({
                            title: "Agendar Sesión Comité",
                            text: _mensajes.sesionExpiro,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            location.replace(context + "/mostrarLogin");
                        });
                    } else {
                        swal({
                            title: "Agendar Sesión Comité",
                            text: _mensajes.errorAjax,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }
                }
            });
        }
    });
}

function verificarHoras() {
    if ($('#horaFin').val() <= $('#horaInicio').val()) {
        swal({
            title: "Agendar Sesión Comité",
            text: _mensajes.horaFinMenorInicio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }
    return true;
}

function verificarHorasEditar() {
    if ($('#editHoraFinal').val() <= $('#editHoraInicio').val()) {
        swal({
            title: "Agendar Sesión Comité",
            text: _mensajes.horaFinMenorInicio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }
    return true;
}

function listaAsistentes() {
    $("#emprendimientos").empty();
    if (sesionComite != null) {
        sesionComite.evaluacionemprendimientoses.forEach(function (item) {
            $("#emprendimientos").append("<li>" + item.emprendimiento.nombreemprendimiento + "</li>");
        });
    }
    $("#modalOpciones").modal("hide");
    $("#modalListaAsistencia").modal("show");
}

function cerrarLista() {
    $("#modalListaAsistencia").modal("hide");
    $("#modalOpciones").modal("show");
}
