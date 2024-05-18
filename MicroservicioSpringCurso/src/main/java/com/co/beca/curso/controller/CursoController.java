package com.co.beca.curso.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.co.beca.common.usuario.models.entity.Alumno;
import com.co.beca.common.usuario.models.entity.Curso;
import com.co.beca.commons.controller.CommonController;
import com.co.beca.curso.services.CursoService;


@RestController
public class CursoController extends CommonController<Curso, CursoService>{
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Curso curso, @PathVariable Long id){
		Optional<Curso> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		cursoBd.setNombre(curso.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	
	@PutMapping("/{id}/asignar-alumno")
	public ResponseEntity<?> asignarAlumno(@RequestBody List<Alumno> alumno, @PathVariable Long id){
		Optional<Curso> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		alumno.forEach(a-> {
			cursoBd.addAlumnos(a);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	
	@PutMapping("/{id}/eliminar-alumno")
	public ResponseEntity<?> desasignarAlumno(@RequestBody Alumno alumno, @PathVariable Long id){
		Optional<Curso> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Curso cursoBd = ob.get();
		cursoBd.removeAlumnos(alumno);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoBd));
	}
	
	
}
