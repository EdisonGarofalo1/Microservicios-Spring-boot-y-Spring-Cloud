package com.venta.service.models.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
@Entity
@Table(name = "detalleVenta")
public class DetalleVenta   implements Serializable{
	
	
	

	
	private static final long serialVersionUID = 8484963134431311053L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long detalleVenta_Id;

	       @ManyToOne (fetch= FetchType.LAZY, optional=false)
           @JoinColumn(name = "venta_id")
           @JsonProperty(access = Access.WRITE_ONLY)
			private Venta venta;
	        
	    
	       @Column(name = "producto_id")
			private Long producto_id;
		   
	     
         
	        @Column(name = "cantidad")
	        private Integer cantidad;

	        
	        @Column(name = "precioUnitario")
	        private Double precioUnitario;
	        
	        @Column(name = "subtotal")
	        private Double subtotal;

			public DetalleVenta() {
				super();
			}
			

			public Long getProducto_id() {
				return producto_id;
			}


			public void setProducto_id(Long producto_id) {
				this.producto_id = producto_id;
			}


			public Long getDetalleVenta_Id() {
				return detalleVenta_Id;
			}

			public void setDetalleVenta_Id(Long detalleVenta_Id) {
				this.detalleVenta_Id = detalleVenta_Id;
			}

			public Venta getVenta() {
				return venta;
			}

			public void setVenta(Venta venta) {
				this.venta = venta;
			}

		

			public Integer getCantidad() {
				return cantidad;
			}

			public void setCantidad(Integer cantidad) {
				this.cantidad = cantidad;
			}

			public Double getPrecioUnitario() {
				return precioUnitario;
			}

			public void setPrecioUnitario(Double precioUnitario) {
				this.precioUnitario = precioUnitario;
			}

			public Double getSubtotal() {
				return subtotal;
			}

			public void setSubtotal(Double subtotal) {
				this.subtotal = subtotal;
			}


	        
	        
}
