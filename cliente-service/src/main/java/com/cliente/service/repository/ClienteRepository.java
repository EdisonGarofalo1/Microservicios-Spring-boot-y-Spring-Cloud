package com.cliente.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import com.cliente.service.models.entity.Cliente;


public interface ClienteRepository   extends  JpaRepository< Cliente, Long>{
	@Query("from Cliente p where p.nombre like %?1% ")
	List<Cliente> BuscarPorNombre(String filtro);

}
