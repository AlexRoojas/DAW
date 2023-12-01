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

    <title>Taller AR Customs | Citas Mecánico</title>
    
    <script src="https://maps.googleapis.com/maps/api/js?v=3.exp&key=AIzaSyBTSt9QLWeHKFpWWPtgXrkApb6oWdWec90"></script>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	   
  	<link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
  	<link rel="stylesheet" href="estilo/estiloMecanico.css"/>
  	<link rel="stylesheet" href="estilo/estiloTienda.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    
    
    
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
                    <div class="collapse navbar-collapse justify-content-center " id="navbarScroll">
                      
                      <ul class="nav barrita">
                        <li class="nav-item">
                          <a class="nav-link px-3 py-4 " aria-current="page" href="irInicio">INICIO</a>
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
            <li class="breadcrumb-item active " aria-current="page"> Citas</li>
          </ol>
          
      </nav>
      
    </div>
    
    <!-- CONTENEDOR PRINCIPAL -->
    
    <h4 class="text-center my-5">Bienvenido <span>${usuario.nombreusu}</span>, estas son las citas.</h4>
     <a href="verPartes" title="Página para ver todas las facturas"><button class="offset-3 offset-md-9 col-md-2 btnDet mb-3 mr-3 btn-indigo">Ir a las facturas</button></a>
    <div class="col-md-10 offset-md-1 d-flex justify-content-center ">
       
       <div class="container-fluid">
        <div class="row">
        
        
        
        <div class="accordion" id="accordionExample">
		  
		
        
	       <c:forEach var="cita" items="${listaCitas}" varStatus="indice">
	       		
	       		<div class="accordion-item">
	       		
				    <h2 class="accordion-header" id="headingOne">
				      <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapse${indice.index}" aria-expanded="true" aria-controls="collapseOne">
				        <p class="fw-bold">Código Cita:<span class="fw-normal"> ${cita.codCita}</span></p>
				      </button>
				    </h2>
				    
				    <div id="collapse${indice.index}" class="accordion-collapse collapse " aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				      <div class="accordion-body">
	        	       		<div class="col-12 cajagrande d-flex justify-content-around flex-wrap border border-warning border-3 my-2">
				            
				            <div class="col-md-2 m-2">
				              <p class="fw-bold">Matrícula: <span class="fw-normal"> ${cita.matricCoche}</span></p>
				            </div>
				            <div class="col-md-2 m-2">
				              <p class="fw-bold">Marca: <span class="fw-normal"> ${cita.marcaCoche}</span></p>
				            </div>
				            <div class="col-md-2 m-2">
				              <p class="fw-bold">Modelo: <span class="fw-normal"> ${cita.modeloCoche}</span></p>
				            </div>
				            
				            <div class="col-md-2 m-2">
				              <p class="fw-bold">Fecha: <span class="fw-normal"> ${cita.fechaCita}</span></p>
				            </div>
				            <div class="col-md-2 m-2">
				              <p class="fw-bold">DNI Cliente: <span class="fw-normal"> ${cita.dniCli}</span></p>
				            </div>
				            <div class="col-5 m-2">
				              <p class="fw-bold">Descripción: <span class="fw-normal"> ${cita.descrpCita}</span></p>
				            </div>
				            <div class="col-md-3 m-2">
				              <span id="tipCit" class="fw-bold mb-2">Estado Actual : </span class="fw-normal mb-2">${cita.estadoCita}</span></span>
				              <form action="actualizaEstado">
				              <input type="hidden" name="codiguito" value="${cita.codCita}">
				              <select name="estado" class="form-select" aria-label="Elegir Tipo Cita">
				                <option selected>Elige una opción</option>
				                <option value="Recibido">Recibido</option>
				                <option value="Aceptado">Aceptado</option>
				                <option value="Proceso">En Proceso</option>
				                <option value="Finalizado">Finalizado</option>
				                
				              </select>
				              
				            </div>
				            <div class="col-md-2 m-2 d-flex flex-wrap align-content-center">
				            	<input type="submit" class="btn btn-primary" value="Actualizar estado">
				            	</form>
				            </div>
				          </div>
				      </div>
				      
				    </div>
				  </div>
	       		
	       		
	       		

	          
	       </c:forEach>
       
       </div>
       
       </div>
      </div>
      
    </div> 
    
    
    <!-- FIN CONTENEDOR PRINCIPAL --> 
     
     
     
     </div>
</body>
</html>