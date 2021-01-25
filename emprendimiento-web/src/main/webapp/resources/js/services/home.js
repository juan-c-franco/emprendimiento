/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


function loadView(name, url) {
    $.ajax({
        method: "GET",
        url: url
    }).done(function (data) {
        $("#body_content").html(data);
        $("#idPage").html(name);
        $("#modalLoader").modal("hide");
        myVar = setTimeout(hidenLoader, 500);
    });
}
function hidenLoader() {
    $("#modalLoader").modal("hide");
}
function showLoader() {
    $("#modalLoader").modal({backdrop: 'static', keyboard: false});

}
function buildAlert(target, message, type) {
    var error = "<div class='alert alert-" + type + " alert-dismissible fade show' role='alert'>" + message;
    error += "<button type='button' class='close' data-dismiss='alert' aria-label='Close'>";
    error += "<span aria-hidden='true'>&times;</span></button></div>";
    $("#" + target).html(error);

}