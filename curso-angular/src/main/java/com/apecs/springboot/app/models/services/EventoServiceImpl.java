package com.apecs.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apecs.springboot.app.models.dao.EventoDao;
import com.apecs.springboot.app.models.entity.Evento;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoDao eventoDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Evento> findAll() {
		
		return (List<Evento>) eventoDao.findAll();
	}

	@Override
	@Transactional
	public Evento save(Evento evento) {
	
		return eventoDao.save(evento);
	}

	@Override
	@Transactional(readOnly = true)
	public Evento findbyId(Long id) {
		
		return eventoDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
		eventoDao.deleteById(id);
	}

}
