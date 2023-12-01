/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//----------------------------------------------------------------------

    function geoLocaliza(){ // función que obtiene la latitud y longitud del 
                          // objeto geolocation del objeto navigator de nuestro navegador
                         //  mostrando en un mapa de Google Maps nuestra posicion.                  
        // Try HTML5 geolocation
         if(navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(
                   function(position) {
                        var pos = new google.maps.LatLng(position.coords.latitude,
                                                         position.coords.longitude);
                            
                        map = new google.maps.Map(document.getElementById("mapa"),
                                                  {zoom:10,center:pos});  
                    });//funtion                       
           }
        else alert("Tu navegador no soprta Geopocalización");  
      }
  //---------------------------------------------------------------------  
  function mapa(){
      var textoBoton=document.getElementById("bmapa").textContent;
       if (textoBoton=="Donde Estoy? "){
           document.getElementById("mapa").style.display='block';
           document.getElementById("bmapa").textContent="OcultarMapa";
           geoLocaliza();
       }
       else {
           document.getElementById("mapa").style.display='none';
           document.getElementById("bmapa").textContent="Donde Estoy? ";
           
       }
           
  }

