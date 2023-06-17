package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAula;
	
	@Column(name="lugar")
	private String lugar;
	
	@Column(name="lucesYcortinas")
	private boolean lucesYcortinas;
	
	@OneToOne
	@JoinColumn(name="camaraAula")
	private CamaraAula camara;

	
	public Aula() {
		super();
	}

	public Aula(int idAula, String lugar, boolean lucesYcortinas, CamaraAula camara) {
		super();
		this.idAula = idAula;
		this.lugar = lugar;
		this.lucesYcortinas = lucesYcortinas;
		this.camara = camara;
	}

	public int getIdAula() {
		return idAula;
	}

	public void setIdAula(int idAula) {
		this.idAula = idAula;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public boolean isLucesYcortinas() {
		return lucesYcortinas;
	}

	public void setLucesYcortinas(boolean lucesYcortinas) {
		this.lucesYcortinas = lucesYcortinas;
	}

	public CamaraAula getCamara() {
		return camara;
	}

	public void setCamara(CamaraAula camara) {
		this.camara = camara;
	}
	
}
