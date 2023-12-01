package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Vistafacturacompleta;

public interface VistafacturacompletaDAO extends JpaRepository<Vistafacturacompleta, String>{
	@Query("SELECT v FROM Vistafacturacompleta v WHERE v.dniUsu = ?1")
	List <Vistafacturacompleta> encuentraPorDNIFact(String dniUsu);
	
	@Query("SELECT v FROM Vistafacturacompleta v WHERE v.dniUsu = ?1  and v.codFactura= ?2")
	List <Vistafacturacompleta> encuentraPorDNIyCodFact(String dniUsu, int codFact);
}
