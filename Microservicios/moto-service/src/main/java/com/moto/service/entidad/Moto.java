package com.moto.service.entidad;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Moto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMoto;
	private String marcaMoto;
	private String modeloMoto;
	private Integer idUsuario;
	
	public Integer getIdMoto() {
		return idMoto;
	}

	public void setIdMoto(Integer idMoto) {
		this.idMoto = idMoto;
	}

	public String getMarcaMoto() {
		return marcaMoto;
	}

	public void setMarcaMoto(String marcaMoto) {
		this.marcaMoto = marcaMoto;
	}

	public String getModeloMoto() {
		return modeloMoto;
	}

	public void setModeloMoto(String modeloMoto) {
		this.modeloMoto = modeloMoto;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Moto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
