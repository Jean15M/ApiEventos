package com.apecs.springboot.app.models.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.apecs.springboot.app.models.dao.ReservaDao;
import com.apecs.springboot.app.models.entity.Reserva;

@Service
public class ReservaServiceImpl implements ReservaService {

	@Autowired
	private ReservaDao reservaDao;
	
	@Override
	@Transactional(readOnly = true)
	public List<Reserva> findAll() {
		
		return (List<Reserva>) reservaDao.findAll();
	}

	@Override
	@Transactional
	public Reserva save(Reserva reserva) {
		
		return reservaDao.save(reserva);
	}

	@Override
	@Transactional(readOnly = true)
	public Reserva findbyId(Long id) {
		
		return reservaDao.findById(id).orElse(null);
	}

	@Override
	@Transactional
	public void delete(Long id) {
	
		reservaDao.deleteById(id);
	}

}
