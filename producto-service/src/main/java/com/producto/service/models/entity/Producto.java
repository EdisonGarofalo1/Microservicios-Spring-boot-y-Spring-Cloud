package com.producto.service.models.entity;

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
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "producto", uniqueConstraints = { @UniqueConstraint(columnNames = { "nombre" }) })
public class Producto implements Serializable {

	private static final long serialVersionUID = 3791493197760367854L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long producto_id;

	@Column(name = "nombre")
	private String nombre;

	@Column(name = "categoria_id")

	private Long categoria_id;

	@Column(name = "precio")
	private Double precio;

	@Column(name = "stock")
	private Integer stock;

	public Producto() {
		super();
	}

	public Long getProducto_id() {
		return producto_id;
	}

	public void setProducto_id(Long producto_id) {
		this.producto_id = producto_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Long getCategoria_id() {
		return categoria_id;
	}

	public void setCategoria_id(Long categoria_id) {
		this.categoria_id = categoria_id;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

}
