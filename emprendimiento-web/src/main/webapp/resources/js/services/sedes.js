/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(function () {
    $(".preloader").fadeOut();
    $('#tableData').DataTable({
        language: datatableLanguageEs
    });
});
$(".btn-modificar").on('click', function (e) {
    e.preventDefault();
    var id = $(this).data('index');
    verSede(id);
});

$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();
});

function verSede(id) {

    $(".preloader").fadeIn();
    jQuery.ajax({
        method: "GET",
        url: context + "/traerSede",
        dataType: "json",
        async: false,
        data: {id: id},
        success: function (data, status, xhr) {
            $(".preloader").fadeOut();
            if (data.status === '1') {
                $("#nombre").text(data.sedes[0].nombre);
                $("#codigo").text(data.sedes[0].codigo);
                $("#direccion").text(data.sedes[0].direccion);
                $("#estado").text(data.sedes[0].estado === 'A' ? 'Activa' : 'Inactiva');
                $("#principal").text(data.sedes[0].principal === true ? 'Si' : 'No');
                $("#idInstitucion").text(data.institucion.nombreInstitucion);
                $("#idMunicipio").text(data.sedes[0].municipios.nombre);
                $("#idDepartamento").text(data.sedes[0].departamentos.nombre);
                $("#modalVerSede").modal("show");

            } else {
                swal({
                    title: "Error Cargar Sede",
                    text: data.descripcion,
                    type: "error",
                    confirmButtonText: "Ok",
                    showCancelButton: false

                });
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Sedes",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Sedes",
                    text: error,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
//    $.get(context + "/traerSede", {id: id}, function (data) {
//        $(".preloader").fadeOut();
//        if (data.status === '1') {
//            $("#nombre").text(data.sedes[0].nombre);
//            $("#codigo").text(data.sedes[0].codigo);
//            $("#direccion").text(data.sedes[0].direccion);
//            $("#estado").text(data.sedes[0].estado === 'A' ? 'Activa' : 'Inactiva');
//            $("#principal").text(data.sedes[0].principal === true ? 'Si' : 'No');
//            $("#idInstitucion").text(data.institucion.nombreInstitucion);
//            $("#idMunicipio").text(data.sedes[0].municipios.nombre);
//            $("#idDepartamento").text(data.sedes[0].departamentos.nombre);
//            $("#modalVerSede").modal("show");
//
//        } else {
//            swal({
//                title: "Error Cargar Sede",
//                text: data.descripcion,
//                type: "error",
//                confirmButtonText: "Ok",
//                showCancelButton: false
//
//            });
//        }
////            $("#body_content").html(data);
////        $("#idPage").html("Editar Institución");
////        $(".preloader").fadeOut();
//    });
}