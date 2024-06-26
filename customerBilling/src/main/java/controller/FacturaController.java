package controller;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.FacturaModel;

@RestController
public class FacturaController {

	@Autowired
	RestTemplate template;	
	String url = "http://localhost:8080";
	
	@PostMapping(value="/createFactura", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> creacionFactura(@RequestBody FacturaModel billing) {
	    Map<String, Object> response = new HashMap<>();
		try {
	        // Realizamos la solicitud GET al microservicio
	        ResponseEntity<Map> customerResponse = template.getForEntity(url + "/customer/read/" + billing.getIdCustomer(), Map.class);

	        // Verificamos si la respuesta es exitosa
	        if (customerResponse.getStatusCode() == HttpStatus.OK) {
	            String urlBilling = "http://localhost:8081";	            
	            	Map<String, Object> responseBilling = new HashMap<>();
		            try {
		            	
		            	if((customerResponse.getBody().get("Status").equals(200))){
		            		ResponseEntity<Map> billingResponse = template.postForEntity(urlBilling + "/billing/create", billing, Map.class);
			            	responseBilling.put("Status", 200);
			            	responseBilling.put("Descripcion", "Creado correctamente la factura: ");
			            	responseBilling.put("Data", billingResponse.getBody());
			            	return responseBilling;
		            	}else {
		            		 response.put("ErrorBilling", "Error inesperado en el microservicio");
		            		 response.put("Status", customerResponse.getBody().get("Status"));
		            	}
		            	
		            }catch(Exception ee) {
		            	 response.put("ErrorBilling", ee.getMessage());	
		            }	            	            
	        } else {
	            response.put("ErrorCustomer", "Error al obtener el cliente");
	        }
	    } catch (Exception e) {
	        response.put("ErrorCustomer", e.getMessage());
	    }
	    return response;
	}
}
