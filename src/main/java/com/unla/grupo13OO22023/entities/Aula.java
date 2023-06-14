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


//Comprobar nombre de las tablas luego de creer la bdd en grupo!!

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="aula")
public class Aula {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idAula;
	
	@Column(name="cortinas")
	private boolean cortinas;
	
	@Column(name="luces")
	private boolean luces;
	
	@OneToOne
	@JoinColumn(name="camaraAula")
	private CamaraAula camara;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="edificio", nullable=false)
	private Lugar edificio;
 
	public Aula(int idAula, boolean cortinas, boolean luces, CamaraAula camara, Lugar edificio) {
		super();
		this.idAula = idAula;
		this.cortinas = cortinas;
		this.luces = luces;
		this.camara = camara;
		this.edificio = edificio;
	}
	
	
}
