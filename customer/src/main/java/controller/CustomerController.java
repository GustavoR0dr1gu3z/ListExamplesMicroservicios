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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.websocket.server.PathParam;
import model.CustomerModel;
import service.CustomerService;


@RestController
@RequestMapping(value="/customer")
public class CustomerController {

	@Autowired
	CustomerService serviceCus;
	
	@PostMapping(value="/create", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> createCustomer(@RequestBody CustomerModel customer) {
		return serviceCus.createCustomer(customer);
	}
	
	@GetMapping(value="/read/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> readCustomer(@PathVariable("id") Long idCustomer){
		return serviceCus.readCustomer(idCustomer);
	}
	
	@GetMapping(value="/readAll", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> readCustomer(){
		return serviceCus.readCustomerAll();
	}
	
	@PutMapping(value="/update/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> updateCustomer(@PathVariable("id") Long idCustomer, @RequestBody CustomerModel customer){
		return serviceCus.updateCustomer(idCustomer, customer);
	}
	
	@DeleteMapping(value="/delete/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> deleteCustomer(@PathVariable("id") Long idCustomer){
		return serviceCus.deleteCustomer(idCustomer);
	}
	
	
	
	
}
