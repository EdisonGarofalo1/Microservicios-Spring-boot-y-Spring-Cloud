package com.venta.service.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.venta.service.models.dto.VentaDto;
import com.venta.service.models.entity.Venta;


@Service
public interface VentaService {
	public List<Venta> findAll();
	public Venta findById(Long id) throws Exception;
	public Venta  RealizarVenta(VentaDto  ventaDto );
	public Venta  ActualizarVenta( Long id ,VentaDto  ventaDto );

}
