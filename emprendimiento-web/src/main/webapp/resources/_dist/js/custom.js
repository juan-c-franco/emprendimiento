window.onbeforeunload = function () {
    window.scrollTo(0, 0);
    document.documentElement.pageYOffset = 0;
};

$(function () {
    "use strict";
    $(function () {
        $(".preloader").fadeOut();
    });
    jQuery(document).on('click', '.mega-dropdown', function (e) {
        e.stopPropagation();
    });



    // ============================================================== 
    // This is for the top header part and sidebar part
    // ==============================================================  
    var set = function () {
        var width = (window.innerWidth > 0) ? window.innerWidth : this.screen.width;
        var topOffset = 50;
        if (width < 1170) {
            $("body").addClass("mini-sidebar");
            $('.navbar-brand span').hide();
            $(".sidebartoggler i").addClass("ti-menu");
        } else {
            $("body").removeClass("mini-sidebar");
            $('.navbar-brand span').show();
        }
        var height = ((window.innerHeight > 0) ? window.innerHeight : this.screen.height) - 1;
        height = height - topOffset;
        if (height < 1)
            height = 1;
        if (height > topOffset) {
            // $(".page-wrapper").css("min-height", (height) + "px");
        }
    };
    $(window).ready(set);
    $(window).on("resize", set);
    // ============================================================== 
    // Theme options
    // ==============================================================     
    $(".sidebartoggler").on('click', function () {
        if ($("body").hasClass("mini-sidebar")) {
            $("body").trigger("resize");
            $("body").removeClass("mini-sidebar");
            $('.navbar-brand span').show();
        } else {
            $("body").trigger("resize");
            $("body").addClass("mini-sidebar");
            $('.navbar-brand span').hide();
        }
    });
    // this is for close icon when navigation open in mobile view
    $(".nav-toggler").click(function () {
        $("body").toggleClass("show-sidebar");
        $(".nav-toggler i").toggleClass("ti-menu");
        $(".nav-toggler i").addClass("ti-close");
    });
    $(".search-box a, .search-box .app-search .srh-btn").on('click', function () {
        $(".app-search").toggle(200);
    });
    //
    // ============================================================== 
    // Right sidebar options
    // ============================================================== 
    $(".right-side-toggle").click(function () {
        $(".right-sidebar").slideDown(50);
        $(".right-sidebar").toggleClass("shw-rside");
    });
    // ============================================================== 
    // This is for the floating labels
    // ============================================================== 
    $('.floating-labels .form-control').on('focus blur', function (e) {
        $(this).parents('.form-group').toggleClass('focused', (e.type === 'focus' || this.value.length > 0));
    }).trigger('blur');

    // ============================================================== 
    //tooltip
    // ============================================================== 
    $(function () {
        $('body').tooltip({
            selector: '[data-toggle="tooltip"]',
            trigger: 'hover'
        });
    });

    // ============================================================== 
    //Popover
    // ============================================================== 
    $(function () {
        $('body').popover({
            selector: '[data-toggle="popover"]'
        });
    });

    // ============================================================== 
    // Perfect scrollbar
    // ============================================================== 
    $('.scroll-sidebar, .right-side-panel, .message-center, .right-sidebar').perfectScrollbar();
    // ============================================================== 
    // Resize all elements
    // ============================================================== 
    $("body").trigger("resize");

    // ============================================================== 
    // To do list
    // ============================================================== 
    $(".list-task li label").click(function () {
        $(this).toggleClass("task-done");
    });
    // ============================================================== 
    // Collapsable cards
    // ==============================================================
    $('a[data-action="collapse"]').on('click', function (e) {
        e.preventDefault();
        $(this).closest('.card').find('[data-action="collapse"] i').toggleClass('ti-minus ti-plus');
        $(this).closest('.card').children('.card-body').collapse('toggle');
    });
    // Toggle fullscreen
    $('a[data-action="expand"]').on('click', function (e) {
        e.preventDefault();
        $(this).closest('.card').find('[data-action="expand"] i').toggleClass('mdi-arrow-expand mdi-arrow-compress');
        $(this).closest('.card').toggleClass('card-fullscreen');
    });
    // Close Card
    $('a[data-action="close"]').on('click', function () {
        $(this).closest('.card').removeClass().slideUp('fast');
    });

    // ============================================================== 
    // Load View content
    // ==============================================================
    $('.option-menu').on('click', function (e) {
        e.preventDefault();

        var etiqueta = $(this).data('etiqueta');
        var url = $(this).data('ruta');

        loadView(etiqueta, url);
    });

    /**
     * Get a prestored setting
     *
     * @param String name Name of of the setting
     * @returns String The value of the setting | null
     */
    function get(name) {
        if (typeof (Storage) !== 'undefined') {
            return localStorage.getItem(name)
        } else {
            window.alert('Utilice un navegador moderno para ver correctamente este sitio!')
        }
    }
    /**
     * Store a new settings in the browser
     *
     * @param String name Name of the setting
     * @param String val Value of the setting
     * @returns void
     */
    function store(name, val) {
        if (typeof (Storage) !== 'undefined') {
            localStorage.setItem(name, val)
        } else {
            window.alert('Utilice un navegador moderno para ver correctamente este sitio!')
        }
    }
    $(document).scrollTop(0);
});

