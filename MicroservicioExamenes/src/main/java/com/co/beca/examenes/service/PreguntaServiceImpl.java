package com.co.beca.examenes.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.co.beca.common.usuario.models.entity.Pregunta;
import com.co.beca.examenes.repository.PreguntaRepository;

public class PreguntaServiceImpl  implements PreguntaService{
	
	@Autowired
	PreguntaRepository dao;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Pregunta> findAll() {
		
		return dao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Pregunta> findById(Long id) {
		
		return dao.findById(id);
	}

	@Override
	@Transactional
	public Pregunta save(Pregunta pregunta) {
		
		return dao.save(pregunta);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		dao.deleteById(id);
		
	}

}
