package com.producto.service.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.producto.service.models.entity.Producto;




public interface ProductoRepository  extends  JpaRepository< Producto, Long>{

@Query("from Producto  p  order by p.nombre")
	List<Producto> listarProducto();



@Query("from Producto  p  where p.categoria_id=?1 order by p.nombre")
List<Producto> BuscarProductoXcategoria(Long id);

@Query("from Producto p where p.nombre like %?1% ")
List<Producto> BuscarProductoPorNombre(String filtro);


}
