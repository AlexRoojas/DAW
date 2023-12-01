package com.daw.proyectotalleralex.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Partes;

public interface PartesDAO extends JpaRepository<Partes, Integer>{
	@Query("SELECT p FROM Partes p WHERE p.codParte = :codParte")
	Partes buscarMiParteCod (Integer codParte);
}
