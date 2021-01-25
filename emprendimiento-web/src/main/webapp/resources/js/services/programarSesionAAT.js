/* global context, moment, FullCalendar, bootbox */
var args;
var idSession;
var emprendimiento;
var estados = ["2"];
var lTable;
$(function () {

    // Only one of these modals should show at a time.
    $('#modalListaAsistencia').on('show.bs.modal', function (e) {
        $('#modalEditar').modal('hide');
        $('body').css("overflow", "hidden");
        $(this).css("overflow-y", "auto");
    })
            .on('hide.bs.modal', function (e) {
                // @todo reload the job
                $('#modalEditar')
                        .modal('show')
                        .css("overflow-y", "auto");
            });
    $('#modalEditar').on('show.bs.modal', function (e) {
        $('body').css("overflow", "hidden");
    })
            .on('hide.bs.modal', function (e) {
                $('body').css("overflow", "visible");
            });

    $("#btnValidarDisponibilidad").on("click", validarDisponibilidad);
    $("#btnSeleccionarCaja").on("click", seleccionarCaja);
    $("#btnCancelarSesion").on("click", cancelarSesionAAT);
    $('#btnActualizar').on('click', function (e) {
        e.preventDefault();
        $("#btnActualizar").prop("disabled", true);
        if (!validationFormErrors(e, "#modalEditar")) {
            actualizarSesionAAT();
        }
        $("#btnActualizar").prop("disabled", false);
    });

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
    $("#editHoraInicio").on("dp.change", function (e) {
        $('#editHoraFinal').data("DateTimePicker").minDate(e.date);
    });
    $("#editHoraFinal").on("dp.change", function (e) {
        $('#editHoraInicio').data("DateTimePicker").maxDate(e.date);
    });
    $("body").on("contextmenu", function (e) {
        return false;
    });

//    var idAsistenteTecnico = $("#idAsistenteTecnico").val();
    var idAsistenteTecnico = idfuncionario;
    if (idAsistenteTecnico) {
        loaderSesionesAAT(function (s) {
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
                    right: 'month, agendaWeek'
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

                select: function (arg) {
                    args = arg;
                    var horaInicio = arg.startStr;
                    var horaFin = arg.endStr;

                    var dif = moment(arg.startStr) - new Date();
                    var dias = Math.floor(dif / (1000 * 3600 * 24));
                    if (dias < 0) {
                        swal({
                            title: "Programar Sesión",
                            text: _mensajes.sesionesPasado,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    } else {
                        if (arg.view.type === 'agendaWeek') {
                            $("#horaInicio").val(moment(horaInicio).format('YYYY-MM-DD kk:mm'));
                            $("#horaFin").val(moment(horaFin).format('YYYY-MM-DD kk:mm'));
                            $("#horaFin").prop("disabled", true);
                            $("#horaInicio").prop("disabled", true);
                        } else {
                            $("#fechaSesion").val('');
                            $("#horaInicio").val("");
                            $("#horaFin").val("");
                            $("#horaFin").prop("disabled", false);
                            $("#horaInicio").prop("disabled", false);
                        }
                        refrescarModalProgramacion();
                        $("#fechaSesion").val(moment(arg.startStr).format("YYYY-MM-DD"));
                        $("#modalProgramacion").modal("show");
                        $('#programarSesionAAT').on('click', function (e) {
                            e.preventDefault();
                            $("#programarSesionAAT").prop("disabled", true);
                            var validationError = validationFormErrors(e, "#modalProgramacion");
                            if (!validationError) {
                                if (args === arg) {
                                    if (arg.view.type === 'month') {
                                        horaInicio = arg.startStr + "T" + $("#horaInicio").val() + ":00";
                                        horaFin = arg.startStr + "T" + $("#horaFin").val() + ":00";
                                    }
                                    guardaProgramacion(moment(horaInicio).format('YYYY-MM-DD kk:mm'), moment(horaFin).format('YYYY-MM-DD kk:mm'), $("#ubicacionSesion").val());
                                    calendar.unselect();
                                }
                            }
                            $("#programarSesionAAT").prop("disabled", false);
                        });
                    }
                }, events: s, eventClick: function (element) {
                    idSession = element.event.id;
                    estadoSesion = element.event.title;
                    loadEditarAAT();
                }
            });
            calendar.render();
            $('#horaInicio').datetimepicker({format: 'HH:mm', icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa  fa-arrow-up",
                    down: "fa fa-arrow-down",
                    onSelect: function (date) {
                        alert("onSelect");
                    }
                }});
            $('#horaFin').datetimepicker({
                format: 'HH:mm',
                useCurrent: false, //Important! See issue #1075
                icons: {
                    time: "fa fa-clock-o",
                    date: "fa fa-calendar",
                    up: "fa fa-arrow-up",
                    down: "fa fa-arrow-down",
                    onSelect: function (date) {
                        alert("onSelect");
                    }
                }
            });
        });
    }
    $(".preloader").fadeOut();
});

