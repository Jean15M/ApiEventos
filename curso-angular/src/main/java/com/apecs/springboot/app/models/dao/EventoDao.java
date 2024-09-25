package com.apecs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apecs.springboot.app.models.entity.Evento;

public interface EventoDao extends CrudRepository<Evento, Long> {

}
