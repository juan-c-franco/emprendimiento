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
                    $.get(context + "/cargarEmprendimientosSesionComite",
                            {idSesionComite: idSesioncomite, idfuncionario:
                                        idfuncionario, idcajacompensacion: idcajacompensacion},
                            function (data) {
                                $("#body_content").html(data);
                                $("#idPage").html("Calificación Individual");
                                $(".preloader").fadeOut();
                            });
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

function loaderSesiones(s) {
    var sesiones = [];
    jQuery.ajax({
        method: "GET",
        url: context + "/cargarSesionesComiteIndividual",
        dataType: "json",
        async: false,
        data: {idFuncionario: idfuncionario, todas: soloProgramadas},
        success: function (result, status, xhr) {
            console.log(result);
            if (result.status === '1') {
                result.sesiones.forEach(function (item, index, array) {
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
                    title: "Cargar Sesiones",
                    text: result.descripcion,
                    type: "warning",
                    confirmButtonText: "Aceptar"

                }, function () {
                    location.replace(context + "/");
                });
            }

        }
    });
}

function loadEditar() {
//    if (estadoSesion == "Culminada" || estadoSesion == "Cancelada") {
    swal({
        title: "Agendar Sesión Comité",
        text: _mensajes.noCambiosSesion,
        type: "warning",
        confirmButtonText: "Aceptar"

    });
}

