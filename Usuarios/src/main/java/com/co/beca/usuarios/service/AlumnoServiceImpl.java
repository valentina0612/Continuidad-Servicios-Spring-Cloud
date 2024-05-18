package com.co.beca.usuarios.service;

import org.springframework.stereotype.Service;

import com.co.beca.common.usuario.models.entity.Alumno;
import com.co.beca.commons.service.CommonService;
import com.co.beca.commons.service.CommonServiceImpl;
import com.co.beca.usuarios.repository.AlumnoRepository;



@Service
public class AlumnoServiceImpl extends  CommonServiceImpl<Alumno, AlumnoRepository> implements CommonService<Alumno>{


}
