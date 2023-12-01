// JavaScript Document

function creaTabla(titulo,donde, datos){
    

// Crear <table> y sus dos atributos
	var tabla = document.createElement('table');
	tabla.setAttribute('id', 'otraTabla');
	tabla.setAttribute('border', 1);
	tabla.setAttribute('summary', 'Descripción de la tabla y su contenido');

	// Crear <caption> y añadirlo a la <table>
	var caption = document.createElement('caption');
	var titulo = document.createTextNode("Listado de la provincia: "+titulo);
	caption.appendChild(titulo);
	tabla.appendChild(caption);

	// Crear sección <thead>
	var thead = document.createElement('thead');
	tabla.appendChild(thead);

	// Añadir una fila a la sección <thead>
	thead.insertRow(0);

	var filas=Object.keys(datos);
	var columnas= Object.keys(datos[filas[0]]);

	// Añadir las tres columnas de la fila de <thead>    

	for(col of columnas){
	 var cabecera = document.createElement('th');
	 cabecera.innerHTML = col;
	 thead.rows[0].appendChild(cabecera);   

	}    

    var nifClientes=Object.keys(datos);//LA CATIDAD DE FILAS QUE TENGO
	
	var clavesClientesNif;
	
	for(let i=0;i<nifClientes.length;i++){
		clavesClientesNif=Object.keys(datos[nifClientes]);
		var fila=document.createElement("tr");
		for(let clavePersonaNif in clavesClientesNif){
			var celda=document.createElement("td");
			celda.innerHTML=datos[nifClientes][clavesClientesNif[clavePersonaNif]];
			fila.appendChild(celda);	
		}
		tabla.appendChild(fila);
	}
	
	
	document.body.appendChild(tabla);
    
}
//--------------------------------------------------------
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
		
//------------------------------------------			
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