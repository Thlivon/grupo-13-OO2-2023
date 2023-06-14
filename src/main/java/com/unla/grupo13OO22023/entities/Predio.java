package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="Predio")

public class Predio {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPredio;
	
	@Column(name="nombre")
	private String nombre;

	public Predio(int idPredio, String nombre) {
		this.idPredio = idPredio;
		this.nombre = nombre;
	}
	
	
	
}
