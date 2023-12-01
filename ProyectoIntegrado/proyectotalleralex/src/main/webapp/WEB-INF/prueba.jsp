<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Tienda</title>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
  	<link rel="stylesheet" href="estilo/estiloTienda.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    <link rel="stylesheet" href="https://fonts.sandbox.google.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    
    <script>
	    $(document).ready(function(){
	    	
	    	
			var objProd = JSON.parse($("#jsonprodCompleto2").val());
	    	
			var prodOrd = ordenar(objProd,'punProd','DESC');
			
			//----Elige opcion para ordenar-----
			$("#popular").click(function(e) {
				 prodOrd = ordenar(objProd,'punProd','DESC');
				 
				 rellenaProductos(prodOrd);
				 
				 $(this).addClass('actOrd');		
				 $("#nuevos").removeClass('actOrd');
				 $("#precio").removeClass('actOrd');
			});	 
			$("#nuevos").click(function() {
				 prodOrd = ordenar(objProd,'fecProd','DESC');
				 
				 rellenaProductos(prodOrd);
				 
				 $(this).addClass('actOrd');		
				 $("#popular").removeClass('actOrd');
				 $("#precio").removeClass('actOrd');
	    	});
			
			$("#precio").click(function() {
				 prodOrd = ordenar(objProd,'precProd','DESC');
				 
				 rellenaProductos(prodOrd);
				 
				 $(this).addClass('actOrd');		
				 $("#nuevos").removeClass('actOrd');
				 $("#popular").removeClass('actOrd');
	    	});
			
			
			//------Para cambiar de categoria------
			$(".btnCate").click(function() {
				
				var miCate = $(this).attr("value");
	    		$("#categoria").val(miCate);
	    		$( "#formCate" ).submit();
	    		
			});
			
			
			if($("#cateSel").val()!=""){
				$('.grupoCate li').removeClass('active');
				$("li[data="+$("#cateSel").val()+"]").addClass('active');
			}else{
				$(".vertodo").addClass('active');
			}
			
			
			$(".vertodo").click(function() {
				$("#cateSel").val("")
	    		$('.grupoCate li').removeClass('active');
	    		$( "#formtodo" ).submit();
			});
			
			
			//----- AL HACER CLICK A UN PRODUCTO------
			$(".prodImg").click(function() {
				$(this.closest("form")).submit();
			});	
			
			$(".nomProd").click(function() {
				$(this.closest("form")).submit();
			});	
			
			$(".linkProd").click(function() {
				$(this.closest("form")).submit();
			});	
			
			
			
			
			
			//Lo pinto
			//rellenaProductos(prodOrd);
			
			
	    	
	    	//----------------MÉTODOS-------------------
	    	
	    	function rellenaProductos(prodOrd){
	    		
	    		$(".prodImg").each(function(i){
		    		$(this).attr("src","img/prod/"+prodOrd[i].imgProd);
		    	});
	    		
	    		$(".nomProd").each(function(i){
		    		$(this).text(prodOrd[i].nomProd);
		    	});
	    		
	    		$(".punProd").each(function(i){
		    		$(this).text(prodOrd[i].punProd);
		    	});
	    		
	    		$(".desProd").each(function(i){
		    		$(this).text(prodOrd[i].desProd);
		    	});
	    		
	    		$(".uniProd").each(function(i){
		    		$(this).text(prodOrd[i].uniProd);
		    	});
	    		
	    		$(".precProd").each(function(i){
		    		$(this).text(prodOrd[i].precProd+"€");
		    	});
	    		
	    		
	    		$(".codProd").each(function(i){
	    			$(this).attr("value",prodOrd[i].codProd);
	    			$(this).val(prodOrd[i].codProd);
		    	});
	    		
	    	}
	    	
	    	
	    	
	    	function ordenar(objeto,atributoOrdenar,tipoOrdenacion){

				var lista = Object.values(objeto)

				if(typeof(lista[0][atributoOrdenar])=="string"){

					switch(tipoOrdenacion){
						case "ASC":
							lista.sort(function(a, b){
									let x = a[atributoOrdenar].toLowerCase();
									let y = b[atributoOrdenar].toLowerCase();
									if (x < y) {return -1;}
									if (x > y) {return 1;}
									return 0;
							});
							break;
						case "DESC":
							lista.sort(function(a, b){
									let x = a[atributoOrdenar].toLowerCase();
									let y = b[atributoOrdenar].toLowerCase();
									if (x > y) {return -1;}
									if (x < y) {return 1;}
									return 0;
							});
							break;
					}

				}else if("number"){
					switch(tipoOrdenacion){
						case "ASC":
								lista.sort((a, b) => {
									return a[atributoOrdenar] - b[atributoOrdenar];
								});
							break;
						case "DESC":
								lista.sort((a, b) => {
								    return b[atributoOrdenar] - a[atributoOrdenar];
								});
							break;
					}
				}else{
					switch(tipoOrdenacion){
						case "ASC":
								lista.sort((a, b) => {
									return new Date(a[atributoOrdenar]) - new Date(b[atributoOrdenar]);
								});
							break;
						case "DESC":
								lista.sort((a, b) => {
									return new Date(b[atributoOrdenar]) - new Date(a[atributoOrdenar]);
								});
							break;
					}
				}

				return Object.assign({}, lista);

			}
	    });
    </script>
    
