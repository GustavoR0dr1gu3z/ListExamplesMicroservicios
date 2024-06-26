package controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import model.BillingModel;
import service.BillingService;


@RestController
@RequestMapping(value="/billing")
public class BillingController {

	@Autowired
	BillingService serviceCus;
	
	@Autowired
	RestTemplate template;
	String url = "http://localhost:8080/customer";
	
	@PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createBilling(@RequestBody BillingModel billing) {			
		return serviceCus.createBilling(billing);
	}
	
	@GetMapping(value="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> readBilling(@PathVariable("id") Long idBilling){
		return serviceCus.readBilling(idBilling);
	}
	
	@GetMapping(value="/readAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> readBilling(){
		return serviceCus.readBillingAll();
	}
	
	@PutMapping(value="/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> updateBilling(@PathVariable("id") Long idBilling, @RequestBody BillingModel billing){
		return serviceCus.updateBilling(idBilling, billing);
	}
	
	@DeleteMapping(value="/delete/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> deleteBilling(@PathVariable("id") Long idBilling){
		return serviceCus.deleteBilling(idBilling);
	}
	
	
	
	
}
