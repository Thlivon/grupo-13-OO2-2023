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
@Table(name="SensorHumedad")

public class SensorHumedad extends Dispositivo{
	
	@Column(name="tempBaja")
	private boolean tempBaja;
	
	@OneToOne
	@JoinColumn(name="espacioVerde")
	private EspacioVerde espacioVerde;

	public SensorHumedad(int idDispositivo, EspacioVerde espacioVerde) {
		super(idDispositivo, false);
		this.tempBaja = false;
		this.espacioVerde = espacioVerde;
	}

	
	
	
}
