$(function () {


    "use strict";
    $(function () {
        $(".preloader").fadeOut();
    });

    $(function () {
        $('[data-toggle="tooltip"]').tooltip();
    });

    $("input,select,textarea").not("[type=submit]").jqBootstrapValidation();

    // ---------------------------------------------------- 
    // Login y Recuperar Password 
    // ---------------------------------------------------- 

    $('#to-recover').on("click", function () {
        $("#loginform").slideUp();
        $("#recoverform").fadeIn();
        $(".preloader").fadeOut();
    });

    $('#to-login').on("click", function () {
        $("#recoverform").fadeOut();
        setTimeout(function () {
            $("#loginform").fadeIn();
        }, 500);
    });

    if (obligatorio === 1) {
        $('#modalObligatorio').modal("show");
    }
    $("#btnModificar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#modalObligatorio");

        if (!validationError) {

            modificar();

        }
    });
    $("#username2").on("change", function(){
        var username = $("#username2").val().toLowerCase();
        $("#username").val(username);
    });

});

function modificar() {
    var password = $("#password").val();
    var contrasenaN = $("#contrasenaN").val();
    var contrasenaN2 = $("#contrasenaN2").val();

    if (/[\@\#\$\%\^\&\*\(\)\_\+\!]/.test(contrasenaN) && /[a-z]/.test(contrasenaN) && /[0-9]/.test(contrasenaN) && /[A-Z]/.test(contrasenaN)
            && contrasenaN.length > 7) {
        var idestadofuncionario = $("#idestadofuncionario").val();
        $(".preloader").fadeIn();

        $.post(context + "/modificarContrasenaObligado2", {password: password, contrasenaN: contrasenaN, contrasenaN2: contrasenaN2, username: username},
                function (data) {

                    $("#Eerror").removeClass("alert alert-danger alert-rounded");
                    $("#Eerror").addClass("alert alert-success alert-rounded");
                    $("#Eerror").text(data.descripcion);
                    $('#modalObligatorio').modal('hide');
                    $(".preloader").fadeOut();
                });
    } else {
        $("#regggex1").text("La contraseña debe tener mínimo 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial");
        $("#regggex2").text("La contraseña debe tener mínimo 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial");
//        swal({
//            title: "Contraseña Incorrecta",
//            text: "La contraseña debe tener mínimo 8 carácteres, una mayúscula, una minúscula, un número y un carácter especial",
//            type: "error",
//            confirmButtonText: "Ok",
//            showCancelButton: false
//
//        });

    }

}
;
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
