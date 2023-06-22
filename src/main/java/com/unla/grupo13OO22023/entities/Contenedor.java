package com.unla.grupo13OO22023.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name="contenedor")
public class Contenedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idContenedor;
	
	@Column(name="lugar")
	private String lugar;
	
	@OneToOne
	@JoinColumn(name="sensorContenedor")
	private SensorContenedor sensor;

	public Contenedor() {
		super();
	}

	public Contenedor(String lugar) {
		super();
		this.lugar = lugar;
	}

	public Contenedor(int idContenedor, String lugar, SensorContenedor sensor) {
		super();
		this.idContenedor = idContenedor;
		this.lugar = lugar;
		this.sensor = sensor;
	}

	public int getIdContenedor() {
		return idContenedor;
	}

	public void setIdContenedor(int idContenedor) {
		this.idContenedor = idContenedor;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public SensorContenedor getSensor() {
		return sensor;
	}

	public void setSensor(SensorContenedor sensor) {
		this.sensor = sensor;
	}
	
	
}