///GLOBALS ///
/**
 * Validacion de campos con required 
 *
 * @param String event - Evento al que se le hizo clic (boton submit)
 * @returns Boolean jqBootstrapValidation('hasErrors') - Retorna true si hay errores, de lo cantario falso
 */
function validationFormErrors(event, padre) {
    $("div").removeClass("validate").removeClass("issue");
    event.preventDefault();
    var $elements = $(padre).find('input, select, textarea').not("[type=submit]");
    $elements.each(function () {
        $(this).jqBootstrapValidation();
        $(this).trigger("change.validation", {submitting: true});
    });

    return $elements.jqBootstrapValidation('hasErrors');
}
;


/**
 * Carga un View en content Body Global -- TODO: encapsular y cambiar forma de llamada 
 *
 * @param String etiqueta Nombre de pagina 
 * @param String url ...
 * @returns null - solo carga el controlador (este metodo no deberia usarse)
 */
function loadView(etiqueta, url) {
    $(".preloader").fadeIn();


    jQuery.ajax({
        type: "GET",
        url: context + "/sesionExpirada",
        dataType: "json",
        async: false,
        data: {},
        success: function (result, status, xhr) {

            $.ajax({
                method: "GET",
                url: url
            }).done(function (data) {
                $("#body_content").html(data);
                $("#idPage").html(etiqueta);
                setTimeout(function () {
                    $(".preloader").fadeOut();
                }, 500);
            });
        },
        error: function (error) {
            
//                swal({
//                    title: "Consultar Beneficiario",
//                    text: _mensajes.sesionExpiro,
//                    type: "error",
//                    confirmButtonText: "Aceptar"
//                }, function () {");
                    location.replace(context + "/mostrarLogin");
//                });
             
        }
    });



}

// Configuración global de Toast
toastr.options = {
    "closeButton": true,
    "debug": false,
    "positionClass": "toast-bottom-right",
    "onclick": null,
    "showDuration": "1000",
    "hideDuration": "1000",
    "timeOut": "0",
    "extendedTimeOut": "0",
    "showEasing": "swing",
    "hideEasing": "linear",
    "showMethod": "slideDown",
    "hideMethod": "fadeOut",
    "progressBar": true
};
// ============================================================== 
// Objeto de mensajes
// ==============================================================

