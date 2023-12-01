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

    <title>Taller AR Customs | Página Principal</title>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key="></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	   
  	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    
    <script>
	    $(document).ready(function(){
	    	
	    	$(document).on('click','.cerSes',function(){
	    		$.getJSON('cerrarSesion','',function(){});
	    	});
	    	
	    	var objProd = JSON.parse($("#jsonprodCompleto").val());
	    	
	    	var objProdOrd = ordenarGenerico(objProd,"punProd","DESC");
	    	
	    	var claveObjOrd = Object.keys(objProdOrd);
	    	
	    	var arrayProd = [];
	    	
	    	for(let i =0; i<5 ; i++){
	    		arrayProd.push(objProdOrd[claveObjOrd[i]]);
	    	}
	    	
	    	pintarProductos(arrayProd);
	    	
	    	$(".btnVerCesta").click(function() {
				$(this.closest("form")).submit();
			});
	    	
	    	$(".btn-8").click(function() {
				$(this.closest("form")).submit();
			});	
	    	
	    	
	    	$(".cajaTienda").click(function() {
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
	    	
	    	//------------METODOS-----------------
	    	
	    	function pintarProductos(arrayProd){
	    		for(let i = 0; i<arrayProd.length; i++){
	    			$(".imgProd"+i).attr("src", "img/prod/"+arrayProd[i].imgProd);
	    			$(".nomProd"+i).text(arrayProd[i].nomProd);
	    			$(".desProd"+i).text(arrayProd[i].desProd);
	    			$(".codProd"+i).val(arrayProd[i].codProd);
	    		}
	    	}
	    	
	    	
	    	
	    	
	    	function ordenarGenerico(objeto,atributoOrdenar,tipoOrdenacion){

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
                          <a class="nav-link px-3 py-4 activo" aria-current="page" href="irInicio" title="Enlace para ir al inicio">INICIO</a>
                        </li>
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4" href="irTienda" title="Enlace para ir la tienda">TIENDA</a>
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
     <!--CARROUSEL--> 
     <div class="mb-5" style="width: 100%;">
       <div class="col">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Primera publi"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Segunda Publi"></button>
            <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Tercera Publi"></button>
          </div>
          <div class="carousel-inner">
            <div class="carousel-item active">
              <a href="irTienda"><img src="img/of1.png" class="d-block w-100 h-100" alt=""></a>
            </div>
            <div class="carousel-item">
               <a href="irTienda"><img src="img/publi2.png" class="d-block w-100 h-100" alt=""></a>
            </div>
            <div class="carousel-item">
               <a href="irTienda"><img src="img/publi3.png" class="d-block w-100 h-100" alt=""></a>
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev" aria-label="Retroceder imagen">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Anterior</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next" aria-label="Avanzar imagen">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Siguiente</span>
          </button>
        </div>
       </div>
     </div>
     <!--FIN CARROUSEL--> 
		  
     <!--CONTENEDOR ELEGIR-->
     <div class=" d-flex  justify-content-around mb-5">
     
       <div class="col-12 col-md-3 contCompr text-center">
        <h3>TIENDA</h3>
         <div class="over text-center cajaTienda">
           <h3><a class="nav-link px-3 py-4 text-black d-block" href="irTienda" title="Enlace para acceder a la tienda">ACCESO A LA TIENDA</a></h3>
         </div>
         <img class="fotoCaja" src="img/fotoTienda.png" alt="">
        </div>

        <div class="col-12 col-md-3 contCompr text-center">
        <h3>PIDE TU CITA</h3>
          
          <div class="over text-center">
            <h3><a class="nav-link px-3 py-4 text-black d-block" href="cargaCita" title="Enlace para ir a las citas">CITAS</a></h3>
          </div>
          <img class="fotoCaja" src="img/cita.jpg" alt="">
         </div>
        
      </div>
		  <!--FIN CONTENEDOR ELEGIR--> 
		  
      <!--CONTENEDOR OFERTAS-->
      
      <input id="jsonprodCompleto" type="hidden" value='${jsonprodCompleto}'> 
      
      <div class="pt-5">
        <h3 class="text-center mb-5 xprod">PRODUCTOS MÁS VALORADOS</h3>
        <div class="container-fluid d-flex flex-column flex-lg-row justify-content-center">
          <div class="card col-12 col-lg-4">
          <form class="formProducto" action="verProducto">
          <input class="codProd0" type="hidden" name="codigoProducto" value="">
            <div class="product card-body">
              <div class="text-center">
                <img src="img/" alt="Primer Producto más valorado" class="imgProd0">
              </div>
              
              <h4 class="nomProd0"></h4>
              <p class="desProd0 prodDes"></p>
              <button class="custom-btn btn-8" aria-label="Ir a la página del producto"><span>Ver Producto</span></button>
            </div>
             </form>
          </div>
         
          
          <div class="col-12 col-lg-6 d-flex flex-wrap flex-row justify-content-around">
          
          
          
            <div class="card col-12 col-lg-4 m-2">
            <form class="formProducto" action="verProducto">
            <input class="codProd1" type="hidden" name="codigoProducto" value="">
              <div class="card-body product">
                <div class="text-center">
                  <img src="img/" alt="Segundo Producto más valorado" class="imgProd1">
                </div>
                <h4 class="nomProd1"></h4>
                <p class="desProd1 prodDes"></p>
              </div>
              <div class="card-footer">
                <button class="custom-btn btn-8" aria-label="Ir a la página del producto"><span>Ver Producto</span></button>
              </div> 
            </form>   
            </div>
           
            
            
            
            <div class="card col-12 col-lg-4 m-2">
            <form class="formProducto" action="verProducto">
            <input class="codProd2" type="hidden" name="codigoProducto" value="">
              <div class="card-body product">
                <div class="text-center">
                  <img src="img/" alt="Tercer Producto más valorado" class="imgProd2">
                </div>
                <h4 class="nomProd2 "></h4>
                <p class="desProd2 prodDes"></p>
              </div>
              <div class="card-footer">
                <button class="custom-btn btn-8" aria-label="Ir a la página del producto"><span>Ver Producto</span></button>
              </div> 
               </form>
            </div>
           
            
            
            
            <div class="card col-12 col-lg-4 m-2">
            <form class="formProducto" action="verProducto">
            <input class="codProd3" type="hidden" name="codigoProducto" value="">
              <div class="card-body product">
                <div class="text-center">
                  <img src="img/" alt="Cuarto Producto más valorado" class="imgProd3">
                </div>
                <h4 class="nomProd3 "></h4>
                <p class="desProd3 prodDes"></p>
              </div>
              <div class="card-footer">
                <button class="custom-btn btn-8" aria-label="Ir a la página del producto"><span>Ver Producto</span></button>
              </div> 
              </form>
            </div>
            
            
            
            
            <div class="card col-12 col-lg-4 m-2">
            <form class="formProducto" action="verProducto">
            <input class="codProd4" type="hidden" name="codigoProducto" value="">
              <div class="card-body product">
                <div class="text-center">
                  <img src="img/" alt="Último Producto más valorado" class="imgProd4">
                </div>
                <h4 class="nomProd4 "></h4>
                <p class="desProd4 prodDes"></p>
              </div>
              <div class="card-footer">
                <button class="custom-btn btn-8" aria-label="Ir a la página del producto"><span>Ver Producto</span></button>
              </div> 
              </form>
            </div>
            
          </div>
        </div>

      </div>
      <!--FIN CONTENEDOR OFERTAS--> 

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