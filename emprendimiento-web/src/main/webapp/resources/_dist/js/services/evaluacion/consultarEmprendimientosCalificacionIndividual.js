/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var emprendimiento = null;
var temas = [];
var documentos = [];
var indexResult = 0;
var indexAgenda = 0;
var response = {};
var idEmpren = -1;
var maxLength = 500;
$(function () {
    $('#observa').keyup(function () {
        var length = $(this).val().length;
        var length = maxLength - length;
        $('#chars').text(length);
    });

    $(".preloader").fadeOut();
    $("#btn-Cancelar").on("click", cancelar);
    $('[data-toggle="tooltip"]').tooltip({
        trigger: 'hover'
    });
    $('#btnGuardar').on('click', function (e) {
        var validationError = validationFormErrors(e, "#modalCalificar");

        if (!validationError) {
            $("#modalCalificar").modal("hide");
            var cal = $('input[name=aprobado]:checked', '#modalCalificar').val();
            calificar(cal);
        }
    });

    $("#tableData").on('click', '.btn-calificar', function (e) {
        e.preventDefault();
        var index = $(this).data('index');
        var nom = $(this).data('nombre');
        idEmpren = index;
        califica(index, nom);
    });

    $("#tableData").on('click', '.btn-ver', function (e) {
        e.preventDefault();
        var index = $(this).data('index');
        ver(index);
    });
    getEmprendimientosSeguimiento();
    if (response.status === "1") {
        emprendimientos = response.emprendimientos;

        response.emprendimientos.forEach(function (item) {
            var row = "<tr>" +
                    "<td id=idemprendimiento" + indexAgenda + ">" + item.idemprendimiento + "</td>" +
                    "<td class='noOverflow' id=nombreemprendimiento" + indexAgenda + ">" + item.nombreemprendimiento + "</td>" +
                    "<td id=tipoemprendimiento" + indexAgenda + ">" + item.tipoemprendimiento.nombretipoemprendimiento + "</td>" +
                    "<td id=fecharegistro" + indexAgenda + ">" + moment(item.fecharegistro).format('DD-MM-YYYY') + "</td>" +
                    "<td align='center'><button type='button' data-index='" + item.idemprendimiento + "' class='btn btn-sm btn-rounded btn-info btn-ver' data-toggle='tooltip' data-placement='top' title='Ver'><i class='fas fa-eye'></i></button>" +
                    "<button type='button' data-index='" + item.idemprendimiento + "' data-nombre='" + item.nombreemprendimiento + "' class='btn btn-sm btn-rounded btn-success btn-calificar m-l-5'' data-toggle='tooltip' data-placement='top' title='Calificar'><i class='fas fa-check-circle'></i></button></td>" +
                    "</tr>";
            /*var row = "<tr id='agendar" + indexAgenda + "'>" +
             "<td id='idAgenda'>" + $('#idemprendimiento' + i).html() + "</td>" +
             "<td id='nAgenda'>" + $('#nombreemprendimiento' + i).html() + "</td>" +
             "<td id='tAgenda'>" + $('#tipoemprendimiento' + i).html() + "</td>" +
             "<td id='fAgenda'>" + $('#fecharegistro' + i).html() + "</td>" +
             "<td><button type='button' onclick='eliminar(" + indexAgenda + ")' class='btn btn-success btn-sm'>Eliminar</button></td>" +
             "</tr>";*/
            $('#tableData tr:last').after(row);
            indexAgenda += 1;
        });
    }
});


function getEmprendimientosSeguimiento() {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientosSeguimiento",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {estados: JSON.stringify(["4"]), idcajacompensacion: idcajacompensacion},
        success: function (result, status, xhr) {
            response = result;
        },
        error: function (xhr, status, error) {
            alert("Error cargando informacion beneficiario");
        }
    });
}

function califica(i, nom) {
    var id = i;
    $('#nombreEmprendimientoCal').text(nom);
    $("#modalCalificar").modal("show");

}


