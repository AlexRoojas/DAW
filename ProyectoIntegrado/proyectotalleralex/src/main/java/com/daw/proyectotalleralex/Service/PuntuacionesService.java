package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.PuntuacionesPK;

public interface PuntuacionesService {
	public List<Puntuaciones> FindAll();
    public Puntuaciones FindById(int clave);
    public void save(Puntuaciones puntu);
    public void edit (Puntuaciones puntu);
    public void delete(PuntuacionesPK puntuPK);
    
    public List <Puntuaciones> buscamiPuntu(String dni);
    
    public List <Puntuaciones> buscamiPuntuCo(Integer codigoprod);
}
