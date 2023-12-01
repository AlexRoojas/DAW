// JavaScript Document
//-----------------------------------
	function cargaFichero2(input,provincias) {
		
		var files = input.files;
	  if (files) {
				
		//añadir a la galeria	
		//for(i=0; i< files.length;i++){
			
			var file=files[0];
			var reader = new FileReader();
			reader.onload = function (e) {
			
			// cargar el select de los Cd's......	
				parser = new DOMParser();
				xmlDoc = parser.parseFromString(e.target.result,"text/xml");
				//CargaProvincias("cd", xmlDoc);
				CargaXML_Objeto_Lista(xmlDoc,"listaProvincias");//, provincias);
				//return xmlDoc;
				//return provincias;
			  
							
			}
			//reader.readAsDataURL(file);
			reader.readAsText(file);
		//};//for
		
  		}//if	
	}
		
//----------------------------------------------------------------------------------------
function loadDoc(url, cFunction,id) {
  var xhttp;
  xhttp = new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      cFunction(this.responseXML,id);
    }
  };
  xhttp.open("GET", url, true);
  xhttp.send();
}
//----------------------------------------------------------------------------------------
function CargalistaCds(lista, cds){
	var lista=document.getElementById(lista);
				
				tit=cds.getElementsByTagName("title");
				aut=cds.getElementsByTagName("artist");
				cou=cds.getElementsByTagName("country");
				pre=cds.getElementsByTagName("price");
				alert("tit.length = " + tit.length);
				
				for (i=0;i<tit.length;i++)
				  {
				  lista.options.add(new Option( tit[i].childNodes[0].nodeValue +" / "+
				  								aut[i].childNodes[0].nodeValue,
												pre[i].childNodes[0].nodeValue ) );
				
				   linea = new lineacd(tit[i].childNodes[0].nodeValue,
									aut[i].childNodes[0].nodeValue,
									cou[i].childNodes[0].nodeValue,
									pre[i].childNodes[0].nodeValue,
									colorAleatorio());
									
				 	listaCds[Object.keys(listaCds).length]=linea;							
											
				  }
		}
//----------------------------------------------------------------------------------------
			
		// function Cargar(id){
		function  CargaXML_Objeto_Lista(xmlDoc,id){
			
			    //var provincias={};
	            var pueblos=[];	var nombre="";
			 	var lista=document.getElementById(id);
				
				prov=xmlDoc.getElementsByTagName("provincia");
				
				alert("nº de provincias -> " + prov.length);
				
				for (let i=0; i<prov.length;i++){
					provincia=prov[i].firstElementChild.textContent;
					
				  lista.options.add(new Option(provincia.substring(0, provincia.length-1), 
				 // prov[i].childNodes[1].textContent,
												prov[i].id) );
												
				  //provincia[prov[i].firstElementChild.textContent]=[];
				  	
				  loc=prov[i].getElementsByTagName("localidad");
				  
				  pueblos=[];
				  
				  for (let j=0;j<loc.length;j++){	// array con el nombre de las loc...					
				   nombre=loc[j].textContent;
				   pueblos[j] = nombre.substring(0, nombre.length-1);
				 }
				 objetoProvincias[provincia.substring(0, provincia.length-1)]=pueblos;
				 
				}
				//return provincias;	
			}
		//-------------------------------------------------------------------------	
		function aleatorio(inferior,superior){
			numPosibilidades = superior - inferior
			aleat = Math.random() * numPosibilidades
			aleat = Math.floor(aleat)
			return parseInt(inferior) + aleat
		} 

		function colorAleatorio(){
			hexadecimal = new Array("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F")
			color_aleatorio = "#";
			var i=0;
			for (i=0;i<6;i++){
				pos =  Math.ceil(Math.round(Math.random()*15));
				//pos = aleatorio(0,hexadecimal.length)
				color_aleatorio += hexadecimal[pos]
			}
			return color_aleatorio
		}
	//------------------------------------------------------------------------
	//------------- Tabla 2 ----------------------------------------------------------
