//FUNÇÕES DE ANIMAÇÃO PARA TELA DE clientes



$(document).ready(function(){
 	console.log('entrou no script');
                
        $("table[id$='clientePJdataTable']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true
        
    });
    
    $("table[id$='clientePJdataTableModal']").DataTable({
        paging: true,
        ordering: false,
        scrollX: false,
        scrollY: false,
        responsive: true,
        pageLength: 5,
        bLengthChange: false
        
    });

    $("#clientesPJ").hide();
    $("#novaclienteup").hide();
    //$("#inputClientesPF").hide();
    //$("#inputClientesPJ").hide();

    $("#novaclientedown").click(function(){
    	$('#clientesPJ').slideDown();
    	$("#novaclienteup").show();
    	$("#novaclientedown").hide();

    });

    $("#novaclienteup").click(function(){
    	$('#clientesPJ').slideUp();
    	$("#novaclientedown").show();
    	$("#novaclienteup").hide();
    });

    $("button[id$=clientePJ]").click(function(){
        $("#inputClientesPJ").slideDown();
    });
    
   $(function() {
        $.mask.addPlaceholder("~", "[+-]");
        $("#inputClientPhone").mask("(99) 9999-9999");
    });
});