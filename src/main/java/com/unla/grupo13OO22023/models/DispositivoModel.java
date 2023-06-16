package com.unla.grupo13OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class DispositivoModel {
	private int idDispositivo;

	public DispositivoModel(int idDispositivo) {
		super();
		this.idDispositivo = idDispositivo;
	}
	
}
