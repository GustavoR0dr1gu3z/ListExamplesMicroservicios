package model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Table(name="usuarios")
@Entity
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long idUsuario;
	private String name;
	private String lastName;
	private String phone;
	private String email;
	private String fkReservacion;
	private String fkStatus;
	
	public Usuario() {
		super();
	}
	
	public long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFkReservacion() {
		return fkReservacion;
	}
	public void setFkReservacion(String fkReservacion) {
		this.fkReservacion = fkReservacion;
	}
	public String getFkStatus() {
		return fkStatus;
	}
	public void setFkStatus(String fkStatus) {
		this.fkStatus = fkStatus;
	}
	
	

}
