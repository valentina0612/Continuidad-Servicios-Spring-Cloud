package com.co.beca.common.usuario.models.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name="preguntas")
public class Pregunta {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String texto;
	
	@JsonIgnoreProperties(value = {"preguntas"})
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="examen_id")
	private Examen examen;

	public Pregunta(Long id, String texto, Examen examen) {
		this.id = id;
		this.texto = texto;
		this.examen = examen;
	}
	
	public Pregunta() {
		
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto= texto;
	}
	
	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}
}