package com.venta.service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.venta.service.models.entity.Venta;



public interface VentaRepository  extends  JpaRepository<Venta  , Long> {

}
