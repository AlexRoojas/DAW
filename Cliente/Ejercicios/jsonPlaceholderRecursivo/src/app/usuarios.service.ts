import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class UsuariosService {

  constructor(private http: HttpClient) { 
    console.log('Servicio HTTP:');  
  }

  getUsuario$():any{
    return this.http.get("https://jsonplaceholder.typicode.com/users")
  }
}
