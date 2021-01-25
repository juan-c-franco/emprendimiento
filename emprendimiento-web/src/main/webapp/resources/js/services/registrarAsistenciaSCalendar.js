var args;
var idSession;
var estadoSesion;
var tiposesion = 4;
var soloProgramadas = 0;
$(function () {
    $(".preloader").fadeOut();
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
            events: s, eventClick: function (element) {
                idSession = element.event.id;
                swal({
                    title: "Registrar Asistencia",
                    text: _mensajes.seguroRegistrar,
                    type: "info",
                    confirmButtonText: "Si",
                    showCancelButton: true,
                    cancelButtonText: "No"
                }, function (isConfirm) {
                    if (isConfirm) {
                        $(".preloader").fadeIn();
                        $("#body_content").load(context + '/traerAsistentesS',
                                {idfuncionario: idfuncionario, idsesion: idSession});
                        $(".preloader").fadeOut();
                    }
                });
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

function loaderSesiones(s) {
    var sesiones = [];
    $.get(context + "/cargarSesiones", {idFuncionario: idfuncionario, tiposesion: tiposesion,
        todas: soloProgramadas}, function (data) {
        if (data.status === "1") {
            data.sesiones.forEach(function (item, index, array) {
                var sesion = {};
                sesion.id = Number(array[index].idsesion);
                sesion.start = moment(new Date(array[index].fechainicio)).format("YYYY-MM-DDTkk:mm:ss");
                sesion.end = moment(new Date(array[index].fechafinal)).format("YYYY-MM-DDTkk:mm:ss");
                if (new Date(array[index].fechainicio) < new Date() && (item.estadosesion.idestadosesion == 1 || item.estadosesion.idestadosesion == 4)) {
                    sesion.title = "Registrar Asistencia";
                    sesion.className = 'bg-registrar';
                    sesiones.push(sesion);
                }

            });
            s(sesiones);
        } else {
            swal({
                title: "Registrar Asistencia",
                text: data.descripcion,
                type: "Error",
                confirmButtonText: "Si",
                showCancelButton: false,

            }, function () {

                $(".preloader").fadeIn();
                location.replace(context + "/");
                $(".preloader").fadeOut();

            });
        }
    });
}