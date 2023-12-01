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
    
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/chart.js@latest/dist/Chart.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
    
    
    <script type="text/javascript">
    
    $(document).ready(function(){
    	
    	var objProd = JSON.parse($("#illo").val());
    	
    	var claveObjOrd = Object.keys(objProd);
    	
    	const arrayNom = [];
    	const arrayData = [];
    	const arrayData2 = [];
    	
    	$(claveObjOrd).each(function (i,k){
    		arrayNom.push(objProd[k].nomProd);
    		arrayData.push(objProd[k].uniProd);
    		arrayData2.push(objProd[k].punProd);
    	});
    	
    	
    	const labels =arrayNom;
    	const data = {
    	  labels: labels,
    	  datasets: [
    	    {
    	      label: 'Unidades',
    	      data: arrayData,
    	      borderColor: 'rgb(255, 196, 0)',
    	      backgroundColor: 'rgba(75, 192, 192, 0.7)',
    	    },{
   	    	  label: 'Puntuación',
      	      data: arrayData2,
      	      borderColor: 'rgb(75, 192, 192)',
      	      backgroundColor: 'rgba(255, 196, 0, 0.7)',
    	    }
    	  ]
    	};
    	
    	
    	
    	const config = {
    			  type: 'bar',
    			  data: data,
    			  options: {
    				indexAxis: 'y',
    			    responsive: true,
    			    plugins: {
    			      legend: {
    			        position: 'top',
    			      },
    			      title: {
    			        display: true,
    			        text: 'Productos'
    			      }
    			    }
    			  },
    			};
    	
    	const myChart = new Chart(
				document.getElementById('myChart'),
				config
			);
    	
    	
    	
      
    });
    </script>
</head>
<body>
	<input type="hidden" id="illo" value='${listProductos}'>
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
          <a href="irAdminEsta"><button class="btnAdmin mb-3 mr-3 activo"> <h5>Estadística</h5></button></a>
        </div>
        <div class="col">
          <a href="verAdmin"><button class="btnAdmin mb-3 mr-3"> <h5>Usuarios</h5></button></a>
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
		<canvas id="myChart"></canvas>
		
		
		
	</div>

     

	</div>
	  
	  
	  

    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

    
  </body>
</html>