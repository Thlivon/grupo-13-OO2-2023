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
@Table(name="sensorContenedor")
public class SensorContenedor extends Dispositivo {
	
	@Column(name="estaLleno")
	private boolean estaLleno;
	
	@OneToOne
	@JoinColumn(name="contenedor")
	private Contenedor contenedor;
	
	public SensorContenedor() {
		super();
	}

	public SensorContenedor(int idDispositivo, boolean estaLleno) {
		super(idDispositivo);
		this.estaLleno = estaLleno;
	}
	
	
}
