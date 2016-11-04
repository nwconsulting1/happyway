//FUNÇÕES DE ANIMAÇÃO PARA TELA DE PRODUTOS
$(document).ready(function(){
 	console.log('entrou no script');
        
    $("table[id$='usuariosDataTable']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true
        
    });
    
    var usuario = $("input[id$='usuariosDataTable'").val();
    
    console.log($("input[id$='usuariosDataTable'").val() );
    
    if(usuario != null && usuario != 'undefined' && usuario != 0){
        $("#usuarios").slideDown();
        $("#novousuarioup").show();
        $("#novousuariodown").hide();
    }else {
        $("#usuarios").hide();
        $("#novousuarioup").hide();
        $("#novousuariodown").show();
    }
    
    $("#novousuariodown").click(function(){
    	$('#usuarios').slideDown();
    	$("#novousuarioup").show();
    	$("#novousuariodown").hide();

    });

    $("#novousuarioup").click(function(){
    	$('#usuarios').slideUp();
    	$("#novousuariodown").show();
    	$("#novousuarioup").hide();
    });
    
    
    
    
});