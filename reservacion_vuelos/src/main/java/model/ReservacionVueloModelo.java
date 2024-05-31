package model;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="VueloGeneral")
@NamedQuery(name="ReservacionVueloModelo.findAll", query = "SELECT rv FROM ReservacionVueloModelo rv")
public class ReservacionVueloModelo implements Serializable {
	
	public ReservacionVueloModelo() {
		
	}

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="idVuelo")
	private int idVuelo;
	
	@Column(name="Origen")
	private String Origen;
	
	@Column(name="Destino")
	private String destino;
	
	@Column(name="Fecha")
	private String fecha;
	
	@Column(name="Dias")
	private int dias;
	
	@Column(name="Hotel")
	private String hotel;
	
	@Column(name="Recamaras")
	private int recamaras;
	
	@Column(name="FkUsuario")
	private int fkUsuario;
	
	@Column(name="Precio")
	private String precio;
	

	public int getIdVuelo() {
		return idVuelo;
	}

	public void setIdVuelo(int idVuelo) {
		this.idVuelo = idVuelo;
	}

	public String getOrigen() {
		return Origen;
	}

	public void setOrigen(String origen) {
		Origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public int getDias() {
		return dias;
	}

	public void setDias(int dias) {
		this.dias = dias;
	}

	public String getHotel() {
		return hotel;
	}

	public void setHotel(String hotel) {
		this.hotel = hotel;
	}

	public int getRecamaras() {
		return recamaras;
	}

	public void setRecamaras(int recamaras) {
		this.recamaras = recamaras;
	}

	public int getFkUsuario() {
		return fkUsuario;
	}

	public void setFkUsuario(int fkUsuario) {
		this.fkUsuario = fkUsuario;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}
	
	
	

}
