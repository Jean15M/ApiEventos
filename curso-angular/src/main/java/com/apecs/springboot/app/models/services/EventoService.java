package com.apecs.springboot.app.models.services;

import java.util.List;

import com.apecs.springboot.app.models.entity.Evento;


public interface EventoService {
	public List<Evento> findAll();

	public Evento save(Evento evento);

	public Evento findbyId(Long id);

	public void delete(Long id);
}
