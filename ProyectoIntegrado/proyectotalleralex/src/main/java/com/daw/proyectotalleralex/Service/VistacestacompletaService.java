package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Vistacestacompleta;

public interface VistacestacompletaService {
	
	public List<Vistacestacompleta> FindAll();
    public Vistacestacompleta FindById(String clave);
    public void save(Vistacestacompleta vista);
    public void edit (Vistacestacompleta vista);
    public void delete(Vistacestacompleta vista);
    
    public List <Vistacestacompleta> encuentraPorDNICesta(String dniusuario);
}
