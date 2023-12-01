package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.PartesDAO;
import com.daw.proyectotalleralex.DTO.Partes;

@Service
public class PartesServiceImple implements PartesService{

	@Autowired
	PartesDAO partesdao;
	@Override
	public List<Partes> FindAll() {
		return (List <Partes>) partesdao.findAll();
	}

	@Override
	public Partes FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Partes producto) {
		partesdao.save(producto);
		
	}

	@Override
	public void edit(Partes producto) {
		partesdao.save(producto);
		
	}

	@Override
	public void delete(int indice) {
		partesdao.deleteById(indice);
		
	}

	@Override
	public Partes buscarMiParteCod(Integer codParte) {
		return partesdao.buscarMiParteCod(codParte);
	}

}