function ver(i) {
    $("#asociados").empty();
    $("#idTblTemasRutaAAT").find("tr:gt(0)").remove();
    $("#tablaDocs").find("tr:gt(0)").remove();
    getEmprendimientoCompleto(i);

    var emp = emprendimiento;
    var tem = temas;
    var docu = documentos;

    temas.forEach(function (item) {

        var row = "<tr>" +
                "<td>" + item.temasevaluacion.nombretema + "</td>" +
                "<td >" + item.cantidadhorasplaneadas + "</td>" +
                "<td>" + item.cantidadHorasEjecutadas + "</td>" +
                "<td>" + (item.cantidadHorasEjecutadas * 100) / item.cantidadhorasplaneadas + "<label>%</label></td>" +
                "<td>" + (item.urldocumentotema !== null && item.urldocumentotema !== '' ? "<a class='btn btn-primary' href='" + context + "/verDocumentoTemaRutaAAT?id=" + item.idtemarutaacompanamientoat + "'>Ver Documento</a>" : "Sin Documento") +
                "</td>" +
                "</tr>";
        $('#idTblTemasRutaAAT tr:last').after(row);

    });

    documentos.forEach(function (item) {
        var row = "<tr>" +
                "<td>" + item.tipodocumentos.nombretipodocumento + "</td>" +
                "<td>" + "<a class='btn btn-primary' href='" + context + "/verDocumentoComiteAAT?id=" + item.iddocumento + "'>Ver Documento</a>" + "</td>" +
                "</tr>";
        $('#tablaDocs tr:last').after(row);

    });

    $('#nombreEmprendimiento').text(emp.nombreemprendimiento);
    $('#tEmprendimiento').text(emp.tipoemprendimiento.nombretipoemprendimiento);
    emp.asociadoses.forEach(function (item) {
        $("#asociados").append("<li>" + item.beneficiario.primernombre + " " +
                item.beneficiario.primerapellido + "</li>");
    });

    if (emp.formalizados.length > 0) {
        $('#siFormalizado').checked = true;
        $("#divNoEstablecido").hide();
        $("#divFormalizado").show();
        var formalizado = emp.formalizados[0];
        $('#formalizado').text("Si");
        $('#nombreEmpresa').text(formalizado.nombreempresa);
        $('#nit').text(formalizado.nit);
        $('#nRegistroMercantil').text(formalizado.numeroregistromercantil);
        $('#nombreRepresentante').text(formalizado.representantelegal);
        $('#direccion').text(formalizado.direccionempresa);
        $('#telefono').text(formalizado.telefonoempresa);
        $('#municipio').text(formalizado.municipios.nombre);
        $('#email').text(formalizado.emailempresa);
        $('#web').text(formalizado.sitioweb);
        $('#constitucionF').text(formalizado.tipoconstitucionlegal.nombretipoconstitucionlegal);
        $('#sectorF').text(formalizado.sectorproductivo.nombresectorproductivo);

        if (formalizado.negociosinternet == "0") {
            $('#negInternet').text("No");
        } else {
            $('#negInternet').text("Si");
        }

        $('#prodServF').text(formalizado.productoservicioofrece);
        $('#fechaRenov').text(moment(formalizado.fecharenovacion).format('DD-MM-YYYY'));
        $('#fechaInicio').text(moment(formalizado.fechainiciolabores).format('DD-MM-YYYY'));
        $('#actividad').text(formalizado.actividadinternacional.nombreactividadinternacional);
        $('#empDirectos').text(formalizado.empleosdirectos);
        $('#empIndirectos').text(formalizado.empleosindirectos);
    } else {
        $('#formalizado').text("No");
        $("#divFormalizado").hide();
        $("#divNoEstablecido").show();
        var noEstablecido = emp.noestablecidos[0];
        $('#constitucionN').text(noEstablecido.tipoconstitucionlegal.nombretipoconstitucionlegal);
        $('#sectorN').text(noEstablecido.sectorproductivo.nombresectorproductivo);
        $('#prodServN').text(noEstablecido.productoservicioofrece);
        $('#cuandoInicia').text(moment(new Date(noEstablecido.cuandoinicia)).format("DD-MM-YYYY"));
        $('#observaciones').text(noEstablecido.observaciones);
    }
    $('#modalVerEmprendimiento').modal("show");
}

function getEmprendimientoCompleto(idemprendimiento) {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientoCompleto",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idemprendimiento: idemprendimiento},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                emprendimiento = result.emprendimiento;
                temas = result.temasRutasAAT;
                documentos = result.documentosDTO;
            } else {
                emprendimiento.nombreemprendimiento = "No registra emprendimiento activo para calificar.";
            }
        },
        error: function (xhr, status, error) {
            alert("Error cargando emprendimiento");

        }
    });

}


//$('#btnAprobado').on('click', function () {
//    var cal = 1;
//    calificar(cal);
//});
//$('#btnNoAprobado').on('click', function () {
//    var cal = 0;
//    calificar(cal);
//});

function calificar(cal) {
    var observaciones = $("#observa").val();
    var calificacion = cal;

    $(".preloader").fadeIn();
    $.post(context + "/calificarEmprendimientoIndividual",
            {observaciones: observaciones, calificacion: calificacion,
                idemprendimiento: idEmpren, idfuncionario: idfuncionario}, function (data) {
        setTimeout(function () {
            $("#body_content").html(data);
            $("#idPage").html("Calificacion Individual");
            $(".preloader").fadeOut();
        }, 500);


    });
}

function cancelar() {

    $.get(context + "/cargarDatosCalificacionIndividual", function (data) {
        $("#body_content").html(data);
        $("#idPage").html("Calificación Proyectos");
    });

}
