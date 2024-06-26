package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

@Entity
@Table(name = "Billing")
@NamedQuery(name="BillingModel.findAll", query="SELECT c FROM BillingModel c")
public class BillingModel {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idBilling;
	private Long idCustomer;
	private String number;
	private String detalle;
	private double amount;
	
	
	public Long getIdBilling() {
		return idBilling;
	}
	public void setIdBilling(Long idBilling) {
		this.idBilling = idBilling;
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
