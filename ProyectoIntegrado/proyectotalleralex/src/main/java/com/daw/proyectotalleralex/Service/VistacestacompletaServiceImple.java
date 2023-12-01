package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.VistacestacompletaDAO;
import com.daw.proyectotalleralex.DTO.Vistacestacompleta;
@Service
public class VistacestacompletaServiceImple implements VistacestacompletaService{

	@Autowired
	VistacestacompletaDAO vistaServicio;
	
	@Override
	public List<Vistacestacompleta> FindAll() {
		return (List<Vistacestacompleta>) vistaServicio.findAll();
	}

	@Override
	public Vistacestacompleta FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Vistacestacompleta vista) {
		vistaServicio.save(vista);
		
	}

	@Override
	public void edit(Vistacestacompleta vista) {
		vistaServicio.save(vista);
		
	}

	@Override
	public void delete(Vistacestacompleta vista) {
		vistaServicio.delete(vista);
		
	}

	@Override
	public List <Vistacestacompleta> encuentraPorDNICesta(String dniusuario) {
		return vistaServicio.encuentraPorDNICesta(dniusuario);
	}

}
