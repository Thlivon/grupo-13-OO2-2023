package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="camaraAula")
public class CamaraAula extends Dispositivo {
	@Column(name="hayAlguien")
	private boolean hayAlguien;
	
	@OneToOne
	@JoinColumn(name="aula")
	private Aula aula;
	
	
	public CamaraAula() {
		super();
	}

	public CamaraAula(int idDispositivo, Aula aula) {
		super(idDispositivo);
		this.aula = aula;
	}

	public CamaraAula(int idDispositivo, boolean altaLogicaYActivadoEmpiezanEn, boolean hayAlguien, Aula aula) {
		super(idDispositivo, altaLogicaYActivadoEmpiezanEn);
		this.hayAlguien = hayAlguien;
		this.aula = aula;
	}
	

}
