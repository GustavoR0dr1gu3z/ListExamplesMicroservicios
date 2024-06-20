package model;


import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name="contacts")
@NamedQuery(name="AgendaModel.findAll", query = "SELECT a FROM AgendaModel a")
public class AgendaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idContacts")
    private int idContacts;  // Renombrado para seguir la convención camelCase
    private String nombre;
    private String email;
    private String phone;
    
    public AgendaModel() {
    	
    }
    
	public int getIdContacts() {
		return idContacts;
	}
	public void setIdContacts(int idContacts) {
		this.idContacts = idContacts;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
    
    
    

}
