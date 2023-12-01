/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*---------------------------------
function oferta(){
	var oferta=document.getElementById("ofrta");
	//if(intervalo === undefined){
		if(!paraIntervalo){
			document.getElementById("aviso").textContent="Parar Ofertas...";
			intervalo=setInterval('lanzaOferta()',
					document.getElementById('tiempo').value*1000);
					
			paraIntervalo=true;		
			
	}
		
	else{	
		document.getElementById("aviso").textContent="Ver Ofertas cada:";
		clearInterval(intervalo);
		
			oferta.style.display="none";
			paraIntervalo=false;
		
	}
}
//--------------------------*/
function lanzaOferta(){ // Sin Worker....................
	var num=aleatorio(0,Object.keys(listaCds).length);
	var por=aleatorio(5,15);
	var oferta=document.getElementById("ofrta");
	//crear la oferta
	//alert( "Oferta en-> "+ listaCds[num].Titulo);
	var rebaja=document.createTextNode(listaCds[num].Titulo+":"+por+"%");
	//oferta.appendChild(rebaja);
	oferta.replaceChild(rebaja,oferta.firstChild);
	
	oferta.style.display="block";
	//setTimeout(ocultaOferta(), (document.getElementById('tiempo').value*1000)-3000 );
	
}
//------------------------------ con Web Workres----------------
function oferta(){
	var oferta=document.getElementById("ofrta");
	
	estadoOfertas =document.getElementById("aviso");
	if(estadoOfertas.textContent =="Ver Ofertas cada:"){
		estadoOfertas.textContent="Parar Ofertas...";
		startWorker();
		 oferta.style.display="block";
	}
	else{
		estadoOfertas.textContent="Ver Ofertas cada:";
		
		stopWorker();
		oferta.style.display="none";
	}
}
//--------------------------------
function ocultaOferta(){
	var oferta=document.getElementById("ofrta");
	//oferta.removeChild(oferta.firstChild);
	oferta.style.display="none";
}
//------------------------------ Web Workers----------------------------
var wwOfertas;
//var oferta=document.getElementById("ofrta");

function startWorker() {
    if(typeof(Worker) !== "undefined") {
        if(typeof(wwOfertas) === "undefined") {
            wwOfertas = new Worker("js/ofertas.js");
			
			seg=document.getElementById('tiempo').value*1000;		
			des={min:5,max:15};
			datos = JSON.stringify({lcd:listaCds,segundos:seg,descuento:des});
			
			var oferta=document.getElementById("ofrta");
			
			 wwOfertas.onmessage = function(event) {
          	  document.getElementById("ofrta").replaceChild( document.createTextNode(event.data),oferta.firstChild); 
			 
			        };
						
			wwOfertas.postMessage(datos);
			
        }
       
    } else {
        document.getElementById("ofrta").innerHTML = "Sorry! No Web Worker support.";
    }
}

function stopWorker() {
    wwOfertas.terminate();
    wwOfertas = undefined;
}

