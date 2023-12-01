<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="utf-8"%>
    
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Producto</title>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
  	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="stylesheet" href="estilo/estiloProd.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@20..48,100..700,0..1,-50..200" />
    <script>
    $(document).ready(function(){
    	
    	function initMap() {
  		  // The location of Uluru
  		  const uluru = { lat: 36.7516517, lng: -5.1607469 };
  		  // The map, centered at Uluru
  		  const map = new google.maps.Map(document.getElementById("map"), {
  		    zoom: 10,
  		    center: uluru,
  		  });
  		  // The marker, positioned at Uluru
  		  const marker = new google.maps.Marker({
  		    position: uluru,
  		    map: map,
  		  });
  		}


		initMap();
    	
    	
    	
    	
    	
    	
    	
    	valoraciones();
    	
    	$(".minus").click(function() {
    		if($('.count').val()!=1)
    		$('.count').val(parseInt($('.count').val()) - 1 );
    		
    	});
    	
    	$(".plus").click(function() {
    		
    		var max = $('.count').attr("max");
    		
    		var val = $('.count').val();
    		
    		if(max>val){
    			$('.count').val(parseInt($('.count').val()) + 1 );
    		}
    		
    	});
    	
    	
    	$(".btn-carro").click(function() {
			$(this.closest("form")).submit();
		});	
    	
    	
             
    	
        
    	
    	function valoraciones(){
    		var puntu = $("#puntuacion").val();
        	
        	for(var i=0; i<puntu;i++){
        		$(".cajaEstrellas").append("<span class='material-symbols-outlined starAma'>star</span>")
        	}
        	
    	}
    	
    	
    	
    });
    </script>
  </head>
  <body>
	<input id="puntuacion" type="hidden" value='${miProd.puntuacionProd}'>
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
							   <a class="nav-link px-3 py-4 activo" href="irTienda" title="Enlace para ir la tienda">TIENDA</a>
							 </li>
							 <li class="nav-item">
							   <a class="nav-link px-3 py-4" href="cargaCita" title= "Enlace para ir a las citas">CITAS</a>
							 </li>
							 <c:if test="${sessionScope.usuario.tipousu == 'C'}">
	                        	<li class="nav-item">
		                          <a class="nav-link px-3 py-4" href="cargaPuntu" title="Enlace para puntuar los productos">PUNTUAR</a>
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
     <div class="container mt-3">
      
      <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item text-black"><a href="irInicio" aria-label="Volver a la página principal" class="text-decoration-none"><i class="fa-solid fa-house"></i> Inicio</a></li>
            <li class="breadcrumb-item" ><a href="irTienda" aria-label="Volver a la tienda" class="text-decoration-none"> Tienda</a></li>
            <li class="breadcrumb-item active " aria-current="page"> ${miProd.categoriaProd}</li>
          </ol>
          
      </nav>
      
    </div>
     <!-- CAJA PRINCIPAL -->
     <div class="col-12 col-md-10 offset-md-1  mt-5 d-flex justify-content-between flex-wrap flex-md-nowrap">
        <div class="col-12 col-md-6 ">
          <div class="row mt-5">
            <h4 class="fw-bold mb-5">${miProd.nomProd}</h4>
            <img src="img/prod/${miProd.imgProd}" class="img-fluid imgProd m-auto my-5" alt="${miProd.nomProd}">


          </div>

          <!-- DESCRIPCIÓN-->
          <div class="row mt-5">
            <h5 class="my-5">Descripción</h5>
            <p class="ms-3">${miProd.descripProd}</p>
          </div>

          

          <!-- CONSEJOS-->

          <div class="row my-5  ps-2">
            <h5 class="my-5">Consejos</h5>
            <c:choose>
         
	         <c:when test="${miProd.categoriaProd == 'Baterias'}">
	            <p><strong>La batería es un producto perecedero,</strong> se descarga y su reserva de electricidad (capacidad) disminuye con el tiempo.</p>
	            <p><strong>¡Atención!</strong> Una batería descargada almacenada no siempre se podrá recuperar después de cargarla.
					El exceso de calor es uno de los principales enemigos de las baterías. A 40ºC la durabilidad de almacenamiento de una batería convencional es de 3 meses. Después de los 3 meses, las baterías convencionales se tienen que recargar.
					En caso de recargar una batería, hay que elegir siempre un sitio aireado.
					En caso de necesidad de añadir líquido, añadir siempre agua destilada protegiéndote las manos y los ojos. 
					Si vas a reemplazar la batería tú mismo, ponte siempre guantes (si es posible, de caucho) y gafas de protección apropiadas para trabajar con la batería, ya que contiene ácido corrosivo.</p>
					
				<p><strong>Importante:</strong> La sustitución de una batería en un vehículo reciente (con gestión electrónica) necesita unas herramientas específicas, por lo tanto, es aconsejable cambiar la batería en un taller profesional como Taller AR Customs.
					</p>
					
					
				<div class="video text-center">
	              <iframe width="560" height="315" src="https://www.youtube.com/embed/z93QCe-RXQo" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	            </div>	
	         </c:when>
	         
	         <c:when test="${miProd.categoriaProd == 'Escapes'}">
	            <p>Una vez realizada la instalación deberás <strong>acudir a la ITV con toda la documentación necesaria:</strong> permiso de circulación, ficha técnica y certificados. Tras revisar la documentación la ITV homologará tu tubo de escape y podrás circular con normalidad con tu vehículo.</p>
	         	<p>En el caso de que hayas usado recambios que no son originales y no hayas obtenido la aprobación de la ITV tendrás 15 días para aportar la documentación pertinente, si no lo haces deberás <strong>hacer frente a una multa de 500 euros.</strong></p>
	         	
	         	<div class="video text-center">
	         		<iframe width="560" height="315" src="https://www.youtube.com/embed/m6jDnt91gQk" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	         	</div>
	         </c:when>
	         
	         <c:when test="${miProd.categoriaProd == 'Neumaticos'}">
	            <p>Si sus neumáticos se desgastan hasta la profundidad mínima legal de la banda de rodadura de 1,6 milímetros o ya están por debajo de esta, significa que la goma vieja se ha desgastado y se necesita un neumático nuevo. Este es el momento de montar los neumáticos. ¿Es un cambio de llanta más sensato que un cambio completo de rueda?</p>
	            <p>No necesariamente. El montaje y desmontaje frecuente de neumáticos daña la goma y la llanta. Esto significa que también afecta la vida útil de sus neumáticos. Es mucho mejor cambiar la rueda completa cada temporada.</p>
	            <p>Montar neumáticos nuevos es útil si sus llantas aún están en buen estado, pero sus neumáticos muestran signos de vejez. Siempre debe reemplazar los neumáticos si hay daños irreparables o bandas de rodadura gastadas.</p>
	            
	            <div class="video text-center">
	            	<iframe width="560" height="315" src="https://www.youtube.com/embed/y1QnrqMR87w" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	            </div>
	         </c:when>
	         
	         <c:when test="${miProd.categoriaProd == 'Embragues'}">
	            <p>El <strong>embrague es la arteria aorta</strong> de los coches manuales por lo que su avería deja sin oxígeno a todo conductor ya que es una de las más caras, en algunas marcas ronda los 1.000 euros. Malos hábitos y vicios acaban provocando un desgaste prematuro del mecanismo que merma el bolsillo de los propietarios y aparca el vehículo en el taller.</p>
	            <p>Los comportamientos inadecuados al volante además de provocar riesgos en la seguridad vial y un gasto desorbitado del combustible, afectan también a la mecánica del automóvil. Y es que, con la L en mano nos hacemos dueños de la carretera adquiriendo rutinas contraproducentes para el perfecto mantenimiento del vehículo.</p>
	         	
	            <div class="video text-center">
	            	<iframe width="560" height="315" src="https://www.youtube.com/embed/fue6d8_pVZ0" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	            </div>
	         </c:when>
	         
	          <c:when test="${miProd.categoriaProd == 'Suspension'}">
	            <p>Cierto es que para mantener tu sistema de suspensión en perfectas condiciones, debes revisarlo en tu taller de confianza año tras año. Además de esto, te vamos a dar algunos consejos para que, a la hora de conducir, tu amortiguación no sufra en demasía:</p>
				<ul>
					<li>Siempre evita circular a gran velocidad en lugares donde la carretera es irregular</li>
					<li>Revisa de forma periódica la presión de las llantas</li>
					<li>Muy atento a la carga que colocas en el coche. El exceso de peso puede dañar la suspensión.</li>
					<li>Pon atención a las repentinas pérdidas de control del vehículo o a los ruidos que produce el vehículo.</li>
				</ul>
	            <div class="video text-center">
	            	<iframe width="560" height="315" src="https://www.youtube.com/embed/qTFCOrQgXtY" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>
	            </div>
	         </c:when>
	         
	         <c:otherwise>
	           <p> No hay consejos para tu producto :/</p>
	         </c:otherwise>
	         
	      </c:choose>
            
            

            
          </div>

        </div>
        <div class="col-12 col-md-4 derecha ">
          <div class="row mb-5">
            <div class="cajaCompra">
            <form action="anadirCesta">
            <input name="codigoProd" type="hidden" value="${miProd.codProd}">
            <input name="sitio" type="hidden" value="producto">
              <div class="cajaEstrellas text-center my-5">
                <span class="valo">Valoración:</span>
              </div>
              <div class="cosis d-flex justify-content-around my-5">
                <div>
                  <h5 class="verdesito" >${miProd.precioProd}$</h5><br>
                  <span class=" mb-4 verdesito">Disponible</span>
                </div>
                
                
                <div class="contador d-flex align-items-center">
                  <div class="qty d-flex justify-content-evenly">
                    <span class="minus bg-dark" aria-label="Reducir cantidad cesta">-</span>
                    <input type="number" class="count" name="cantidad" value="1" aria-label="contador" min="1" max="${miProd.unidadesProd}">
                    <span class="plus bg-dark" aria-label="Aumentar cantidad cesta">+</span>
                    <span>Unidades</span>
                  </div>
                </div>
                
              </div>
              
           		  <c:choose>
                  	<c:when test="${not empty sessionScope.usuario}">
                  		<button type="button" class="btn mb-2 mb-md-0 btn-carro btn-block" aria-label="Añadir a la cesta">Añadir Cesta</button>
                  	</c:when>
                  	<c:otherwise>
                  	<div data-bs-toggle="tooltip" data-bs-placement="bottom" title="Inicia sesión para comprar">
                  		<button type="button" class="btn mb-2 mb-md-0 btn-carro btn-block disabled">Añadir Cesta</button>
                  	</div>
                  	</c:otherwise>
                  </c:choose>
              
              
              
              
              
              </form>
              
              
            </div>
          </div>
          <div class="row  mt-5">
            <h5 class="text-center"><i class="fa-solid fa-location-dot"></i> <a href="#map" class="text-decoration-none" title="Enlace que baja a la ubicación del taller">Ver Ubicación del Taller</a></h5>
            
              <div class="">
                <p class="verdesito">Recogida en 1H</p>
                <p>Ahora también puedes pagar en Tienda</p>
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
                            <form action="enviaemail" class="form-subs">
                                <div class="row input-group-newsletter">
                                    <div class="col-md-9 mb-3 mb-md-0">
                                        <input name="email" type="text" class="form-control emailNewletter" aria-label="Introducir tu correo" placeholder="Introduce tu correo"/> 
                                        <input type="hidden" name="origen" value="irInicio">
                                    </div>
                                    <div class="col-md-2 btnNews position-relative">
                                        <button type="submit" class="btn btn-subs" >Suscribirme</button>
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