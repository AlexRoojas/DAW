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
          <a href="verAdmin"><button class="btnAdmin mb-3 mr-3 "> <h5>Usuarios</h5></button></a>
        </div>
        <div class="col">
          <a href="irAdminProd"><button class="btnAdmin mb-3 mr-3 "> <h5>Productos</h5></button></a>
        </div>
        <div class="col">
          <a href="irAdminCitas"><button class="btnAdmin mb-3 mr-3 activo"> <h5>Citas Y Partes</h5></button></a>
        </div>
        <div class="col">
          <a href="verAdminFacts"><button class="btnAdmin mb-3 mr-3 "> <h5>Facturas</h5></button></a>
        </div>
      </div>
     </div>
     <!-- FIN CAJA PRINCIPAL-->
	<div class="col-10 offset-1">
		<table id="tabla" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
		<caption>Tabla de todas las citas</caption>
		  <thead>
		    <tr>
		      <th class="th-sm">Cod Cita</th>
		      <th class="th-sm">Matrícula</th>
		      <th class="th-sm">Marca</th>
		      <th class="th-sm">Modelo</th>
		      <th class="th-sm">Tipo Cita</th>
		      <th class="th-sm">Descripción</th>
		      <th class="th-sm">Fecha</th>
		      <th class="th-sm">Estado</th>
		      <th class="th-sm">DNI Cliente</th>
		      <th class="th-sm">Editar</th>
		      <th class="th-sm">Eliminar</th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach var="citas" items="${listCitas}" varStatus="vs">
		    	<tr>
		    		<td>
		    			<p>${citas.codCita}</p>
		    		</td>
		    		<td>
		    			<p>${citas.matricCoche}</p>
		    		</td>
		    		<td>
		    			<p>${citas.marcaCoche}</p>
		    		</td>
		    		<td>
		    			<p>${citas.modeloCoche}</p>
		    		</td>
		    		<td>
		    			<p>${citas.tipoCita}</p>
		    		</td>
		    		<td>
		    			<p>${citas.descrpCita}</p>
		    		</td>
		    		<td>
		    			<p>${citas.fechaCita}</p>
		    		</td>
		    		<td>
		    			<p>${citas.estadoCita}</p>
		    		</td>
		    		<td>
		    			<p>${citas.dniCli}</p>
		    		</td>
		    		<td>
		    			<form action="modifCita">
		    				<input type="hidden" name="cod" value="${citas.codCita}">
		    				<input type="submit" class="btn btn-info" value="Editar">
		    			</form>
		    		</td>
		    		<td>
		    			<button class="btn btn-danger" value="Eliminar" data-bs-toggle="modal" data-bs-target="#myModal${vs.index}">Eliminar</button>
		    		</td>
		    		
		    	</tr>
		    	
		    	
		    	
            
	            <div class="modal fade" id="myModal${vs.index}"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	            <form action="borracita">
   					<input type="hidden" name="cod" value="${citas.codCita}">
					  <div class="modal-dialog modal-dialog-centered">
					    <div class="modal-content">
					      <div class="modal-header d-flex justify-content-end">
					        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
					      </div>
					      <div class="modal-body">
					        <h5>¿Estás seguro de que quieres borrar esta Cita?</h5>
					        <p>${citas.codCita}</p>
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
		
		<h4 class="mt-5">Actualiza o crea una Cita</h4>
		<form action="actuCita" class="my-5">
			<div class="d-flex justify-content-around flex-wrap">
	            <div class="col-2 m-2">
	              <p id="matr">Cod Cita</p>
	              <c:choose>
			            	<c:when test="${not empty si}">
				            	<input name="Cod" type="text" class="formuinpu" aria-label="Código de la cita" aria-describedby="citas" value="${lacita.codCita}" readonly>
			            	</c:when>
			            	<c:otherwise>
				            	<input name="Cod" type="text" class="formuinpu" aria-label="Código de la cita" aria-describedby="matr" value="${lacita.codCita}" required>    
			            	</c:otherwise>
	            	</c:choose>
	              
	            </div>
	            <div class="col-2 m-2">
	              <p id="marc">Matricula</p>
	              <input name="Matricula" type="text" class="formuinpu" aria-label="Matricula Coche" aria-describedby="marc" value="${lacita.matricCoche}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Marca</p>
	              <input name="Marca" type="text" class="formuinpu" aria-label="Marca Coche" aria-describedby="mode" value="${lacita.marcaCoche}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Modelo</p>
	              <input name="Modelo" type="text" class="formuinpu" aria-label="Modelo Coche" aria-describedby="mode" value="${lacita.modeloCoche}">
	            </div>
	            <div class="col-6 m-2">
	              <p id="mode">Descripción</p>
	              <textarea name="descrp"  class="form-control formuinpu" aria-label="Descripcion de la cita"  id="descrp" style="height: 100px" value="">${lacita.descrpCita}</textarea>
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">Fecha</p>
	              <input name="Fecha" type="text" class="formuinpu" aria-label="Fecha de la cita" aria-describedby="mode" value="${lacita.fechaCita}">
	            </div>
	            <div class="col-2 m-2">
	              <p id="mode">DNI Cliente</p>
	              <input name="DNI" type="text" class="formuinpu" aria-label="DNI del cliente" aria-describedby="mode" value="${lacita.dniCli}">
	            </div>
	            <div class="col-2 m-2">
	             <p class="fw-bold">Tipo Cita</p>
            	 <p>Tipo actual: ${lacita.tipoCita}</p>
	             
	              <select name="tipoCit" class="form-select" aria-label="Elegir Tipo Cita">
	                
	                <option value="neumaticos">Neumaticos</option>
	                <option value="aceite">Aceite</option>
	                <option value="mantenimiento">Mantenimiento</option>
	                <option value="revision">Revisión</option>
	              </select>
	            </div>
	            <div class="col-2 m-2">
	             <p class="fw-bold">Estado</p>
            	 <p>Estado actual: ${lacita.estadoCita}</p>
	             
	              <select name="estadoCita" class="form-select" aria-label="Elegir Tipo Cita">
	                <option value="Recibido">Recibido</option>
	                <option value="Aceptado">Aceptado</option>
	                <option value="Proceso">En Proceso</option>
	                <option value="Finalizado">Finalizado</option>
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
	       
	       
	       
	       
	       <!------------------------------------PARTES---------------------------------- -->
		<div class="col-12 my-5 text-center">
			<h4 id="pp">PARTES</h4>
		</div>
			<table id="tabla2" class="table table-striped table-bordered table-sm" cellspacing="0" width="100%">
			  <thead>
			    <tr>
			      <th class="th-sm">Cod Parte</th>
			      <th class="th-sm">Mecánico</th>
			      <th class="th-sm">Matrícula</th>
			      <th class="th-sm">Costes Total</th>
			      <th class="th-sm">Estado</th>
			      <th class="th-sm">Fecha</th>
			      <th class="th-sm">Productos usados</th>
			      <th class="th-sm">Cod Cita</th>
			      <th class="th-sm">Editar</th>
			      <th class="th-sm">Eliminar</th>
			    </tr>
			  </thead>
			  <tbody>
			    <c:forEach var="parte" items="${listPart}" varStatus="vs">
			    	<tr>
			    		<td>
			    			<p>${parte.codParte}</p>
			    		</td>
			    		<td>
			    			<p>${parte.codmecParte}</p>
			    		</td>
			    		<td>
			    			<p>${parte.matricParte}</p>
			    		</td>
			    		<td>
			    			<p>${parte.costesTotal}</p>
			    		</td>
			    		<td>
			    			<p>${parte.estadoParte}</p>
			    		</td>
			    		<td>
			    			<p>${parte.fechaParte}</p>
			    		</td>
			    		<td>
			    			<p>${parte.productosParte}</p>
			    		</td>
			    		<td>
			    			<p>${parte.codcitaParte}</p>
			    		</td>
			    		<td>
			    			<form action="modifParte">
			    				<input type="hidden" name="codP" value="${parte.codParte}">
			    				<input type="submit" class="btn btn-info" value="Editar">
			    			</form>
			    		</td>
			    		<td>
			    			<button class="btn btn-danger" value="Eliminar" data-bs-toggle="modal" data-bs-target="#myxdd${vs.index}">Eliminar</button>
			    		</td>
			    		
			    	</tr>
			    	
			    	
			    	
	            
		            <div class="modal fade" id="myxdd${vs.index}"  tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		            <form action="borraparte">
	   					<input type="hidden" name="codP" value="${parte.codParte}">
						  <div class="modal-dialog modal-dialog-centered">
						    <div class="modal-content">
						      <div class="modal-header d-flex justify-content-end">
						        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
						      </div>
						      <div class="modal-body">
						        <h5>¿Estás seguro de que quieres borrar este Parte?</h5>
						        <p>${parte.codParte}</p>
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
			
			<h4 class="mt-5">Actualiza o crea un Parte</h4>
			<form action="actuParte">
				<div class="d-flex justify-content-around flex-wrap">
		            <div class="col-2 m-2">
		              <p id="matr">Cod Parte</p>
		              <c:choose>
			            	<c:when test="${not empty si}">
				            	<input name="codP" type="number" class="formuinpu" aria-label="Código del parte" aria-describedby="matr" value="${elparte.codParte}" readonly>
			            	</c:when>
			            	<c:otherwise>
				            	<input name="codP" type="number" class="formuinpu" aria-label="Código del parte" aria-describedby="matr" value="${elparte.codParte}" required>    
			            	</c:otherwise>
	            	</c:choose>
		              
		            </div>
		            <div class="col-2 m-2">
		              <p id="marc">Mecánico</p>
		              <input name="mec" type="text" class="formuinpu" aria-label="Código del mecánico" aria-describedby="marc" value="${elparte.codmecParte}">
		            </div>
		            <div class="col-2 m-2">
		              <p id="mode">Matrícula</p>
		              <input name="matr" type="text" class="formuinpu" aria-label="Matricula Coche" aria-describedby="mode" value="${elparte.matricParte}">
		            </div>
		            <div class="col-2 m-2">
		              <p id="mode">Costes Total</p>
		              <input name="coste" type="text" class="formuinpu" aria-label="Costes total" aria-describedby="mode" value="${elparte.costesTotal}">
		            </div>
		            <div class="col-2 m-2">
		              <p id="mode">Fecha</p>
		              <input name="fech" type="text" class="formuinpu" aria-label="Fecha del parte" aria-describedby="mode" value="${elparte.fechaParte}">
		            </div>
		            <div class="col-2 m-2">
		              <p id="mode">Productos usados</p>
		              <input name="prods" type="text" class="formuinpu" aria-label="Productos utilizados" aria-describedby="mode" value="${elparte.productosParte}">
		            </div>
		            <div class="col-2 m-2">
		              <p id="mode">Cod Cita</p>
		              <input name="cita" type="number" class="formuinpu" aria-label="Código de la cita aparte" aria-describedby="mode" value="${elparte.codcitaParte}">
		            </div>
		            <div class="col-2 m-2">
		             <p class="fw-bold">Estado</p>
	            	 <p>Estado actual: ${elparte.estadoParte}</p>
		             
		              <select name="estad" class="form-select" aria-label="Elegir Tipo Cita">
		                
				                <option value="En Espera">En Espera</option>
				                <option value="En Trabajo">En Trabajo</option>
				                <option value="Finalizado">Finalizado</option>
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