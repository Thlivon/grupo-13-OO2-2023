package com.unla.grupo13OO22023.entities;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name="dispositivo")

public class Dispositivo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idDispositivo;
	
	@Column(name="activado")
	private boolean activado;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idHabilitacion", nullable=false)
	private Habilitacion habilitado;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="dispositivo")
	private Set<Evento> eventos;
	
	
	//Si no lo agregaba el /new me tiraba error
	public Dispositivo() {
		super();
	}


	public Dispositivo(int idDispositivo, boolean activado, Habilitacion habilitado) {
		super();
		this.idDispositivo = idDispositivo;
		this.activado = activado;
		this.habilitado = habilitado;
	}


	public int getIdDispositivo() {
		return idDispositivo;
	}


	public void setIdDispositivo(int idDispositivo) {
		this.idDispositivo = idDispositivo;
	}


	public boolean isActivado() {
		return activado;
	}


	public void setActivado(boolean activado) {
		this.activado = activado;
	}


	public Habilitacion getHabilitado() {
		return habilitado;
	}


	public void setHabilitado(Habilitacion habilitado) {
		this.habilitado = habilitado;
	}


	public Set<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}


	@Override
	public String toString() {
		return "Dispositivo [idDispositivo=" + idDispositivo + ", activado=" + activado + ", habilitado=" + habilitado
				+ "]";
	}

	
	

}
