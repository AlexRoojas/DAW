// JavaScript Document
//-----------------------------------
	function cargaFichero(input,provincias) {
		
		var files = input.files;
	  if (files) {
		
			var file=files[0];
			var reader = new FileReader();
			reader.onload = function (e) {
		
			parser = new DOMParser();
			xmlDoc = parser.parseFromString(e.target.result,"text/xml");
				
			metodoCargaXml(xmlDoc);
						
			}
			//reader.readAsDataURL(file);
			reader.readAsText(file);
		
  		}//if	
	}
		

//----------------------------------------------------------------------------------------
//-----------------------------------------
function descargaArchivo() {
// Obtener la instancia del objeto XMLHttpRequest
	if(window.XMLHttpRequest) {
		peticion_http = new XMLHttpRequest();
	}
		else if(window.ActiveXObject) {
		peticion_http = new ActiveXObject("Microsoft.XMLHTTP");
	}
	// Preparar la funcion de respuesta
		peticion_http.onreadystatechange = muestraContenido;
	// Realizar peticion HTTP
		peticion_http.open('GET', 'http://localhost/provinciasypoblaciones.xml', true);
		peticion_http.send(null);
	
		function muestraContenido() {
			if(peticion_http.readyState == 4) {
				if(peticion_http.status == 200) {
					alert(peticion_http.responseXML);
			}
		}
	}
}
//--------------------CREA TABLA----------------------------
function creaTabla(titulo,donde){
	// Crear <table> y sus dos atributos
var tabla = document.createElement('table');
tabla.setAttribute('id', 'otraTabla');
tabla.setAttribute('summary', 'Descripción de la tabla y su contenido');

// Crear <caption> y añadirlo a la <table>
var caption = document.createElement('caption');
var titulo = document.createTextNode('Título de la tabla');
caption.appendChild(titulo);
tabla.appendChild(caption);

// Crear sección <thead>
var thead = document.createElement('thead');
tabla.appendChild(thead);

// Añadir una fila a la sección <thead>
thead.insertRow(0);

// Añadir las tres columnas de la fila de <thead>
var cabecera = document.createElement('th');
cabecera.innerHTML = '';
thead.rows[0].appendChild(cabecera);

cabecera = document.createElement('th');
cabecera.setAttribute('scope', 'col');
cabecera.innerHTML = 'Cabecera columna 1';
tabla.rows[0].appendChild(cabecera);

cabecera = document.createElement('th');
cabecera.setAttribute('scope', 'col');
cabecera.innerHTML = 'Cabecera columna 2';
tabla.rows[0].appendChild(cabecera);

// La sección <tfoot> se crearía de forma similar a <thead>

// Crear sección <tbody>
var tbody = document.createElement('tbody');
tabla.appendChild(tbody);

// Añadir una fila a la sección <tbody>
tbody.insertRow(0);

cabecera = document.createElement("th");
cabecera.setAttribute('scope', 'row');
cabecera.innerHTML = 'Cabecera fila 1'
tabla.tBodies[0].rows[0].appendChild(cabecera);

tbody.rows[0].insertCell(1);
tbody.rows[0].cells[1].innerHTML = 'Celda 1 - 1';
// También se podría hacer:
// tbody.rows[0].cells[0].appendChild(document.createTextNode('Celda 1 - 1'));

tbody.rows[0].insertCell(2);
tbody.rows[0].cells[2].innerHTML = 'Celda 1 - 2';

// El resto de filas del <tbody> se crearía de la misma forma

// Añadir la tabla creada al final de la página
document.body.appendChild(tabla);
}