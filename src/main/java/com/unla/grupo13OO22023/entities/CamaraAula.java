package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Comprobar nombre de las tablas luego de creer la bdd en grupo!!
@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="camaraAula")
public class CamaraAula extends Dispositivo {
	@Column(name="hayAlguien")
	private boolean hayAlguien;
	
	public CamaraAula(int idDispositivo, boolean hayAlguien) {
		super(idDispositivo);
		this.hayAlguien = hayAlguien;
	}
	

}
