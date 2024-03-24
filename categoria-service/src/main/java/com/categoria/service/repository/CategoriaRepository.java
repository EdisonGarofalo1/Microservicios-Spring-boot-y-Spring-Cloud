package com.categoria.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.categoria.service.models.entity.Categoria;



public interface CategoriaRepository  extends  JpaRepository< Categoria, Long>{
	
	@Query("from Categoria p where p.nombre like %?1% ")
	List<Categoria> BuscarPorNombre(String filtro);


}
