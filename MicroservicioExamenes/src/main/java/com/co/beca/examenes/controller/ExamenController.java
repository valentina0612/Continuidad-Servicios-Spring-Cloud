package com.co.beca.examenes.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.co.beca.common.usuario.models.entity.Examen;
import com.co.beca.common.usuario.models.entity.Pregunta;
import com.co.beca.commons.controller.CommonController;
import com.co.beca.examenes.service.ExamenService;

public class ExamenController extends CommonController<Examen, ExamenService>{
	@Value("${config.balanceador.test")
	private String balanceadorTest;
	
	@GetMapping("/balanceador-test")
	public ResponseEntity<?> balanceadorTest(){
		Map<String, Object> response = new HashMap<String, Object>();
				response.put("balanceador", balanceadorTest);
				response.put("exámen", service.findAll());
				
				return ResponseEntity.ok().body(response);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Examen examen, @PathVariable Long id){
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Examen examenBd = ob.get();
		examenBd.setNombre(examen.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenBd));
	}
	@PutMapping("/{id}/agregar-pregunta")
	public ResponseEntity<?> asignPregunta(@RequestBody List<Pregunta> pregunta, @PathVariable Long id){
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Examen examenBd = ob.get();
		pregunta.forEach(p-> {
			examenBd.addPregunta(p);
		});
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenBd));
	}
	
	@PutMapping("/{id}/eliminar-pregunta")
	public ResponseEntity<?> desasignarPregunta(@RequestBody Pregunta pregunta, @PathVariable Long id){
		Optional<Examen> ob = service.findById(id);
		
		if(ob.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		Examen examenBd = ob.get();
		examenBd.removePregunta(pregunta);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenBd));
	}
}
