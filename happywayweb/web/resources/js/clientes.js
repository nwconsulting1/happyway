//FUNÇÕES DE ANIMAÇÃO PARA TELA DE clientes



$(document).ready(function(){
 	console.log('entrou no script');
        
        $("table[id$='clientePFdataTable']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true
        
    });

    $("#clientes").hide();
    $("#novaclienteup").hide();
    //$("#inputClientesPF").hide();
    //$("#inputClientesPJ").hide();

    $("#novaclientedown").click(function(){
    	$('#clientes').slideDown();
    	$("#novaclienteup").show();
    	$("#novaclientedown").hide();

    });

    $("#novaclienteup").click(function(){
    	$('#clientes').slideUp();
    	$("#novaclientedown").show();
    	$("#novaclienteup").hide();
    });

    $("button[id$=clientePF]").click(function(){
        $("#inputClientesPF").slideDown();
    });
});