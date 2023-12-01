package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Vistafacturacompleta;

public interface VistafacturacompletaService {
	
	public List<Vistafacturacompleta> FindAll();
    public Vistafacturacompleta FindById(String clave);
    public void save(Vistafacturacompleta vista);
    public void edit (Vistafacturacompleta vista);
    public void delete(Vistafacturacompleta vista);
    
    public List <Vistafacturacompleta> encuentraPorDNIFact(String dniUsu);
    public List <Vistafacturacompleta> encuentraPorDNIyCodFact(String dniUsu, int codFact);
}
