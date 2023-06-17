package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="espacioVerde")

public class EspacioVerde{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEspacioVerde;
	
	@Column(name="lugar")
	private String lugar;
	@OneToOne
	@JoinColumn(name="sensorHumedad")
	private SensorHumedad senHumedad;
	
	
	
	public EspacioVerde(int idEspacioVerde, String lugar, SensorHumedad senHumedad) {
		super();
		this.idEspacioVerde = idEspacioVerde;
		this.lugar = lugar;
		this.senHumedad = senHumedad;
	}
	
	
}
