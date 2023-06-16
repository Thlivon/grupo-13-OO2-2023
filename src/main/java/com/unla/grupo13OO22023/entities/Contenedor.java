package com.unla.grupo13OO22023.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="contenedor")
public class Contenedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContenedor;
	
	@OneToOne
	@JoinColumn(name="sensor")
	private SensorContenedor sensor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="lugar", nullable=false)
	private Lugar lugar;
	
	public Contenedor(int idContenedor, SensorContenedor sensor, Lugar lugar) {
		super();
		this.idContenedor= idContenedor;
		this.sensor = sensor;
		this.lugar = lugar;
	}
	
	
}
