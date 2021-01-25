var emprendimientos = [];
var indexResult = 0;
var indexAgenda = 0;
var response = {};
var idEmprendimientos = [];
var nEmprendimientos = [];
var lTable;
$(function () {
    $("#tableData").on('click', '.btn-agregar', function (e) {
        e.preventDefault();
        var index = $(this).data('index');
        agregar(index);
    });

    $("#tableData").on('click', '.btn-ver', function (e) {
        e.preventDefault();
        var index = $(this).data('index');
        ver(index);
    });
    getEmprendimientosComite();
    if (response.status == "1") {
        var dataSet = [];
        emprendimientos = response.emprendimientos;
        emprendimientos.forEach(function (item) {
            var row = [];
            row.push(item.idemprendimiento);
            row.push(item.nombreemprendimiento);
            row.push(item.tipoemprendimiento.nombretipoemprendimiento);
            row.push(moment(item.fecharegistro).format("DD-MM-YYYY"));
            row.push("<button type='button' data-index=" + indexResult + " class='btn btn-sm btn-rounded btn-info btn-ver' data-toggle='tooltip' data-placement='top' title='Ver'><i class='fas fa-eye'></i></button>" +
                    "<button type='button' data-index=" + indexResult + " class='btn btn-sm btn-rounded btn-success btn-agregar m-l-5' data-toggle='tooltip' data-placement='top' title='Agregar'><i class='fas fa-plus-circle'></i></button>");
            dataSet.push(row);
//            var row = "<tr>" +
//                    "<td id=idemprendimiento" + indexAgenda + ">" + item.idemprendimiento + "</td>" +
//                    "<td id=nombreemprendimiento" + indexAgenda + ">" + item.nombreemprendimiento + "</td>" +
//                    "<td id=tipoemprendimiento" + indexAgenda + ">" + item.tipoemprendimiento.nombretipoemprendimiento + "</td>" +
//                    "<td id=fecharegistro" + indexAgenda + ">" + moment(item.fecharegistro).format("DD-MM-YYYY") + "</td>" +
//                    "<td align='center'><button type='button' data-index=" + indexAgenda + " class='btn btn-sm btn-rounded btn-info btn-ver' data-toggle='tooltip' data-placement='top' title='Ver'><i class='fas fa-eye'></i></button>" +
//                    "<button type='button' data-index=" + indexAgenda + " class='btn btn-sm btn-rounded btn-success btn-agregar m-l-5' data-toggle='tooltip' data-placement='top' title='Agregar'><i class='fas fa-plus-circle'></i></button></td>" +
//                    "</tr>";
//            $('#tableData tr:last').after(row);
            indexResult += 1;
        });
        if (lTable != null) {
            lTable.destroy();
        }
        lTable = $('#tableData').DataTable({
            language: datatableLanguageEs,
            data: dataSet,
            autoWidth: false,
            columns: [
                {title: "Id"},
                {title: "Nombre Emprendimiento", className: "noOverflow"},
                {title: "Tipo"},
                {title: "Fecha de Registro"},
                {title: "Acción", className: "text-center"},
            ]
        });
    } else {
        lTable = $('#tableData').DataTable({
            language: datatableLanguageEs,
            autoWidth: false,
            columns: [
                {title: "Id"},
                {title: "Nombre Emprendimiento", className: "noOverflow"},
                {title: "Tipo"},
                {title: "Fecha de Registro"},
                {title: "Acción", className: "text-center"},
            ]
        });
    }
    $(".preloader").fadeOut();
});

function agregar(i) {
    var data = lTable.row(i).data();

    if (yaAgendado(data[0])) {
        warningMsg(_mensajes.emprendimientoYaAgendadoSesionComite);
//        $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-warning");
//        $("#mensajes > span").text(_mensajes.emprendimientoYaAgendadoSesionComite);
//        $("#mensajes").show();
    } else {
        var row = "<tr id='agendar" + indexAgenda + "'>" +
                "<td id='idAgenda'>" + data[0] + "</td>" +
                "<td id='nAgenda'>" + data[1] + "</td>" +
                "<td id='tAgenda'>" + data[2] + "</td>" +
                "<td id='fAgenda'>" + data[3] + "</td>" +
                "<td align='center'><button type='button' onclick='eliminar(" + indexAgenda + ")' class='btn btn-sm btn-rounded btn-danger' data-toggle='tooltip' data-placement='top' title='Eliminar'><i class='fas fa-trash-alt'></i></button></td>" +
                "</tr>";
        $('#tbAgendados tr:last').after(row);
        indexAgenda += 1;
    }
}

