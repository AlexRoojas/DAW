package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.RegistroFacturaDAO;
import com.daw.proyectotalleralex.DTO.RegistroFactura;
@Service
public class RegistroFacturaServiceImple implements RegistroFacturaService{

	@Autowired
	RegistroFacturaDAO registroDAO;
	
	@Override
	public List<RegistroFactura> FindAll() {
		return (List<RegistroFactura> ) registroDAO.findAll();
	}

	@Override
	public RegistroFactura FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(RegistroFactura reg) {
		registroDAO.save(reg);
		
	}

	@Override
	public void edit(RegistroFactura reg) {
		registroDAO.save(reg);
		
	}

	@Override
	public void delete(int indice) {
		registroDAO.deleteById(indice);
		
	}

	@Override
	public List<RegistroFactura> buscaReg(int codFactura) {
		return registroDAO.buscaReg(codFactura);
	}

	@Override
	public RegistroFactura buscaRegCompleta(int codFactura, int codProducto, String dniUsu) {
		return registroDAO.buscaRegCompleta(codFactura, codProducto, dniUsu);
	}

}