var _mensajes = {
    noCambios24h: "No se puede modificar una sesión en las últimas 24 horas",
    noCambiosSesion: "No se puede cambiar el estado de esta sesión.",
    sesionesPasado: "No se puede agendar una sesión en la fecha seleccionada.",
    horaFinMenorInicio: "La Hora Fin debe ser posterior de la Hora Inicio.",
    seguroActualizar: "¿Esta seguro que desea actualizar la sesión?",
    seguroCancelar: "¿Esta seguro que desea cancelar la sesión?",
    correoInvalido: "El siguiente correo electrónico no es válido: ",
    noBeneficiario: "No se ha seleccionado ningún beneficiario.",
    seguroRegistrarBeneficiario: "¿Realmente desea registrar el Beneficiario?",
    yaExisteBeneficiario: "El usuario ya existe, ¿Desea realizar el agendamiento?",
    registroBeneficiarioSatisfactorio: "Registro Satisfactorio, ¿Desea realizar el agendamiento?",
    soloSesionesReservadas: "Solo se pueden liberar sesiones reservadas",
    parametrosNoValidosAgendarValoracion: "Lista de Beneficiarios o Funcionario Valorador no válido.",
    parametrosNoValidosAgendarLiderComite: "Lista de Beneficiarios o Funcionario Líder Comité no válido.",
    seguroAgendar: "¿Realmente desea asociar los beneficiarios seleccionados a esta sesión?",
    beneficiariosCargados: "Consulta realizada exitosamente.",
    errorCargaBeneficiario: "Error cargando información del beneficiario",
    errorCargaEmprendimiento: "Error cargando información del Emprendimiento",
    respuestaNoReconocida: "Respuesta no reconocida",
    sinResultados: "No existe un beneficiario con los datos ingresados",
    yaExisteCorreoElectronico: "Ya existe un beneficiario enlistado con el siguiente correo electrónico: ",
    noBeneficiariosSeleccionados: "Debe seleccionar por lo menos un Beneficiario.",
    noEmprendimientosSeleccionados: "Debe seleccionar por lo menos un Emprendimiento.",
    seguroRegistrarEmprendimiento: "¿Realmente desea registrar el Emprendimiento?",
    seguroRegistrarSeguimiento: "¿Realmente desea registrar este Seguimiento?",
    emprendimientoYaAgendadoSesionComite: "Emprendimiento ya fue agregado a la lista de agendados.",
    seguroRegistrar: "¿Está seguro que desea registrar asistencia?",
    programarSesionAATOK: "Se programó una nueva sesión! ",
    errorCancelarSesionAAT: "No es posible cancelar la sesión, por favor contactar al administrador",
    cancelarSesionAATOK: "Sesión cancelada con éxito",
    actualizarSesionAATOK: "Sesión Actualizada con éxito",
    funcionarioObligatorio: "Funcionario asistente técnico obligatorio",
    noResultadosAAT: "La consulta no arrojó resultados. Recuerde que debe terminar el proceso de valoración previamente.",
    aproboConsultaAATOK: "Se aprobó el emprendimiento exitosamente",
    verificarCampos: "Verificar campos requeridos y validaciones.",
    beneficiarioNoEmprendimiento: "Beneficiario no presenta emprendimiento activo.",
    sesionesComiteCargadas: "Sesiones Comité cargadas exitosamente",
    noSesionesComite: "No hay sesiones comité por calificar",
    errorCargandoSesionesComite: "Error cargando sesiones comité",
    emprendimientosCargados: "Emprendimientos cargados exitosamente",
    errorCargaCalificacionesIntegrantesComite: "Error cargando calificaciones integrantes comité",
    documentoObligatorio: "Es obligatorio diligenciar documento",
    file5mb: "El archivo no debe superar 5MB",
    errorCalificandoEmprendimiento: "Error calificando emprendimiento",
    soloPDF: "Solo se permiten documentos con extensión PDF",
    soloTXT: "Solo se permiten documentos con extensión .txt",
    calificarContinuar: "Debe calificar todos los emprendimientos antes de continuar.",
    registroUmbralCalificaciones: "La calificación básica debe ser menor a la calificación intermedia, la calificación intermedia debe ser menor a la calificación avanzada",
    registroHoras: "La cantidad de horas de nivel básico debe ser mayor a la cantidad de horas de nivel intermedio, la cantidad de horas de nivel intermedio debe ser mayor a la cantidad de horas de nivel avanzado",
    regexContrasena: "La contraseña debe tener mínimo 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial",
    errorCargaInformacionFinanciera: "Error cargando información financiera",
    seguroAdjuntarPlanAccion: "Si guarda el documento, este sobreescribirá los documentos que haya cargado anteriormente. ¿Desea guardar el documento?",
    seguroEliminarDocumento: "¿Está seguro que desea eliminar el documento?",
    cargaFinalizada: "Proceso de carga de documento finalizado",
    seguroEliminarTema: "¿Está seguro que desea eliminar el tema? Se eliminarán todas las preguntas que éste contenga",
    seguroEliminarPregunta: "¿Está seguro que desea eliminar la pregunta?",
    sesionExpiro: "Su sesión ha expirado, por favor ingrese sus credenciales nuevamente.",
    errorAjax: "No fue posible procesar su solicitud, intentelo nuevamente.",
    horasPlanteadasCumplidas: "Ya se ha cumplido con las horas planteadas para este tema",
    registrarAsistenciaExito: "Asistencia registrada exitosamente",
    comiteMinimo3: "El comité de evaluación debe tener como mínimo 3 integrantes",
    comiteImpar: "La cantidad de integrantes del comité de evaluación debe ser impar",
    comiteLiderCero: "El comité de evaluación debe tener como mínimo un líder",
    comiteLiderUno: "Cada comité debe tener máximo un lider",
    seguroAprobarSinDoc: "Aun no se ha adjuntado Documento Comité. ¿Desea continuar?",
    fechaInicialMenor: "La fecha de inicio debe ser anterior a la fecha final",
    errorCargaSesiones: "Ocurrió un error cargando las sesiones del funcionario.",
    longitudTelefono: "El número de telefono debe tener mínimo 7 dígitos y maximo 15",
    documentoInvalido: "Número de documento Invalido",
    avanceGrupal: "El avance grupal debe ser de al menos 80% para poder aprobar",
    configuracionesNoCambios: "No hay cambios que guardar",
    beneficiarioNoPuedeRegistrar: "El beneficiario seleccionado no cumple con los requisitos para registro.",
    sinResultados2: "La búsqueda no tuvo resultados.",
    fechaInicioNoPasada: "La fecha de inicio de un emprendimiento de formalizado no puede ser posterior a la actual.",
    fechaRenovacionNoPasada: "La fecha de renovación de matrícula debe ser posterior a la actual.",
    fechaPasada: "No se pueden hacer programaciones en el pasado",
    modulosAlumnosVacio: "Programación sin Alumnos o Módulos/Ciclos asociados.",
    errorProcesandoArchivo: "Ocurrió un error procesando el archivo."
};

