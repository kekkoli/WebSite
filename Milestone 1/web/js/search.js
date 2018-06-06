/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



function createElement(elemento) {
    if (elemento.type === 'categoria')
        var cont = $("<li>").html('<a href=notizie.html?category=' + elemento.content + '>' + elemento.content);
    return $(".listaCategorie").append(cont);
    
    if (elemento.type === 'user')
        cont = $("<li>").html('<a href=notizie.html?userId=' + elemento.id + '>' + elemento.nome);
    return $(".listaAutori").append(cont);

}



function stateSuccess(data) {

    var newsDiv = $(".listaCategorie");

    $(newsDiv).empty();
    
    var newsDiv = $(".listaAutori");

    $(newsDiv).empty();

    for (var instance in data)
    {
        $(newsDiv).append(createElement(data[instance]))
    }
}

function stateFailure(data, state) {
    console.log(state);
}

$(document).ready(function () {
    $("#search").keypress(function (event) {
        if (event.which === 13) {
            alert('You pressed enter!');
            $.ajax({
                url: "filter.json",
                data: {
                    cmd: "search",
                    toSearch: event.target.value
                },
                dataType: 'json',
                success: function (data, state) {
                    stateSuccess(data);
                },
                error: function (data, state) {
                    stateFailure(data, state);
                }
            });
        }
    });

});