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
@Table(name = "Inventario")
@NamedQuery(name ="InventarioModel.findAll", query="SELECT i from InventarioModel i")
public class InventarioModel implements Serializable{

	private static final long serialVersionUID = 1L;
	
	 @Id
	 @GeneratedValue(strategy=GenerationType.IDENTITY)
	 @Column(name="idInventario")
	 private int idInventario;
	 
	 @Column(name="Nombre")
	 private String nombre;
	 
	 @Column(name="Descripción")
	 private String descripcion;
	 
	 @Column(name="Precio")
	 private double precio;
	 
	 @Column(name="Stock")
	 private int stock;
	 
	 @Column(name="FkStatus")
	 private int fkStatus;
	 
	public int getIdInventario() {
		return idInventario;
	}
	public void setIdInventario(int idInventario) {
		this.idInventario = idInventario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public int getFkStatus() {
		return fkStatus;
	}
	public void setFkStatus(int fkStatus) {
		this.fkStatus = fkStatus;
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
