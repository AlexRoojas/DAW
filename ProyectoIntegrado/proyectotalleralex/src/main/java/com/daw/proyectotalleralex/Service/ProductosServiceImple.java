package com.daw.proyectotalleralex.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.daw.proyectotalleralex.DAO.ProductosDAO;

import com.daw.proyectotalleralex.DTO.Productos;

@Service
public class ProductosServiceImple implements ProductosService{

	@Autowired
	ProductosDAO productosdao;
	
	@Override
	public List<Productos> FindAll() {
		return (List<Productos>) productosdao.findAll();
	}

	@Override
	public Productos FindById(String clave) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Productos producto) {
		productosdao.save(producto);
		
	}

	@Override
	public void edit( Productos producto) {
		productosdao.save(producto);
		
	}

	@Override
	public void delete(int indice) {
		productosdao.deleteById(indice);
		
	}

	@Override
	public List<Productos> buscarProductos(String nombreBusqueda) {
		return productosdao.buscarProductos(nombreBusqueda);
		 
	}

	@Override
	public List<Productos> buscarCategoria(String categoria) {
		
		return productosdao.buscarCategoria(categoria);
	}

	@Override
	public List<Productos> buscarMiProd(int codProd) {
		
		return productosdao.buscarMiProd(codProd);
		
	}

	@Override
	public Productos buscarProd(int codProd) {
		return productosdao.buscarProd(codProd);
	}

}
