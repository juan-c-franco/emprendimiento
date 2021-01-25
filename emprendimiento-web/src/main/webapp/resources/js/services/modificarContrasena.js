/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $("#btnModificar").on("click", function (e) {
        var validationError = validationFormErrors(e, "#valora");

        if (!validationError) {

            modificarContrasena();

        }
    });
//    $("#btnModificar").on("click", modificarContrasena);

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
                $.post(context + "/modificarContrasena2", {password: password, contrasenaN: contrasenaN, contrasenaN2: contrasenaN2},
                        function (data) {
                            $("#body_content").html(data);
                            $("#idPage").html("Modificar Contrasena");
                            $(".preloader").fadeOut();
                        });
            } else {
                $("#reggex1").text(_mensajes.regexContrasena);
                $("#reggex2").text(_mensajes.regexContrasena);
//                swal({
//                    title: "Contraseña Incorrecta",
//                    text: _mensajes.regexContrasena,
//                    type: "error",
//                    confirmButtonText: "Ok",
//                    showCancelButton: false
//
//                });

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
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();

});
//<form:form action="${pageContext.request.contextPath}/modificarContrasena2" method="POST">