function eliminar(i) {
    $('#agendar' + i).remove();
}

function agendar() {
    var id;
    $('#tbAgendados tr').each(function (a, b) {
        id = $('#idAgenda', b).text();
        if (id != "") {
            idEmprendimientos.push(id);
            nEmprendimientos.push($('#nAgenda', b).text());
        }
    });
    if (idEmprendimientos.length == 0) {
        errorMsg(_mensajes.noEmprendimientosSeleccionados);
//        $("#mensajes").removeClass("alert-danger alert-success alert-warning").addClass("alert-danger");
//        $("#mensajes > span").text(_mensajes.noEmprendimientosSeleccionados);
//        $("#mensajes").show();
    } else {
        $(".preloader").fadeIn();
        loadView("Consultar Agenda Lider Comité", context + '/consultarAgendaLiderComite');
    }
}

function validateEmail(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(String(email).toLowerCase());
}

function yaAgendado(x) {
    var id;
    var result = false;
    $('#tbAgendados tr').each(function (a, b) {
        id = $('#idAgenda', b).text();
        if (id == x) {
            result = true;
        }
    });
    return result;
}

function ver(i) {
    var emp = emprendimientos[i];
    $("#asociados").empty();
    $('#nombreEmprendimiento').text(emp.nombreemprendimiento);
    $('#tEmprendimiento').text(emp.tipoemprendimiento.nombretipoemprendimiento);

    emp.asociadoses.forEach(function (item) {
        $("#asociados").append("<li>" + item.beneficiario.primernombre + " " +
                item.beneficiario.primerapellido + "</li>");
    });

    if (emp.formalizados.length > 0) {
        $('#siFormalizado').checked = true;
        $(".noEstablecido").hide();
        $(".formalizado").show();
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


        formalizado.paisescomercializas.forEach(function (item) {
            $("#paises").append("<li>" + item.paises.nombrepais + "</li>");
        });

        $("#prodServF").empty();
        formalizado.productoservicioofrece.split(",").forEach(function (item) {
            $("#prodServF").append("<li>" + item + "</li>");
        });

        $('#fechaRenov').text(moment(new Date(formalizado.fecharenovacion)).format("DD-MM-YYYY"));
        $('#fechaInicio').text(moment(new Date(formalizado.fechainiciolabores)).format("DD-MM-YYYY"));
        $('#actividad').text(formalizado.actividadinternacional.nombreactividadinternacional);
        $('#empDirectos').text(formalizado.empleosdirectos);
        $('#empIndirectos').text(formalizado.empleosindirectos);
    } else {
        $('#formalizado').text("No");
        $(".formalizado").hide();
        $(".noEstablecido").show();
        var noEstablecido = emp.noestablecidos[0];
        $('#constitucionN').text(noEstablecido.tipoconstitucionlegal.nombretipoconstitucionlegal);
        $('#sectorN').text(noEstablecido.sectorproductivo.nombresectorproductivo);
        $("#prodServN").empty();
        noEstablecido.productoservicioofrece.split(",").forEach(function (item) {
            $("#prodServN").append("<li>" + item + "</li>");
        });
        $('#cuandoInicia').text(moment(new Date(noEstablecido.cuandoinicia)).format("DD-MM-YYYY"));
        $('#observaciones').text(noEstablecido.observaciones);
    }
    $('#modalVerEmprendimiento').modal("show");
}

function getEmprendimientosComite() {
    jQuery.ajax({
        type: "GET",
        url: context + "/getEmprendimientosComite",
        contentType: "application/x-www-form-urlencoded; charset=UTF-8",
        dataType: "json",
        async: false,
        data: {idcajacompensacion: idcajacompensacion},
        success: function (result, status, xhr) {
            if (result.status == "1") {
                response = result;
                successMsg(_mensajes.emprendimientosCargados);
            } else {
                errorMsg(result.descripcion);
            }
        },
        error: function (error) {
            if (error.status == 200) {
                swal({
                    title: "Agendar Sesión Comité",
                    text: _mensajes.sesionExpiro,
                    type: "error",
                    confirmButtonText: "Aceptar"
                }, function () {
                    location.replace(context + "/mostrarLogin");
                });
            } else {
                errorMsg(_mensajes.errorCargaEmprendimiento);
            }
        }
    });
}
