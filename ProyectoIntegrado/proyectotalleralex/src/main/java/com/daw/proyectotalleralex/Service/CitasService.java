package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Citas;

public interface CitasService {
	public List<Citas> FindAll();
    public Citas FindById(String clave);
    public void save(Citas producto);
    public void edit (Citas producto);
    public void delete(int indice);
    
    public List <Citas>  buscarMiCitaDNI (String dniCli);
    
    public Citas buscarMiCitaCod (Integer codCita);
}
