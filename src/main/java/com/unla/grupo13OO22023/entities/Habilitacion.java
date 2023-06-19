package com.unla.grupo13OO22023.entities;

import java.util.ArrayList;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="Habilitacion")
public class Habilitacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idHabilitacion;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name="habilitado")
	private boolean habilitado;
	
	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name="dispositivos", nullable=false)
	private Set<Dispositivo> dispositivos;

	public Habilitacion() {
		super();
	}

	public Habilitacion(String nombre) {
		super();
		this.nombre = nombre;
	}

	public Habilitacion(int idHabilitacion, String nombre, boolean habilitado) {
		super();
		this.idHabilitacion = idHabilitacion;
		this.nombre = nombre;
		this.habilitado = habilitado;
	}

	public int getIdHabilitacion() {
		return idHabilitacion;
	}

	public void setIdHabilitacion(int idHabilitacion) {
		this.idHabilitacion = idHabilitacion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isHabilitado() {
		return habilitado;
	}

	public void setHabilitado(boolean habilitado) {
		this.habilitado = habilitado;
	}

	public Set<Dispositivo> getDispositivos() {
		return dispositivos;
	}

	public void setDispositivos(Set<Dispositivo> dispositivos) {
		this.dispositivos = dispositivos;
	}

	
	
	
}
