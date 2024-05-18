package com.co.beca.usuarios.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.co.beca.common.usuario.models.entity.Alumno;


@Repository
public interface AlumnoRepository extends CrudRepository<Alumno, Long>{

}
