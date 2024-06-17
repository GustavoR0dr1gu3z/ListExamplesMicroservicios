package model;

public class PaisesModel {

	private String nombre;
	private String capital;
	private String poblacion;
	private String bandera;
	
	
	public PaisesModel(String nombre, String capital, String poblacion, String bandera) {
		super();		
		this.nombre 	= nombre;
		this.capital 	= capital;
		this.poblacion	= poblacion;
		this.bandera	= bandera;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getPoblacion() {
		return poblacion;
	}
	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}
	public String getBandera() {
		return bandera;
	}
	public void setBandera(String bandera) {
		this.bandera = bandera;
	}
	
	
	
}
