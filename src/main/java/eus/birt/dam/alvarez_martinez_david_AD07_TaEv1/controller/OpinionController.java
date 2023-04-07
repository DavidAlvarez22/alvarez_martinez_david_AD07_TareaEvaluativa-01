package eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.domain.Opinion;
import eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.repository.ArticuloRepository;
import eus.birt.dam.alvarez_martinez_david_AD07_TaEv1.repository.OpinionRepository;

@CrossOrigin (origins= {"http://localhost:4200"})
@RestController
@RequestMapping ("api/opiniones")
public class OpinionController {

	@Autowired
	OpinionRepository opinionRepository;
	
	@Autowired
	ArticuloRepository articuloRepository;
		
	@GetMapping({"/",""})
	public List <Opinion> index() {
		return opinionRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Opinion show(@PathVariable("id") int id) {
		return opinionRepository.findById(id).orElse(null);
	}
	
	@PostMapping({"","/"})
	@ResponseStatus (HttpStatus.CREATED)
	public Opinion create(@RequestBody Opinion opinion) {
		return opinionRepository.save(opinion);
	}
	
	@PutMapping("/{id}")
	@ResponseStatus (HttpStatus.CREATED)
	public Opinion update(@RequestBody Opinion opinion, @PathVariable("id") int id) {
		Opinion tempOpinion = opinionRepository.findById(id).orElse(null);
		
		tempOpinion.setNombre(opinion.getNombre());
		tempOpinion.setValoracion(opinion.getValoracion());
		tempOpinion.setFechaValoracion(opinion.getFechaValoracion());
		tempOpinion.setRazon(opinion.getRazon());
				
		return opinionRepository.save(tempOpinion);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus (HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") int id) {
		opinionRepository.deleteById(id);
	}
	
}


