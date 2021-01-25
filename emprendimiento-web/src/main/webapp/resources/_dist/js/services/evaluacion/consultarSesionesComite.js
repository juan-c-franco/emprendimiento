var sesionesComite = [];
var indexResult = 0;
var idSesioncomite = 0;
var estadoSesion;
var soloProgramadas = 0;
$(function () {
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
            eventClick: function (element) {
                idSesioncomite = element.event.id;
                estadoSesion = element.event.title;
                if (estadoSesion == "Calificar") {
                    $(".preloader").fadeIn();
                    $("#body_content").load(context + "/consultarEmpCalificacionDefinitiva");
                } else {
                    loadEditar();
                    $("#modalOpciones").modal("show");
                }
            }
        });
        calendar.render();
    });
    $(".preloader").fadeOut();
});

//function loaderSesiones(s) {
//    var sesiones = [];
//    jQuery.ajax({
//        type: "GET",
//        url: context + "/getSesionesComitePorFuncionario",
//        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
//        dataType: "json",
//        async: false,
//        data: {idFuncionario: idfuncionario},
//        success: function (result, status, xhr) {
//            if (result.status == "1") {
//                sesionesComite = result.sesiones;
//                if (result.sesiones.lenght <= 0) {
//                    swal({
//                        title: "Consultar Sesiones Comité",
//                        text: _mensajes.noSesionesComite,
//                        type: "warning",
//                        confirmButtonText: "Aceptar"
//                    });
//                } else {
//                    result.sesiones.forEach(function (item, index, array) {
//                        var sesion = {};
//                        sesion.id = Number(array[index].idsesioncomite);
//                        sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
//                        sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
//                        if (new Date(array[index].fechainicio) < new Date() && (item.estadosesion.idestadosesion == 1 || item.estadosesion.idestadosesion == 4)) {
//                            sesion.title = "Calificar";
//                            sesion.className = 'bg-registrar';
//                            sesiones.push(sesion);
//                        }
//                    });
//                    s(sesiones);
//                }
//            } else {
//                swal({
//                    title: "Consultar Sesiones Comité",
//                    text: _mensajes.errorCargandoSesionesComite,
//                    type: "error",
//                    confirmButtonText: "Aceptar"
//                });
//            }
//        }
//    });
//}

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
                        sesion.title = "Calificar";
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
                    title: "Consultar Sesiones Comité",
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
                    title: "Consultar Sesiones Comité",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Consultar Sesiones Comité",
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
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada") {
        swal({
            title: "Consultar Sesiones Comité",
            text: _mensajes.noCambiosSesion,
            type: "warning",
            confirmButtonText: "Aceptar"
        });
    }
    $(".noCambios").attr("disabled", true);

    sesionComite = null;
    jQuery.ajax({
        method: "GET",
        url: context + "/consultaSesionComiteXId",
        dataType: "json",
        async: false,
        data: {idSesion: idSesioncomite},
        success: function (result, status, xhr) {
            sesionComite = result;
            if (estadoSesion == "Reservada") {
                var dif = Math.abs(moment(result.fechainicio) - new Date());
                var dias = Math.floor(dif / (1000 * 3600 * 24));
                if (dias < 1) {
                    $("#modalOpciones").modal("hide");
                    $(".modal-backdrop").remove();
                    $(".liberar").attr("disabled", true);
                    swal({
                        title: "Consultar Sesiones Comité",
                        text: _mensajes.noCambios24h,
                        type: "warning",
                        confirmButtonText: "Aceptar"
                    });
                }
            } else {
                $(".liberar").attr("disabled", true);
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
                    title: "Consultar Sesiones Comité",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Consultar Sesiones Comité",
                    text: _mensajes.errorAjax,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
}

function eliminarSesion() {
    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada" || estadoSesion == "Registrar Asistencia") {
        swal({
            title: "Consultar Sesiones Comité",
            text: _mensajes.noCambiosSesion,
            type: "error",
            confirmButtonText: "Aceptar"
        });
        return false;
    }

    swal({
        title: "Consultar Sesiones Comité",
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
                data: {idSesion: idSesioncomite},
                success: function (result, status, xhr) {
                    $("#modalOpciones").modal("hide");
                    $(".modal-backdrop").remove();
                    if (result.status == "1") {
                        swal({
                            title: "Consultar Sesiones Comité",
                            text: result.descripcion,
                            type: "success",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            $(".preloader").fadeIn();
                            loadView('Consultar Sesiones Comité', context + '/cargarDatosCalificacionDefinitiva');
                        });
                    } else {
                        swal({
                            title: "Consultar Sesiones Comité",
                            text: result.descripcion,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }

                },
                error: function (error) {
                    if (error.status == 200) {
                        swal({
                            title: "Consultar Sesiones Comité",
                            text: _mensajes.sesionExpiro,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            location.replace(context + "/mostrarLogin");
                        });
                    } else {
                        swal({
                            title: "Consultar Sesiones Comité",
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