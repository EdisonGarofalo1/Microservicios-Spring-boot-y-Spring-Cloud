package com.venta.service.models.dto;

import java.util.List;

public class VentaDto {
	  private Long venta_id;
	  
	  private List<DetalleVentaDto> detallesVenta;
	  
		private Long cliente_id; 
	
	    private Double Total;
	
	    private String fecha;

		public VentaDto() {
			super();
		}

		public Long getVenta_id() {
			return venta_id;
		}

		public void setVenta_id(Long venta_id) {
			this.venta_id = venta_id;
		}

		public List<DetalleVentaDto> getDetallesVenta() {
			return detallesVenta;
		}

		public void setDetallesVenta(List<DetalleVentaDto> detallesVenta) {
			this.detallesVenta = detallesVenta;
		}

		public Long getCliente_id() {
			return cliente_id;
		}

		public void setCliente_id(Long cliente_id) {
			this.cliente_id = cliente_id;
		}

		public Double getTotal() {
			return Total;
		}

		public void setTotal(Double total) {
			Total = total;
		}

		public String getFecha() {
			return fecha;
		}

		public void setFecha(String fecha) {
			this.fecha = fecha;
		}


}
