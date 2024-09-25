package com.apecs.springboot.app.models.services;

import java.util.List;

import com.apecs.springboot.app.models.entity.Persona;

public interface PersonaService {
	
	public List<Persona> findAll();

	public Persona save(Persona persona);

	public Persona findbyId(Long id);

	public void delete(Long id);
	
	public Persona findByCedula(String cedula);

}