</head>
<body>

<input id="jsonprodCompleto2" type="hidden" value='${jsonprodCompleto2}'> 
	
	<input id="cateSel" type="hidden" value='${cateSel}'> 
	
	
	
	<div class="container-fluid p-0">

<div class="sticky-top">
       <div class="container-fluid p-0">

        <div class="row barra">
        </div>

        <header class="sticky-top fondoBarra">
          <div class="container-fluid">
            <div class="row">
                <div class="col d-flex justify-content-start align-items-center">
                  <a class="navbar-brand fs-3 m-0" href="irInicio"><img class="img-responsive logo" height="100" src="img/1.png" alt="Logotipo del taller"/></a>
                </div>
                <div class="col-4 d-flex justify-content-around align-items-center">
                  <button class="btn fw-bold letraAma" type="button"><i class="fa-solid fa-location-dot  me-2"></i>UBICACIÓN</button>
                  
                  <c:choose>
                  	<c:when test="${not empty sessionScope.usuario}">
                  		<button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" type="button"><i class="fa-solid fa-user me-2"></i>${usuario.nombreusu}</button>
		                  <ul class="dropdown-menu">
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Estado Cita</button></li>
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Facturas</button></li>
		                    <li><hr class="dropdown-divider"></li>
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><a href="cerrarSesion" class="text-decoration-none sinDeco cerSes">Cerrar Sesión</a></button></li>
		                  </ul>
                  	</c:when>
                  	<c:otherwise>
                  		<button class="btn letraAma fw-bold" type="button"><a href="irLogin" class="text-decoration-none sinDeco"><i class="fa-solid fa-user me-2"></i>MI CUENTA</a></button>
                  	</c:otherwise>
                  </c:choose>
                  
                  <button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-solid fa-cart-shopping me-2"></i>CESTA (0)</button>
                  <ul class="dropdown-menu">
                    <li class="dropdown-item">Productos en total : <span>2</span></li>
                    <li class="dropdown-item">Total: <span>300,00</span>€</li>
                    <li><hr class="dropdown-divider"></li>
                    <li class="px-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Ver Cesta</button></li>
                  </ul>
                </div>
              </div>
              <div class="row">
                <div class="col fondo2">
                  <nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
                    
                      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                      </button>
                      <div class="collapse navbar-collapse justify-content-center id="navbarScroll">
                        
                        <ul class="nav barrita">
                          <li class="nav-item">
                            <a class="nav-link  px-3 py-4" aria-current="page" href="irInicio">INICIO</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link activo px-3 py-4" href="irTienda">TIENDA</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link px-3 py-4" href="#">CITAS</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link px-3 py-4" href="#" >CONTACTO</a>
                          </li>
                        </ul>
                        
                      </div>
                        
                        
                    
                  </nav>

                  
                </div>
              </div>
          </div>
        </header>
       </div>
     </div>
     
    <div class="container mt-3">
      
      <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item text-black"><a href="irInicio" aria-label="Volver a la página principal" class="text-decoration-none"><i class="fa-solid fa-house"></i> Inicio</a></li>
            <li class="breadcrumb-item active " aria-current="page"> Tienda</li>
          </ol>
          
      </nav>
      
    </div>
    <div class="col mb-4">
      <h4 class="text-center">Todos los productos</h4>
      </div>
    <div class="container-fluid d-flex">
      
