<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <!-- Required meta tags -->
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Cesta</title>

    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>

 	  <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>



	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
	<link rel="stylesheet" href="estilo/estiloCesta.css"/>
	<link rel="stylesheet" href="estilo/estiloProd.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    <link rel="stylesheet" href="https://fonts.sandbox.google.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
   
   
   <script>
   $(document).ready(function(){
	   
		   $(".minus").click(function() {
		   		if($((this).nextElementSibling).val()!=1)
		   			$((this).nextElementSibling).val(parseInt($((this).nextElementSibling).val()) - 1 );
		   		
		   	});
	   	
	   	$(".plus").click(function() {
	   		$((this).previousElementSibling).val(parseInt($((this).previousElementSibling).val()) + 1 );
	   	});
	   	
	   	$(".botonparacesta").click(function(){
	   		var miClase = $(this).attr('class');
	   		$("#miBoton").val(miClase);
	   		$(this.closest("form")).submit();
	   	});
	   	
	   	
	   	$(".btn-cest").click(function(e){
	   		e.preventDefault();
	   	});
	   	
	   	
	   	
	   	$(".btnElimina").click(function() {
			$(this.closest("form")).submit();
		});	
	   	

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
	   	
   });
   </script>
   
</head>
<body>

	<div class="container-fluid p-0">
		  
		 <!-- HEADER--> 
     <div class="sticky-top" aria-label="Cabecera de la página">
			<div class="container-fluid p-0">
	 
			 <div class="row barra">
			 </div>
	 
			 <header class="sticky-top fondoBarra">
			   <div class="container-fluid">
				 <div class="row">
					 <div class="col d-flex flex-column flex-md-row justify-content-start align-items-center">
					   <a class="navbar-brand fs-3 m-0" href="irInicio" title="Enlace para ir a la página principal"><img class="img-responsive logo" height="100" src="img/1.png" title ="Logotipo del taller" alt=""/></a>
					   <form class="d-flex ms-md-5 formxd" action="irTienda">
						 <input class="form-control me-2" type="search" name="busca" placeholder="Buscar..." aria-label="Buscador Principal de artículos">
						 <button type="submit" class="btn amarillo" aria-label="Boton para accionar la búsqueda">
						 <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16" aria-label="Lupa para hacer la búsqueda">
						   <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
						 </svg>
						 </button>  
					   </form>
					 </div>
					 <div class="col-12 col-md-4 d-flex justify-content-around align-items-center">
					   <button class="btn fw-bold letraAma" type="button"><a href="irMapa" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver la ubicación del taller"><i class="fa-solid fa-location-dot  me-2"></i>UBICACIÓN</a></button>
					   <c:choose>
						   <c:when test="${not empty sessionScope.usuario}">
							   <button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" type="button" aria-label="Boton para desplegar un mini menú"><i class="fa-solid fa-user me-2"></i>${usuario.nombreusu}</button>
							   <ul class="dropdown-menu">
								 
								 <c:choose>
									 <c:when test="${sessionScope.usuario.tipousu == 'M'}">
										 <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="verCitasMec" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver tus citas">Ver Citas</a></button></li>
									 </c:when>
									 <c:when test="${sessionScope.usuario.tipousu == 'A'}">
										 <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="verAdmin" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ir a la página del administrador">Administración</a></button></li>
									 </c:when>
									 <c:otherwise>
										 <c:choose>
											 <c:when test="${not empty sessionScope.codigoFact}">
												 <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><a href="verEstadoCita" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver el estado de tu cita">Estado Cita</a></button></li>
												 <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver la última factura">Última Factura</a></button></li>
											 </c:when>
											 <c:otherwise>
												 <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="verEstadoCita" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver el estado de tu cita">Estado Cita</a></button></li>
												   <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver la última factura">Última Factura</a></button></li>
											   </c:otherwise>
											 
										 </c:choose>
									 </c:otherwise>
								 </c:choose>
								 
								 
								 
								 
								 <li><hr class="dropdown-divider"></li>
								 <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><a href="cerrarSesion" class="text-decoration-none sinDeco cerSes" title="Enlace para cerrar sesión">Cerrar Sesión</a></button></li>
							   </ul>
							   
							   <button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" aria-label="Mini menú de tu cesta"><i class="fa-solid fa-cart-shopping me-2"></i>CESTA ${prodTotal}</button>
							   <ul class="dropdown-menu">
								 <li class="dropdown-item">Productos en total : <span>${prodTotal}</span></li>
								 <li class="dropdown-item">Total: <span>${precioTotal}</span>$</li>
								 <li><hr class="dropdown-divider"></li>
								 <li class="px-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block btnVerCesta"><a href="irCesta" class="text-decoration-none sinDeco d-block encesta" title="Enlace para ver tu cesta">Ver Cesta</a></button></li>
							   </ul>
						   </c:when>
						   <c:otherwise>
							   <button class="btn letraAma fw-bold" type="button"><a href="irLogin" class="text-decoration-none sinDeco" title="Enlace para Iniciar Sesión"><i class="fa-solid fa-user me-2"></i>MI CUENTA</a></button>
						   </c:otherwise>
					   </c:choose>
					   
					   
					 </div>
				   </div>
				   <div class="row">
					 <div class="col fondo2">
	 
					   <nav class="navbar navbar-expand-lg navbar-light bg-light p-0">
						 
						 <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Activar toggle">
						   <span class="navbar-toggler-icon"></span>
						 </button>
						 <div class="collapse navbar-collapse justify-content-center " id="navbarScroll">
						   
						   <ul class="nav barrita">
							 <li class="nav-item">
							   <a class="nav-link px-3 py-4 " aria-current="page" href="irInicio" title="Enlace para ir al inicio">INICIO</a>
							 </li>
							 <li class="nav-item">
							   <a class="nav-link px-3 py-4 " href="irTienda" title="Enlace para ir la tienda">TIENDA</a>
							 </li>
							 <li class="nav-item">
							   <a class="nav-link px-3 py-4" href="cargaCita" title= "Enlace para ir a las citas">CITAS</a>
							 </li>
							 <li class="nav-item">
							   <a class="nav-link px-3 py-4" href="#" title="">CONTACTO</a>
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
            <li class="breadcrumb-item text-black"><a href="index.html" aria-label="Volver a la página principal" class="text-decoration-none"><i class="fa-solid fa-house"></i> Inicio</a></li>
            <li class="breadcrumb-item active " aria-current="page"> Cesta</li>
          </ol>
          
      </nav>
      
    </div>
    <!-- CAJA PRINCIPAL -->
    <h2 class="text-center">Esta es tu cesta ${miUsu.nombreusu}</h2>
    
    <div class="col-4 col-md-2 offset-3 offset-md-10 my-5 my-md-0 d-flex derecha">
      <div>
        <h5>Total: <span>${prodTotal}</span> productos</h5>
        <h5 class="text-center">${precioTotal}$</h5>
        <button type="button" class="btn  btn-confi btn-block my-3"><a href="irConf" class="text-decoration-none d-block letraconfi" title="Confirmar compra">Confirmar</a></button>
      </div>
      
    </div>
    <div class="col-10 offset-1  mt-5 ">
    
    <c:forEach var="prodCesta" items="${listaCesta}" varStatus="vs">
    
      <div class="col-12 col-md-8 border-top d-flex flex-wrap flex-md-nowrap m-auto">
      <input name="codProd" type="hidden" value='${prodCesta.codproducto}'>
        <div class="col-5 col-md-2">
          <img src="img/prod/${prodCesta.imgProd}" class="img-fluid imgCest m-auto my-5" alt="${prodCesta.nomProd}">
        </div>
        <div class="col-7 ">
          <h5 class="fw-bold ms-5 my-5 ">${prodCesta.nomProd}</h5>
          <p class="ms-5 fw-bold">Precio Actual: <span>${prodCesta.precioProd}$</span></p>
        </div>
        <div class="col d-flex align-items-center">
        
          <div class="contador">
			<form action="actualizaProd" class="formCestaAct">
				<input name="codProd" type="hidden" value='${prodCesta.codproducto}'>
				<input name="precioProd" type="hidden" value='${prodCesta.precioProd}'>
				<input id="miBoton" name="boton" type="hidden" value=''>
	            <div class="qty d-flex justify-content-evenly align-items-center">
	            <span class="me-4">Añadir</span>
	              <span class="minus bg-dark botonparacesta"  aria-label="Reducir cantidad cesta">-</span>
	              <input type="number" class="count fs-4 mx-5" name="qty" value="${prodCesta.unidadesCesta}" aria-label="contador">
	              <span class="plus bg-dark botonparacesta"  aria-label="Aumentar cantidad cesta">+</span>
	              <span>Unidades</span>
	            </div>
            </form>
            
            
            
            <button class="btn mb-2 mb-md-0 btn-cest btn-block my-5" value="Eliminar" data-bs-toggle="modal" data-bs-target="#myModal${vs.index}">Eliminar</button>
            
            <div class="modal fade" id="myModal${vs.index}"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <form action="borraProdCesta" class="formCesta">
            <input name="codProd" type="hidden" value='${prodCesta.codproducto}'>
			  <div class="modal-dialog modal-dialog-centered">
			    <div class="modal-content">
			      <div class="modal-header d-flex justify-content-end">
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      <div class="modal-body">
			        <h5>¿Estás seguro de que quieres borrar este artículo?</h5>
			        <p>${prodCesta.nomProd}</p>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
			        <button type="button" class="btn btn-primary btnElimina">Eliminar</button>
			      </div>
			    </div>
			  </div>
			  </form>
			</div>
            
            
            
            
          </div>
        </div>
      </div>
      
     </c:forEach>
      </div>
    <!-- FIN CAJA PRINCIPAL-->

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
	  
	  
	  
	  
	  
	  
	  
	  

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    
  </body>
</html>