package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Table(name="paises")
@Entity
@NamedQuery(name="Paises.findAll", query="SELECT u FROM Paises u")
public class Paises implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idPais;
	private String namePais;
	private String disponibilidad;
	private String status;
	
	
	public Paises() {
		super();
	}


	public Long getIdPais() {
		return idPais;
	}


	public void setIdPais(Long idPais) {
		this.idPais = idPais;
	}


	public String getNamePais() {
		return namePais;
	}


	public void setNamePais(String namePais) {
		this.namePais = namePais;
	}


	public String getDisponibilidad() {
		return disponibilidad;
	}


	public void setDisponibilidad(String disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	

}
