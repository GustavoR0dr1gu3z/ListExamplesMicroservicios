package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.BillingModel;
import repository.BillingRepositoryClass;

@Service
public class BillingService {

	@Autowired
	BillingRepositoryClass repo;
	
	public Map<String, Object> createBilling(BillingModel billing){
		return repo.createBilling(billing);
	}
	public Map<String, Object> readBilling(Long idBilling){
		return repo.readBilling(idBilling);
	}
	public Map<String, Object> readBillingAll(){
		return repo.readBillingAll();
	}
	public Map<String, Object> updateBilling(Long idBilling, BillingModel billing){
		return repo.updateBilling(idBilling, billing);
	}
	public Map<String, Object> deleteBilling(Long idBilling){
		return repo.deleteBilling(idBilling);
	}
	
	
}
