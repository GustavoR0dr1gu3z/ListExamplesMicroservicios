package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Contacto;
import service.AgendaService;


@CrossOrigin(origins="*")
@RestController
public class ContactosController {

	@Autowired
	AgendaService service;
	
	@GetMapping(value="getContacts", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Contacto> recuperarContactos(){
		return service.recuperarContactos();
	}
	
	@GetMapping(value="getContactsById/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Contacto recuperarContactos(@PathVariable("id") int id) {
		return service.buscarContacto(id);
	}
	
	@PostMapping(value="postContacts", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String guardarContacto(@RequestBody Contacto contacto) {
		return String.valueOf(service.agregarContacto(contacto));
	}
	
	@PutMapping(value="putContacts", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void actualizarContacto(@RequestBody Contacto contacto) {
		service.actualizarContacto(contacto);
	}
	
	@DeleteMapping(value="deleteContactsById/{id}")
	public void eliminarPorId(@PathVariable("id") int idContacto) {
		service.eliminarContacto(idContacto);
	}
	
}
