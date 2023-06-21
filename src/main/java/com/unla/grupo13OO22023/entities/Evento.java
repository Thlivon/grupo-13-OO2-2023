package com.unla.grupo13OO22023.entities;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
@Table(name="evento")
public class Evento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idEvento;
	
	@Column(name="descripcion")
	private String descripcion;
	
	@Column(name="fechaYHora")
	@CreationTimestamp
	private LocalDateTime fechaYHora;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="idDispositivo", nullable=false)
	private Dispositivo dispositivo;

	public Evento() {
		super();
	}

	
	public Evento(String descripcion) {
		super();
		this.descripcion = descripcion;
	}


	public Evento(String descripcion, Dispositivo dispositivo) {
		super();
		this.descripcion = descripcion;
		this.dispositivo = dispositivo;
	}

	public Evento(int idEvento, String descripcion, LocalDateTime fechaYHora, Dispositivo dispositivo) {
		super();
		this.idEvento = idEvento;
		this.descripcion = descripcion;
		this.fechaYHora = fechaYHora;
		this.dispositivo = dispositivo;
	}

	public int getIdEvento() {
		return idEvento;
	}

	public void setIdEvento(int idEvento) {
		this.idEvento = idEvento;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public LocalDateTime getFechaYHora() {
		return fechaYHora;
	}

	public void setFechaYHora(LocalDateTime fechaYHora) {
		this.fechaYHora = fechaYHora;
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}


	@Override
	public String toString() {
		return "Evento [idEvento=" + idEvento + ", descripcion=" + descripcion + ", fechaYHora=" + fechaYHora
				+ ", dispositivo=" + dispositivo + "]";
	}
	
	
	
}
