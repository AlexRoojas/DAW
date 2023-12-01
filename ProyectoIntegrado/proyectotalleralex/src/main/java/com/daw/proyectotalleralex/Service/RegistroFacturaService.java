package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.RegistroFactura;


public interface RegistroFacturaService {
	public List<RegistroFactura> FindAll();
    public RegistroFactura FindById(String clave);
    public void save(RegistroFactura reg);
    public void edit (RegistroFactura reg);
    public void delete(int indice);
    
    public List <RegistroFactura> buscaReg(int codFactura);
    
    public RegistroFactura buscaRegCompleta (int codFactura,int codProducto, String dniUsu);
}
