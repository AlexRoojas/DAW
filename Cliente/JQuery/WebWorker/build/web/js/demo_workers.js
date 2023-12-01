/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
var i = 0;
self.addEventListener("message",arranca);
function arranca(ev){
    i=ev.data.inicio;
    timedCount();
}
function timedCount() {
  i = i + 1;
  postMessage(i);
  setTimeout("timedCount()",ev.data.tiempo*1000);
}



