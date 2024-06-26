package model;

public class FacturaModel {
	
	private Long idCustomer;
	private String number;
	private String detalle;
	private double amount;
	
	String name;
	String lastName;
	String email;
	String phone;
	
	/*public FacturaModel(Long idCustomer, String name, String lastName, String email, String phone) {
		this.idCustomer = idCustomer;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
	}*/
	
	
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
	
	
	public Long getIdCustomer() {
		return idCustomer;
	}
	public void setIdCustomer(Long idCustomer) {
		this.idCustomer = idCustomer;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	
	

}
