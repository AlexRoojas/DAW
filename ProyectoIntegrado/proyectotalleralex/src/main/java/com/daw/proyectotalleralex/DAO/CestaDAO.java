package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Cesta;
import com.daw.proyectotalleralex.DTO.CestaPK;



public interface CestaDAO extends JpaRepository<Cesta, CestaPK>{
	@Query("SELECT c from Cesta c WHERE c.cestaPK.dniusuario = ?1 AND c.cestaPK.codproducto = ?2")
	public List <Cesta> buscarMiProd (String dniusuario, int codproducto);
	
	@Query("SELECT c from Cesta c WHERE c.cestaPK.dniusuario = ?1")
	public List <Cesta> buscarMiListaProd (String dniusuario);
}
