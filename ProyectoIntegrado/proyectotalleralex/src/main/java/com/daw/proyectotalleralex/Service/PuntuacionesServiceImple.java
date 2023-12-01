package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.PuntuacionesDAO;
import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.PuntuacionesPK;
@Service
public class PuntuacionesServiceImple implements PuntuacionesService{

	@Autowired
	PuntuacionesDAO puntudao;
	
	@Override
	public List<Puntuaciones> FindAll() {
		return (List<Puntuaciones>) puntudao.findAll();
	}

	@Override
	public Puntuaciones FindById(int clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Puntuaciones puntu) {
		puntudao.save(puntu);
		
	}

	@Override
	public void edit(Puntuaciones puntu) {
		puntudao.save(puntu);
		
	}

	@Override
	public void delete(PuntuacionesPK puntuPK) {
		puntudao.deleteById(puntuPK);
		
	}

	@Override
	public List <Puntuaciones> buscamiPuntu(String dni) {
		return puntudao.buscamiPuntu(dni);
	}

	@Override
	public List<Puntuaciones> buscamiPuntuCo(Integer codigoprod) {
		return puntudao.buscamiPuntuCo(codigoprod);
	}

}
