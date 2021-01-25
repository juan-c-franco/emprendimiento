var contador = 0;
var localBeneficiario = beneficiario;
var idSesion;
beneficiario = null;
var tiposesion = 2;
var soloProgramadas = 0;
var idSession;
var estadoSesion;
var lTable;
$(function () {
    if (localBeneficiario && localBeneficiario.length != 0 && idfuncionario) {

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
                    if (element.event.title == "Disponible") {
                        idSesion = element.event.id;
                        swal({
                            title: "Agendar Sesión",
                            text: _mensajes.seguroAgendar,
                            type: "info",
                            showCancelButton: true,
                            cancelButtonText: "No",
                            confirmButtonText: "Si",
                            closeOnConfirm: false,
                        }, function (isConfirm) {
                            if (isConfirm) {
                                $(".preloader").fadeIn();
                                asociarBeneficiarios();
                            }
                        });
                    } else if (element.event.title == "Reservada") {
                        idSession = element.event.id;
                        estadoSesion = element.event.title;
                        loadEditar();
                        $("#modalOpciones").modal("show");
                    }
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
    $("#modalConfirmar").modal("hide");
    var request = JSON.stringify({idSesion: idSesion, beneficiarios: localBeneficiario});
    jQuery.ajax({
        method: "POST",
        url: context + "/asociarBeneficiariosValoracion",
        data: {requestEmp: request},
        //contentType: "application/json",
        dataType: "json",
        async: false,
        done: function () {
            $(".preloader").fadeOut();
        },
        success: function (result, status, xhr) {
            $("#modalConfirmar").modal("hide");
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
                        if (new Date(array[index].fechainicio) >= new Date() && item.estadosesion.idestadosesion == 1) {
                            sesion.id = Number(array[index].idsesion);
                            sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                            sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                            sesion.title = "Disponible";
                            sesion.className = 'bg-disponible';
                            sesiones.push(sesion);
                        } else if (item.estadosesion.idestadosesion == 4) {
                            jQuery.ajax({
                                method: "GET",
                                url: context + "/getAsistentesSesion",
                                dataType: "json",
                                async: false,
                                data: {idsesion: item.idsesion},
                                success: function (result, status, xhr) {
                                    if (result.status == "1") {
                                        result.asistenciaDTO.forEach(function (item2, index, array) {
                                            localBeneficiario.forEach(function (item3) {
                                                if (item2.beneficiario.idbeneficiario == item3) {
                                                    sesion.id = Number(item.idsesion);
                                                    sesion.start = moment(new Date(item.fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                                                    sesion.end = moment(new Date(item.fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                                                    sesion.title = "Reservada";
                                                    sesion.className = 'bg-reservada';
                                                    sesiones.push(sesion);
                                                }
                                            });
                                        });
                                    }
                                }
                            });
                        }
                    });
                    s(sesiones);
                } else {
                    swal({
                        title: "Agendar Sesión",
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
            {title: "Correo"}
        ]
    });
    $("#modalOpciones").modal("hide");
    $("#modalListaAsistencia").modal("show");
}

function loadEditar() {
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
                $(".liberar").attr("disabled", true);
                swal({
                    title: "Agendar Sesión",
                    text: _mensajes.noCambios24h,
                    type: "warning",
                    confirmButtonText: "Aceptar"
                });
            } else {
                $(".liberar").attr("disabled", false);
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

function cerrarLista() {
    $("#modalListaAsistencia").modal("hide");
    $("#modalOpciones").modal("show");
}

function liberarSesion() {
    if (estadoSesion != "Reservada") {
        swal({
            title: "Agendar Sesión",
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
                    title: "Agendar Sesión",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                }, function () {
                    $("#modalOpciones").modal("hide");
                    $(".preloader").fadeIn();
                    location.replace(context + "/");
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