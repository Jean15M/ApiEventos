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

import com.apecs.springboot.app.models.entity.Reserva;
import com.apecs.springboot.app.models.services.ReservaService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ReservaController {
	@Autowired
	private ReservaService reservaService;

	@GetMapping("/reserva")
	public List<Reserva> index() {
		return reservaService.findAll();
	}

	@GetMapping("/reserva/{id}")
	public Reserva show(@PathVariable Long id) {
		return reservaService.findbyId(id);
	}
	
	@PostMapping("/reserva")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva create(@RequestBody Reserva reserva) {
		return reservaService.save(reserva);
	}

	@PutMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Reserva update(@RequestBody Reserva reserva, @PathVariable Long id) {
		Reserva reservaActual = reservaService.findbyId(id);
		reservaActual.setEstado(reserva.getEstado());
		return reservaService.save(reservaActual);
	}

	@DeleteMapping("/reserva/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		reservaService.delete(id);
	}

}
