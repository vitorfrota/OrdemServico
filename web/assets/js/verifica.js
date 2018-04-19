function confirma(){
    var apagar = confirm('Deseja excluir os dados do sistema?');
     if (apagar){ 
       document.frm.submit(); 
    } else{
        event.preventDefault();
    }
    
    
}

function vcep(valor){
    if(valor.length < 9){
      //  alert("CEP INCORRETO!");
        document.getElementById("txtcep").style.border= " 2px solid #F66464";
    }else{
        document.getElementById("txtcep").style.border= "";
    }  
}
function vcpf(valor){
    if(valor.length < 14){
       // alert("CPF INCORRETO!");
        document.getElementById("txtcpf").style.border= " 2px solid #F66464";
    }else{
        document.getElementById("txtcpf").style.border= "";
    }  
}
function vfone(valor){
    if(valor.length < 14){
       // alert("TELEFONE INCORRETO!");
        document.getElementById("txtfone").style.border= " 2px solid #F66464";
    }else{
        document.getElementById("txtfone").style.border= "";
    }  
}
function vdata(valor){
    if(valor.length < 10){
      //  alert("DATA INCORRETA!");
        document.getElementById("txtdata").style.border= " 2px solid #F66464";
    }else{
        document.getElementById("txtdata").style.border= "";
    }  
}