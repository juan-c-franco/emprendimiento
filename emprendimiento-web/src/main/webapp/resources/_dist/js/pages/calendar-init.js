
!function ($) {
    "use strict";

    var CalendarApp = function () {
        this.$body = $("body")
        this.$calendar = $('#calendar'),
                this.$event = ('#calendar-events div.calendar-events'),
                this.$categoryForm = $('#add-new-event form'),
                this.$extEvents = $('#calendar-events'),
                this.$modal = $('#my-event'),
                this.$saveCategoryBtn = $('.save-category'),
                this.$calendarObj = null
    };


    /* on drop */
    CalendarApp.prototype.onDrop = function (eventObj, date) {
        var $this = this;
        // retrieve the dropped element's stored Event Object
        var originalEventObject = eventObj.data('eventObject');
        var $categoryClass = eventObj.attr('data-class');
        // we need to copy it, so that multiple events don't have a reference to the same object
        var copiedEventObject = $.extend({}, originalEventObject);
        // assign it the date that was reported
        copiedEventObject.start = date;
        if ($categoryClass)
            copiedEventObject['className'] = [$categoryClass];
        // render the event on the calendar
        $this.$calendar.fullCalendar('renderEvent', copiedEventObject, true);
        // is the "remove after drop" checkbox checked?
        if ($('#drop-remove').is(':checked')) {
            // if so, remove the element from the "Draggable Events" list
            eventObj.remove();
        }
    },
            /* on click on event */
            CalendarApp.prototype.onEventClick = function (calEvent, jsEvent, view) {
                var $this = this;
                var form = $("<form></form>");
                form.append("<label>Cambiar nombre de evento</label>");
                form.append("<div class='input-group'><input class='form-control' type=text value='" + calEvent.title + "' /><span class='input-group-btn'><button type='submit' class='btn btn-success waves-effect waves-light'><i class='fa fa-check'></i> Save</button></span></div>");
                $this.$modal.modal({
                    backdrop: 'static'
                });
                $this.$modal.find('.delete-event').show().end().find('.save-event').hide().end().find('.modal-body').empty().prepend(form).end().find('.delete-event').unbind('click').click(function () {
                    $this.$calendarObj.fullCalendar('removeEvents', function (ev) {
                        return (ev._id == calEvent._id);
                    });
                    $this.$modal.modal('hide');
                });
                $this.$modal.find('form').on('submit', function () {
                    calEvent.title = form.find("input[type=text]").val();
                    $this.$calendarObj.fullCalendar('updateEvent', calEvent);
                    $this.$modal.modal('hide');
                    return false;
                });
            },
            /* on select */
            CalendarApp.prototype.onSelect = function (start, end, allDay) {
                var $this = this;
                $this.$modal.modal({
                    backdrop: 'static'
                });
                var form = $("<form></form>");
                form.append("<div class='row'></div>");
                form.find(".row")
                        .append("<div class='col-md-6'><div class='form-group'><label class='control-label'>Nombre de evento</label><input class='form-control' placeholder='Ingrese nombre de evento' type='text' name='title'/></div></div>")
                        .append("<div class='col-md-6'><div class='form-group'><label class='control-label'>Categoria</label><select class='form-control' name='category'></select></div></div>")
                        .find("select[name='category']")
                        .append("<option value='bg-danger'>Rojo</option>")
                        .append("<option value='bg-success'>Verde</option>")
                        .append("<option value='bg-purple'>Purpura</option>")
                        .append("<option value='bg-primary'>Naranja</option>")
                        .append("<option value='bg-pink'>Rosado</option>")
                        .append("<option value='bg-info'>Azul</option>")
                        .append("<option value='bg-inverse'>Navy</option>")
                        .append("<option value='bg-warning'>Amarillo</option></div></div>");
                $this.$modal.find('.delete-event').hide().end().find('.save-event').show().end().find('.modal-body').empty().prepend(form).end().find('.save-event').unbind('click').click(function () {
                    form.submit();
                });
                $this.$modal.find('form').on('submit', function () {
                    var title = form.find("input[name='title']").val();
                    var beginning = form.find("input[name='beginning']").val();
                    var ending = form.find("input[name='ending']").val();
                    var categoryClass = form.find("select[name='category'] option:checked").val();
                    if (title !== null && title.length != 0) {
                        $this.$calendarObj.fullCalendar('renderEvent', {
                            title: title,
                            Start: start,
                            end: end,
                            allDay: false,
                            className: categoryClass
                        }, true);
                        $this.$modal.modal('hide');
                    } else {
                        alert('Debes ingresar un título a tu evento');
                    }
                    return false;

                });
                $this.$calendarObj.fullCalendar('unselect');
            },
            CalendarApp.prototype.enableDrag = function () {
                //init events
                $(this.$event).each(function () {
                    // crear un Event Object (http://arshaw.com/fullcalendar/docs/event_data/Event_Object/)
                    // no requiere tener start o end
                    var eventObject = {
                        title: $.trim($(this).text()) // usar el texto del evento como titulo
                    };
                    // almacenar el objeto de Evento en el elemento DOM para que podamos acceder a él más tarde
                    $(this).data('eventObject', eventObject);

                    // hace que el evento sea draggable usando jQuery UI
                    $(this).draggable({
                        zIndex: 999,
                        revert: true, // hace que el evento vuelva este
                        revertDuration: 0  //  posicion original despues del drag
                    });
                });
            }
    /* Initializing */
    CalendarApp.prototype.init = function () {
        this.enableDrag();
        /*  Inicializar el calendar  */
        var today = new Date($.now());

        var defaultEvents = [{
                title: 'Primera instrucción UI y plantillas básicas!',
                Start: '2018-10-26',
                className: 'bg-info'
            }, {
                title: 'Esto es un evento para hoy',
                Start: today,
                end: today,
                className: 'bg-danger'
            }, {
                title: 'Segunda instrucción elementos de FORM',
                Start: '2018-10-30',
                className: 'bg-info'
            }, {
                title: 'Tercera instrucción elementos de TABLE',
                Start: '2018-11-02T15:00:00',
                end: '2018-11-02T17:00:00',
                className: 'bg-warning'
            }, {
                title: 'Reunión con Felipe',
                Start: new Date($.now() - 1199000000),
                end: new Date($.now() - 1199000000),
                className: 'bg-purple'
            }, {
                title: 'Tercera instrucción elementos de CALENDARIOS Y HELPERS',
                Start: '2018-11-06',
                end: '2018-11-06',
                className: 'bg-info'
            },
            {
                title: 'Cuarta instrucción PLUGINS VARIOS',
                Start: '2018-11-09',
                end: '2018-11-09',
                className: 'bg-danger'
            }, {
                title: 'Algo más aquí',
                Start: new Date($.now() + 348000000),
                className: 'bg-success'
            }];

        var $this = this;
        $this.$calendarObj = $this.$calendar.fullCalendar({
            slotDuration: '00:15:00', /* Si queremos cortar el day time cada 15min */
            minTime: '08:00:00',
            maxTime: '19:00:00',
            defaultView: 'month',
            handleWindowResize: true,
            locale: 'es',

            header: {
                left: 'prev,next today',
                center: 'title',
                right: 'month,agendaWeek,agendaDay'
            },
            events: defaultEvents,
            editable: true,
            droppable: true, // activa poder soltar elementos sobre el calendario !!!
            eventLimit: true, // permite el vinculo "más" cuando hay muchos eventos
            selectable: true,
            drop: function (date) {
                $this.onDrop($(this), date);
            },
            select: function (start, end, allDay) {
                $this.onSelect(start, end, allDay);
            },
            eventClick: function (calEvent, jsEvent, view) {
                $this.onEventClick(calEvent, jsEvent, view);
            }

        });

        //on new event
        this.$saveCategoryBtn.on('click', function () {
            var categoryName = $this.$categoryForm.find("input[name='category-name']").val();
            var categoryColor = $this.$categoryForm.find("select[name='category-color']").val();
            if (categoryName !== null && categoryName.length != 0) {
                $this.$extEvents.append('<div class="calendar-events" data-class="bg-' + categoryColor + '" style="position: relative;"><i class="fa fa-circle text-' + categoryColor + '"></i>' + categoryName + '</div>')
                $this.enableDrag();
            }

        });
    },
            //init CalendarApp
            $.CalendarApp = new CalendarApp, $.CalendarApp.Constructor = CalendarApp

}(window.jQuery),
//initializing CalendarApp
        function ($) {
            "use strict";
            $.CalendarApp.init()
        }(window.jQuery);