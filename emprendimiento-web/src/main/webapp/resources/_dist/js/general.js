$(function () {
    "use strict";

    $(function () {
        $(".preloader").fadeOut();
    });

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    // ============================================================== 
    // jQuery validator activate
    // ==============================================================
    $("input,textarea,select").not("[type=submit]").jqBootstrapValidation({
        preventSubmit: true,
        submitError: function ($form, event, errors) {
            // console.log('datos incompletos!');
        },
        submitSuccess: function ($form, event) {
            event.preventDefault();
        },
        filter: function () {
            return $(this).is(":visible");
        }
    }
    );

});

///GLOBALS ///
/**
 * Validacion de campos con required 
 *
 * @param String event - Evento al que se le hizo clic (boton submit)
 * @returns Boolean jqBootstrapValidation('hasErrors') - Retorna true si hay errores, de lo cantario falso
 */
function validationFormErrors(event, padre) {
    event.preventDefault();
    var $elements = $(padre).find('input, select, textarea').not("[type=submit]");
    //console.log($elements);
    $elements.each(function () {
        //console.log($(this));
        $(this).jqBootstrapValidation();
        $(this).trigger("change.validation", {submitting: true});
    });

    return $elements.jqBootstrapValidation('hasErrors');
    };
