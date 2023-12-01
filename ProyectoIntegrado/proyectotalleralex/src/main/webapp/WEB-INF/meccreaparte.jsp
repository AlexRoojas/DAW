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

    <title>Taller AR Customs | Crea Parte Mecánico</title>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	   
  	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
  	<link rel="stylesheet" href="estilo/estiloMecanico.css"/>
  	<link rel="stylesheet" href="estilo/estiloTienda.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    
    
    <link rel="stylesheet" href="https://fonts.sandbox.google.com/css2?family=Material+Symbols+Outlined:opsz,wght,FILL,GRAD@48,400,0,0" />
    
    
    
    <script>
    $(document).ready(function(){
    	
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
		                    
		                    <c:choose>
		                    	<c:when test="${sessionScope.usuario.tipousu == 'M'}">
		                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block "><a href="verEstadoCita" class="text-decoration-none sinDeco d-block encesta">Ver Citas</a></button></li>
		                    	</c:when>
		                    	<c:otherwise>
		                    		<c:choose>
				                    	<c:when test="${not empty sessionScope.codigoFact}">
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Estado Cita</button></li>
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta">Última Factura</a></button></li>
				                    	</c:when>
				                    	<c:otherwise>
				                    		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Estado Cita</button></li>
					                  		<li class="p-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-subsC btn-block disabled"><a href="cargaFactura" class="text-decoration-none sinDeco d-block encesta">Última Factura</a></button></li>
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
    
    <div class="container mt-3">
      
      <nav style="--bs-breadcrumb-divider: url(&#34;data:image/svg+xml,%3Csvg xmlns='http://www.w3.org/2000/svg' width='8' height='8'%3E%3Cpath d='M2.5 0L1 1.5 3.5 4 1 6.5 2.5 8l4-4-4-4z' fill='currentColor'/%3E%3C/svg%3E&#34;);" aria-label="breadcrumb">
          <ol class="breadcrumb">
            <li class="breadcrumb-item text-black"><a href="irInicio" aria-label="Volver a la página principal" class="text-decoration-none"><i class="fa-solid fa-house"></i> Inicio</a></li>
            <li class="breadcrumb-item" ><a href="verCitasMec" aria-label="Volver a las citas" class="text-decoration-none"> Citas</a></li>
            <li class="breadcrumb-item" ><a href="verPartes" aria-label="Volver a las citas" class="text-decoration-none"> Partes</a></li>
            <li class="breadcrumb-item active " aria-current="page"> Crear Parte</li>
          </ol>
          
      </nav>
      
    </div>
    
    
     <!-- CAJA PRINCIPAL -->
    <div class="col-10 offset-1 my-5 border border-warning border-3">
      <div class="container-fluid">
        <div class="row">
          <div class="col-2 m-2 mb-5">
            <p id="tipCit" class="fw-bold">Cita</p>
            <form action="vercreaParte">
            <select class="form-select" name="codCita" aria-label="Elegir Cita">
              <option selected>Elige tu Cita</option>
              <c:forEach var="cita" items="${listacitas}">
	              <option value="${cita.codCita}">Cod : ${cita.codCita} , Matricula: ${cita.matricCoche}</option>
              </c:forEach>
            </select>
          </div>
          <div class="col-2 m-2 mb-5">
          	<input type="submit" class="btn btn-primary mt-4" value="Buscar Cita">
         		 </form>
          </div>
            
          
          
         
         <div class="col-12 cajaCrear d-flex justify-content-around flex-wrap ">
           <div class="col-4 m-2 text-center">
             <p class="fw-bold">Vehículo:<span class="fw-normal"> ${miCita.marcaCoche} ${miCita.modeloCoche} - ${miCita.matricCoche}</span></p>
           </div>
           <div class="col-2 m-2 text-center">
             <p class="fw-bold">Tipo Cita: <span class="fw-normal"> ${miCita.tipoCita} </span></p>
           </div>
           <div class="col m-2 text-center">
             <p class="fw-bold">Descripción </p>
             <textarea name="descrp"  class="form-control descrip"  id="descrp" style="height: 100px" readonly>${miCita.descrpCita}</textarea>
           </div>

            
          </div>
        </div>
        <div class="col-2 offset-5 text-center">
        	<form action ="creaParte">
	        	<input type="submit" class="btn btn-primary mt-4 w-100" value="Crear Parte">
	       </form>
        </div>
        
        
        <div class="row my-5">
          <h4>Productos para añadir</h4>
          
          <div class="col-12 col-md-7">
            <form  class="d-flex offset-1" action="vercreaParte">
              <input class="form-control me-2 buscad" name="busca" type="search" placeholder="Buscar..." aria-label="Buscador Principal de artículos" value="${buscado}">
              <button type="submit" class="btn amarillo">
              <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-search" viewBox="0 0 16 16">
                <path d="M11.742 10.344a6.5 6.5 0 1 0-1.397 1.398h-.001c.03.04.062.078.098.115l3.85 3.85a1 1 0 0 0 1.415-1.414l-3.85-3.85a1.007 1.007 0 0 0-.115-.1zM12 6.5a5.5 5.5 0 1 1-11 0 5.5 5.5 0 0 1 11 0z"/>
              </svg>
              </button>  
              
            </form>
          </div>
          <c:forEach var="productos" items="${miListaProductos}">
			<form class="formProducto" action="verProducto">
		      <div class="row">
		        <div class="col-10 col-md-10 offset-1 mt-5 d-flex flex-column flex-md-row filita p-0 pb-md-4">
		        
		        	<input class="codProd" type="hidden" name="codigoProducto" value="${productos.codProd}">
		        	
		          <div class="col-10 offset-1 col-md-2">
			          	
		           	<img src="img/prod/${productos.imgProd}" class="img-thumbnail prodImg" alt="">
		          </div>
			
			          <div class="offset-1 col-10 col-md-6 d-flex flex-column ">
			            <h4 class="nomProd">${productos.nomProd}</h4>
			            <input class="puntuacion" type="hidden"  value="${productos.puntuacionProd}">
			            
			            <div class="cajaEstrellas">
			            
			            <c:forEach var="i" begin="1" end="${productos.puntuacionProd}">
				            <span class="material-symbols-outlined starAma">star</span>
			            </c:forEach>
			            
			            </div>
			            
			            <p class="desProd">${productos.descripProd}</p>
			            <a href="#" class="link-primary linkProd">Más Información</a>
			          </div>
			
			          <div class="offset-1 col-10 col-md-2 d-flex flex-column text-center justify-content-center verdesito">
			            <span class="precProd" >${productos.precioProd} $  </span>
			            <!--  fmt:formatNumber value="${productos.precioProd}" type="currency" />-->
			            <span class=" mb-4">Disponible</span>
		      </form>
			            
			            <form class="formCesta" action="anadirCesta">
			            
			            	<input name="codigoProd" type="hidden" value="${productos.codProd}">
			            	<input name="sitio" type="hidden" value="parte">
			            	<c:choose>
			                  	<c:when test="${not empty sessionScope.usuario}">
			                  		<button type="button" class="btn  mb-2 mb-md-0 btn-carro btn-block">Añadir Producto</button>
			                  	</c:when>
			                  	<c:otherwise>
			                  	<div data-bs-toggle="tooltip" data-bs-placement="bottom" title="Inicia sesión para comprar">
			                  		<button type="button" class="btn  mb-2 mb-md-0 btn-carro btn-block disabled" data-bs-toggle="tooltip" data-bs-placement="top" title="Inicia sesión para comprar">Añadir Cesta</button>
		                  		</div>
			                  	</c:otherwise>
		                  	</c:choose>
		                  	
			            	
			            </form>
			          </div>
		          
		         
		        </div>
		      </div>
		       
		      </c:forEach>
          
          
        </div>
        <div class="row my-5 d-flex justify-content-around">
          <h4 class="col text-center">Total Productos Añadidos: <span>${prodTotal}</span></h4>
          <h4 class="col text-center">Precio total: <span>${precioTotal} $</span></h4>
        </div>
       <form action ="creaParte">
        	<input type="submit" class="btn btn-primary mt-4" value="Crear Parte">
       </form>
      </div>
    </div>
     <!-- FIN CAJA PRINCIPAL-->
     
     
     
     </div>
</body>
</html>