package com.cliente.service.services;

import java.util.List;

import com.cliente.service.models.entity.Cliente;


public interface ClienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id) throws Exception;
	public Cliente save(Cliente cliente) throws Exception;
	public List<Cliente> search(String filtro)throws Exception;
	

}
