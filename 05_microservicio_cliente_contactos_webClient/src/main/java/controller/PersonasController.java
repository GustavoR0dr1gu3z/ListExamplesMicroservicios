package controller;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import model.Persona;

@RestController
public class PersonasController {
	
	@Autowired
	WebClient webClient;
	String url = "http://localhost:8080";
	
	@GetMapping(value="/personas/{nombre}/{email}/{edad}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> altaPersona(@PathVariable("nombre") String nombre,
			@PathVariable("email") String email,
			@PathVariable("edad") int edad){
		Persona persona = new Persona(nombre, email, edad); // CONSTRUIR EL OBJETO 
		
		webClient
		.post() //RequestBodyUriRequest
		.uri(url+"/contactos") // requestBodySpec
		.contentType(MediaType.APPLICATION_JSON) // RequestBodySpec
		.bodyValue(persona) //RequestHeadersSpec
		.retrieve() // ResponseSpec
		.bodyToMono(Void.class) // Devuelve un Mono<Void>
		.block(); // Void
		
		Persona[] personas = webClient
		.get() // RequestHeadersUriSpec
		.uri(url+"/contactos") // RequestHeadersSpec
		.retrieve() // ResponseSpec
		.bodyToMono(Persona[].class) // Mono<Persona>
		.block(); // Array de Persona[]
		
		
		return Arrays.asList(personas);
	}
	
	
	// Un servicio cliente hace peticiones más especificas, como personas entre un rango de edades
	// Usar otro servicio para hacer peticiones a las db
	/*@GetMapping(value="/personas/{edad1}/{edad2}", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> buscarEdadesPersona(@PathVariable("edad1") int edad1, @PathVariable("edad2") int edad2){
		Persona[] personas =  template.getForObject(url+"/contactos",Persona[].class); 
		return Arrays.stream(personas)
				.filter( p->p.getEdad() >= edad1 && p.getEdad()<=edad2 )
				.collect(Collectors.toList());
	}*/

}
