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

	public CamaraAula(int idDispositivo, boolean activado, Habilitacion habilitado, Aula aula) {
		super(idDispositivo, activado, habilitado);
		this.aula = aula;
	}

	public CamaraAula(int idDispositivo, boolean activado, Habilitacion habilitado, boolean hayAlguien, Aula aula) {
		super(idDispositivo, activado, habilitado);
		this.hayAlguien = hayAlguien;
		this.aula = aula;
	}

	public boolean isHayAlguien() {
		return hayAlguien;
	}

	public void setHayAlguien(boolean hayAlguien) {
		this.hayAlguien = hayAlguien;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	@Override
	public String toString() {
		return super.toString()+"CamaraAula [hayAlguien=" + hayAlguien + ", aula=" + aula + "]";
	}

	
}
