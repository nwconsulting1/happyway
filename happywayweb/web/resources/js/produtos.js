//FUNÇÕES DE ANIMAÇÃO PARA TELA DE PRODUTOS



$(document).ready(function(){
 	console.log('entrou no script');

    $("#produtos").hide();
    $("#novoprodutoup").hide();

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