<aside class="col-2 offset-1">
        <h2>CATEGORÍAS</h2>
        
	        <ul class="list-group list-group-light grupoCate">
	        <form  action="buscar" id="formtodo">
	        	<input name="tipoTodo" type="hidden" value="vertodo">
       			<li class="list-group-item px-3 border-0 btnCate vertodo text-center ">Ver todas</li>
       	 	</form>
	        <form action="buscar" id="formCate">
	        	<input id="categoria" name="cate" type="hidden" value="">
	        	
	        	<li class="list-group-item px-3 border-0 btnCate" value="Baterias" data="Baterias">Baterías</li>
	        	<li class="list-group-item px-3 border-0 btnCate" value="Embragues" data="Embragues">Embragues</li>
        	  	<li class="list-group-item px-3 border-0 btnCate" aria-current="true" value="Escapes" data="Escapes">Escapes</li>
		        <li class="list-group-item px-3 border-0 btnCate" value="Neumaticos" data="Neumaticos">Neumáticos</li>
		        <li class="list-group-item px-3 border-0 btnCate" value="Suspension" data="Suspension">Suspensión</li>
	        </form> 
	        </ul>
	       
      </aside>
      
      <div class="col-8">
        <div class="row">
          <div class="col-7">
            <form  class="d-flex offset-1" action="irTienda">
              <input class="form-control me-2 buscad" name="busca" type="search" placeholder="Buscar..." aria-label="Buscador Principal de artículos" value="${buscado}">
              <button type="submit" class="btn amarillo">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
              </svg>
              </button>  
              
            </form>
          </div>
          <nav class="col offset-1 d-flex align-items-center">
          	<a href="#" class="p-3 ord actOrd" id="popular">Populares</a>
            <a href="#" class="p-3 ord " id="nuevos">Nuevos</a>
            <a href="#" class="p-3 ord " id="precio">Precio</a>
            
            
          </nav>
      </div>

	<c:forEach var="productos" items="${miListaProductos}">
	<form class="formProducto" action="verProducto">
      <div class="row">
        <div class="col-10 offset-1 mt-5 d-flex filita pb-4">
        
        	<input class="codProd" type="hidden" name="codigoProducto" value="${productos.codProd}">
        	
          <div class="col-2">
	          	
           	<img src="img/prod/${productos.imgProd}" class="img-thumbnail prodImg" alt="">
          </div>
	
	          <div class="offset-1 col-6 d-flex flex-column ">
	            <h4 class="nomProd">${productos.nomProd}</h4>
	            <div class="cajaEstrellas">
	              <span class="material-symbols-outlined starAma">star</span>
	              <span class="material-symbols-outlined">star</span>
	              <span class="material-symbols-outlined">star</span>
	              <span class="material-symbols-outlined">star</span>
	              <span class="material-symbols-outlined">star_half</span>
	            </div>
	            <p class="desProd">${productos.descripProd}</p>
	            <a href="#" class="link-primary linkProd">Más Información</a>
	          </div>
	
	          <div class="offset-1 col-2 d-flex flex-column text-center justify-content-center verdesito">
	            <span class="precProd">${productos.precioProd}€  </span>
	            <h1>€</h1>
	            <!--  fmt:formatNumber value="${productos.precioProd}" type="currency" />-->
	            <span class=" mb-4">Disponible</span>
	            <button type="button" class="btn  mb-2 mb-md-0 btn-carro btn-block">Añadir Cesta</button>
	            
	          </div>
          
         
        </div>
      </div>
       </form>
      </c:forEach>
      
      
      </div>
      
      </div>
      <!--  FOOTER DE LA PÁGINA CON EL NEWSLETTER -->
      <div class="">  
        <footer class="bd-footer">
            <section class="subs" id="signup">
                <div class="container px-4 px-md-5">
                    <div class="row gx-4 gx-md-5">
                        <div class="col-md-10 col-md-8 mx-auto text-center">
                            <h2 class="mb-3">¡Suscribete para recibir nuevas noticias!</h2>
                            <i class="far fa-paper-plane fa-2x mb-5 "></i>
                            <h:form styleClass="form-subs">
                                <div class="row input-group-newsletter">
                                    <div class="col-md-9 mb-3 mb-md-0">
                                        <input type="text" class="form-control emailNewletter" /> 
                                    </div>
                                    <div class="col-md-2 btnNews position-relative">
                                        <button class="btn btn-subs" title="Suscribirme">Suscribirme</button>
                                        <span class="ocultar">Botón para suscribirse al periódico y recibir noticias por correo</span>
                                    </div>
                                </div>
                            </h:form>
                        </div>
                    </div>
                </div>
            </section>
            <div class="position-relative w-100 pie">
                <div class="redes position-absolute start-50 translate-middle">
                    <ul>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Twitter"><i class="neg fab fa-brands fa-twitter"></i></a></li>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Instagram"><i class="neg fab fa-instagram"></i></a></li>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Facebook"><i class="neg fab fa-brands fa-facebook-f"></i></a></li>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Youtube"><i class="neg fab fa-brands fa-youtube"></i></a></li>
                        
                    </ul>
                </div>
            </div>
            <div class="contaier-fuild finFoot d-flex justify-content-around py-5">
              <div class="col-2 text-center">
                <h4 class="mb-5 titFoot">CONTACTA CON NOSOTROS</h4>
                <div class="d-flex justify-content-center flex-wrap">
                  <h5 class="pb-2"><i class="fa-solid fa-envelope letraAma "></i> artaller@gmail.com</h5>
                  <h5><i class="fa-solid fa-phone letraAma"></i>+34 654654654</h5>
                </div>
              </div>
              <div class="col-3 text-center">
                <h4 class="mb-5 titFoot">VISITA NUESTRO TALLER</h4>
              </div>
            </div>
        </footer>
      </div> 
    <!--  FIN FOOTER -->

     

	</div>
	  
	  
	  
	  
	  
	  
	  
	  
	  

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
      
      
      
      
      
      
      
      
      
      
      
      

<c:set var="pep" value="12"></c:set>
<h1>${pep}€</h1>
</body>
</html>