package com.apecs.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apecs.springboot.app.models.dao.PersonaDao;
import com.apecs.springboot.app.models.entity.Persona;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaDao personaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Persona> findAll() {

		return (List<Persona>) personaDao.findAll() ;
	}

	@Override
	@Transactional
	public Persona save(Persona persona) {
		return personaDao.save(persona);
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findbyId(Long id) {
		return personaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		personaDao.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly = true)
	public Persona findByCedula(String cedula) {
		return personaDao.findByCedula(cedula);
	}

}
