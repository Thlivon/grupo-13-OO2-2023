package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="Lugar")

public class Lugar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected int idLugar;
	
	@Column(name="nombre")
	protected String nombre;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="predio", nullable=false)
	protected Predio predio;

	public Lugar(int idLugar, String nombre, Predio predio) {
		super();
		this.idLugar = idLugar;
		this.nombre = nombre;
		this.predio = predio;
	}
	
	
	
	
}
