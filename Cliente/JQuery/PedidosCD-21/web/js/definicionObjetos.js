/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var intervalo;
			var paraIntervalo=false;
	
			var xmlDoc;
			var xslDoc;
			
			
			var detallePedido;
			
// 3.- Use de un tipo personalizado..funcion constructora.........
 var Cds ={};
	function cd(titulo,autor,pais,precio){
		this.Titulo = titulo;
		this.Artista=autor;
		this.Pais = pais;
		this.precio=precio;
		this.imprimir=function(){
				return this.Titulo+ "/"+this.Artista;
				}
		
	}
	
	var Clientes ={};
	function cliente(nombre,apellidos,edad,nif){//,pedidos){
		this.nombre = nombre;
		this.apellidos=apellidos;
		this.edad = edad;
		this.nif=nif;
		//this.pedidos=pedidos;
		this.imprimir=function(){
				return this.nombre+ " "+this.apellidos;
				}
		
	}
	 
        Clientes["123456789H"]	=new cliente("Bernardo","López",33,"123456789H");;
	Clientes["3333333H"]	=new cliente("Lola","López",12,"3333333H");
	
	 Cds["0"]= new cd("Empire Burlesque","Columbia","Bob Dylan",10.90);
	 Cds["1"]= new cd("Hide your heart","CBS Records","Bonnie Tyler",9.90);
	 Cds["2"]= new cd("Greatest Hits","RCA","Dolly Parton",8.80);
	
	
	//----Pedidos...................
	//var listaPedidosClientes={};//{nif:pedidos{np:pedido,totalPedidos:0}
	var listaPedidosClientes={ultimoPedido:0, pedidos:{}};
	var detallePedido={};
	
	function pedido (detalle){
		this.detalle=detalle;
		this.fecha  = (new Date).toLocaleDateString();
		};
		
	function lineap(cd,precio,cantidad,color){
		this.cd=cd;
		this.precio=precio;
		this.cantidad=cantidad;
		this.color=color;
	} 
