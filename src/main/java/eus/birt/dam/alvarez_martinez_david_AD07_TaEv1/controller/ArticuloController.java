package eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.http.HttpStatus;

import eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.domain.Articulo;
import eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.repository.ArticuloRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/articulos")
public class ArticuloController {
	
	@Autowired
	ArticuloRepository articuloRepository;
		
		@GetMapping({"/",""})
		public List <Articulo> index() {
		return articuloRepository.findAll();
		}
		
		@GetMapping("/{id}")
		public  Articulo show(@PathVariable("id") Integer id) {
			return articuloRepository.findById(id).orElse(null);
		}
		
		@PostMapping({"/",""})
		@ResponseStatus (HttpStatus.CREATED)
		public Articulo create(@RequestBody Articulo articulo) {
			return articuloRepository.save(articulo);
		}
		
		
		@PutMapping("/{id}")
		@ResponseStatus (HttpStatus.CREATED)
		public Articulo update(@RequestBody Articulo articulo, @PathVariable("id") Integer id) {
			Articulo tempArticulo = articuloRepository.findById(id).orElse(null);
			
			tempArticulo.setTitulo(articulo.getTitulo());
			tempArticulo.setAutor(articulo.getAutor());
			tempArticulo.setFechaPublicacion(articulo.getFechaPublicacion());
			tempArticulo.setRevista_Publicacion(articulo.getRevista_Publicacion());
			//Al ser un id diferente, el método save hace en realidad un update
			return articuloRepository.save(tempArticulo);
		}
		
		@DeleteMapping("/{id}")
		@ResponseStatus (HttpStatus.NO_CONTENT)
		public void delete(@PathVariable("id") Integer id) {
			articuloRepository.deleteById(id);
		}
	

}
