var args;
var idProgramacion;
var lTable;
var todas = 1;
$(function () {

    // Only one of these modals should show at a time.
    $('#modalListaAsistencia').on('show.bs.modal', function (e) {
        $('#modalOpciones').modal('hide');
        $('body').css("overflow", "hidden");
        $(this).css("overflow-y", "auto");
    })
            .on('hide.bs.modal', function (e) {
                // @todo reload the job
                $('#modalOpciones')
                        .modal('show')
                        .css("overflow-y", "auto");
            });
    $('#modalOpciones').on('show.bs.modal', function (e) {
        // @todo reload the job
        $('body').css("overflow", "hidden");
    })
            .on('hide.bs.modal', function (e) {
                // @todo reload the job
                $('body').css("overflow", "visible");
            });

//$('#theForm').on('click', '#btnActualizar', function (e) {
    $('#btnActualizar').on('click', function (e) {
        e.preventDefault();
        if (!validationFormErrors(e, "#modalOpciones")) {
            $("#btnActualizar").prop("disabled", true);
            actualizarSesion();
            $("#btnActualizar").prop("disabled", false);
        }
    });
    $('.editDate').datetimepicker({
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
            selectMirror: true,
            contentHeight: 500,
            themeSystem: 'bootstrap4',
            selectable: true,
            StartEditable: false,
            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek'
            }, views: {
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
            select: function (arg) {
                args = arg;
                var horaInicio = arg.startStr;
                var horaFin = arg.endStr;
                var dia = moment(horaInicio).format("YYYY-MM-DD");
                if (new Date() >= new Date(dia)) {
                    swal({
                        title: "Programar Capacitación",
                        text: _mensajes.sesionesPasado,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                } else {

                    $("#startDay").val(dia);
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
                    $("#modalProgramacion").modal("show");
                    $('#programar').on('click', function (e) {
                        e.preventDefault();
                        var validationError = validationFormErrors(e, "#modalProgramacion");
                        if (!validationError) {
                            if (args === arg) {

//                                if (arg.view.type === 'month') {
//                                    horaInicio = arg.startStr + "T" + $("#horaInicio").val() + ":00";
//                                    horaFin = arg.startStr + "T" + $("#horaFin").val() + ":00";
//                                }
                                horaInicio = $("#startDay").val() + "T" + $("#horaInicio").val() + ":00";
                                horaFin = $("#endDay").val() + "T" + $("#horaFin").val() + ":00";
                                $("#programar").prop("disabled", true);
                                guardaProgramacion(moment(horaInicio).format('YYYY-MM-DD kk:mm'),
                                        moment(horaFin).format('YYYY-MM-DD kk:mm'), $("#maximoAsistentes").val(), $("#aula").val());
                                $("#programar").prop("disabled", false);
                                calendar.unselect();
                            }
                        }
                    });
                }
            }, events: s, eventClick: function (element) {
                idProgramacion = element.event.id;
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
    $(".preloader").fadeOut();
});
function guardaProgramacion(fechaInicial, fechaFin, maxCantidad, ubicacion) {
    if (!verificarHoras())
        return false;

    jQuery.ajax({
        method: "POST",
        url: context + "/guardarProgramacion",
        dataType: "json",
        async: false,
        data: {fechaInicial: fechaInicial.toString(), fechaFinal: fechaFin.toString(),
            maxCantidad: maxCantidad, idFuncionario: idfuncionario,
            idCapacitacion: idcapacitacion, idDocente: iddocente, idSede: idsede,
            ubicacion: ubicacion},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                $("#modalProgramacion").modal("hide");
                swal({
                    title: "Programar Capacitación",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    $(".preloader").fadeIn();
                    loadView('Programar Capacitación', context + '/programarCapacitacionView');
                });
            } else {
                swal({
                    title: "Programar Capacitación",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Programar Capacitación",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Programar Capacitación",
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
        url: context + "/cargarProgramaciones",
        dataType: "json",
        async: false,
        data: {idDocente: iddocente, todas: todas},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result = result.programaciones;
                result.forEach(function (item, index, array) {
                    var cuposDisponibles;
                    var sesion = {};
                    sesion.id = Number(array[index].idprogramacion);
                    sesion.start = moment(new Date(array[index].fechainicioprogramacion)).format("YYYY-MM-DDTkk:mm:ss");
                    sesion.end = moment(new Date(array[index].fechafinalrogramacion)).format("YYYY-MM-DDTkk:mm:ss");
                    if (new Date(array[index].fechainicioprogramacion) < new Date() && (item.estadosesion.idestadosesion == 4 || item.estadosesion.idestadosesion == 1)) {
                        sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Registrar Asistencia";
                        sesion.className = 'bg-registrar';
                    } else if (item.estadosesion.idestadosesion == 3) {
                        sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Cancelada";
                        sesion.className = 'bg-cancelada';
                    } else if (item.estadosesion.idestadosesion == 4) {
                        sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Reservada";
                        sesion.className = 'bg-reservada';
                    } else if (item.estadosesion.idestadosesion == 2) {
                        sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Culminada";
                        sesion.className = 'bg-culminada';
                    } else {
                        jQuery.ajax({
                            method: "GET",
                            url: context + "/getAsistentesProgramacion",
                            dataType: "json",
                            async: false,
                            data: {idProgramacion: Number(array[index].idprogramacion)},
                            success: function (result, status, xhr) {
                                if (result.alumnos)
                                    cuposDisponibles = item.maxasistentes - result.alumnos.length;
                                else
                                    cuposDisponibles = item.maxasistentes;
                                sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Cupos: " + cuposDisponibles.toString();
                                if (cuposDisponibles > 0) {
                                    sesion.className = 'bg-disponible';
                                } else {
                                    sesion.className = 'bg-sincupo';
                                }
                            }
                        });
                    }
                    sesiones.push(sesion);
                });
                s(sesiones);
            } else {
                swal({
                    title: "Programar Capacitación",
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
                    title: "Programar Capacitación",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Programar Capacitación",
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
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Registrar Asistencia") {
        swal({
            title: "Programar Capacitación",
            text: _mensajes.noCambiosSesion,
            type: "warning",
            confirmButtonText: "Aceptar"
        });
        //bootbox.alert("No se puede cambiar el estado de esta sesion.");
        $(".noCambios").attr("disabled", true);
    } else {
        $(".noCambios").attr("disabled", false);
    }

    if (estadoSesion == "Registrar Asistencia") {
        $(".registrarAsistencia").attr("hidden", false);
    } else {
        $(".registrarAsistencia").attr("hidden", true);
    }

    jQuery.ajax({
        method: "GET",
        url: context + "/consultaProgramacion",
        dataType: "json",
        async: false,
        data: {idProgramacion: idProgramacion},
        success: function (result, status, xhr) {
            var dif = Math.abs(moment(result.fechainicioprogramacion) - new Date());
            var dias = Math.floor(dif / (1000 * 3600 * 24));
            if (dias < 1) {
                $("#modalOpciones").modal("hide");
                $(".modal-backdrop").remove();
                $(".noCambios").attr("disabled", true);
                $(".liberar").attr("disabled", true);
                swal({
                    title: "Programar Capacitación",
                    text: _mensajes.noCambios24h,
                    type: "warning",
                    confirmButtonText: "Aceptar"
                });
                //bootbox.alert("No se puede modificar una sesion en las ultimas 24 horas");
            }
            $("#editStartDay").val(moment(result.fechainicioprogramacion).format("YYYY-MM-DD"));
            $("#editEndDay").val(moment(result.fechafinalrogramacion).format("YYYY-MM-DD"));
            $("#editHoraInicio").val(moment(result.fechainicioprogramacion).format("kk:mm"));
            $("#editHoraFinal").val(moment(result.fechafinalrogramacion).format("kk:mm"));
            $("#editMaxAsistentes").val(result.maxasistentes);
            $("#editAula").val(result.ubicacion);
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Programar Capacitación",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Programar Capacitación",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function actualizarSesion() {
    if (!verificarHorasEditar())
        return false;
    $("#modalOpciones").modal("hide");
    var horaInicial = $("#editStartDay").val() + "T" + $("#editHoraInicio").val() + ":00";
    var horaFinal = $("#editEndDay").val() + "T" + $("#editHoraFinal").val() + ":00";
    var maxCantidad = $("#editMaxAsistentes").val();
    var aula = $("#editAula").val();
    if (idProgramacion) {
        swal({
            title: "Programar Capacitación",
            text: _mensajes.seguroActualizar,
            type: "info",
            showCancelButton: true,
            confirmButtonText: "Si",
            cancelButtonText: "No",
            closeOnConfirm: false
        }, function (isConfirm) {
            if (isConfirm) {
                $.ajax({
                    method: "POST",
                    url: context + "/actualizarProgramacion",
                    data: {fechaInicial: moment(horaInicial).format('YYYY-MM-DD kk:mm'),
                        fechaFinal: moment(horaFinal).format('YYYY-MM-DD kk:mm'),
                        maxCantidad: maxCantidad, idFuncionario: idfuncionario,
                        idCapacitacion: idcapacitacion, idDocente: iddocente, idSede: idsede,
                        ubicacion: aula, idProgramacion: idProgramacion},
                    async: false,
                    dataType: "json",
                    success: function (result, status, xhr) {
                        if (result.status == "1") {
                            $("#modalProgramacion").modal("hide");
                            swal({
                                title: "Programar Capacitación",
                                text: result.descripcion,
                                type: "success",
                                confirmButtonText: "Aceptar",
                            }, function () {
                                $(".preloader").fadeIn();
                                loadView('Programar Capacitación', context + '/programarCapacitacionView');
                            });
                        } else {
                            swal("Programar Capacitación", result.descripcion, "error");
                        }
                    },
                    error: function (error) {
                        if (error.status == 200) {
                            swal({
                                title: "Programar Capacitación",
                                text: _mensajes.sesionExpiro,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                location.replace(context + "/mostrarLogin");
                            });
                        } else {
                            swal({
                                title: "Programar Capacitación",
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
            title: "Programar Capacitación",
            text: _mensajes.noCambiosSesion,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    if (idProgramacion) {
        jQuery.ajax({
            method: "GET",
            url: context + "/consultaProgramacion",
            dataType: "json",
            async: false,
            data: {idProgramacion: idProgramacion},
            success: function (result, status, xhr) {
                var dif = Math.abs(moment(result.fechainicioprogramacion) - new Date());
                var dias = Math.floor(dif / (1000 * 3600 * 24));
                if (dias < 1) {
                    $("#modalOpciones").modal("hide");
                    $(".modal-backdrop").remove();
                    swal({
                        title: "Programar Capacitación",
                        text: _mensajes.noCambios24h,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                } else {
                    swal({
                        title: "Programar Capacitación",
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
                                url: context + "/eliminarProgramacion",
                                dataType: "json",
                                async: false,
                                data: {idProgramacion: idProgramacion},
                                success: function (result, status, xhr) {
                                    $("#modalOpciones").modal("hide");
                                    $(".modal-backdrop").remove();
                                    if (result.status == "1") {
                                        swal({
                                            title: "Programar Capacitación",
                                            text: result.descripcion,
                                            type: "success",
                                            confirmButtonText: "Aceptar"
                                        }, function () {
                                            $(".preloader").fadeIn();
                                            loadView('Programar Capacitación', context + '/programarCapacitacionView');
                                        });
                                    } else {
                                        swal({
                                            title: "Programar Capacitación",
                                            text: result.descripcion,
                                            type: "error",
                                            confirmButtonText: "Aceptar"
                                        });
                                    }

                                },
                                error: function (error) {
                                    if (error.status == 200) {
                                        swal({
                                            title: "Programar Capacitación",
                                            text: _mensajes.sesionExpiro,
                                            type: "error",
                                            confirmButtonText: "Aceptar"
                                        }, function () {
                                            location.replace(context + "/mostrarLogin");
                                        });
                                    } else {
                                        swal({
                                            title: "Programar Capacitación",
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
            },
            error: function (error) {
                if (error.status == 200) {
                    swal({
                        title: "Programar Capacitación",
                        text: _mensajes.sesionExpiro,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    }, function () {
                        location.replace(context + "/mostrarLogin");
                    });
                } else {
                    swal({
                        title: "Programar Capacitación",
                        text: _mensajes.errorAjax,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                }
            }
        });
    }
}

function verificarHoras() {
    if ($('#horaFin').val() <= $('#horaInicio').val()) {
        swal({
            title: "Programar Capacitación",
            text: _mensajes.horaFinMenorInicio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    var horaInicio = $("#startDay").val() + "T" + $("#horaInicio").val() + ":00";
    var horaFin = $("#endDay").val() + "T" + $("#horaFin").val() + ":00";

    if (moment(horaInicio) < new Date()
            || moment(horaFin) < new Date()) {
        swal({
            title: "Programar Capacitación",
            text: _mensajes.fechaPasada,
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
            title: "Programar Capacitación",
            text: _mensajes.horaFinMenorInicio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    var horaInicio = $("#editStartDay").val() + "T" + $("#horaInicio").val() + ":00";
    var horaFin = $("#editEndDay").val() + "T" + $("#horaFin").val() + ":00";

    if (moment(horaInicio) < new Date()
            || moment(horaFin) < new Date()) {
        swal({
            title: "Programar Capacitación",
            text: _mensajes.fechaPasada,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }
    return true;
}

function listaAsistentes() {
    var dataSet = [];
    jQuery.ajax({
        method: "GET",
        url: context + "/getAsistentesProgramacion",
        dataType: "json",
        async: false,
        data: {idProgramacion: idProgramacion},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result.alumnos.forEach(function (item, index, array) {
                    var row = [];
                    row.push(item.beneficiario.numerodocumento);
                    row.push(item.beneficiario.tipodocumentoid.nombredocumento);
                    row.push(item.beneficiario.primernombre + " " +
                            (item.beneficiario.segundonombre != null ? item.beneficiario.segundonombre : ""));
                    row.push(item.beneficiario.primerapellido + " " +
                            (item.beneficiario.segundoapellido != null ? item.beneficiario.segundoapellido : ""));
                    row.push(item.beneficiario.telefono);
                    row.push(item.beneficiario.email);
                    row.push(item.aprobacions != null && item.aprobacions.length != 0 && item.aprobacions[0].calificacionfinal == 1 ? "Aprobó" :
                            item.aprobacions != null && item.aprobacions.length != 0 && item.aprobacions[0].calificacionfinal == -2 ? "Reprobó por faltas" :
                            item.aprobacions != null && item.aprobacions.length != 0 && item.aprobacions[0].calificacionfinal == 0 ? "Reprobó" : "Sin calificar");
                    dataSet.push(row);
                }
                );
            }
        }
    });
    if (lTable != null) {
        lTable.destroy();
    }
    lTable = $('.tablaData').DataTable({
        language: datatableLanguageEs,
        data: dataSet,
        autoWidth: false,
        columns: [
            {title: "Documento"},
            {title: "Tipo Documento"},
            {title: "Nombres"},
            {title: "Apellidos"},
            {title: "Teléfono"},
            {title: "Correo"},
            {title: "¿Aprobó?"}
        ]
    });
    $("#modalListaAsistencia").modal("show");
}

function cerrarLista() {
    $("#modalListaAsistencia").modal("hide");
    $("#modalOpciones").modal("show");
}

function registrarAsistencia() {
    swal({
        title: "Registrar Asistencia",
        text: _mensajes.seguroRegistrar,
        type: "info",
        confirmButtonText: "Si",
        showCancelButton: true,
        cancelButtonText: "No"
    }, function (isConfirm) {
        if (isConfirm) {
            $("#modalOpciones").modal("hide");
            setTimeout(function () {
                $(".preloader").fadeIn();
                $("#body_content").load(context + '/traerAsistentes',
                        {idfuncionario: idfuncionario, idsesion: idProgramacion});
                $(".preloader").fadeOut();
            }, 2000);
        }
    });
}
