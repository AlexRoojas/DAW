<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Estado Cita</title>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="stylesheet" href="estilo/estiloCitas.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    
    
    <script>
	    $(document).ready(function(){
	    	
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
     <div class="sticky-top">
       <div class="container-fluid p-0">

        <div class="row barra">
        </div>

        <header class="sticky-top fondoBarra">
          <div class="container-fluid">
            <div class="row">
                <div class="col d-flex justify-content-start align-items-center">
                  <a class="navbar-brand fs-3 m-0" href="irInicio"><img class="img-responsive logo" height="100" src="img/1.png" alt="Logotipo del taller"/></a>
                  <form class="d-flex ms-5" action="irTienda">
                    <input class="form-control me-2" type="search" name="busca" placeholder="Buscar..." aria-label="Buscador Principal de artículos">
                    <button type="submit" class="btn amarillo">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                      <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg>
                    </button>  
                  </form>
                </div>
                <div class="col-4 d-flex justify-content-around align-items-center">
                  <button class="btn fw-bold letraAma" type="button"><a href="irMapa" class="text-decoration-none sinDeco d-block encesta"><i class="fa-solid fa-location-dot  me-2"></i>UBICACIÓN</a></button>
                  <c:choose>
                  	<c:when test="${not empty sessionScope.usuario}">
                  		<button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" type="button"><i class="fa-solid fa-user me-2"></i>${usuario.nombreusu}</button>
		                  <ul class="dropdown-menu">
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Estado Cita</button></li>
		                    <c:choose>
		                    	<c:when test="${not empty sessionScope.codigoFact}">
		                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta">Última Factura</a></button></li>
		                    	</c:when>
		                    	<c:otherwise>
			                  		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block disabled"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta">Última Factura</a></button></li>
			                  	</c:otherwise>
		                    	
		                    </c:choose>
		                    
		                    <li><hr class="dropdown-divider"></li>
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><a href="cerrarSesion" class="text-decoration-none sinDeco cerSes">Cerrar Sesión</a></button></li>
		                  </ul>
		                  
		                  <button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false"><i class="fa-solid fa-cart-shopping me-2"></i>CESTA ${prodTotal}</button>
		                  <ul class="dropdown-menu">
		                    <li class="dropdown-item">Productos en total : <span>${prodTotal}</span></li>
		                    <li class="dropdown-item">Total: <span>${precioTotal}</span>$</li>
		                    <li><hr class="dropdown-divider"></li>
		                    <li class="px-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block btnVerCesta"><a href="irCesta" class="text-decoration-none sinDeco d-block encesta">Ver Cesta</a></button></li>
		                  </ul>
                  	</c:when>
                  	<c:otherwise>
                  		<button class="btn letraAma fw-bold" type="button"><a href="irLogin" class="text-decoration-none sinDeco"><i class="fa-solid fa-user me-2"></i>MI CUENTA</a></button>
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
                      <div class="collapse navbar-collapse justify-content-center id="navbarScroll">
                        
                        <ul class="nav barrita">
                          <li class="nav-item">
                            <a class="nav-link px-3 py-4" aria-current="page" href="irInicio">INICIO</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link px-3 py-4" href="irTienda">TIENDA</a>
                          </li>
                          <li class="nav-item">
                            <a class="nav-link px-3 py-4" href="cargaCita">CITAS</a>
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
     <!--FIN HEADER--> 

     <!-- CAJA PRINCIPAL -->
     <div class="col-10 offset-1 border border-warning border-3 rounded-3 my-5">
     <c:choose>
     	<c:when test="${not empty noCita}">
     		<h4 class="text-center">No tienes ninguna Cita</h4>
     	</c:when>
     	<c:otherwise>
     		<h3 class="text-center mt-2 mb-5">Estado de Tu Cita</h3>
		      <ul id="progressbar" class="text-center fw-bold p-0" aria-label="Proceso del estado de tu cita">
		      <c:choose>
		      	<c:when test="${estado == 'Recibido'}">
		   			<li id="prim" class="active">Recibido</li>
			        <li id="seg" class="">Aceptado / Rechazado</li>
			        <li id="ter">En Proceso</li>
			        <li id="cuar">Finalizado</li>
		      	</c:when>
		      	<c:when test="${estado == 'Aceptado'}">
		      		<li id="prim" class="active">Recibido</li>
			        <li id="seg" class="active">Aceptado / Rechazado</li>
			        <li id="ter">En Proceso</li>
			        <li id="cuar">Finalizado</li>
		      	</c:when>
		      	<c:when test="${estado == 'Proceso'}">
		      		<li id="prim" class="active">Recibido</li>
			        <li id="seg" class="active">Aceptado / Rechazado</li>
			        <li id="ter" class="active">En Proceso</li>
			        <li id="cuar">Finalizado</li>
		      	</c:when>
		      	<c:when test="${estado == 'Finalizado'}">
		      		<li id="prim" class="active">Recibido</li>
			        <li id="seg" class="active">Aceptado / Rechazado</li>
			        <li id="ter" class="active">En Proceso</li>
			        <li id="cuar" class="active">Finalizado</li>
		      	</c:when>
		      	<c:otherwise>
		      		<h4>No tienes ninguna cita por ahora.</h4>
		      	</c:otherwise>
		      </c:choose>
		        
		      </ul>
		      <div class="text-center my-5"> 
		      <c:choose>
		      	<c:when test="${estado == 'Finalizado'}">
		      		<a href="cargaFactura"></a><button class="btn mb-md-0 mb-2 btn-morao p-4 fs-4"> Ver Factura </button>
		      	</c:when>
		      	<c:otherwise>
		      		<button class="btn mb-md-0 mb-2 btn-morao p-4 fs-4 disabled"> Ver Factura </button>
		      	</c:otherwise>
		      </c:choose>
		      </div>
		
		      <div class="col-md-4 text-center offset-md-4 my-4">
		        <h4 class="mb-3 border-bottom border-3 morao">¿Tienes alguna duda? Contáctenos</h4>
		        <div class="d-flex justify-content-center flex-wrap flex-column">
		          <h5 class="pb-2"><i class="fa-solid fa-envelope Tmorao "></i> artaller@gmail.com</h5>
		          <h5><i class="fa-solid fa-phone Tmorao"></i>+34 654654654</h5>
		        </div>
		      </div>
     	</c:otherwise>
     </c:choose>
      
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
                                        <input name="email" type="text" class="form-control emailNewletter" /> 
                                        <input type="hidden" name="origen" value="irInicio">
                                    </div>
                                    <div class="col-md-2 btnNews position-relative">
                                        <button type="submit" class="btn btn-subs" title="Suscribirme">Suscribirme</button>
                                        <span class="ocultar">Botón para suscribirse al periódico y recibir noticias por correo</span>
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
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Twitter"><i class="neg fab fa-brands fa-twitter"></i></a></li>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Instagram"><i class="neg fab fa-instagram"></i></a></li>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Facebook"><i class="neg fab fa-brands fa-facebook-f"></i></a></li>
                        <li><a href="#" target="blank" aria-label="Enlace para ir a la cuenta de Youtube"><i class="neg fab fa-brands fa-youtube"></i></a></li>
                        
                    </ul>
                </div>
            </div>
            <div class="contaier-fuild finFoot d-flex justify-content-around flex-column py-5">
              
              <div class="col-12 text-center">
                <h4 class="mb-5 titFoot m-auto">VISITA NUESTRO TALLER</h4>
                <div class="position-relative">
                	<div id="map"></div>
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