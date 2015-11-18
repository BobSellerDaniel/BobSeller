
/*
 * Funcion para enviar formularios
 * */
function enviarForm(Nombreform,iputName,pagSig){
	document.getElementById("pagAct").value = pagSig;
	document.getElementById(Nombreform).submit();
}