// ============================================================== 
// Mascaras de Validacion
// ==============================================================
$(document).on('keyup', '.only-number', function () {
    this.value = this.value.replace(/\D/g, '');
});

$('.maxAsistentesProgramarSensibilizacion').mask('000');
$('.registroMercantil').mask('0000000000');
$('.telefono').mask('0000000000000000');
$('.empleados').mask('0000');

// ============================================================== 
// Funciones globales Juan Carlos Franco
// ==============================================================
function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}
// ============================================================== 
// Datatable Español
// ==============================================================
var datatableLanguageEs = {sProcessing: "Procesando...", sLengthMenu: "Mostrar _MENU_ registros", sZeroRecords: "No se encontraron resultados", sEmptyTable: "Ningún dato disponible en esta tabla", sInfo: "Mostrando registros _START_ al _END_ de un total de _TOTAL_ registros", sInfoEmpty: "Mostrando registros 0 de un total de 0 registros", sInfoFiltered: "(filtrado de un total de _MAX_ registros)", sInfoPostFix: "", sSearch: "Buscar:", sUrl: "", sInfoThousands: ".", sLoadingRecords: "Cargando...", oPaginate: {sFirst: "Primero", sLast: "Último", sNext: "Siguiente", sPrevious: "Anterior"}, oAria: {sSortAscending: ": Activar para ordenar la columna de manera ascendente", sSortDescending: ": Activar para ordenar la columna de manera descendente"}};

// ============================================================== 
// Funciones Globales
// ==============================================================

function errorMsg(msg) {
    //Verifico si está el div mensajes;
    var dMsg = document.getElementById("mensajes");
    if (dMsg != null) {
        dMsg.parentNode.removeChild(dMsg);
    }

    var div = document.createElement("div");
    div.setAttribute('id', "mensajes");
    div.setAttribute('class', "alert alert-danger");
    div.innerHTML = "<i class='fas fa-exclamation-circle'></i>  <span></span> <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button>";
    document.getElementById("msgContainer").appendChild(div);
    $("#mensajes > span").html(msg);
}

function errorListMsg(msg) {
    //Verifico si está el div mensajes;
    var dMsg = document.getElementById("mensajes");
    if (dMsg != null) {
        dMsg.parentNode.removeChild(dMsg);
    }

    var div = document.createElement("div");
    div.setAttribute('id', "mensajes");
    div.setAttribute('class', "alert alert-danger");
    div.innerHTML = "<i class='fas fa-exclamation-circle'></i> <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button> <p></p>";
    document.getElementById("msgContainer").appendChild(div);
    $("#mensajes > p").html(msg);
}

function warningMsg(msg) {
    //Verifico si está el div mensajes;
    var dMsg = document.getElementById("mensajes");
    if (dMsg != null) {
        dMsg.parentNode.removeChild(dMsg);
    }

    var div = document.createElement("div");
    div.setAttribute('id', "mensajes");
    div.setAttribute('class', "alert alert-warning");
    div.innerHTML = "<i class='fas fa-exclamation-circle'></i>  <span></span> <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button>";
    document.getElementById("msgContainer").appendChild(div);
    $("#mensajes > span").html(msg);
}

function successMsg(msg) {
    //Verifico si está el div mensajes;
    var dMsg = document.getElementById("mensajes");
    if (dMsg != null) {
        dMsg.parentNode.removeChild(dMsg);
    }

    var div = document.createElement("div");
    div.setAttribute('id', "mensajes");
    div.setAttribute('class', "alert alert-success");
    div.innerHTML = "<i class='fa fa-check-circle'></i>  <span></span> <button type='button' class='close' data-dismiss='alert' aria-label='Close'> <span aria-hidden='true'>&times;</span> </button>";
    document.getElementById("msgContainer").appendChild(div);
    $("#mensajes > span").html(msg);
}

function getBeneficiarioDOC(doc) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getBeneficiarioDOC",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {doc: doc},
        success: function (result, status, xhr) {
            $("#mensajes").hide();
            response = result;
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consultar Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                errorMsg(_mensajes.errorCargaBeneficiario);
            }
        }
    });
}

function getBeneficiarioNombreApellido(pNombre, sNombre, pApellido, sApellido) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getBeneficiarioNombreApellido",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {pNombre: pNombre,
            sNombre: sNombre,
            pApellido: pApellido,
            sApellido: sApellido},
        success: function (result, status, xhr) {
            $("#mensajes").hide();
            response = result;
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Consultar Beneficiario",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                errorMsg(_mensajes.errorCargaBeneficiario);
            }
        }
    });
}
