var todas = 0;
var idProgramacion = -1;

$(function () {

    $('input:radio[name=selectBeneficiario]').on('change', function () {
        if (this.value === '1') {
            $('#filtroDocumento').show();
            $('#filtroNombres').hide();
            $('input[name=documento]').prop('required', true);
            $('input[name=pNombre]').prop('required', false);
            $('input[name=pApellido]').prop('required', false);
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
        } else {
            $('#filtroDocumento').hide();
            $('#filtroNombres').show();
            $('input[name=documento]').prop('required', false);
            $('input[name=pNombre]').prop('required', true);
            $('input[name=pApellido]').prop('required', true);
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
        }
    });

    $("#btnFiltroBeneficiario").on("click", function (e) {
        var buscarPor = $("input[name=selectBeneficiario]:checked").val();
        if (buscarPor === '1') {
            var $documento = $("input[name=documento]");
            $documento.jqBootstrapValidation();
            $documento.trigger("change.validation", {submitting: true});
            buscarXDocumento($documento);
        } else {
            var $pNombre = $("input[name=pNombre]");
            var $sNombre = $("input[name=sNombre]");
            $pNombre.jqBootstrapValidation();
            $pNombre.trigger("change.validation", {submitting: true});

            var $pApellido = $("input[name=pApellido]");
            var $sApellido = $("input[name=sApellido]");
            $pApellido.jqBootstrapValidation();
            $pApellido.trigger("change.validation", {submitting: true});

            buscarXNombreApellido($pNombre, $sNombre, $pApellido, $sApellido);
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
            }, events:
                    s,
            eventClick: function (element) {
                $(".preloader").fadeIn();
                idProgramacion = element.event.id;
                jQuery.ajax({
                    method: "GET",
                    url: context + "/getSedesPorId",
                    dataType: "json",
                    async: false,
                    data: {idsede: idsede},
                    success: function (result, status, xhr) {
                        if (result.status == "1") {
                            var sede = result.sedes[0];
                            $("#nombreSede").text(sede.nombre);
                            $("#direccionSede").text(sede.direccion);
                        } else {
                            swal({
                                title: "Agendar Capacitación",
                                text: result.descripcion,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }
                    },
                    error: function (error) {
                        if (error.status == 200) {
                            swal({
                                title: "Agendar Capacitación",
                                text: _mensajes.sesionExpiro,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                location.replace(context + "/mostrarLogin");
                            });
                        } else {
                            swal({
                                title: "Agendar Capacitación",
                                text: _mensajes.errorCargaSesiones,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }
                    }
                });

                jQuery.ajax({
                    method: "GET",
                    url: context + "/getProgramacionPorId",
                    dataType: "json",
                    async: false,
                    data: {idProgramacion: idProgramacion},
                    success: function (result, status, xhr) {
                        if (result.status == "1") {
                            var programacion = result.programaciones[0];
                            $("#nombreCapacitacion").text(programacion.capacitacionprograma.nombrecapacitacionprograma);
                            $("#ubicacion").text(programacion.ubicacion);
                            $("#fechaInicio").text(moment(programacion.fechainicioprogramacion).format("DD/MM/YYYY").toString());
                            $("#fechaFin").text(moment(programacion.fechafinalrogramacion).format("DD/MM/YYYY").toString());
                            $("#horario").text(moment(programacion.fechainicioprogramacion).format("kk:mm").toString()
                                    + " a " + moment(programacion.fechafinalrogramacion).format("kk:mm").toString());
                        } else {
                            swal({
                                title: "Agendar Capacitación",
                                text: result.descripcion,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }
                    },
                    error: function (error) {
                        if (error.status == 200) {
                            swal({
                                title: "Agendar Capacitación",
                                text: _mensajes.sesionExpiro,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            }, function () {
                                location.replace(context + "/mostrarLogin");
                            });
                        } else {
                            swal({
                                title: "Agendar Capacitación",
                                text: _mensajes.errorCargaSesiones,
                                type: "error",
                                confirmButtonText: "Aceptar"
                            });
                        }
                    }
                });
                $(".formInput").empty();
                $("#resultBeneficiarios").find("tr:gt(0)").remove();
                $("#modalSesion").modal("show");
                $(".preloader").fadeOut();
            }
        });
        calendar.render();
    });
    $(".preloader").fadeOut();
});

function asociarBeneficiario(index) {
    jQuery.ajax({
        method: "POST",
        url: context + "/asociarBeneficiarioProgramacion",
        dataType: "json",
//        async: true,
        async: false,
        data: {idProgramacion: idProgramacion,
            idBeneficiario: $('#idResult' + index).html(),
            idFuncionario: idfuncionario},
        beforeSend: function () {
            $(".preloader").fadeIn();
        },
        complete: function () {
            $(".preloader").fadeOut();
        },
        success: function (result, status, xhr) {
            if (result.status == "1") {
                swal({
                    title: "Agendar Capacitación",
                    text: result.descripcion,
                    type: "success",
                    confirmButtonText: "Aceptar"
                });
                $("#resultBeneficiarios").dataTable().fnClearTable();
            } else {
                swal({
                    title: "Agendar Capacitación",
                    text: result.descripcion,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Capacitación",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Capacitación",
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
        url: context + "/getProgramacionPorSedeCapacitacion",
        dataType: "json",
        async: false,
        data: {idsede: idsede, idcapacitacion: idcapacitacion, vencidas: 0},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                result = result.programaciones;
                result.forEach(function (item, index, array) {
                    var cuposDisponibles;
                    var sesion = {};
                    sesion.id = Number(array[index].idprogramacion);
                    sesion.start = moment(new Date(array[index].fechainicioprogramacion)).format("YYYY-MM-DDTkk:mm:ss");
                    sesion.end = moment(new Date(array[index].fechafinalrogramacion)).format("YYYY-MM-DDTkk:mm:ss");
                    if (new Date(array[index].fechainicioprogramacion) >= new Date() && item.estadosesion.idestadosesion == 1) {
                        sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Registrar Asistencia";
                        sesion.className = 'bg-registrar';
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
                        sesiones.push(sesion);
                    }
//                    else {
//                        jQuery.ajax({
//                            method: "GET",
//                            url: context + "/getAsistentesProgramacion",
//                            dataType: "json",
//                            async: false,
//                            data: {idProgramacion: Number(array[index].idprogramacion)},
//                            success: function (result, status, xhr) {
//                                if (result.alumnos)
//                                    cuposDisponibles = item.maxasistentes - result.alumnos.length;
//                                else
//                                    cuposDisponibles = item.maxasistentes;
//                                sesion.title = item.capacitacionprograma.nombrecapacitacionprograma + " - Cupos: " + cuposDisponibles.toString();
//                                if (cuposDisponibles > 0) {
//                                    sesion.className = 'bg-disponible';
//                                } else {
//                                    sesion.className = 'bg-sincupo';
//                                }
//                            }
//                        });
//                        sesiones.push(sesion);
//                    }
                });
                s(sesiones);
            } else {
                swal({
                    title: "Agendar Capacitación",
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
                    title: "Agendar Capacitación",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Agendar Capacitación",
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

function buscarXDocumento($documento) {

    var documento = $documento.val();
    if (documento === '')
        return false;
    if (documento) {
        $("#inputDocumento").val("");
        getBeneficiarioDOC(documento);
        if (response.status == "0") {
            errorMsg(response.descripcion);
        } else if (response.status == "1") {
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length == 0) {
                warningMsg(_mensajes.sinResultados);
            } else {
                successMsg(_mensajes.beneficiariosCargados);
            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = "<tr >" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " +
                        (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " +
                        (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + item.telefono + "</td>" +
                        "<td id='eResult" + indexResult + "'>" + item.email + "</td>" +
                        "<td align='center'><button type='button' onclick='asociarBeneficiario(" + indexResult + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Agregar'><i class='fas fa-plus-circle'></i></button></td>" +
                        "</tr>";
                $('#resultBeneficiarios tr:last').after(row);
                indexResult += 1;
            });
        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
    }
}


function buscarXNombreApellido($pNombre, $sNombre, $pApellido, $sApellido) {

    var pNombre = $pNombre.val(),
            sNombre = $sNombre.val(),
            pApellido = $pApellido.val(),
            sApellido = $sApellido.val();
    if (pNombre === '' || pApellido === '')
        return false;

    if (pNombre && pApellido) {
        $("#inputPrimerNombre").val("");
        $("#inputSegundoNombre").val("");
        $("#inputPrimerApellido").val("");
        $("#inputSegundoApellido").val("");
        getBeneficiarioNombreApellido(pNombre, sNombre, pApellido, sApellido);
        if (response.status == "0") {
            errorMsg(response.descripcion);
        } else if (response.status == "1") {
            var lbeneficiarios = response.beneficiariosDTO;
            if (lbeneficiarios.length == 0) {
                warningMsg(_mensajes.sinResultados);
            } else {
                successMsg(_mensajes.beneficiariosCargados);
            }
            indexResult = 0;
            $("#resultBeneficiarios").find("tr:gt(0)").remove();
            jQuery.each(lbeneficiarios, function (i, item) {
                var row = "<tr >" +
                        "<td id='idResult" + indexResult + "' hidden>" + item.idbeneficiario + "</td>" +
                        "<td id='dResult" + indexResult + "'>" + item.numerodocumento + "</td>" +
                        "<td id='tdResult" + indexResult + "'>" + item.tipodocumentoid.nombredocumento + "</td>" +
                        "<td id='nResult" + indexResult + "'>" + item.primernombre + " " + (item.segundonombre != null ? item.segundonombre : "") + "</td>" +
                        "<td id='aResult" + indexResult + "'>" + item.primerapellido + " " + (item.segundoapellido != null ? item.segundoapellido : "") + "</td>" +
                        "<td id='tResult" + indexResult + "'>" + item.telefono + "</td>" +
                        "<td id='eResult" + indexResult + "'>" + item.email + "</td>" +
                        "<td align='center'><button type='button' onclick='asociarBeneficiario(" + indexResult + ")' class='btn btn-sm btn-rounded btn-success' data-toggle='tooltip' data-placement='top' title='Agregar'><i class='fas fa-plus-circle'></i></button></td>" +
                        "</tr>";
                $('#resultBeneficiarios tr:last').after(row);
                indexResult += 1;
                //$("table tbody").append();

            });
        } else {
            errorMsg(_mensajes.respuestaNoReconocida);
        }
    }
}