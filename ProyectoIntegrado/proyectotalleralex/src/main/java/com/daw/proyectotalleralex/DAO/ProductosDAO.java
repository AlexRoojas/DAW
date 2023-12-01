package com.daw.proyectotalleralex.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.daw.proyectotalleralex.DTO.Productos;

public interface ProductosDAO extends JpaRepository<Productos, Integer>{

	@Query("SELECT p from Productos p where p.nomProd like %?1%")
	public List <Productos> buscarProductos (String nombreBusqueda);
	
	@Query("SELECT p from Productos p where p.categoriaProd like %?1%")
	public List <Productos> buscarCategoria (String categoria);
	
	@Query("SELECT p from Productos p where p.codProd = ?1")
	public List <Productos> buscarMiProd (int codProd);
	
	@Query("SELECT p from Productos p where p.codProd = ?1")
	public Productos buscarProd (int codProd);
} 
