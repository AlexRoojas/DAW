package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Partes;

public interface PartesService {
	public List<Partes> FindAll();
    public Partes FindById(String clave);
    public void save(Partes producto);
    public void edit (Partes producto);
    public void delete(int indice);
    
    public Partes buscarMiParteCod (Integer codParte);
    
}
