package com.venta.service.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.venta.service.feignclients.ProductoFeignClient;
import com.venta.service.models.dto.ProductoDto;
import com.venta.service.models.dto.VentaDto;
import com.venta.service.models.entity.Venta;
import com.venta.service.services.VentaService;



@RestController
@RequestMapping("/api/ventas")
public class VentaController {
	
	   @Autowired
	    private  VentaService ventaService;
	    
	   @Autowired
        private ProductoFeignClient productoFeignClient;
	   
		@GetMapping("/verproducto/{id}")
		public Optional<ProductoDto>producto(@PathVariable Long id) throws Exception {
			return productoFeignClient.buscaridProducto(id);
		}
	   
		
		   @PutMapping("/actualizarProducto/{id}")
		    public ResponseEntity<ProductoDto> actualizarProducto(@PathVariable Long id, @RequestBody ProductoDto productoDto) {
			   ProductoDto ventaProducto = productoFeignClient.ActualizarProductoFeing( productoDto, id);
		        if (ventaProducto != null) {
		            return new ResponseEntity<>(ventaProducto, HttpStatus.OK);
		        } else {
		            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		        }
		   }
		
	   
		@GetMapping("/listar")
		public List<Venta> listar() {
			return ventaService.findAll();
		}
		
		@GetMapping("/ver/{id}")
		public Venta detalle(@PathVariable Long id) throws Exception {
			return ventaService.findById(id);
		}
	   @PostMapping("/realiarventa")
	    public ResponseEntity<Venta> procesarVenta(@RequestBody VentaDto ventaDTO) {
		   
	
		    Venta ventaGuardada =   ventaService.RealizarVenta(ventaDTO);
	        return new ResponseEntity<>( ventaGuardada,HttpStatus.CREATED);
	        
	    }
	   
	   
	
	   
	   @PutMapping("/{id}")
	    public ResponseEntity<Venta> actualizarVenta(@PathVariable Long id, @RequestBody VentaDto ventaDTO) {
	        Venta ventaActualizada = ventaService.ActualizarVenta(id, ventaDTO);
	        if (ventaActualizada != null) {
	            return new ResponseEntity<>(ventaActualizada, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    }

}
