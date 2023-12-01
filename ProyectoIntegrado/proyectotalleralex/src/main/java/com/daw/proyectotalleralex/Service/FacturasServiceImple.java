package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.FacturasDAO;
import com.daw.proyectotalleralex.DTO.Facturas;

@Service
public class FacturasServiceImple implements FacturasService{

	@Autowired
	FacturasDAO facturasDAO;
	
	@Override
	public List<Facturas> FindAll() {
		return (List<Facturas>) facturasDAO.findAll();
	}

	@Override
	public Facturas FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Facturas facturas) {
		facturasDAO.save(facturas);
		
	}

	@Override
	public void edit(Facturas facturas) {
		facturasDAO.save(facturas);
		
	}

	@Override
	public void delete(int indice) {
		facturasDAO.deleteById(indice);
		
	}

	@Override
	public Facturas buscaFactUsu(String dniCli) {
		return facturasDAO.buscaFactUsu(dniCli);
	}

	@Override
	public Facturas buscaFactCod(Integer codFact) {
		return facturasDAO.buscaFactCod(codFact);
	}

	@Override
	public List<Facturas> buscaFactDNIFech(String dniCli) {
		return facturasDAO.buscaFactDNIFech(dniCli);
	}

}
