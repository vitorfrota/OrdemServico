/* 
AQUI FICAM AS FUNÇÕES QUE FORMATAM OS CAMPOS DE ACORDO COM CADA UM
EX: CAMPO TELEFONE  0000000000 FORMATA P/ (00)00000-0000
 */

// FUNÇÃO FORMATAÇÃO CAMPO TELEFONE
function fone(){
if (document.frm.txtfone.value.length == 0){
document.frm.txtfone.value = "(" + document.frm.txtfone.value; }
if (document.frm.txtfone.value.length == 3){
document.frm.txtfone.value = document.frm.txtfone.value + ")"; }
if (document.frm.txtfone.value.length == 9){
document.frm.txtfone.value = document.frm.txtfone.value + "-";}
}

// FUNÇÃO FORMATAÇÃO CAMPO CPF
function cpf(){  
if (document.frm.txtcpf.value.length == 3){
document.frm.txtcpf.value = document.frm.txtcpf.value + "."; }
if (document.frm.txtcpf.value.length == 7){
document.frm.txtcpf.value = document.frm.txtcpf.value + "."; }
if (document.frm.txtcpf.value.length == 11){
document.frm.txtcpf.value = document.frm.txtcpf.value + "-"; }
}

// FUNÇÃO FORMATAÇÃO CAMPO DATA
function data(){
if (document.frm.txtdata.value.length == 2){
document.frm.txtdata.value = document.frm.txtdata.value + "/"; }
if (document.frm.txtdata.value.length == 5){
document.frm.txtdata.value = document.frm.txtdata.value + "/"; }
}

// FUNÇÃO FORMATAÇÃO CAMPO CEP
function cep(){
if (document.frm.txtcep.value.length == 5){
document.frm.txtcep.value = document.frm.txtcep.value + "-"; }
}


