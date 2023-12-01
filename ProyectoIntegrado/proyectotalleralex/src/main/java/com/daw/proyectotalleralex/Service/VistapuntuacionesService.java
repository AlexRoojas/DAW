package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.Vistapuntuaciones;

public interface VistapuntuacionesService {
	public List<Vistapuntuaciones> FindAll();
    public Vistapuntuaciones FindById(String clave);
    public void save(Vistapuntuaciones vista);
    public void edit (Vistapuntuaciones vista);
    public void delete(Vistapuntuaciones vista);
    
    public List <Vistapuntuaciones> buscaPuntuDNI(String dniusuario);
    
    public List <Vistapuntuaciones> buscaPuntuCod(Integer codigoprod);
}
