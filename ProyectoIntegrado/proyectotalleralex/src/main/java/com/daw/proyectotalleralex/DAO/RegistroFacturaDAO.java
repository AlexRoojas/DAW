package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.RegistroFactura;


public interface RegistroFacturaDAO extends JpaRepository<RegistroFactura, Integer>{
	@Query("select u from RegistroFactura u where u.codFactura = ?1")
	List <RegistroFactura> buscaReg(int codFactura);
	
	@Query("select u from RegistroFactura u where u.codFactura = ?1 and u.codProducto = ?2 and u.dniUsu = ?3")
	RegistroFactura buscaRegCompleta (int codFactura,int codProducto, String dniUsu);
}
