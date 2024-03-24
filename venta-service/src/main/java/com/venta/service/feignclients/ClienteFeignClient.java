package com.venta.service.feignclients;



import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venta.service.exception.MyException;
import com.venta.service.models.dto.ClienteDto;



//@FeignClient(name = "cliente-service",url = "http://localhost:8182")
@FeignClient(name = "cliente-service")
@RequestMapping("/api/cliente")
public interface ClienteFeignClient {
	
	@GetMapping("/ver/{id}")
	public Optional<ClienteDto> buscaridCliente(@PathVariable("id") Long id)  throws MyException;

}