function tabla2(titulo,id,donde,datos,estilo,remplazar){ 
	//{borrar:true, Subtotal:{c1:,c2}}
// Crear <table> y sus dos atributos
	var tabla = document.createElement('table');
	tabla.setAttribute('id', id);
	tabla.setAttribute('border', 1);
	tabla.setAttribute('summary', 'Descripción de la tabla y su contenido');
	// Crear <caption> y añadirlo a la <table>
	var caption = document.createElement('caption');
	var titulo = document.createTextNode(titulo);
	caption.appendChild(titulo);
	tabla.appendChild(caption);
	
	
	// Crear sección <thead>
	var thead = document.createElement('thead');
	tabla.appendChild(thead);
	// Añadir una fila a la sección <thead>
	thead.insertRow(0);
	// Añadir las tres columnas de la fila de <thead>
	var cabecera;
	
	try{
	calvesFilas = Object.keys(datos)	
	nfilas	 	= calvesFilas.length;
	
	clavesLinea = Object.keys(datos[calvesFilas["0"]]);// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	//clavesLinea = Object.keys(datos["1"]);
	
	ncolumnas	= clavesLinea.length;	
	// cabecera oculta
	//var i =0;	
	//	cabecera = document.createElement('th');
		//cabecera.style.visibility="hidden";
		//cabecera.style.display="none";  Oculto
	//	thead.rows[0].appendChild(cabecera);
		
	for (i=0; i<ncolumnas ; i++)
	{
		cabecera = document.createElement('th');
		cabecera.innerHTML = clavesLinea[i];
		thead.rows[0].appendChild(cabecera);
	}
	// Insertamos la columna Subtotal...............
	//if(estilo.subtotal){
            if(estilo.subtotal!==undefined){
		cabecera = document.createElement('th');
		cabecera.innerHTML = "Subtotal";
		thead.rows[0].appendChild(cabecera);
	}
	
	// Crear sección <tbody>
	var tbody = document.createElement('tbody');
	tabla.appendChild(tbody);
		
	var suma=0;
//	for (i=0; i<calvesFilas.length ; i++)//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    var i =0;
	//for(clave in datos)
	for (i=0; i<nfilas ; i++)
	{
		// columnna oculta con el numero de fila
		//var j=0;
		//tbody.insertRow(clave); 
                tbody.insertRow(i); 
		//tbody.rows[clave].insertCell(j).innerHTML =clave;// reeemplazar i por clave->rowIndex
                //tbody.rows[clave].ondragstart=drag;////////////
		//tbody.rows[i].cells[j].width=0;
		//tbody.rows[i].cells[j].style.visibility="hidden";
		//tbody.rows[i].cells[j].style.display="none";Oculto
		
		for (j=0; j<ncolumnas ; j++)
			{
				tbody.rows[i].insertCell(j);
				//tbody.rows[i].cells[j].ondragstart=arrastra;
												//datos[i+1][clavesLinea[j]];	
				tbody.rows[i].cells[j].innerHTML = datos[calvesFilas[i]][clavesLinea[j]];
				//tbody.rows[clave].cells[j].innerHTML = datos[clave][clavesLinea[j]];
				
			}
			//coloreamos la fila;
			/*console.log(datos[clave][clavesLinea[ncolumnas-1]]);
			tbody.rows[clave].setAttribute("style","color:"+datos[clave][clavesLinea[ncolumnas-1]]);*/
			
			// Insertamos la columna Subtotal...............
			//if(estilo.subtotal){
                        if(estilo.subtotal!==undefined){
			console.log("ncolumnas:"+ncolumnas);
			tbody.rows[i].insertCell(ncolumnas);
						
			tbody.rows[i].cells[ncolumnas].innerHTML =
                                                    parseFloat(tbody.rows[i].cells[estilo.subtotal.c1].innerHTML)
						    *parseInt(tbody.rows[i].cells[estilo.subtotal.c2].innerHTML);
							/*	    parseFloat(tbody.rows[i].cells[3].innerHTML)
								   *parseInt(tbody.rows[i].cells[4].innerHTML);*/
								   
		 	suma+=parseFloat(tbody.rows[i].cells[ncolumnas].textContent);
			}
			// Insertamos la columna borrar...............
			if(estilo.borrar){
				tbody.rows[i].insertCell(ncolumnas+1);
				tbody.rows[i].cells[ncolumnas+1].appendChild(creaBoton());
			}
		//i++;	
	}
	}catch(err)
	  {
	  txt="There was an error on this page.\n\n";
	  txt+="Error description: " + err.message + "\n\n";
	  txt+="Click OK to continue.\n\n";
	  alert(txt);
	  }
	 
	 // tfoot.........................
	 // Crear sección <tfoot>
	 if(estilo.subtotal){
		var tfoot = document.createElement('tfoot');
		tabla.appendChild(tfoot);
		// Añadir una fila a la sección <thead>
		tfoot.insertRow(0);
		// Añadir las dos columnas de la fila de <thead>
		var cabecera = document.createElement('th');
		cabecera.setAttribute('colspan', thead.rows[0].cells.length-1);
		cabecera.innerHTML = 'Total:...';
		tfoot.rows[0].appendChild(cabecera);
		
		cabecera = document.createElement('td');
		cabecera.innerHTML =Math.round(suma)+ ' €';
		tfoot.rows[0].appendChild(cabecera);
	 }
	 
//  var donde= document.getElementById(arguments[arguments.length-1]);
  var donde= document.getElementById(donde);
  
   if (donde.childNodes.length>0 && remplazar)
	  	donde.replaceChild(tabla,donde.childNodes[0]);
	else		
		donde.appendChild(tabla);
	//document.body.appendChild(tabla);
}
//-------------------------------------------------------------------
function enviarPeticion(metodo,url,asincrono,datos,funcionManejadora)
{
	var xhttp;
	xhttp = new XMLHttpRequest();
	
	xhttp.onreadystatechange = function() 
	{
		if (this.readyState == 4 && this.status == 200) 
		{
			funcionManejadora(this);
		}
	};
	
	 if (metodo.toUpperCase()=="GET"){
		 
        xhttp.open(metodo,url+"?"+datos,asincrono); 
        
        xhttp.send();
    }
    else{
       xhttp.open(metodo,url,asincrono); 
       xhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
       xhttp.send(datos);  
    }
	
}
	