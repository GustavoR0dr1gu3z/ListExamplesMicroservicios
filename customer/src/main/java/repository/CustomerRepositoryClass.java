package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.CustomerModel;

@Repository
public class CustomerRepositoryClass implements CustomerInterfaceRepository {
	
	@Autowired
	CustomerInterfaceRepositoryJPA jpa;

	@Override
	public Map<String, Object> createCustomer(CustomerModel customer) throws Exception{
		Map<String, Object> response = new HashMap<>();
		try {
				String email = customer.getEmail();
				CustomerModel customerSearch = jpa.findByEmailCustomer(email);
				if( customerSearch == null ) {
					CustomerModel customerSave = jpa.save(customer);
					response.put("Status", 200);
					response.put("Descripción", "Guardado correctamente");
					response.put("Customer", customerSave);
				}
				throw new Exception("Customer Duplicadoooooooo");
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}

	@Override
	public Map<String, Object> readCustomer(Long idCustomer) {
		Map<String, Object> response = new HashMap<>();		
		try {
			CustomerModel customerSearch = jpa.findById(idCustomer).orElse(null);
			if(customerSearch == null) {
				response.put("Status", 404);
				response.put("Descripción", "No existe ningún customer");
				response.put("Count", 0);
			}else {				
				response.put("Status", 200);
				response.put("Descripción", "Ok");
				response.put("Data", customerSearch);
			}						
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}
	
	@Override
	public Map<String, Object> readCustomerAll() {
		Map<String, Object> response = new HashMap<>();		
		try {
			List<CustomerModel> customerList = jpa.findAll();
			if(customerList.size() > 0) {
				response.put("Status", 200);
				response.put("Descripción", "Ok");
				response.put("Count", customerList.size());
				response.put("Data", customerList);
			}else {
				response.put("Status", 404);
				response.put("Descripción", "No existe ningún customer");
				response.put("Count", 0);
				
			}						
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}


	@Override
	public Map<String, Object> updateCustomer(Long idCustomer, CustomerModel customer) {
		Map<String, Object> response = new HashMap<>();
		try {
			String email = customer.getEmail();
			CustomerModel customerSearch = jpa.findByEmailCustomer(email);
			if( customerSearch == null || jpa.findById(idCustomer).isEmpty() ) {
				response.put("Status", 404);
				response.put("Descripción", "Customer no encontrado");
			}else {
				customer.setIdCustomer(idCustomer);
				jpa.save(customer);
				response.put("Status", 200);
				response.put("Descripción", "Actualizado");				
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}

	@Override
	public Map<String, Object> deleteCustomer(Long idCustomer) {
		Map<String, Object> response = new HashMap<>();
		try {
			CustomerModel customerDelete = jpa.findById(idCustomer).orElse(null);
			if( customerDelete == null ) {
				response.put("Status", 404);
				response.put("Descripción", "No hay registros para eliminar");
			}else {
				jpa.deleteById(idCustomer);
				response.put("Status", 200);
				response.put("Descripción", "Eliminado");	
			}
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}

}