function validarDisponibilidad() {
    var cajaId = idcajacompensacion;
    var asistenteTecnicoId = idfuncionario;
    if (asistenteTecnicoId === "") {
        bootbox.alert("Funcionario asistente técnico obligatorio");
    } else {
        $.get(context + "/cargarDatosProgramarSesionAAT",
                {cajaId: cajaId, asistenteTecnicoId: asistenteTecnicoId}, function (data) {
            $("#body_content").html(data);
            $("#idPage").html("Asistente - Programar Sesión Asistencia Técnica");
        });
    }
}

function seleccionarCaja() {
    var cajaId = $("#cajaId").val();
    $.get(context + "/cargarDatosProgramarSesionAAT",
            {cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Caja - Programar Sesión Asistencia Técnica");
    });
}

function loaderSesionesAAT(s) {
    var sesionesAAT = [];
    var asistenteTecnicoId = idfuncionario;

    jQuery.ajax({
        method: "POST",
        url: context + "/cargarSesionesProgramadasReservadasAAT",
        dataType: "json",
        async: false,
        data: {asistenteTecnicoId: asistenteTecnicoId},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result = result.sesionesAATDTO;
                result.forEach(function (item, index, array) {
                    var sesion = {};
                    sesion.id = Number(item.idsesionacompanamientoat);
                    sesion.start = moment(new Date(item.fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                    sesion.end = moment(new Date(item.fechafinal)).format("YYYY-MM-DDTkk:mm");
                    if (new Date(array[index].fechainicio) < new Date() &&
                            (item.estadosesion.idestadosesion == 1 || item.estadosesion.idestadosesion == 4)) {
                        if (item.estadosesion.idestadosesion == 1) {
                            sesion.title = "Culminada";
                            sesion.className = 'bg-culminada';
                        } else if (item.estadosesion.idestadosesion == 4) {
                            sesion.title = "Registrar Asistencia";
                            sesion.className = 'bg-registrar';
                        }
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
                    sesionesAAT.push(sesion);
                });
                s(sesionesAAT);
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
                    title: "Programar Sesión",
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

function guardaProgramacion(fechaInicial, fechaFin, ubicacionSesion) {
    if (!verificarHoras())
        return false;

    var idAsistenteTecnico = idfuncionario;
    jQuery.ajax({
        method: "POST",
        url: context + "/programarSesionAAT",
        dataType: "json",
        async: false,
        data: {asistenteTecnicoId: idAsistenteTecnico,
            fechaInicial: fechaInicial.toString(),
            fechaFinal: fechaFin.toString(),
            ubicacionSesion: ubicacionSesion},
        success: function (result, status, xhr) {
            $("#modalProgramacion").modal("hide");
            if (result.status === "1") {
                swal({
                    title: "Programar Sesión",
                    text: _mensajes.programarSesionAATOK,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    $(".preloader").fadeIn();
                    loadView('Programar Sesión', context + '/cargarDatosProgramarSesionAAT');
                });
            } else {
                swal({
                    title: "Programar Sesión",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Programar Sesión",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Programar Sesión",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

//function programarSesionAAT(fechaInicial, fechaFin, ubicacionSesion, respuestaSW) {
//    if (!verificarHoras())
//        return false;
////    var idAsistenteTecnico = $("#idAsistenteTecnico").val();
//    var idAsistenteTecnico = idfuncionario;
//    $.post(context + "/programarSesionAAT", {asistenteTecnicoId: idAsistenteTecnico, fechaInicial: fechaInicial.toString(), fechaFinal: fechaFin.toString(), ubicacionSesion: ubicacionSesion}, function (data) {
//        $("#modalProgramacion").modal("hide");
//        respuestaSW(data);
//    });
//}

function cancelarSesionAAT() {
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Registrar Asistencia") {
        swal({
            title: "Programar Sesión",
            text: _mensajes.noCambiosSesion,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    if (idSession) {
        swal({
            title: "Programar Sesión",
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
                    url: context + "/eliminarSesionAAT",
                    dataType: "json",
                    async: false,
                    data: {idSesionAAT: idSession},
                    success: function (result, status, xhr) {
                        $("#modalOpciones").modal("hide");
                        $(".modal-backdrop").remove();
                        if (result.status == "1") {
                            $("#modalEditar").modal("hide");
                            $(".modal-backdrop").remove();
                            swal({
                                title: "Programar Sesión",
                                text: _mensajes.cancelarSesionAATOK,
                                type: "success",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                $(".preloader").fadeIn();
                                loadView('Programar Sesión AAT', context + '/cargarDatosProgramarSesionAAT');
                            });
                        } else {
                            swal({
                                title: "Programar Sesión",
                                text: _mensajes.errorCancelarSesionAAT,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }

                    },
                    error: function (error) {
                        if (error.status == 200) {
                            swal({
                                title: "Programar Sesión",
                                text: _mensajes.sesionExpiro,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                location.replace(context + "/mostrarLogin");
                            });
                        } else {
                            swal({
                                title: "Programar Sesión",
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

function loadEditarAAT() {
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Registrar Asistencia") {
        swal({
            title: "Programar Sesión",
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

    if (estadoSesion == "Registrar Asistencia") {
        $(".registrarAsistencia").attr("hidden", false);
    } else {
        $(".registrarAsistencia").attr("hidden", true);
    }

    $.post(context + "/consultaSesionAATPorId", {idSesionAAT: idSession}, function (sesion) {
        var dif = Math.abs(moment(sesion.fechainicio) - new Date());
        var dias = Math.floor(dif / (1000 * 3600 * 24));
        if (dias < 1) {
            $(".modal-backdrop").remove();
            $(".noCambios").attr("disabled", true);
            $(".liberar").attr("disabled", true);
            swal({
                title: "Programar Sesión",
                text: _mensajes.noCambios24h,
                type: "warning",
                confirmButtonText: "Aceptar"
            });
        }
        $("#editUbicacionSesion").val(sesion.ubicacion);
        $("#editDay").val(moment(sesion.fechainicio).format("YYYY-MM-DD"));
        $("#editHoraInicio").val(moment(sesion.fechainicio).format("kk:mm"));
        $("#editHoraFinal").val(moment(sesion.fechafinal).format("kk:mm"));
    });
    $("#modalEditar").modal("show");
}

function actualizarSesionAAT() {
    if (!verificarHorasEditar())
        return false;

    var asistente = idfuncionario;
    var ubicacion = $("#editUbicacionSesion").val();
    var dia = $("#editDay").val();
    var horaInicial = $("#editHoraInicio").val();
    var horaFinal = $("#editHoraFinal").val();
    if (idSession) {
        swal({
            title: "Programar Sesión",
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
                    url: context + "/actualizarSesionAAT",
                    data: {
                        fechaInicial: moment(dia + " " + horaInicial + "").format('YYYY-MM-DD kk:mm'),
                        fechaFinal: moment(dia + " " + horaFinal + "").format('YYYY-MM-DD kk:mm'),
                        ubicacion: ubicacion,
                        idsesionacompanamientoat: idSession,
                        asistente: asistente},
                    async: false,
                    dataType: "json",
                    success: function (result, status, xhr) {
                        if (result.status == "1") {
                            $("#modalEditar").modal("hide");
                            swal({
                                title: "Programar Sesión",
                                text: _mensajes.actualizarSesionAATOK,
                                type: "success",
                                confirmButtonText: "Aceptar",
                            }, function () {
                                $(".preloader").fadeIn();
                                loadView('Programar Sesión AAT', context + '/cargarDatosProgramarSesionAAT');
                            });
                        } else {
                            swal("Programar Sesión", result.descripcion, "error");
                        }
                    },
                    error: function (error) {

                        if (error.status == 200) {
                            swal({
                                title: "Programar Sesión",
                                text: _mensajes.sesionExpiro,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                location.replace(context + "/mostrarLogin");
                            });
                        } else {
                            swal({
                                title: "Programar Sesión",
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

function refrescarModalProgramacion() {
    $("#ubicacionSesion").val('');
    $("#fechaSesion").val('');
    $("#horaInicio").val('');
    $("#horaFin").val('');
}

function liberarSesion() {
    if (estadoSesion != "Reservada") {
        swal({
            title: "Programar Sesión",
            text: _mensajes.soloSesionesReservadas,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    jQuery.ajax({
        method: "GET",
        url: context + "/liberarSesionAAT",
        dataType: "json",
        async: false,
        data: {idSesion: idSession},
        success: function (result, status, xhr) {
            $("#modalEditar").modal("hide");
            $(".modal-backdrop").remove();
            if (result.status = "1") {
                swal({
                    title: "Programar Sesión",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    $("#modalEditar").modal("hide");
                    loadView('Programar Valoracion', context + '/programarValoracion');
                });
            } else {
                swal({
                    title: "Programar Sesión",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Programar Sesión",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Programar Sesión",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
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
            $("#modalEditar").modal("hide");
            $(".preloader").fadeIn();
            $("#body_content").load(context + '/traerAsistentes',
                    {idfuncionario: idfuncionario, idsesion: idSession});
            $(".preloader").fadeOut();
        }
    });
}

function verificarHoras() {
    if ($('#horaFin').val() <= $('#horaInicio').val()) {
        swal({
            title: "Programar Sesión",
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
            title: "Programar Sesión",
            text: _mensajes.horaFinMenorInicio,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }
    return true;
}

function listaAsistentes() {
    var dataSet = [];
    $('#nEmprendimiento').text("");
    jQuery.ajax({
        method: "GET",
        url: context + "/getAsistentesSesionAAT",
        dataType: "json",
        async: false,
        data: {idsesion: idSession},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                getEmprendimientoXDOC(result.asistenciaDTO[0].beneficiario.numerodocumento);
                result.asistenciaDTO.forEach(function (item, index, array) {
                    var row = [];
                    row.push(item.beneficiario.numerodocumento);
                    row.push(item.beneficiario.tipodocumentoid.nombredocumento);
                    row.push(item.beneficiario.primernombre + " " +
                            (item.beneficiario.segundonombre != null ? item.beneficiario.segundonombre : ""));
                    row.push(item.beneficiario.primerapellido + " " +
                            (item.beneficiario.segundoapellido != null ? item.beneficiario.segundoapellido : ""));
                    row.push(item.beneficiario.telefono);
                    row.push(item.beneficiario.email);
                    row.push((item.registroasistencia == '1' ? "<i class='mdi mdi-account-check'></i> Si" : (item.registroasistencia == '0' ? " <i class='mdi mdi-account-remove'></i> No" : " <i class='mdi mdi-account-alert'></i> Sin registro")));
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
            {title: "¿Asistió?"}
        ]
    });
    $("#modalEditar").modal("hide");
    $("#modalListaAsistencia").modal("show");
}

function getEmprendimientoXDOC(doc) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientoXDOC",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {documento: doc, estados: JSON.stringify(estados),
            idcajacompensacion: idcajacompensacion},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                emprendimiento = result.emprendimientos[0];
                $('#nEmprendimiento').text(emprendimiento.nombreemprendimiento);
            } else {
                $('#nEmprendimiento').text(_mensajes.beneficiarioNoEmprendimiento);
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Programar Sesión",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                $('#nEmprendimiento').text(_mensajes.beneficiarioNoEmprendimiento);
            }
        }
    });
}

function cerrarLista() {
    $("#modalListaAsistencia").modal("hide");
    $("#modalEditar").modal("show");
}
