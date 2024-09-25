package com.apecs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apecs.springboot.app.models.entity.Persona;



public interface PersonaDao extends CrudRepository<Persona, Long> {
	Persona findByCedula(String cedula);
}
