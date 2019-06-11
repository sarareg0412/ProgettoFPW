/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function createElement(autore){

    var nome = $("<li>").html(autore.nome+", "+autore.cognome+" ("+autore.id+")");
    return $("<a>").attr("class", "div-autori").append(nome);
    
}

function stateSuccess(data){ //Risposta HTTP con positiva
    //Quindi data è la risposta (array di json) che ho costruito nel JSP

    var autoriDiv = $("#div-autori");

    $(autoriDiv).empty();

    for(var instance in data){
        $(autoriDiv).append(createElement(data[instance]));
    }
    
}

function stateFailure(data, state){
    console.log(state);
}

$(document).ready(function() { //Quando è pronto il DOM
    
    $("#author").keyup(function(event){ //Viene scritto qualcosa nella textarea "author"
      
       $.ajax({
          url: "suggest.json", 
          data: {cmd: "search",
                 toSearch: event.target.value
          },
          dataType: 'json',
          success: function(data, state){stateSuccess(data);},
          error: function(data, state){stateFailure(data, state);}
       });
        
    });
    
});
