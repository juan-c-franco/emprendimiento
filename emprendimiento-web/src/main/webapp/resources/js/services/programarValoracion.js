var args;
var idSession;
var estadoSesion;
var tiposesion = 2;
var soloProgramadas = 0;
var lTable;
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

    $('#btnActualizar').on('click', function (e) {
        e.preventDefault();
        $("#btnActualizar").prop("disabled", true);
        if (!validationFormErrors(e, "#modalOpciones")) {
            actualizarSesion();
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

    /*$('.tablaData').DataTable({
     language: datatableLanguageEs
     });*/

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
                    $("#modalProgramacion").modal("show");
                    $('#programar').on('click', function (e) {
                        e.preventDefault();
                        $("#programar").prop("disabled", true);
                        var validationError = validationFormErrors(e, "#modalProgramacion");
                        if (!validationError) {
                            if (args === arg) {
                                if (arg.view.type === 'month') {
                                    horaInicio = arg.startStr + "T" + $("#horaInicio").val() + ":00";
                                    horaFin = arg.startStr + "T" + $("#horaFin").val() + ":00";
                                }
                                guardaProgramacion(moment(horaInicio).format('YYYY-MM-DD kk:mm'),
                                        moment(horaFin).format('YYYY-MM-DD kk:mm'), $("#descripValoracion").val(),
                                        $("#ubicacionValoracion").val());

                                calendar.unselect();
                            }
                        }
                        $("#programar").prop("disabled", false);
                    });
                }
            }, events: s, eventClick: function (element) {
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
    $(".preloader").fadeOut();
});

function guardaProgramacion(fechaInicial, fechaFin, descripcion, ubicacion) {
    if (!verificarHoras())
        return false;

    jQuery.ajax({
        method: "POST",
        url: context + "/guardarSesion",
        dataType: "json",
        async: false,
        data: {descripcion: descripcion, fechaInicial: fechaInicial.toString(),
            fechaFinal: fechaFin.toString(), maxCantidad: 1000,
            ubicacion: ubicacion, idFuncionario: idfuncionario, tiposesion: tiposesion},
        success: function (result, status, xhr) {
            $("#modalProgramacion").modal("hide");

            if (result.status = "1") {
                swal({
                    title: "Programar Sesión",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
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

function loaderSesiones(s) {
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

function loadEditar() {
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Registrar Asistencia") {
        swal({
            title: "Programar Sesión",
            text: _mensajes.noCambiosSesion,
            type: "warning",
            confirmButtonText: "Aceptar"
        });
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

    jQuery.ajax({
        method: "GET",
        url: context + "/consultaSesionXId",
        dataType: "json",
        async: false,
        data: {idSesion: idSession},
        success: function (result, status, xhr) {
            var dif = Math.abs(moment(result.fechaInicio) - new Date());
            var dias = Math.floor(dif / (1000 * 3600 * 24));

            if (dias < 1) {
                $("#modalOpciones").modal("hide");
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
            $("#editDescripcion").val(result.descripcion);
            $("#editUbicacion").val(result.ubicacion);
            $("#editDay").val(moment(result.fechaInicio).format("YYYY-MM-DD"));
            $("#editHoraInicio").val(moment(result.fechaInicio).format("kk:mm"));
            $("#editHoraFinal").val(moment(result.fechaFin).format("kk:mm"));

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

function actualizarSesion() {
    if (!verificarHorasEditar())
        return false;

    $("#modalOpciones").modal("hide");
    var descripcion = $("#editDescripcion").val();
    var ubicacion = $("#editUbicacion").val();
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
                    method: "PUT",
                    url: context + "/actualizarSesion",
                    data: JSON.stringify({
                        descripcion: descripcion,
                        fechaInicio: moment(dia + " " + horaInicial + "").valueOf(),
                        fechaFin: moment(dia + " " + horaFinal + "").valueOf(),
                        ubicacion: ubicacion,
                        idSesion: idSession,
                        idestadosesion: (estadoSesion == "Disponible" ? 1 : 4),
                        idfuncionario: idfuncionario
                    }),
                    async: false,
                    contentType: "application/json",
                    dataType: "json",
                    success: function (result, status, xhr) {
                        if (result.status == "1") {
                            $("#modalProgramacion").modal("hide");
                            swal({
                                title: "Programar Sesión",
                                text: result.descripcion,
                                type: "success",
                                confirmButtonText: "Aceptar",
                            }, function () {
                                $(".preloader").fadeIn();
                                loadView('Programar Sesión', context + '/programarValoracion');
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

function eliminarSesion() {
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
        jQuery.ajax({
            method: "GET",
            url: context + "/consultaSesionXId",
            dataType: "json",
            async: false,
            data: {idSesion: idSession},
            success: function (result, status, xhr) {
                var dif = Math.abs(moment(result.fechaInicio) - new Date());
                var dias = Math.floor(dif / (1000 * 3600 * 24));

                if (dias < 1) {
                    $("#modalOpciones").modal("hide");
                    $(".modal-backdrop").remove();
                    swal({
                        title: "Programar Sesión",
                        text: _mensajes.noCambios24h,
                        type: "error",
                        confirmButtonText: "Aceptar"
                    });
                } else {
                    $("#modalOpciones").modal("hide");
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
                                url: context + "/eliminarSesion",
                                dataType: "json",
                                async: false,
                                data: {idSesion: idSession, tipoSesion: tiposesion},
                                success: function (result, status, xhr) {
                                    $("#modalOpciones").modal("hide");
                                    $(".modal-backdrop").remove();
                                    if (result.status == "1") {
                                        swal({
                                            title: "Programar Sesión",
                                            text: result.descripcion,
                                            type: "success",
                                            confirmButtonText: "Aceptar"
                                        }, function () {
                                            $(".preloader").fadeIn();
                                            loadView('Programar Sesión', context + '/programarValoracion');
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
    jQuery.ajax({
        method: "GET",
        url: context + "/getAsistentesSesion",
        dataType: "json",
        async: false,
        data: {idsesion: idSession},
        success: function (result, status, xhr) {
            //lTable.clear();
            if (result.status == "1") {
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
    $("#modalOpciones").modal("hide");
    $("#modalListaAsistencia").modal("show");
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
        url: context + "/liberarSesion",
        dataType: "json",
        async: false,
        data: {idSesion: idSession, tipoSesion: tiposesion},
        success: function (result, status, xhr) {
            $("#modalOpciones").modal("hide");
            $(".modal-backdrop").remove();
            if (result.status = "1") {
                swal({
                    title: "Programar Sesión",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    $("#modalOpciones").modal("hide");
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
                $("#body_content").load(context + '/traerAsistentesV',
                        {idfuncionario: idfuncionario, idsesion: idSession});
                $(".preloader").fadeOut();
            }, 2000);
        }
    });
}