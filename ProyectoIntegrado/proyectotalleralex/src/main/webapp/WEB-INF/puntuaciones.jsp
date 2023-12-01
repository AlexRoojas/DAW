<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
	<!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Puntuaciones</title>
    
   	<script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
	  <link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="stylesheet" href="estilo/estiloAdmin.css"/>
    <link rel="stylesheet" href="estilo/estiloTienda.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
   
   <script src="/js/estrella.js"></script>
   <style>
	   	.jq-stars {
		  display: inline-block;
		}
		
		.jq-rating-label {
		  font-size: 22px;
		  display: inline-block;
		  position: relative;
		  vertical-align: top;
		  font-family: helvetica, arial, verdana;
		}
		
		.jq-star {
		  width: 100px;
		  height: 100px;
		  display: inline-block;
		  cursor: pointer;
		}
		
		.jq-star-svg {
		  padding-left: 3px;
		  width: 100%;
		  height: 100% ;
		}
		
		.jq-star:hover .fs-star-svg path {
		}
		
		.jq-star-svg path {
		  /* stroke: #000; */
		  stroke-linejoin: round;
		}
		
		/* un-used */
		.jq-shadow {
		  -webkit-filter: drop-shadow( -2px -2px 2px #888 );
		  filter: drop-shadow( -2px -2px 2px #888 );
		}
   </style>
   <script>
	   $(document).ready(function(){
		   $(".my-rating").starRating({
			   initialRating: 0,
			   strokeColor: '#894A00',
			   strokeWidth: 10,
			   starSize: 25,
			   useFullStars: true
			 });
		   
		   
		   $(".actu").click(function() {
			   
			   var xd = $(this.previousElementSibling).attr("data");
			   
			   var puntu = $('.'+xd).starRating('getRating');
			   
			   var xdddd = (this).previousElementSibling.previousElementSibling;
			   
			   xdddd.setAttribute("value",puntu)
			   
			   if(puntu!= "0.0"){
				   $(this.closest("form")).submit();
			   }
			   
				
			});	
		   
		   
		   
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
                          <a class="nav-link px-3 py-4" href="irTienda" title="Enlace para ir la tienda">TIENDA</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4" href="cargaCita" title= "Enlace para ir a las citas">CITAS</a>
                        </li>
                        <c:if test="${sessionScope.usuario.tipousu == 'C'}">
                        	<li class="nav-item">
	                          <a class="nav-link px-3 py-4 activo" href="cargaPuntu" title="Enlace para puntuar los productos">PUNTUAR</a>
	                        </li>
                        </c:if>
                        
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

	<div class="col-10 offset-1">
		
		<c:forEach var="puntu" items="${lvs}" varStatus="vs">
		  <form class="formProducto" action="actualizaPuntu" >
			<div class="row">
			  <div class="col-10 col-md-10 offset-1 mt-5 d-flex flex-column flex-lg-row filita p-0 pb-md-4">
			  
				  <input  type="hidden" name="codigoProducto" value="${puntu.codigoprod}">
				  
				<div class="col-10 offset-1 col-lg-2">
						
					 <img src="img/prod/${puntu.imgProd}" class="img-thumbnail prodImg" alt="${puntu.nomProd}">
				</div>
		  
					<div class="offset-1 col-10 col-lg-6 d-flex flex-column ">
					  <h4 class="nomProd">${puntu.nomProd}</h4>
					  <input class="puntuacion" type="hidden"  value="${puntu.puntuacionProd}">
					  
					  <div class="cajaEstrellas">
					  <p>Puntuación actual:</p>
					  <c:forEach var="i" begin="1" end="${puntu.puntuacionProd}">
						  <span class="material-symbols-outlined starAma">star</span>
					  </c:forEach>
					  
					  </div>
					  <p class="fw-bold">Tu última puntuación: <span class="fw-normal"> ${puntu.puntuacion}</span>  <span class="material-symbols-outlined starAma">star</span></p>
					  
					  <a href="#" class="link-primary linkProd" title="Ver Producto"></a>
					</div>
					
					<div >
		  			<input type="hidden" class="form-control xdddd+${vs.index}" name="nuevaPunt" min="0" max="5" value="0">
		  			<div class="my-rating xd${vs.index}" id="es+${vs.index}" data="xd${vs.index}"></div>
						<button type="button" value="Actualizar" class="btn btn-primary actu">Actualizar </button>
		  			</div>
		  	
				  </div>
			  </div>
			</form>
		</c:forEach>
		
	</div>

     

	</div>
	  
	  
	  

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    
  </body>
</html>