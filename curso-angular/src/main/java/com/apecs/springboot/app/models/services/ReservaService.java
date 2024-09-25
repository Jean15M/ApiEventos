package com.apecs.springboot.app.models.services;

import java.util.List;

import com.apecs.springboot.app.models.entity.Reserva;

public interface ReservaService {
	
	public List<Reserva> findAll();

	public Reserva save(Reserva reserva);

	public Reserva findbyId(Long id);

	public void delete(Long id);

}
