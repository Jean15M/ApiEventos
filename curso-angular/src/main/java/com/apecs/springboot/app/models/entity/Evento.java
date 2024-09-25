package com.apecs.springboot.app.models.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_evento;

	private String nombre_evento;
	private Date fecha_evento;
	private String ubicacion;
	private Integer capacidad;

	@OneToMany(mappedBy = "evento")
	private List<Reserva> reserva;

	public Long getId_evento() {
		return id_evento;
	}

	public void setId_evento(Long id_evento) {
		this.id_evento = id_evento;
	}

	public String getNombre_evento() {
		return nombre_evento;
	}

	public void setNombre_evento(String nombre_evento) {
		this.nombre_evento = nombre_evento;
	}

	public Date getFecha_evento() {
		return fecha_evento;
	}

	public void setFecha_evento(Date fecha_evento) {
		this.fecha_evento = fecha_evento;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public Integer getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Integer capacidad) {
		this.capacidad = capacidad;
	}

	public List<Reserva> getReserva() {
		return reserva;
	}

	public void setReserva(List<Reserva> reserva) {
		this.reserva = reserva;
	}

	private static final long serialVersionUID = 1L;

}
