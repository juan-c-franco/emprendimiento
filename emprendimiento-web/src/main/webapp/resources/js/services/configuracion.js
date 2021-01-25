/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var configuraciones = [];
$(function () {
    $(".preloader").fadeOut();
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });

    $("#btn-Cancelar").on('click', function (e) {
        e.preventDefault();
        $(".preloader").fadeIn();
        location.replace(context + "/");
        $(".preloader").fadeOut();
    });

    $("#btn-guardar").on('click', function (e) {
        configuraciones = [];
        $('#tableData tr').each(function (rIndex, row) {
            var cols = [];
            $(this).find('td').each(function (colIndex, col) {
                if (colIndex != 4) {
                    cols.push(col.textContent);
                } else {
                    if ($("#activo" + rIndex).is(":checked") && $("#activo" + rIndex).attr("checked") != "checked") {
                        var conf = {
                            idconfiguracion: cols[0],
                            nombreconfiguracion: cols[1],
                            fechamodificacion: cols[2],
                            valor: 1
                        };
                        configuraciones.push(conf);
                    } else if (!$("#activo" + rIndex).is(":checked") && $("#activo" + rIndex).attr("checked") == "checked") {
                        var conf = {
                            idconfiguracion: cols[0],
                            nombreconfiguracion: cols[1],
                            fechamodificacion: cols[2],
                            valor: 0
                        };
                        configuraciones.push(conf);
                    }
                }
            });
        });
        if (configuraciones.length == 0) {
            swal({
                title: "Configuraciones",
                text: _mensajes.configuracionesNoCambios,
                type: "warning",
                confirmButtonText: "Aceptar"
            });
        } else {
            jQuery.ajax({
                method: "POST",
                url: context + "/guardarConfiguraciones",
                data: {request: JSON.stringify(configuraciones)},
                //contentType: "application/json",
                dataType: "json",
                async: false,
                success: function (result, status, xhr) {
                    if (result.status == "1") {
                        swal({
                            title: "Configuraciones",
                            text: result.descripcion,
                            type: "success",
                            confirmButtonText: "Aceptar"
                        }, function (isConfirm) {
                            if (isConfirm) {
                                $(".preloader").fadeIn();
                                $("#body_content").load(context + '/configuracion');
                            }
                        });
                    } else {
                        swal({
                            title: "Configuraciones",
                            text: result.descripcion,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }
                },
                error: function (error) {
                    if (error.status == 200) {
                        swal({
                            title: "Configuraciones",
                            text: _mensajes.sesionExpiro,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        }, function () {
                            location.replace(context + "/mostrarLogin");
                        });
                    } else {
                        swal({
                            title: "Configuraciones",
                            text: _mensajes.errorAjax,
                            type: "error",
                            confirmButtonText: "Aceptar"
                        });
                    }
                }
            });
        }
    });
});


