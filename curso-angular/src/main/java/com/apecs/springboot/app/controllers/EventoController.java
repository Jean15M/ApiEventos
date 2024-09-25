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

import com.apecs.springboot.app.models.entity.Evento;
import com.apecs.springboot.app.models.services.EventoService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class EventoController {
	
	@Autowired
	private EventoService eventoService;

	@GetMapping("/evento")
	public List<Evento> index() {
		return eventoService.findAll();
	}

	@GetMapping("/evento/{id}")
	public Evento show(@PathVariable Long id) {
		return eventoService.findbyId(id);
	}
	

	@PostMapping("/evento")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento create(@RequestBody Evento evento) {
		return eventoService.save(evento);
	}

	@PutMapping("/evento/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Evento update(@RequestBody Evento evento, @PathVariable Long id) {
		Evento eventoActual = eventoService.findbyId(id);
		eventoActual.setNombre_evento(evento.getNombre_evento());
		eventoActual.setUbicacion(evento.getUbicacion());
		eventoActual.setFecha_evento(evento.getFecha_evento());
		return eventoService.save(eventoActual);
	}

	@DeleteMapping("/evento/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		eventoService.delete(id);
	}

}
