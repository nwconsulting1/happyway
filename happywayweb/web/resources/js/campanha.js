//FUNÇÕES DE ANIMAÇÃO PARA TELA DE CAMPANHAS 



$(document).ready(function(){
 	console.log('entrou no script');
        
        $("table[id$='campanhaDataTable']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true
        
    });
    
    $("table[id$='campanhaDataTableModal']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true,
        pageLength: 5,
        bLengthChange: false
        
    });

    $("#campanhas").hide();
    $("#campanhaUp").hide();
    //$("#inputClientesPF").hide();
    //$("#inputClientesPJ").hide();

    $("#campanhaDown").click(function(){
    	$('#campanhas').slideDown();
    	$("#campanhaUp").show();
    	$("#campanhaDown").hide();

    });

    $("#campanhaUp").click(function(){
    	$('#campanhas').slideUp();
    	$("#campanhaDown").show();
    	$("#campanhaUp").hide();
    });

    $("button[id$=campanhas]").click(function(){
        $("#inputCampanhas").slideDown();
    });
});