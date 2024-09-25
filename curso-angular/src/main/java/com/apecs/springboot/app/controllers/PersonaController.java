package com.apecs.springboot.app.controllers;

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

import com.apecs.springboot.app.models.entity.Persona;
import com.apecs.springboot.app.models.services.PersonaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class PersonaController {
	
	@Autowired
	private PersonaService personaService;

	@GetMapping("/persona")
	public List<Persona> index() {
		return personaService.findAll();
	}

	@GetMapping("/persona/{id}")
	public Persona show(@PathVariable Long id) {
		return personaService.findbyId(id);
	}
	
	@GetMapping("/persona/cedula/{cedula}")
	public Persona getPersonaByCedula(@PathVariable String cedula) {
		return personaService.findByCedula(cedula);
	}

	@PostMapping("/persona")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona create(@RequestBody Persona persona) {
		return personaService.save(persona);
	}

	@PutMapping("/persona/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Persona update(@RequestBody Persona persona, @PathVariable Long id) {
		Persona personaActual = personaService.findbyId(id);
		personaActual.setNombre(persona.getNombre());
		personaActual.setApellido(persona.getApellido());
		personaActual.setDireccion(persona.getDireccion());
		personaActual.setCorreo(persona.getCorreo());
		personaActual.setFecha_nacimiento(persona.getFecha_nacimiento());
		return personaService.save(personaActual);
	}

	@DeleteMapping("/persona/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		personaService.delete(id);
	}

}
