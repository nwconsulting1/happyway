//FUNÇÕES DE ANIMAÇÃO PARA TELA DE PRODUTOS



$(document).ready(function(){
 	console.log('entrou no script');
        
    var produto = $("input[id$='inputProductCode'").val();
    
    console.log($("input[id$='inputProductCode'").val() );
    
    if(produto != null && produto != 'undefined' && produto != 0){
        $("#produtos").slideDown();
        $("#novoprodutoup").show();
        $("#novoprodutodown").hide();
    }else {
        $("#produtos").hide();
        $("#novoprodutoup").hide();
        $("#novoprodutodown").show();
    }
    
    $("#novoprodutodown").click(function(){
    	$('#produtos').slideDown();
    	$("#novoprodutoup").show();
    	$("#novoprodutodown").hide();

    });

    $("#novoprodutoup").click(function(){
    	$('#produtos').slideUp();
    	$("#novoprodutodown").show();
    	$("#novoprodutoup").hide();
    });
    
    
});