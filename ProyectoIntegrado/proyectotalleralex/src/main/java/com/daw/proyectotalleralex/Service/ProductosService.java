package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Productos;

public interface ProductosService {
	public List<Productos> FindAll();
    public Productos FindById(String clave);
    public void save(Productos producto);
    public void edit (Productos producto);
    public void delete(int indice);
    
    public List <Productos> buscarProductos (String nombreBusqueda);
    
    public List <Productos> buscarCategoria (String categoria);
    
    public List <Productos> buscarMiProd (int codProd);
    
    public Productos buscarProd (int codProd);
}
