/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $(".preloader").fadeOut();
    $("#btnModificar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");
        if (!validationError) {

            modificarContrasena();

        }
    });
});

function modificarContrasena() {
    var password = $("#password").val();
    var contrasenaN = $("#contrasenaN").val();
    var contrasenaN2 = $("#contrasenaN2").val();
    if (password !== "" && contrasenaN !== "" && contrasenaN2 !== "") {
        if (contrasenaN === contrasenaN2) {
            if (/[\@\#\$\%\^\&\*\(\)\_\+\!]/.test(contrasenaN) && /[a-z]/.test(contrasenaN) && /[0-9]/.test(contrasenaN) && /[A-Z]/.test(contrasenaN)
                    && contrasenaN.length > 7) {
                var idestadofuncionario = $("#idestadofuncionario").val();
                $(".preloader").fadeIn();
                $.post(context + "/modificarContrasenaObligado2", {password: password, contrasenaN: contrasenaN, contrasenaN2: contrasenaN2, username: username},
                        function (data) {
                            $(".preloader").fadeOut();
                        });
            } else {
                swal({
                    title: "Contraseña Incorrecta",
                    text: "La contraseña debe tener mínimo 8 caracteres, una mayúscula, una minúscula, un número y un carácter especial",
                    type: "error",
                    confirmButtonText: "Ok",
                    showCancelButton: false

                });

            }
        } else {
            alert("Las contraseñas no coinciden");
            return false;
        }
    } else {
        alert("Por favor diligencie todos los campos");
        return false;
    }

}

