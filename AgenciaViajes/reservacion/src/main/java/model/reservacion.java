package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Table(name = "reservacion")
@Entity
@NamedQuery(name = "reservacion.findAll", query = "SELECT r FROM reservacion r")
public class reservacion implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	Long idReservacion;
	String origen;
	String fkPais;
	String fkUsr;
	String precio;
	String fecha;
	String numPersonas;
	Long statusPago;
	
	public reservacion() {
		super();
	}
	
	public Long getIdReservacion() {
		return idReservacion;
	}
	public void setIdReservacion(Long idReservacion) {
		this.idReservacion = idReservacion;
	}
	public String getOrigen() {
		return origen;
	}
	public void setOrigen(String origen) {
		this.origen = origen;
	}
	public String getFkPais() {
		return fkPais;
	}
	public void setFkPais(String fkPais) {
		this.fkPais = fkPais;
	}
	public String getFkUsr() {
		return fkUsr;
	}
	public void setFkUsr(String fkUsr) {
		this.fkUsr = fkUsr;
	}
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNumPersonas() {
		return numPersonas;
	}
	public void setNumPersonas(String numPersonas) {
		this.numPersonas = numPersonas;
	}
	public Long getStatusPago() {
		return statusPago;
	}
	public void setStatusPago(Long statusPago) {
		this.statusPago = statusPago;
	}
	
	
}
