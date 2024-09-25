package com.apecs.springboot.app.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.apecs.springboot.app.models.entity.Reserva;

public interface ReservaDao extends CrudRepository<Reserva, Long> {

}
