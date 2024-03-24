package com.producto.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.producto.service.models.entity.Producto;
import com.producto.service.repository.ProductoRepository;


@Service
public class ProductoServiceImp  implements ProductoService{
	
	@Autowired
	   private ProductoRepository productoRepository;

	@Override
	public List<Producto> findAll() {
		
	//	return (List<Producto>) productoRepository.findAll();
		return (List<Producto>) productoRepository.listarProducto();
	}

	@Override
	public Producto findById(Long id) throws Exception {
		try {
			return productoRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Producto save(Producto producto) throws Exception {
		try {
			return productoRepository.save(producto);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Producto> search(String filtro) throws Exception {
	
		try {
			
		return productoRepository.BuscarProductoPorNombre(filtro);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	
	}

	@Override
	public List<Producto> BuscarProductoXcategoria(Long id) throws Exception {
		
		try {
			
			
			return  (List<Producto>) productoRepository.BuscarProductoXcategoria(id);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	
	}
 
}
