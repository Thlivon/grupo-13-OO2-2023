package com.unla.grupo13OO22023.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CamaraModel {
	private int idCamara;

	public CamaraModel(int idCamara) {
		super();
		this.idCamara = idCamara;
	}
	
}
