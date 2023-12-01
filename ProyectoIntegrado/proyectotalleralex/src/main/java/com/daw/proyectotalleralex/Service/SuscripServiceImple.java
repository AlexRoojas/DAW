package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.SuscripDAO;
import com.daw.proyectotalleralex.DTO.Suscrip;
@Service
public class SuscripServiceImple implements SuscripService{

	@Autowired
	SuscripDAO susdao;
	
	@Override
	public List<Suscrip> FindAll() {
		return (List<Suscrip>)susdao.findAll();
	}

	@Override
	public Suscrip FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Suscrip producto) {
		susdao.save(producto);
		
	}

	@Override
	public void edit(Suscrip producto) {
		susdao.save(producto);
		
	}

	@Override
	public void delete(String email) {
		susdao.deleteById(email);
		
	}

}
