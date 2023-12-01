package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Productos;
import com.daw.proyectotalleralex.DTO.Vistacestacompleta;



public interface VistacestacompletaDAO extends JpaRepository<Vistacestacompleta, String>{
	@Query("select v from Vistacestacompleta v where v.dniusuario = ?1")
	List <Vistacestacompleta> encuentraPorDNICesta(String dniusuario);
}
