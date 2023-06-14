package com.unla.grupo13OO22023.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="EspacioVerde")

public class EspacioVerde extends Lugar{
	
	@OneToOne
	@JoinColumn(name="sensorHumedad")
	private SensorHumedad senHumedad;

	public EspacioVerde(int idLugar, String nombre, Predio predio) {
		super(idLugar, nombre, predio);
		this.senHumedad = null;
	}
	
	//agregar despues el sensor
	
	
}
