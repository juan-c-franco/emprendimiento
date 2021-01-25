var beneficiario = {};
$(function () {
    $('.onlyNumber').mask('000000000000000');
    $("#btnDoc").on("click", buscarxDoc);
});
function buscarxDoc() {
    var doc = $("#documento").val();
    if (doc) {
        $.get(context + "/findBeneficiarioXDoc", {doc: doc}, function (data) {
            console.log(JSON.stringify(data));
            var html = "<tr>";
            html += "<td>" + data.numeroDocumento + "</td>";
            html += "<td>" + data.tipoDocumento + "</td>";
            html += "<td>" + data.primerNombre + " " + ((data.segundoNombre) ? data.segundoNombre : "") + "</td>";
            html += "<td>" + data.primerApellido + " " + ((data.segundoApellido) ? data.segundoApellido : "") + "</td>";
            html += "<td>" + ((data.telefonoContacto) ? data.telefonoContacto : "Sin Telefono") + "</td>";
            html += "<td>" + ((data.correoElectronico) ? data.correoElectronico : "Sin Correo") + "</td>";
            html += "<td><button type='button' onclick='showModal()' class='btn btn-success btn-sm'>Registrar</button></td>";
            html += "</tr>";
            beneficiario = data;
            $("#bodyBeneficiario").html(html);
        });
    }
}


function showModal() {
    $("#modalRegistro").modal("show");
}
function regBeneficiario() {
    if (beneficiario) {
        $.ajax({
            method: "POST",
            url: context + "/regBeneficiario",
            data: JSON.stringify(beneficiario),
            contentType: "application/json",
            dataType: "json"
        })
                .done(function (iBeneficiario) {
                    beneficiario = iBeneficiario;
                    $("#modalRegistro").modal("hide");
                    bootbox.confirm({
                        message: "Registro Sastisfactorio, ¿Desea realizar la agendamiento?",
                        buttons: {
                            confirm: {
                                label: 'Si',
                                className: 'btn-success'
                            },
                            cancel: {
                                label: 'No',
                                className: 'btn-danger'
                            }
                        },
                        callback: function (result) {
                            if (result) {
                                loadView('Agendar Sesión', context + '/consultarAgendaSensibilizacion');
                            }
                        }
                    });
                }).fail(function (idBeneficiario) {
            beneficiario = idBeneficiario.responseJSON;

            $("#modalRegistro").modal("hide");
            bootbox.confirm({
                message: "Usuario ya existente, ¿Desea realizar la agendamiento?",
                buttons: {
                    confirm: {
                        label: 'Si',
                        className: 'btn-success'
                    },
                    cancel: {
                        label: 'No',
                        className: 'btn-danger'
                    }
                },
                callback: function (result) {
                    if (result) {
                        loadView('Agendar Sesión', context + '/consultarAgendaSensibilizacion');
                    }
                }
            });

        });

    }

}