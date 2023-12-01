<%@ page language="java" contentType="text/html"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html lang="es">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

    <title>Taller AR Customs | Iniciar Sesión</title>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="stylesheet" href="estilo/estiloLogin.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    <script>
		  function cambiaField(selec){
			var formLog = document.getElementById("formLog");
			var formReg = document.getElementById("formReg");
			  
			var tarj = document.getElementById("tarjeta");
			
			var credito = document.getElementById("credit");
			
			if(selec == log){
				formLog.style.display="block";
				formReg.style.display="none";
				
			}else{
				formReg.style.display="block";
				formLog.style.display="none";
				
			}
		}
	  </script>
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
			
			$("input:radio,input:checkbox").on("change",function(){
                if($(this).is(":checked")){
                    $(this).attr("aria-checked","true");
                }else{
                    $(this).attr("aria-checked","false");
                }
            });
			
			
		  
		  
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
                <div class="col d-flex flex-column flex-md-row justify-content-start align-items-center">
                  <a class="navbar-brand fs-3 m-0" href="irInicio"><img class="img-responsive logo" height="100" src="img/1.png" alt="Logotipo del taller"/></a>
                  <form class="d-flex ms-md-5 formxd" action="irTienda">
                    <input class="form-control me-2" type="search" name="busca" placeholder="Buscar..." aria-label="Buscador Principal de artículos">
                    <button type="submit" class="btn amarillo">
                    <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                      <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
                    </svg>
                    </button>  
                  </form>
                </div>
                <div class="col-12 col-md-4 d-flex justify-content-around align-items-center">
                  <button class="btn fw-bold letraAma" type="button"><a href="irMapa" class="text-decoration-none sinDeco d-block encesta"><i class="fa-solid fa-location-dot  me-2"></i>UBICACIÓN</a></button>
                  <c:choose>
                  	<c:when test="${not empty sessionScope.usuario}">
                  		<button class="btn letraAma fw-bold dropdown-toggle" data-bs-toggle="dropdown" aria-expanded="false" type="button"><i class="fa-solid fa-user me-2"></i>${usuario.nombreusu}</button>
		                  <ul class="dropdown-menu">
		                    
		                    <c:choose>
		                    	<c:when test="${sessionScope.usuario.tipousu == 'M'}">
		                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="verCitasMec" class="text-decoration-none sinDeco d-block encesta">Ver Citas</a></button></li>
		                    	</c:when>
		                    	<c:when test="${sessionScope.usuario.tipousu == 'A'}">
		                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="verAdmin" class="text-decoration-none sinDeco d-block encesta">Administración</a></button></li>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<c:choose>
				                    	<c:when test="${not empty sessionScope.codigoFact}">
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block"><a href="verEstadoCita" class="text-decoration-none sinDeco d-block encesta">Estado Cita</a></button></li>
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta">Última Factura</a></button></li>
				                    	</c:when>
				                    	<c:otherwise>
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="verEstadoCita" class="text-decoration-none sinDeco d-block encesta">Estado Cita</a></button></li>
					                  		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta">Última Factura</a></button></li>
					                  	</c:otherwise>
				                    	
				                    </c:choose>
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
                          <a class="nav-link px-3 py-4" aria-current="page" href="irInicio">INICIO</a>
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
     <div class="container border border-warning border-3 rounded-3 bordeColor mt-5">
		
			<div class="row ">
				<div class="botones">
					<input type="radio" name="tipo" value="login" id="log"  checked onClick="cambiaField(this)"><label for="log">Inicia Sesión</label>
					<input type="radio" name="tipo" value="reg" id="reg" onClick="cambiaField(this)"><label for="reg">Registrarse</label>
				</div>
				<form class="p-5 " id="formLog" action="iniciaSesion">
				  <fieldset>
					  
					  <div class="col form-floating mb-3">
						  <input type="email" class="form-control" id="correoLog" placeholder="name@example.com" name="emailL" required>
						  <label for="correo"><i class="fa-solid fa-envelope me-2"></i>Correo Electrónico</label>
					  </div>
					  <div class="col form-floating mb-3">
						  <input type="password" class="form-control" id="contraLog" placeholder="Contraseña" name="contraL" required>
						  <label for="contra"><i class="fa-solid fa-lock me-2"></i>Contraseña</label>
					  </div>
						
					  
					  
					  	<div class="row mt-5">
							<div class="col-12 text-center d-flex flex-column align-items-center">
								<c:if test="${not empty error}">
									<h5 class="col-4 mb-5 border border-danger border-3 rounded-3 align-self-center p-2 cajError">${error}</h5>
								</c:if>
								<button class="botonsillo colorsillo" type="submit">Entrar</button>
					  		</div>
					  	</div>
					  
					  	<div class="row mt-5">
							<div class="col-12 text-center d-flex justify-content-around">
								
								<button type="button" class="btnGoogle"><a href="#">Inicia sesión con Google</a></button>
								
								
								<button type="button" class="btnFace"><a href="#"><i class="fa-brands fa-facebook-f iconFace"></i>Inicia sesión con Facebook</a></button>
								
								
							</div>
						</div>
				  </fieldset>
					
				</form>
		</div>
		<div class="row ">
			<form class="p-5" id="formReg" action="registrarse">
				  <fieldset>
					  
					  <div class="row row-cols-2">
						  
						  <div class="col-12 col-md-6 form-floating mb-3">
							  <input type="text" class="form-control" id="nomReg" placeholder="Juan" name="nomreg" required>
							  <label for="nomReg" class="ms-2"><i class="fa-solid fa-user me-2"></i>Nombre</label>
						  </div>

						  <div class="col-12 col-md-6 form-floating mb-3">
							  <input type="text" class="form-control" id="apeReg" placeholder="Rojas Rosado" name="apereg" required>
							  <label for="apeReg" class="ms-2"><i class="fa-regular fa-user me-2"></i>Apellidos</label>
						  </div>

						  <div class="col-12 col-md-6 form-floating mb-3">
							  <input type="email" class="form-control" id="correoReg" placeholder="name@example.com" name="emailreg" required>
							  <label for="correo" class="ms-2"><i class="fa-solid fa-envelope me-2"></i>Correo Electrónico</label>
						  </div>

						  <div class="col-12 col-md-6 form-floating mb-3">
							  <input type="password" class="form-control" id="contraReg" placeholder="Contraseña" name="contrareg" required>
							  <label for="contra" class="ms-2"><i class="fa-solid fa-lock me-2"></i>Contraseña</label>
							  <div id="passwordHelpBlock" class="form-text">
								  Tu contraseña debe tener entre 8-20 caractéres, contener números y letras sin espacios o carácter especial.
							  </div>
						  </div>

						  <div class="col-12 col-md-6 form-floating mb-3">
							  <input type="text" class="form-control" id="loc" placeholder="Ronda" name="localreg" required>
							  <label for="loc" class="ms-2"><i class="fa-solid fa-house-chimney me-2"></i>Localidad</label>
						  </div>

						  <div class="col-12 col-md-6 form-floating mb-3">
							  <input type="text" class="form-control" id="dni2" placeholder="24123123B" name="dnireg" pattern="[0-9]{8}[A-Za-z]{1}" required>
							  <label for="dni" class="ms-2"><i class="fa-solid fa-id-card me-2"></i>DNI</label>
						  </div>
					  </div>
					  
					  	<div class="row mt-5">
							<div class="col-12 text-center">
								<button class="botonsillo colorsillo" type="submit">Registrarse</button>
					  		</div>
					  	</div>
					  
					  	<div class="row mt-5">
							<div class="col-12 text-center d-flex justify-content-around">
								
								<button type="button" class="btnGoogle"><a href="#">Registrarse con Google</a></button>
								
								
								<button type="button" class="btnFace"><a href="#"><i class="fa-brands fa-facebook-f iconFace"></i>Registrarse con Facebook</a></button>
								
								
							</div>
						</div>
				  </fieldset>
					
				</form>
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