package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import entities.CustomerEntity;
import service.CustomerService;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	CustomerService customerRepo;
	
	@GetMapping(value="/listado")
	public List<CustomerEntity> listadoCustomers(){
		return customerRepo.findAll();
	}
	
	@PostMapping(value="Eliminar/{id}")
	public ResponseEntity<?> eliminarById(@PathVariable("id") Long id){
		try {
			customerRepo.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"Eliminado exitosamente\"}");
		}catch (Exception e) {
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(""
		            + "{"
		            + "\"status\": \"Error al eliminar\", "
		            + "\"description\": \"" + e.getMessage() + "\""
		            + "}");
		    }
		
	}
	
	@PostMapping(value="/guardar")
	public ResponseEntity<?> guardarCustomer(@RequestBody CustomerEntity customerBody){
		
		try {
			customerRepo.save(customerBody);
			//return ResponseEntity.ok(customerGuardado);
			 return ResponseEntity.status(HttpStatus.OK).body(""
			            + "{"
			            + "\"status\": \"Ok\", "
			            + "\"description\": \"Guardado\""
			            + "}");
			   
		}catch (Exception e) {
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(""
		            + "{"
		            + "\"status\": \"Error al guardar\", "
		            + "\"description\": \"" + e.getMessage() + "\""
		            + "}");
		    }
	}
	
	
	@PutMapping(value="/actualizar/{id}")
	public ResponseEntity<?> actualizaCustomerById(@RequestBody CustomerEntity customerBody){
		Optional<CustomerEntity> customerId = customerRepo.findById(customerBody.getId());
		
		if(customerId.isPresent()) {
			CustomerEntity newCustomer = customerId.get();
			newCustomer.setNombre(customerBody.getNombre());
			newCustomer.setPhone(customerBody.getPhone());
			CustomerEntity responseCustomerActualizado = customerRepo.save(newCustomer);
			return ResponseEntity.ok(responseCustomerActualizado);
			
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(""
					+ "{"
					+ "\"status\": \"Error al guardar\" "
					+ "\"description\": \"Customer no encontrado\""
					+ "}");
		}	
	}
		
}
