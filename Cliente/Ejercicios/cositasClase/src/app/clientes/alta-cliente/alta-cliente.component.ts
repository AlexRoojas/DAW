import { Component, OnInit } from '@angular/core';
import { ClientesService } from '../clientes.service';
import { Cliente, Grupo } from '../clientes.module';
import { AbstractControl,FormBuilder,FormGroup,Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-alta-cliente',
  templateUrl: './alta-cliente.component.html',
  styleUrls: ['./alta-cliente.component.css']
})

export class AltaClienteComponent implements OnInit {

  cliente: Cliente = { id:1 ,nombre:"a", cif:"b", direccion:"c", grupo:2}; //objeto
  
  grupos: Grupo[] = [];//array

  public miForm!: FormGroup ;

  constructor(private clientesService : ClientesService, private formBuilder:FormBuilder, private router:Router) { }//Conseguimos una instancia del servicio de clientes


  ngOnInit(): void { //ya se ha recibido el servicio de clientes
    this.cliente = this.clientesService.nuevoCliente();
    this.grupos = this.clientesService.getGrupos();
    console.log(this.cliente);


    this.creaFormulario();
  }

  creaNuevoCliente ():void { //se ejecuta cuando se produzca el envio de datos del formulario (alta)
    this.clientesService.agregarCliente(this.cliente);//lo añadimos
    this.cliente = this.clientesService.nuevoCliente();//creamos el nuevo cliente para que no se machaque
  } 

  creaFormulario(){
    this.miForm=this.formBuilder.group({
      nombre:["Pepe",[Validators.required,Validators.minLength(3)]],
      cif:["22212321A",[Validators.required,Validators.pattern("[0-9]{8}[A-Z]"), this.validaNif]],
      direccion:'',
      grupo:'Sin Grupo'
    });
  }

  alta(){
    
  }

  register(){

  }

  public geterror(controlName: string):string{
    let error='';

    const control = this.miForm.get(controlName);

    if(control?.touched && control.errors!=null)
      error=JSON.stringify(control.errors);
    return error;
  }

  onSubmit(){
    if(this.miForm.valid){
      alert("Alta correcta");
      this.clientesService.agregarCliente(this.miForm.value);
      this.router.navigate(['/Listado'])
    }else{
      alert("Error XD");
    }
  }

  private validaNif(control: AbstractControl){
    const nif = control.value;
    let error = null;
    if(nif.length<9){
      error={nifCorto:'El nif es muy corto'};
    }
    return error;
  }

}
