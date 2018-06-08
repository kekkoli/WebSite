/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function createCategory(categoria) {
    if (categoria.type === 'categoria') {
        var cont = $("<li>").html('<a href=notizie.html?category=' + categoria.content + '>' + categoria.content);
        return $(".listaCategorie").append(cont);
    }

}

function createAutore(autore) {
    if (autore.type === 'user') {
        var cont = $("<li>").html('<a href=notizie.html?userId=' + autore.id + '>' + autore.nome + " " + autore.cognome);
        return $(".listaAutori").append(cont);
    }



}



function stateSuccess(data) {

    var newsDiv = $(".listaCategorie");
    $(newsDiv).empty();

    for (var instance in data)
        $(newsDiv).append(createCategory(data[instance]))


    newsDiv = $(".listaAutori");
    $(newsDiv).empty();

    for (instance in data)
        $(newsDiv).append(createAutore(data[instance]))

}

function stateFailure(data, state) {
    console.log(state);
}

$(document).ready(function () {
    $("#search").keyup(function (event) {
            $.ajax({
                url: "filter.json",
                data: {
                    cmd: "search",
                    q: event.target.value
                },
                dataType: 'json',
                success: function (data, state) {
                    stateSuccess(data);
                },
                error: function (data, state) {
                    stateFailure(data, state);
                }
            });
    });

});