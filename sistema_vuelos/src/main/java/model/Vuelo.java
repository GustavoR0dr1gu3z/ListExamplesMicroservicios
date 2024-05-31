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
@NamedQuery(name="Vuelo.findAll()", query = "SELECT v FROM Vuelo v")
public class Vuelo implements Serializable {
	
	public Vuelo() {
		
	}
	
	private int status;
	private String Descripcion;
	private DetallesReserva reservacionDetalles;
	
	
	
	public int getStatus() {
		return status;
	}



	public void setStatus(int status) {
		this.status = status;
	}



	public String getDescripcion() {
		return Descripcion;
	}



	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}



	public DetallesReserva getReservacionDetalles() {
		return reservacionDetalles;
	}



	public void setReservacionDetalles(DetallesReserva reservacionDetalles) {
		this.reservacionDetalles = reservacionDetalles;
	}



	public static class DetallesReserva {
		private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(strategy=GenerationType.IDENTITY)
	    @Column(name="idVuelo")
	    private int idVuelo; 
	    
	    @Column(name="Origen")
	    private String origen; 
	    
	    @Column(name="Destino")
	    private String destino;
	    
	    @Column(name="Fecha")
	    private LocalDate fecha;
	    
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
			return origen;
		}

		public void setOrigen(String origen) {
			this.origen = origen;
		}

		public String getDestino() {
			return destino;
		}

		public void setDestino(String destino) {
			this.destino = destino;
		}

		public LocalDate getFecha() {
			return fecha;
		}

		public void setFecha(LocalDate fecha) {
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
}