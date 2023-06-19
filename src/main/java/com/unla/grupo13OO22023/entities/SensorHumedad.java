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
@Table(name="sensorHumedad")

public class SensorHumedad extends Dispositivo{
	
	@Column(name="tempBaja")
	private boolean tempBaja;
	
	@OneToOne
	@JoinColumn(name="espacioVerde")
	private EspacioVerde espacioVerde;

	public SensorHumedad(int idDispositivo, boolean activado, Habilitacion habilitado, EspacioVerde espacioVerde) {
		super(idDispositivo, activado, habilitado);
		this.tempBaja = false;
		this.espacioVerde = espacioVerde;
	}

	public SensorHumedad(int idDispositivo, boolean activado, Habilitacion habilitado, boolean tempBaja, EspacioVerde espacioVerde) {
		super(idDispositivo, activado, habilitado);
		this.tempBaja = tempBaja;
		this.espacioVerde = espacioVerde;
	}

	public SensorHumedad() {}

	public boolean isTempBaja() {
		return tempBaja;
	}

	public void setTempBaja(boolean tempBaja) {
		this.tempBaja = tempBaja;
	}

	public EspacioVerde getEspacioVerde() {
		return espacioVerde;
	}

	public void setEspacioVerde(EspacioVerde espacioVerde) {
		this.espacioVerde = espacioVerde;
	}

	
	
	
}
