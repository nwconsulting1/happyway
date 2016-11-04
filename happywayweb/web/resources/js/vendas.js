//FUNÇÕES DE ANIMAÇÃO PARA TELA DE VENDAS



$(document).ready(function(){
 	console.log('entrou no script');
        
    $("table[id$='vendaDataTable']").DataTable({
        paging: true,
        ordering:  false,
        scrollX: false,
        responsive: true
    });
    
    $("table[id$='vendaDataTableHome']").DataTable({
        paging: true,
        ordering:  false,
        scrollX: false,
        pageLength: 5,
        bLengthChange: false
    });

    //$("#vendas").hide();
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