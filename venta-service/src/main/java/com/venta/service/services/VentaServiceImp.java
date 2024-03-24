package com.venta.service.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venta.service.exception.MyException;
import com.venta.service.feignclients.ClienteFeignClient;
import com.venta.service.feignclients.ProductoFeignClient;
import com.venta.service.models.dto.ClienteDto;
import com.venta.service.models.dto.DetalleVentaDto;
import com.venta.service.models.dto.ProductoDto;
import com.venta.service.models.dto.VentaDto;
import com.venta.service.models.entity.DetalleVenta;
import com.venta.service.models.entity.Venta;
import com.venta.service.repository.VentaRepository;




@Service
public class VentaServiceImp  implements VentaService{


	@Autowired
	private VentaRepository ventaRepository;
	
	@Autowired
	private ProductoFeignClient productoFeignClient;
	
	
	@Autowired
	private  ClienteFeignClient clienteFeignClient;
	


	@Override
	public List<Venta> findAll() {
	      return(List<Venta>) ventaRepository.findAll();
	}

	@Override
	public Venta  RealizarVenta(VentaDto ventaDTO) {
		
		try {
		Venta venta = new Venta();
		
		venta.setFecha(ventaDTO.getFecha()); 
		venta.setTotal(ventaDTO.getTotal()); 	
		
		  if (ventaDTO.getTotal() == null) {
              throw new IllegalArgumentException("El tota no puede ser nula");
          }
		  
		  ClienteDto cliente = clienteFeignClient.buscaridCliente(ventaDTO.getCliente_id())
                .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + ventaDTO.getCliente_id()));
		
		venta.setId_cliente(cliente.getCliente_id()); 	
		
		 for (DetalleVentaDto detalleDTO : ventaDTO.getDetallesVenta()) {
		
			 ProductoDto producto = productoFeignClient.buscaridProducto(detalleDTO.getProducto_id())
	                                                  .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + detalleDTO.getProducto_id()));
	           	           
	            if (producto.getStock() < detalleDTO.getCantidad()) {
	                throw new RuntimeException("No hay suficiente stock para el producto " + producto.getNombre());
	            }
	                       
	            DetalleVenta detalleVenta = new DetalleVenta();
	            detalleVenta.setProducto_id(producto.getProducto_id());
	            detalleVenta.setCantidad(detalleDTO.getCantidad());
	            detalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
	            detalleVenta.setSubtotal(detalleDTO.getSubtotal());
	            detalleVenta.setVenta(venta);
	            venta.agregarDetalleVenta(detalleVenta);
	            // Actualizar el stock del producto
	            producto.setStock(producto.getStock() - detalleDTO.getCantidad());
	            productoFeignClient.ActualizarProductoFeing( producto, producto.getProducto_id());
	           
	        }
		 Venta ventaGuardada = ventaRepository.save(venta);
		 
		 return ventaGuardada;
		 
		} catch (Exception e) {
		       
            throw new MyException("Error al procesar la venta completa", e);
        }
		
	}




	@Override
	public Venta findById(Long id) throws Exception {
	
		try {
			return ventaRepository.findById(id).orElse(null);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}



	@Override
	public Venta ActualizarVenta(Long id, VentaDto ventaDTO) {
		
		  try {
	
	    Venta ventaExistente = ventaRepository.findById(id).orElse(null);
          if (ventaExistente != null) {
    		
        	 
        	  ClienteDto cliente = clienteFeignClient.buscaridCliente(ventaDTO.getCliente_id())
                   .orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + ventaDTO.getCliente_id()));
    		
        ventaExistente.setId_cliente(cliente.getCliente_id());
        ventaExistente.setFecha(ventaDTO.getFecha());
        ventaExistente.setTotal(ventaDTO.getTotal());

        for (DetalleVentaDto detalleDTO : ventaDTO.getDetallesVenta()) {
            DetalleVenta detalleExistente = ventaExistente.getDetVenta()
                    .stream()
                    .filter(detalle -> detalle.getDetalleVenta_Id().equals(detalleDTO.getId_det_ventas()))
                    .findFirst()
                    .orElse(null);
        	
            ProductoDto producto = productoFeignClient.buscaridProducto(detalleDTO.getProducto_id())
                    .orElseThrow(() -> new IllegalArgumentException("Producto no encontrado con ID: " + detalleDTO.getProducto_id()));

            if (detalleExistente != null) {
  
                detalleExistente.setCantidad(detalleDTO.getCantidad());
                detalleExistente.setPrecioUnitario(detalleDTO.getPrecioUnitario());
                detalleExistente.setSubtotal(detalleDTO.getSubtotal());
                
               
            } else {
        	
     
            if (producto.getStock() < detalleDTO.getCantidad()) {
                throw new RuntimeException("No hay suficiente stock para el producto " + producto.getNombre());
            }
            DetalleVenta NuevodetalleVenta = new DetalleVenta();
           
            NuevodetalleVenta.setProducto_id(producto.getProducto_id());
            NuevodetalleVenta.setCantidad(detalleDTO.getCantidad());
            NuevodetalleVenta.setPrecioUnitario(detalleDTO.getPrecioUnitario());
            NuevodetalleVenta.setSubtotal(detalleDTO.getSubtotal());
            NuevodetalleVenta.setVenta(ventaExistente);
            ventaExistente.agregarDetalleVenta(NuevodetalleVenta);
          producto.setStock(producto.getStock() - detalleDTO.getCantidad());
         
           productoFeignClient.ActualizarProductoFeing( producto, producto.getProducto_id());
        }
            
        }

     
            return ventaRepository.save(ventaExistente);
        } else {
           return null;
        }   
        
		  } catch (Exception e) {
	       
	            throw new MyException("Error al procesar la venta completa", e);
	        }
	}

}
