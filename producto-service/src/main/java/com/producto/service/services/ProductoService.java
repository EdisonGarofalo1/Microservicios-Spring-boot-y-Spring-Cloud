package com.producto.service.services;

import java.util.List;

import com.producto.service.models.entity.Producto;



public interface ProductoService {

	public List<Producto> findAll();
	public Producto findById(Long id) throws Exception;
	public Producto save(Producto producto) throws Exception;
	public List<Producto> BuscarProductoXcategoria(Long id)throws Exception;
	public List<Producto> search(String filtro) throws Exception;
	
	
}
