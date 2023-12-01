package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.CitasDAO;
import com.daw.proyectotalleralex.DTO.Citas;
@Service
public class CitasServiceImple implements CitasService{

	@Autowired
	CitasDAO citasdao;
	
	@Override
	public List<Citas> FindAll() {
		return (List<Citas>) citasdao.findAll();
	}

	@Override
	public Citas FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Citas producto) {
		citasdao.save(producto);
		
	}

	@Override
	public void edit(Citas producto) {
		citasdao.save(producto);
		
	}

	@Override
	public void delete(int indice) {
		citasdao.deleteById(indice);
		
	}

	@Override
	public List <Citas> buscarMiCitaDNI(String dniCli) {
		return citasdao.buscarMiCitaDNI(dniCli);
	}

	@Override
	public Citas buscarMiCitaCod(Integer codCita) {
		return citasdao.buscarMiCitaCod(codCita);
	}

}
