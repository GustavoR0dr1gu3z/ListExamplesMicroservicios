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
@Table(name="Contacts")
@NamedQuery(name="Contacto.findAll", query="SELECT c FROM Contacto c")
public class Contacto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="idContacts")
    private int idContacts;  // Renombrado para seguir la convención camelCase

    private String nombre;
    
    private String email;
    
    private String phone;

    // Constructor sin parámetros
    public Contacto() {
    }

    // Getters y setters
    public int getIdContacts() {  // Renombrado para seguir la convención camelCase
        return idContacts;
    }

    public void setIdContacts(int idContacts) {  // Renombrado para seguir la convención camelCase
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
