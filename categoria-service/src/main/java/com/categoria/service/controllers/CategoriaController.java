package com.categoria.service.controllers;



import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.categoria.service.exception.MyException;
import com.categoria.service.models.entity.Categoria;
import com.categoria.service.services.CategoriaService;


@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
	
	
	@Autowired
	private  CategoriaService    categoriaService;
	
	
	@GetMapping("/listar")
	public List<Categoria> listar() {
		return categoriaService.findAll();
	}
	
	@GetMapping("/ver/{id}")
	public Categoria detalle(@PathVariable Long id) throws Exception {
		return categoriaService.findById(id);
	}
	
	@GetMapping("/Buscar/{nombre}")
	public List<Categoria> BuscarPorNombre(@PathVariable String nombre) throws Exception {
		return categoriaService.search(nombre);
	}
	
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria crear(@RequestBody Categoria categoria) throws Exception {
		
         try {
         
        
        	  
     		return categoriaService.save(categoria);
         
         }catch (Exception e) {
 			throw new MyException(e.getMessage());
 		}
            
       
	}
	
	@PutMapping("/editar/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Categoria editar(@RequestBody Categoria categoria, @PathVariable Long id) throws Exception {

		try {
			Categoria categoriaDB = categoriaService.findById(id);
			categoriaDB.setNombre(categoria.getNombre());
		
			return categoriaService.save(categoriaDB);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	
	
}
