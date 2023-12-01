import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http'

@Injectable({
  providedIn: 'root'
})
export class ProvinciasService {

  constructor(private http:HttpClient) {

  }

  getProvincias$():any{
    return this.http.get('http://localhost:8084/ComoLlegar21/BuscaPoblaciones?provincia=provincia');
  }

}
