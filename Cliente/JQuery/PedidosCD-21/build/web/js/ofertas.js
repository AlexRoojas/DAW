// JavaScript Document
// datos={listaCds:{}, segundos:5, descuento:{max:15, min:5}}
var intervalo;

self.addEventListener('message', oferta, false);

function oferta(e){
			//alert(e.data);
			if(e)
                            datos= JSON.parse(e.data);	
                        
			postMessage(generaOferta(datos));	
			setTimeout(oferta,datos.segundos);	
			//alert("hola");
	
}
//oferta(datos);
//--------------------------
function generaOferta(datos){
	
	var num=aleatorio(0,Object.keys(datos.lcd).length);
	var por=aleatorio(datos.descuento.min,datos.descuento.max);
		
	//var rebaja=document.createTextNode(datos.listaCds[num].Titulo+":"+por+"%");
	var rebaja=datos.lcd[num].Titulo+":"+por+"%";
	console.log(rebaja);
	
	return rebaja;
}
//------------------------------
function ocultaOferta(){
	var oferta=document.getElementById("ofrta");
	//oferta.removeChild(oferta.firstChild);
	oferta.style.display="none";
}
//-------------------------------
function aleatorio(inferior,superior){
			numPosibilidades = superior - inferior;
			aleat = Math.random() * numPosibilidades;
			aleat = Math.floor(aleat);
			return parseInt(inferior) + aleat;
		} 