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
    verInstitucion(id);
});
$("#btn-Cancelar").on('click', function (e) {
    e.preventDefault();
    $(".preloader").fadeIn();
    location.replace(context + "/");
    $(".preloader").fadeOut();
});
$("#btn-agregar").on('click', function () {
    $(".preloader").fadeIn();
    $.get(context + "/registroInstituciones", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Registro Institución");
        $(".preloader").fadeOut();
    });

});

function verInstitucion(id) {

    $(".preloader").fadeIn();
    jQuery.ajax({
        method: "GET",
        url: context + "/modificarInstituciones",
        dataType: "json",
        async: false,
        data: {id: id},
        success: function (data, status, xhr) {
            $(".preloader").fadeOut();
            $("#nombreInstitución").text(data.institucion.nombreInstitucion);
            $("#correoElectronico").text(data.institucion.correoElectronico);
            $("#telefonoContacto").text(data.institucion.numeroTelefono);
            if (data.institucion.estadoAprobacion === 'A') {
                $("#estadoAprobacion").text('Aprobada');
            } else if (data.institucion.estadoAprobacion === 'R') {
                $("#estadoAprobacion").text('Rechazada');
            } else if (data.institucion.estadoAprobacion === 'N') {
                $("#estadoAprobacion").text('No Aprobada');
            }

            $("#estado").text(data.institucion.estado === 'A' ? 'Activa' : 'Inactiva');
            $("#documento").text(data.institucion.nit);
            $("#digitoVerificacion").text(data.institucion.digitoVerificacion);
            if (data.institucion.tipoCertificacion === 1) {
                $("#tipoCertificacion").text('NTC 6094');
            } else if (data.institucion.tipoCertificacion === 2) {
                $("#tipoCertificacion").text('NTC 5555');
            } else if (data.institucion.tipoCertificacion === 3) {
                $("#tipoCertificacion").text('ISO 9001');
            }

            $("#vencimientoCertificacion").text(moment(data.institucion.vencimientoCertificacion).format('DD-MM-YYYY'));
            $("#origen").text(data.institucion.origen);
            $("#naturalezaJuridica").text(data.institucion.naturalezaJuridica === 0 ? 'Persona Natural' : 'Persona Jurídica');
            $("#modalVerInstitucion").modal("show");

        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Instituciones",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                swal({
                    title: "Instituciones",
                    text: error,
                    type: "error",
                    confirmButtonText: "Aceptar"
                });
            }
        }
    });
//    $.get(context + "/modificarInstituciones", {id: id}, function (data) {
//        $(".preloader").fadeOut();
//        if (data.status === '1') {
//            $("#nombreInstitución").text(data.institucion.nombreInstitucion);
//            $("#correoElectronico").text(data.institucion.correoElectronico);
//            $("#telefonoContacto").text(data.institucion.numeroTelefono);
//            if (data.institucion.estadoAprobacion === 'A') {
//                $("#estadoAprobacion").text('Aprobada');
//            } else if (data.institucion.estadoAprobacion === 'R') {
//                $("#estadoAprobacion").text('Rechazada');
//            } else if (data.institucion.estadoAprobacion === 'N') {
//                $("#estadoAprobacion").text('No Aprobada');
//            }
//
//            $("#estado").text(data.institucion.estado === 'A' ? 'Activa' : 'Inactiva');
//            $("#documento").text(data.institucion.nit);
//            $("#digitoVerificacion").text(data.institucion.digitoVerificacion);
//            if (data.institucion.tipoCertificacion === 1) {
//                $("#tipoCertificacion").text('NTC 6094');
//            } else if (data.institucion.tipoCertificacion === 2) {
//                $("#tipoCertificacion").text('NTC 5555');
//            } else if (data.institucion.tipoCertificacion === 3) {
//                $("#tipoCertificacion").text('ISO 9001');
//            }
//
//            $("#vencimientoCertificacion").text(moment(data.institucion.vencimientoCertificacion).format('DD-MM-YYYY'));
//            $("#origen").text(data.institucion.origen);
//            $("#naturalezaJuridica").text(data.institucion.naturalezaJuridica === 0 ? 'Persona Natural' : 'Persona Jurídica');
//            $("#modalVerInstitucion").modal("show");
//
//        } else {
//            swal({
//                title: "Error Cargar Institución",
//                text: data.descripcion,
//                type: "error",
//                confirmButtonText: "Ok",
//                showCancelButton: false
//
//            });
//        }
//    });
}

