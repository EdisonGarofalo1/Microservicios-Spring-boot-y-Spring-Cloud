package com.cliente.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cliente.service.models.entity.Cliente;
import com.cliente.service.repository.ClienteRepository;


@Service
public class ClienteServiceImpl  implements ClienteService{
	
	@Autowired
	   private  ClienteRepository   clienteRepository;

	@Override
	public List<Cliente> findAll() {

		return (List<Cliente>) clienteRepository.findAll();
	}

	@Override
	public Cliente findById(Long id) throws Exception {
		try {
			return clienteRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public Cliente save(Cliente cliente) throws Exception {
		
		try {
			return clienteRepository.save(cliente);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public List<Cliente> search(String filtro) throws Exception {
		try {
			
			return clienteRepository.BuscarPorNombre(filtro);
			} catch (Exception e) {
				throw new Exception(e.getMessage());
			}
	}

}
