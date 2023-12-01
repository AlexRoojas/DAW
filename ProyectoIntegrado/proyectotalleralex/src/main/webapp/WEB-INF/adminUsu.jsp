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

    <title>Taller AR Customs | Administración</title>
    
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/js/all.min.js"></script>
    <script src="/webjars/jquery/jquery.min.js"></script>
    <script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	  <link rel="stylesheet" href="estilo/estiloPrincipal.css"/>
    <link rel="stylesheet" href="estilo/estiloAdmin.css"/>
    <link rel="shortcut icon" type="image/x-icon" href="img/icon.png">
    
    
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.css">
  
	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>
    
    <!--  script>
	    $(document).ready( function () {
	        $('#tabla').DataTable();
	    } );
    </script>-->
    
    <script>
    	$(document).ready(function(){
	    	
		    $(".btnElimina").click(function() {
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
                 
               </div>
               <div class="col-4 d-flex justify-content-around align-items-center">
                 
                 <button class="btn letraAma fw-bold" type="button"><i class="fa-solid fa-user me-2"></i>ADMIN</button>
                 
                 <ul class="dropdown-menu">
                   <li class="dropdown-item">Productos en total : <span>2</span></li>
                   <li class="dropdown-item">Total: <span>300,00</span>€</li>
                   <li><hr class="dropdown-divider"></li>
                   <li class="px-2"><button type="button" class="btn  mb-2 mb-md-0 btn-subs btn-block">Ver Cesta</button></li>
                 </ul>
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
                           <a class="nav-link px-3 py-4" aria-current="page" href="irInicio">VOLVER AL INICIO</a>
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
     <div class="col-10 offset-1 ">
      <div class="row d-flex justify-content-center my-5">
        <div class="col">
          <a href="irAdminEsta"><button class="btnAdmin mb-3 mr-3"> <h5>Estadística</h5></button></a>
        </div>
        <div class="col">
          <a href="verAdmin"><button class="btnAdmin mb-3 mr-3 activo"> <h5>Usuarios</h5></button></a>
        </div>
        <div class="col">
          <a href="irAdminProd"><button class="btnAdmin mb-3 mr-3 "> <h5>Productos</h5></button></a>
        </div>
        <div class="col">
          <a href="irAdminCitas"><button class="btnAdmin mb-3 mr-3 "> <h5>Citas Y Partes</h5></button></a>
        </div>
        <div class="col">
          <a href="verAdminFacts"><button class="btnAdmin mb-3 mr-3 "> <h5>Facturas</h5></button></a>
        </div>
      </div>
     </div>
     <!-- FIN CAJA PRINCIPAL-->
	<div class="col-10 offset-1">
		<table id="tabla" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
		<caption>Tabla de todos los usuarios</caption>
		  <thead>
		    <tr>
		      <th class="th-sm">DNI</th>
		      <th class="th-sm">Nombre</th>
		      <th class="th-sm">Apellidos</th>
		      <th class="th-sm">Email</th>
		      <th class="th-sm">Contraseña</th>
		      <th class="th-sm">Localidad</th>
		      <th class="th-sm">Tipo Usuario</th>
		      <th class="th-sm">Modificar</th>
		      <th class="th-sm">Eliminar</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="usu" items="${listaUsu}" varStatus="vs">
		    	<tr>
		    		<td>
		    			<p>${usu.dniusu}</p>
		    		</td>
		    		<td>
		    			<p>${usu.nombreusu}</p>
		    		</td>
		    		<td>
		    			<p>${usu.apellusu}</p>
		    		</td>
		    		<td>
		    			<p>${usu.emailusu}</p>
		    		</td>
		    		<td>
		    			<p>${usu.contrausu}</p>
		    		</td>
		    		<td>
		    			<p>${usu.localidadusu}</p>
		    		</td>
		    		<td>
		    			<p>${usu.tipousu}</p>
		    		</td>
		    		<td>
		    			<form action="modifUsu">
		    				<input type="hidden" name="dni" value="${usu.dniusu}">
		    				<input type="submit" class="btn btn-info" value="Editar">
		    			</form>
		    		</td>
		    		<td>
		    			<button class="btn btn-danger" value="Eliminar" data-bs-toggle="modal" data-bs-target="#myModal${vs.index}">Eliminar</button>
		    		</td>
		    		
		    	</tr>
		    	
		    	
		    	
            
	            <div class="modal fade" id="myModal${vs.index}"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	            <form action="eliminUsu">
   					<input type="hidden" name="dni" value="${usu.dniusu}">
					  <div class="modal-dialog modal-dialog-centered">
					    <div class="modal-content">
					      <div class="modal-header d-flex justify-content-end">
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body">
					        <h5>¿Estás seguro de que quieres borrar este Usuario?</h5>
					        <p>${usu.nombreusu} ${usu.apellusu} con dni: ${usu.dniusu}</p>
					      </div>
					      <div class="modal-footer">
					        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
					        <input type="submit" class="btn btn-primary " value="Eliminar">
					      </div>
					    </div>
					  </div>
				  </form>
				</div>
		    	
		    	
		    </c:forEach>
		  </tbody>
		</table>
		
		<h4 class="mt-5">Actualiza o crea un Usuario</h4>
		<form action="actualizaUsu">
			<div class="d-flex justify-content-around flex-wrap">
	            <div class="col-2 m-2">
	              <p id="matr">DNI</p>
	              <input name="dni" type="text" class="formuinpu" aria-label="Matricula" aria-describedby="matr" value="${elusu.dniusu}" readonly>
	            </div>
	            <div class="col-2 m-2">
	              <p id="marc">Nombre</p>
	              <input name="nombre" type="text" class="formuinpu" aria-label="Marca Coche" aria-describedby="marc" value="${elusu.nombreusu}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Apellidos</p>
	              <input name="apell" type="text" class="formuinpu" aria-label="Modelo Coche" aria-describedby="mode" value="${elusu.apellusu}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Email</p>
	              <input name="email" type="text" class="formuinpu" aria-label="Modelo Coche" aria-describedby="mode" value="${elusu.emailusu}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Contraseña</p>
	              <input name="contra" type="text" class="formuinpu" aria-label="Modelo Coche" aria-describedby="mode" value="${elusu.contrausu}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Localidad</p>
	              <input name="loca" type="text" class="formuinpu" aria-label="Modelo Coche" aria-describedby="mode" value="${elusu.localidadusu}">
	            </div>
	            <div class="col-2 m-2">
	             <p id="tipCit" class="fw-bold">Tipo Usuario</p>
            	 <p>Tipo actual: ${elusu.tipousu}</p>
	             
	              <select name="tipoUsu" class="form-select" aria-label="Elegir Tipo Cita">
	                
	                <option value="C">Cliente</option>
	                <option value="M">Mecánico</option>
	                <option value="A">Administrador</option>
	              </select>
	            </div>
	            
	            <c:choose>
	            	<c:when test="${not empty si}">
	            		<div class="col-12">
			            	<input type="submit" class="btn btn-primary" value="Modificar">
			            </div>
	            	</c:when>
	            	<c:otherwise>
	            		<div class="col-12">
			            	<input type="submit" class="btn btn-primary" value="Crear">
			            </div>
	            	</c:otherwise>
	            </c:choose>
	            
	          </div>
	       </form>   
		
		
	</div>

     

	</div>
	  
	  
	  

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    
  </body>
</html>