package com.co.beca.examenes.repository;

import org.springframework.data.repository.CrudRepository;
import com.co.beca.common.usuario.models.entity.Examen;



public interface ExamenRepository extends CrudRepository<Examen, Long>{

}
