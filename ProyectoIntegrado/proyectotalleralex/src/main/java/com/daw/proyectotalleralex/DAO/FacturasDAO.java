package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Facturas;

public interface FacturasDAO extends JpaRepository<Facturas, Integer>{
	@Query("select f from Facturas f where f.dniCli = ?1")
	Facturas buscaFactUsu(String dniCli);
	
	
	@Query("select f from Facturas f where f.codFact = ?1")
	Facturas buscaFactCod(Integer codFact);
	
	@Query("select f from Facturas f where f.dniCli = ?1 ORDER BY codFact DESC")
	List <Facturas> buscaFactDNIFech(String dniCli);
}
