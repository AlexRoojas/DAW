import { Component, OnInit } from '@angular/core';

import { ActivatedRoute, Params } from '@angular/router';
import { ProvinciasService } from '../provincias.service';

@Component({
  selector: 'app-modifica-prov',
  templateUrl: './modifica-prov.component.html',
  styleUrls: ['./modifica-prov.component.css']
})
export class ModificaProvComponent implements OnInit {

  prov:any;
  miProv:any[] =[];

  constructor(private miRuta: ActivatedRoute,private miServicio:ProvinciasService) { }

  ngOnInit(): void {
    this.prov=JSON.parse(this.miRuta.snapshot.paramMap.get("miCod")); 
  }

}
