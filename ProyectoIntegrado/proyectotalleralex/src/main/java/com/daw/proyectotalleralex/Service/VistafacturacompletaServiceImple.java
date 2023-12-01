package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.VistafacturacompletaDAO;
import com.daw.proyectotalleralex.DTO.Vistafacturacompleta;
@Service
public class VistafacturacompletaServiceImple implements VistafacturacompletaService{

	@Autowired
	VistafacturacompletaDAO vistaFacSer;
	
	@Override
	public List<Vistafacturacompleta> FindAll() {
		// TODO Auto-generated method stub
		return (List<Vistafacturacompleta>) vistaFacSer.findAll();
	}

	@Override
	public Vistafacturacompleta FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Vistafacturacompleta vista) {
		vistaFacSer.save(vista);
		
	}

	@Override
	public void edit(Vistafacturacompleta vista) {
		vistaFacSer.save(vista);
		
	}

	@Override
	public void delete(Vistafacturacompleta vista) {
		vistaFacSer.delete(vista);
		
	}

	@Override
	public List<Vistafacturacompleta> encuentraPorDNIFact(String dniUsu) {
		return vistaFacSer.encuentraPorDNIFact(dniUsu);
	}

	@Override
	public List<Vistafacturacompleta> encuentraPorDNIyCodFact(String dniUsu, int codFact) {
		return vistaFacSer.encuentraPorDNIyCodFact(dniUsu, codFact);
	}

}
