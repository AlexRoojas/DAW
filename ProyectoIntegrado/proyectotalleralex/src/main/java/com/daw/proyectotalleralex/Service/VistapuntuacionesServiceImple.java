package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.VistapuntuacionesDAO;
import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.Vistapuntuaciones;

@Service
public class VistapuntuacionesServiceImple implements VistapuntuacionesService{

	@Autowired
	VistapuntuacionesDAO vpdao;
	
	@Override
	public List<Vistapuntuaciones> FindAll() {
		return (List<Vistapuntuaciones>) vpdao.findAll();
	}

	@Override
	public Vistapuntuaciones FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Vistapuntuaciones vista) {
		vpdao.save(vista);
		
	}

	@Override
	public void edit(Vistapuntuaciones vista) {
		vpdao.save(vista);
		
	}

	@Override
	public void delete(Vistapuntuaciones vista) {
		vpdao.delete(vista);
		
	}

	@Override
	public List<Vistapuntuaciones> buscaPuntuDNI(String dniusuario) {
		return vpdao.buscaPuntuDNI(dniusuario);
	}

	@Override
	public List<Vistapuntuaciones> buscaPuntuCod(Integer codigoprod) {
		return vpdao.buscaPuntuCod(codigoprod);
	}

}
