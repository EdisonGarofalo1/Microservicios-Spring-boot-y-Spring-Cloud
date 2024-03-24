package com.categoria.service.services;

import java.util.List;

import com.categoria.service.models.entity.Categoria;



public interface CategoriaService {
	
	public List<Categoria> findAll();
	public Categoria findById(Long id) throws Exception;
	public Categoria save(Categoria categoria) throws Exception;
	public List<Categoria> search(String filtro) throws Exception;
	


}
