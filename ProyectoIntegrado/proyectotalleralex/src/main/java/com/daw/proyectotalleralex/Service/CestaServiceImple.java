package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.CestaDAO;
import com.daw.proyectotalleralex.DTO.Cesta;
import com.daw.proyectotalleralex.DTO.CestaPK;

@Service
public class CestaServiceImple implements CestaService{

	@Autowired
	CestaDAO cestadao;
	
	@Override
	public List<Cesta> FindAll() {
		return (List<Cesta>) cestadao.findAll();
	}

	@Override
	public Cesta FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Cesta cesta) {
		cestadao.save(cesta);
		
	}

	@Override
	public void edit(Cesta cesta) {
		cestadao.save(cesta);
		
	}

	@Override
	public void delete(CestaPK cesta) {
		cestadao.deleteById(cesta);
		
	}

	@Override
	public List<Cesta> buscarMiProd(String dniusuario, int codproducto) {
		return cestadao.buscarMiProd(dniusuario, codproducto);
	}

	@Override
	public List<Cesta> buscarMiListaProd(String dniusuario) {
		return cestadao.buscarMiListaProd(dniusuario);
	}

	

}
