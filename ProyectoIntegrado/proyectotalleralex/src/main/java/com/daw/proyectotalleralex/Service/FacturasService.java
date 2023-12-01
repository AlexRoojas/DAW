package com.daw.proyectotalleralex.Service;

import java.util.List;

import com.daw.proyectotalleralex.DTO.Facturas;

public interface FacturasService {
	public List<Facturas> FindAll();
    public Facturas FindById(String clave);
    public void save(Facturas facturas);
    public void edit (Facturas facturas);
    public void delete(int indice);
    
    public Facturas buscaFactUsu(String dniCli);
    
    public Facturas buscaFactCod(Integer codFact);
    
    public List <Facturas> buscaFactDNIFech(String dniCli);
}
