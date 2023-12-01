package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.Vistapuntuaciones;

public interface VistapuntuacionesDAO extends JpaRepository<Vistapuntuaciones, String>{
	@Query("SELECT v FROM Vistapuntuaciones v WHERE v.dniusuario = :dniusuario")
	List <Vistapuntuaciones> buscaPuntuDNI(String dniusuario);
	
	@Query("SELECT p FROM Puntuaciones p WHERE p.puntuacionesPK.codigoprod = :codigoprod")
	List <Vistapuntuaciones> buscaPuntuCod(Integer codigoprod);
}
