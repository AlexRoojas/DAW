package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Cesta;
import com.daw.proyectotalleralex.DTO.CestaPK;
public interface CestaService {
	public List<Cesta> FindAll();
    public Cesta FindById(String clave);
    public void save(Cesta producto);
    public void edit (Cesta producto);
    public void delete(CestaPK cestaPK);
    
    public List <Cesta> buscarMiProd (String dniusuario, int codproducto);
    
    public List <Cesta> buscarMiListaProd (String dniusuario);
}
