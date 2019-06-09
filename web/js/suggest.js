/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function createElement(libro){

    var nome = $("<h2>").html(libro.name);

    return $("<div>").attr("class", "autori-div").append(nome);
    
}

function stateSuccess(data){ //Risposta HTTP con positiva
    //Quindi data è la risposta (array di json) che ho costruito nel JSP

    var autoriDiv = $("#nomi");

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
