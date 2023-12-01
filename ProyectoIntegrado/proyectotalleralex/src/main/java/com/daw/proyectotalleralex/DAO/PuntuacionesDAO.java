package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Puntuaciones;
import com.daw.proyectotalleralex.DTO.PuntuacionesPK;

public interface PuntuacionesDAO extends JpaRepository<Puntuaciones,PuntuacionesPK>{
	@Query("SELECT p FROM Puntuaciones p WHERE p.puntuacionesPK.dniusuario = ?1")
	List <Puntuaciones> buscamiPuntu(String dni);
	
	@Query("SELECT p FROM Puntuaciones p WHERE p.puntuacionesPK.codigoprod = ?1")
	List <Puntuaciones> buscamiPuntuCo(Integer codigoprod);
}
