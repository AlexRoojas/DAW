<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv='Content-Type' content='text/html; charset=utf-8'>
<meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Tienda</title>

	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
  	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
  	<link rel="stylesheet" href="estilo/estiloTienda.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    
    
    <script>
	    $(document).ready(function(){
	    	
	    	
	    	
	    	
			var objProd = JSON.parse($("#jsonprodCompleto2").val());
	    	
			var prodOrd = ordenar(objProd,'punProd','DESC');
			
			//----Elige opcion para ordenar-----
			$("#popular").click(function() {
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
			
			
			//------ AÑADIR CESTA-------
			
			$(".btn-carro").click(function() {
				$(this.closest("form")).submit();
			});
			
			
			//Lo pinto
			//rellenaProductos(prodOrd);
			
			function initMap() {
		  		  // The location of Uluru
		  		  const uluru = { lat: 36.7515224, lng: -5.1631092 };
		  		  // The map, centered at Uluru
		  		  const map = new google.maps.Map(document.getElementById("map"), {
		  		    zoom: 15,
		  		    center: uluru,
		  		  });
		  		  // The marker, positioned at Uluru
		  		  const marker = new google.maps.Marker({
		  		    position: uluru,
		  		    map: map,
		  		  });
		  		}
		
		
				initMap();
	    	
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
		    		$(this).text(prodOrd[i].precProd+"$");
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
  	<fmt:setBundle basename="mensajes.texto"/>
  
  	
  
	<input id="jsonprodCompleto2" type="hidden" value='${jsonprodCompleto2}'> 
	
	<input id="cateSel" type="hidden" value='${cateSel}'> 
	
	
	
	<div class="container-fluid p-0">
		  
		 <!-- HEADER--> 
     <div class="sticky-top">
       <div class="container-fluid p-0">

        <div class="row barra">
        </div>

        <header class="sticky-top fondoBarra">
          <div class="container-fluid">
            <div class="row">
                <div class="col d-flex flex-column flex-md-row justify-content-start align-items-center">
                  <a class="navbar-brand fs-3 m-0" href="irInicio"><img class="img-responsive logo" height="100" src="img/1.png" alt="Logotipo del taller"/></a>
                  <form class="d-flex ms-md-5 formxd" action="irTienda">
                    <input class="form-control me-2" type="search" name="busca" placeholder='<fmt:message key="buscar"/>' aria-label="Buscador Principal de artículos">
                    <button type="submit" class="btn amarillo">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                      <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg>
                    </button>  
                  </form>
                </div>
                <div class="col-12 col-md-4 d-flex justify-content-around align-items-center">
                  <button class="btn fw-bold letraAma" type="button"><a href="irMapa" class="text-decoration-none sinDeco d-block encesta"><i class="fa-solid fa-location-dot  me-2"></i><fmt:message key="ubi"/></a></button>
                  <c:choose>
                  	<c:when test="${not empty sessionScope.usuario}">
                  		<button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" type="button"><i class="fa-solid fa-user me-2"></i>${usuario.nombreusu}</button>
		                  <ul class="dropdown-menu">
		                    
		                    <c:choose>
		                    	<c:when test="${sessionScope.usuario.tipousu == 'M'}">
		                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="verCitasMec" class="text-decoration-none sinDeco d-block encesta"><fmt:message key="cita"/></a></button></li>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<c:choose>
				                    	<c:when test="${not empty sessionScope.codigoFact}">
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><fmt:message key="estCita"/></button></li>
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta"><fmt:message key="ultfact"/></a></button></li>
				                    	</c:when>
				                    	<c:otherwise>
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><fmt:message key="estCita"/></button></li>
					                  		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block disabled"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta"><fmt:message key="ultfact"/></a></button></li>
					                  	</c:otherwise>
				                    	
				                    </c:choose>
		                    	</c:otherwise>
		                    </c:choose>
		                    
		                    
		                    
		                    
		                    <li><hr class="dropdown-divider"></li>
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><a href="cerrarSesion" class="text-decoration-none sinDeco cerSes"><fmt:message key="cerrSes"/></a></button></li>
		                  </ul>
		                  
		                  <button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-solid fa-cart-shopping me-2"></i><fmt:message key="cestat"/> ${prodTotal}</button>
		                  <ul class="dropdown-menu">
		                    <li class="dropdown-item"><fmt:message key="prodtota"/> : <span>${prodTotal}</span></li>
		                    <li class="dropdown-item">Total: <span>${precioTotal}</span>$</li>
		                    <li><hr class="dropdown-divider"></li>
		                    <li class="px-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block btnVerCesta"><a href="irCesta" class="text-decoration-none sinDeco d-block encesta"><fmt:message key="verCest"/></a></button></li>
		                  </ul>
                  	</c:when>
                  	<c:otherwise>
                  		<button class="btn letraAma fw-bold" type="button"><a href="irLogin" class="text-decoration-none sinDeco"><i class="fa-solid fa-user me-2"></i><fmt:message key="cuenta"/></a></button>
                  	</c:otherwise>
                  </c:choose>
                  
                  
                </div>
              </div>
              <div class="row">
                <div class="col fondo2">

                  <nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
                    
                    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                      <span class="navbar-toggler-icon"></span>
                    </button>
                    <div class="collapse navbar-collapse justify-content-center " id="navbarScroll">
                      
                      <ul class="nav barrita">
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4 " aria-current="page" href="irInicio"><fmt:message key="inicio"/></a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4 activo" href="irTienda"><fmt:message key="tienda"/></a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4" href="cargaCita"><fmt:message key="citas"/></a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4" href="#" ><fmt:message key="contacto"/></a>
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
     <!--FIN HEADER--> 
	 <div class="container mt-3">
      
		<nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
			<ol class="breadcrumb">
			  <li class="breadcrumb-item text-black"><a href="irInicio" aria-label="Volver a la página principal" class="text-decoration-none"><i class="fa-solid fa-house"></i> <fmt:message key="inicio2"/></a></li>
			  <li class="breadcrumb-item active " aria-current="page"> <fmt:message key="tienda2"/></li>
			</ol>
			
		</nav>
		
	  </div>
	  <div class="col mb-4">
		<h4 class="text-center"><fmt:message key="todosprod"/></h4>
		</div>
  
	  <div class="container-fluid d-flex flex-column flex-md-row">
		
	  <!-- ASIDE -->
	   <aside class="col-12 col-md-2 offset-lg-1 my-5 my-md-0">
		  <h2><fmt:message key="categorias"/></h2>
		  
			  <ul class="list-group list-group-light grupoCate">
			  <form  action="buscar" id="formtodo">
				  <input name="tipoTodo" type="hidden" value="vertodo">
					 <li class="list-group-item px-3 border-0 btnCate vertodo text-center "><fmt:message key="vertodas"/></li>
				  </form>
			  <form action="buscar" id="formCate">
				  <input id="categoria" name="cate" type="hidden" value="">
				  
				  <li class="list-group-item px-3 border-0 btnCate" value="Baterias" data="Baterias" aria-label="Mostrar solo productos de tipo baterias"><fmt:message key="bat"/></li>
				  <li class="list-group-item px-3 border-0 btnCate" value="Embragues" data="Embragues" aria-label="Mostrar solo productos de tipo Embragues"><fmt:message key="emb"/></li>
					<li class="list-group-item px-3 border-0 btnCate" aria-current="true" value="Escapes" data="Escapes" aria-label="Mostrar solo productos de tipo Escapes"><fmt:message key="escp"/></li>
				  <li class="list-group-item px-3 border-0 btnCate" value="Neumaticos" data="Neumaticos" aria-label="Mostrar solo productos de tipo Neumaticos"><fmt:message key="neum"/></li>
				  <li class="list-group-item px-3 border-0 btnCate" value="Suspension" data="Suspension" aria-label="Mostrar solo productos de tipo Suspension"><fmt:message key="susp"/></li>
			  </form> 
			  </ul>
			 
		</aside>
	  <!--FIN ASIDE -->
	  <!-- CAJA PRINCIPAL -->
		<div class="col-12 col-lg-8">
		  <div class="row">
			<div class="col-12 col-md-7">
			  <form  class="d-flex offset-1" action="irTienda">
				<input class="form-control me-2 buscad" name="busca" type="search" placeholder='<fmt:message key="buscar"/>' aria-label="Buscador Principal de artículos" value="${buscado}">
				<button type="submit" class="btn amarillo" aria-label="Buscar producto">
				<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16" aria-label="Botón para buscar">
				  <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
				</svg>
				</button>  
				
			  </form>
			</div>
			<nav class="col offset-1 d-flex align-items-center">
				<a href="#" class="p-3 ord actOrd" id="popular" title="Ordenar por Popularidad"><fmt:message key="popu"/></a>
			  <a href="#" class="p-3 ord " id="nuevos" title="Ordenar por Nuevos"><fmt:message key="nuev"/></a>
			  <a href="#" class="p-3 ord " id="precio" title="Ordenar por Precio"><fmt:message key="prec"/></a>
			  
			  
			</nav>
		</div>
  
	  <c:forEach var="productos" items="${miListaProductos}">
	  <form class="formProducto" action="verProducto">
		<div class="row">
		  <div class="col-10 col-md-10 offset-1 mt-5 d-flex flex-column flex-lg-row filita p-0 pb-md-4">
		  
			  <input class="codProd" type="hidden" name="codigoProducto" value="${productos.codProd}">
			  
			<div class="col-10 offset-1 col-lg-2">
					
				 <img src="img/prod/${productos.imgProd}" class="img-thumbnail prodImg" alt="${productos.nomProd}">
			</div>
	  
				<div class="offset-1 col-10 col-lg-6 d-flex flex-column ">
				  <h4 class="nomProd">${productos.nomProd}</h4>
				  <input class="puntuacion" type="hidden"  value="${productos.puntuacionProd}">
				  
				  <div class="cajaEstrellas">
				  
				  <c:forEach var="i" begin="1" end="${productos.puntuacionProd}">
					  <span class="material-symbols-outlined starAma">star</span>
				  </c:forEach>
				  
				  </div>
				  
				  <p class="desProd">${productos.descripProd}</p>
				  <a href="#" class="link-primary linkProd" title="Ver Producto"><fmt:message key="masinfo"/></a>
				</div>
	  
				<div class="offset-1 col-10 col-lg-2 d-flex flex-column text-center justify-content-center verdesito">
				  <span class="precProd" >${productos.precioProd} $  </span>
				  <!--  fmt:formatNumber value="${productos.precioProd}" type="currency" />-->
				  <span class=" mb-4"><fmt:message key="dispo"/></span>
		</form>
				  
				  <form class="formCesta" action="anadirCesta">
					  <input name="codigoProd" type="hidden" value="${productos.codProd}">
					  <input name="sitio" type="hidden" value="tienda">
					  <c:choose>
							<c:when test="${not empty sessionScope.usuario}">
								<button type="button" class="btn  mb-2 mb-md-0 btn-carro btn-block" aria-label="Añadir al carrito"><fmt:message key="addcest"/></button>
							</c:when>
							<c:otherwise>
							<div data-bs-toggle="tooltip" data-bs-placement="bottom" title="Inicia sesión para comprar">
								<button type="button" class="btn  mb-2 mb-md-0 btn-carro btn-block disabled" data-bs-toggle="tooltip" data-bs-placement="top" title="Inicia sesión para comprar"><fmt:message key="addcest"/></button>
							</div>
							</c:otherwise>
						</c:choose>
						
					  
				  </form>
				</div>
			
		   
		  </div>
		</div>
		 
		</c:forEach>
		
		
		</div>
	  <!-- FIN CAJA PRINCIPAL-->
	  
	   
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
							  <form action="enviaemail" class="form-subs">
								  <div class="row input-group-newsletter">
									  <div class="col-md-9 mb-3 mb-md-0">
										  <input name="email" type="text" class="form-control emailNewletter" aria-label="Introducir tu correo" placeholder="Introduce tu correo"/> 
										  <input type="hidden" name="origen" value="irInicio">
									  </div>
									  <div class="col-md-2 btnNews position-relative">
										  <button type="submit" class="btn btn-subs" title="Boton para generar un correo electronico">Suscribirme</button>
										  <span class="ocultar">Botón para suscribirse al periódico y recibir ofertas por correo</span>
									  </div>
								  </div>
							  </form>
						  </div>
					  </div>
				  </div>
			  </section>
			  <div class="position-relative w-100 pie">
				  <div class="redes position-absolute start-50 translate-middle">
					  <ul>
						  <li><a href="#" target="blank" title="Enlace para ir a la cuenta de Twitter"><i class="neg fab fa-brands fa-twitter"></i></a></li>
						  <li><a href="#" target="blank" title="Enlace para ir a la cuenta de Instagram"><i class="neg fab fa-instagram"></i></a></li>
						  <li><a href="#" target="blank" title="Enlace para ir a la cuenta de Facebook"><i class="neg fab fa-brands fa-facebook-f"></i></a></li>
						  <li><a href="#" target="blank" title="Enlace para ir a la cuenta de Youtube"><i class="neg fab fa-brands fa-youtube"></i></a></li>
						  
					  </ul>
				  </div>
			  </div>
			  <div class="contaier-fuild finFoot d-flex justify-content-around flex-column py-5">
				
				<div class="col-12 text-center">
				  <h4 class="mb-5 titFoot m-auto">VISITA NUESTRO TALLER</h4>
				  <div class="position-relative">
					  <div id="map" aria-label="Mapa donde está ubicado nuestro taller"></div>
				  </div>
				</div>
				
				
				<div class="col text-center mt-5">
				  <h4 class="mb-5 titFoot m-auto">CONTACTA CON NOSOTROS</h4>
				  <div class="">
					<h5 class="pb-2"><i class="fa-solid fa-envelope letraAma "></i> tallerarcustoms@outlook.com</h5>
					<h5><i class="fa-solid fa-phone letraAma"></i>+34 654654654</h5>
				  </div>
				</div>
			  </div>
		  </footer>
		</div> 
	  <!--  FIN FOOTER -->
  
	   
  
	  </div>
		
		
		
		
		
		
		
		
		
  <script>
  $(function(){
	  var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
	  var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
			return new bootstrap.Tooltip(tooltipTriggerEl)
	  });
  })
  
  </script>
	  
	  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	  
	  
	</body>
  </html>