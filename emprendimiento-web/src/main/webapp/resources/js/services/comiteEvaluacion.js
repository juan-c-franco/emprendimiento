/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var integrantesArray = [];
$(function () {
    $('.selectpicker').selectpicker();
//    $('#usuarioComiteId').multiSelect();
    $('#usuarioComiteId').multiSelect({
        selectableHeader: "<label class='custom-header'>Funcionarios</label>",
        selectionHeader: "<label class='custom-header'>Integrantes Del Comité</label>"
    });
    $('#usuarioComiteId').val(integrantes);
    $('#usuarioComiteId').multiSelect("refresh");
    $("#btnGuardar").on("click", guardar);
//    $("#btnParametrizarComite").on("click", parametrizarComite);

    $('#btnParametrizarComite').on('click', function (e) {
        if (!validationFormErrors(e, "#divCaja")) {
            $("#btnParametrizarComite").prop("disabled", true);
            parametrizarComite();
            $("#btnParametrizarComite").prop("disabled", false);
        }
    });

});

function guardar() {
    var idComite = $("#idComite").val();
    var cajaId = $("#idCajaCompensacion").val();
    integrantesArray = [];
    $("#usuarioComiteId").each(function () {
        integrantesArray.push($(this).val());
    });

    if (integrantesArray[0].length >= 3) {
        if (integrantesArray[0].length % 2 !== 0) {

            // intento de ajax
            jQuery.ajax({
                method: "POST",
                url: context + "/guardarIntegrantesComite",
                dataType: "json",
                async: false,
                data: {idComite: idComite, integrantesComiteId: JSON.stringify(integrantesArray),
                    cajaId: cajaId},
                success: function (result, status, xhr) {
                    if (result.status === "1") {
                        swal({
                            title: "Guardar Comité",
                            text: result.descripcion,
                            type: "success",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            $(".preloader").fadeIn();
                            $.get(context + "/comiteEvaluacion", {cajaId: cajaId}
                            , function (data) {
                                $("#body_content").html(data);
                                $("#idPage").html("Comite de Evaluacion");
                                $(".preloader").fadeOut();
                            });
                        });
                    } else {
                        swal({
                            title: "Guardar Comité",
                            text: result.descripcion,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }
                },
                error: function (error) {
                    if (error.status == 200) {
                        swal({
                            title: "Guardar Comité",
                            text: _mensajes.sesionExpiro,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            location.replace(context + "/mostrarLogin");
                        });
                    } else {
                        swal({
                            title: "Guardar Comité",
                            text: _mensajes.errorAjax,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }
                }
            });
        } else {
            swal({
                title: "Guardar Comité",
                text: _mensajes.comiteImpar,
                type: "warning",
                confirmButtonText: "OK",
                showCancelButton: false,
                cancelButtonText: "No"
            });
        }

    } else {
        swal({
            title: "Guardar Comité",
            text: _mensajes.comiteMinimo3,
            type: "warning",
            confirmButtonText: "OK",
            showCancelButton: false,
            cancelButtonText: "No"
        });
    }

}

function parametrizarComite() {
    var cajaId = $("#cajaId").val();
    $(".preloader").fadeIn();
    $.get(context + "/comiteEvaluacion",
            {cajaId: cajaId}, function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Parametrizar comité evaluación");
        $(".preloader").fadeOut();
    });
}
