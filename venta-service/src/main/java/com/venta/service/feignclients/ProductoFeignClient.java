package com.venta.service.feignclients;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.venta.service.models.dto.ProductoDto;



@FeignClient(name = "producto-service")
@RequestMapping("/api/producto")
public interface ProductoFeignClient {
	
	@GetMapping("/ver/{id}")
	public Optional <ProductoDto> buscaridProducto(@PathVariable("id") Long id);
	
	@PutMapping("/editar/{id}")
	public ProductoDto ActualizarProductoFeing(  @RequestBody ProductoDto producto ,@PathVariable Long id);
	

}
