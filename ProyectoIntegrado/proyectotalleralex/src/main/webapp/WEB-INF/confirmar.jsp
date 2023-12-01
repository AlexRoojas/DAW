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

    <title>Taller AR Customs | Confirmar Compra</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://code.jquery.com/ui/1.13.0/jquery-ui.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
	  <link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="stylesheet" href="estilo/estiloCesta.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script>
      $(function() {
        var $btnCompra = $('.btnCompra');
        var $modal = $('.modal');

        
        
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
		                    <li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Facturas</button></li>
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
     <!--FIN HEADER--> 
     <div class="container mt-3">
      
      <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item text-black"><a href="irInicio" aria-label="Volver a la página principal" class="text-decoration-none"><i class="fa-solid fa-house"></i> Inicio</a></li>
            <li class="breadcrumb-item" ><a href="irCesta" aria-label="Volver a la tienda" class="text-decoration-none"> Cesta</a></li>
            <li class="breadcrumb-item active " aria-current="page"> Pago</li>
          </ol>
          
      </nav>
      
    </div>
     <!-- CAJA PRINCIPAL -->
     <div class="col-10 offset-1 d-flex justify-content-center border border-warning border-3 rounded-3 bordeColor">
       <div class="container-fluid">
        <div class="row">
          <h4 class="text-center my-5">Selecciona tu método de pago</h4>
        </div>
        
        <div class="row d-flex justify-content-around mb-5">
          <div class="col-12 col-md-3">
            <button class="btnCompra paypal"><i class="fa-brands fa-paypal"></i> Paypal</button>
          </div>
          <div class="col-12 col-md-3">
            <button class="btnCompra cred"><i class="fa-solid fa-credit-card"></i> Tarjeta de Crédito</button>
          </div>
          <div class="col-12 col-md-3">
            <button class="btnCompra tien"><i class="fa-solid fa-shop"></i> Pagar en Tienda</button>
          </div>
          
          
        </div>
        <div class="row d-flex justify-content-center my-5 flex-column align-content-center">
          
          <div class="col-md-3 text-center my-5 total">
            <h5><span>${prodTotal}</span> productos en total.</h5>
            <h5>Total : <span>${precioTotal}$</span></h5>
          </div>
          <div class="col-md-3">
           <a href="confirmarCesta" class="text-decoration-none sinDeco cerSes"> <button type="button" class="btnCompra comprar"><h5>Comprar</h5></button></a>
          </div>

          <div class="modal" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered">
              <div class="modal-content">
                <div class="modal-header cabecera d-flex flex-column">
                  <button type="button" class="btn-close align-self-end p-3 " tabindex="-1" data-bs-dismiss="modal" aria-label="Close"></button>
                  <h3 class="modal-title m-auto text-white">¡Gracias por su compra!</h3>
                </div>
                <div class="modal-body">
                  <p><span class="material-symbols-outlined carro">shopping_cart</span></p>
                </div>
                <div class="modal-footer text-center">
                  <button type="button" class="btn btn-primary" data-bs-dismiss="modal">Ver Factura</button>
                </div>
              </div>
            </div>
          </div>



        </div>
      </div>
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
                  <h5 class="pb-2"><i class="fa-solid fa-envelope letraAma "></i> artaller@gmail.com</h5>
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