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
    
    $("table[id$='clientePFdataTableModal']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true,
        pageLength: 5,
        bLengthChange: false
        
    });

    $("#clientesPF").hide();
    $("#novaclienteup").hide();
    //$("#inputClientesPF").hide();
    //$("#inputClientesPJ").hide();

    $("#novaclientedown").click(function(){
    	$('#clientesPF').slideDown();
    	$("#novaclienteup").show();
    	$("#novaclientedown").hide();

    });

    $("#novaclienteup").click(function(){
    	$('#clientesPF').slideUp();
    	$("#novaclientedown").show();
    	$("#novaclienteup").hide();
    });

    $("button[id$=clientePF]").click(function(){
        $("#inputClientesPF").slideDown();
    });
});