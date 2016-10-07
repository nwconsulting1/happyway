//FUNÇÕES DE ANIMAÇÃO PARA TELA DE VENDAS



$(document).ready(function(){
 	console.log('entrou no script');

    $("#vendas").hide();
    $("#novavendaup").hide();

    $("#novavendadown").click(function(){
    	$('#vendas').slideDown();
    	$("#novavendaup").show();
    	$("#novavendadown").hide();

    });

    $("#novavendaup").click(function(){
    	$('#vendas').slideUp();
    	$("#novavendadown").show();
    	$("#novavendaup").hide();
    });
});