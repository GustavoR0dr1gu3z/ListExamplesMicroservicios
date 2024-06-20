package controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.Persona;
import service.AccesoServiceInterfaz;

@RestController
public class PersonasController {

	@Autowired
	AccesoServiceInterfaz service;
	
	
	String url = "http://localhost:8080";
	
	@GetMapping(value="/personas/{nombre}/{email}/{edad}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre,
			@PathVariable("email") String email,
			@PathVariable("edad") int edad){
		Persona persona = new Persona(nombre, email, edad); // CONSTRUIR EL OBJETO 
		//template.postForLocation(url+"/contactos", persona); // ESTO SE ENVIA AL OBJETO CREADO
		//Persona[] personas =  template.getForObject(url+"/contactos",Persona[].class); 
		CompletableFuture<List<Persona>> resultado = service.llamadaServicio(persona);
		
		
		for(int i=0; i<50; i++){
			try {
				System.out.print("Esperando");
				Thread.sleep(50);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		try {
			return resultado.get();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	

}
