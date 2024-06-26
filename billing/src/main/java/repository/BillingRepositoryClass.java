package repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.BillingModel;

@Repository
public class BillingRepositoryClass implements BillingInterfaceRepository {
	
	@Autowired
	BillingInterfaceRepositoryJPA jpa;

	@Override
	public Map<String, Object> createBilling(BillingModel billing) {
		Map<String, Object> response = new HashMap<>();
		try {			
			BillingModel billingSave = jpa.save(billing);
			response.put("Status", 200);
			response.put("Descripción", "Guardado correctamente");
			response.put("Billing", billingSave);
			
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}

	@Override
	public Map<String, Object> readBilling(Long idBilling) {
		Map<String, Object> response = new HashMap<>();		
		try {
			BillingModel billingSearch = jpa.findById(idBilling).orElse(null);
			if(billingSearch == null) {
				response.put("Status", 404);
				response.put("Descripción", "No existe ningún Billing");
				response.put("Count", 0);
			}else {				
				response.put("Status", 200);
				response.put("Descripción", "Ok");
				response.put("Data", billingSearch);
			}						
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}
	
	@Override
	public Map<String, Object> readBillingAll() {
		Map<String, Object> response = new HashMap<>();		
		try {
			List<BillingModel> billingList = jpa.findAll();
			if(billingList.size() > 0) {
				response.put("Status", 200);
				response.put("Descripción", "Ok");
				response.put("Count", billingList.size());
				response.put("Data", billingList);
			}else {
				response.put("Status", 404);
				response.put("Descripción", "No existe ningún billing");
				response.put("Count", 0);
				
			}						
		}catch(Exception e) {
			response.put("Status", 500);
			response.put("Descripción", e.getMessage());
		}
		return response;
	}


	@Override
	public Map<String, Object> updateBilling(Long idBilling, BillingModel billing) {
		Map<String, Object> response = new HashMap<>();
		try {			
			BillingModel billingSearch = jpa.findById(idBilling).orElse(null);
			if( billingSearch == null || jpa.findById(idBilling).isEmpty() ) {
				response.put("Status", 404);
				response.put("Descripción", "Billing no encontrado");
			}else {
				billing.setIdBilling(idBilling);
				jpa.save(billing);
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
	public Map<String, Object> deleteBilling(Long idBilling) {
		Map<String, Object> response = new HashMap<>();
		try {
			BillingModel billingDelete = jpa.findById(idBilling).orElse(null);
			if( billingDelete == null ) {
				response.put("Status", 404);
				response.put("Descripción", "No hay registros para eliminar");
			}else {
				jpa.deleteById(idBilling);
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
