package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Citas;

public interface CitasDAO extends JpaRepository<Citas, Integer>{
	@Query("SELECT c FROM Citas c WHERE c.dniCli = ?1 ORDER BY c.fechaCita DESC")
	List <Citas> buscarMiCitaDNI (String dniCli);
	
	@Query("SELECT DISTINCT c FROM Citas c WHERE c.codCita = :codCita")
	Citas buscarMiCitaCod (Integer codCita);
}
