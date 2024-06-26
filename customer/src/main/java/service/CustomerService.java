package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.CustomerModel;
import repository.CustomerRepositoryClass;

@Service
public class CustomerService {

	@Autowired
	CustomerRepositoryClass repo;
	
	public Map<String, Object> createCustomer(CustomerModel customer){
		return repo.createCustomer(customer);
	}
	public Map<String, Object> readCustomer(Long idCustomer){
		return repo.readCustomer(idCustomer);
	}
	public Map<String, Object> readCustomerAll(){
		return repo.readCustomerAll();
	}
	public Map<String, Object> updateCustomer(Long idCustomer, CustomerModel customer){
		return repo.updateCustomer(idCustomer, customer);
	}
	public Map<String, Object> deleteCustomer(Long idCustomer){
		return repo.deleteCustomer(idCustomer);
	}
	
	
}
