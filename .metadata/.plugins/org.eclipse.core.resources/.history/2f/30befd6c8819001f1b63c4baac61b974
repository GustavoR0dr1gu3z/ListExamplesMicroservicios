package com.boot.ejemplo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {
 
	@GetMapping(value="saludo", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludo() {
		return "Saludo desde microservicio";
	}
	
	
	@GetMapping(value="saludoParams/{nombree}", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludoParms (@PathVariable("nombree") String nombre) {
		return "Bienvenido a Springboot: "+nombre;
	}
	
	@GetMapping(value="saludoParamsDos", produces = MediaType.TEXT_PLAIN_VALUE)
	public String saludoParamsDos (@RequestParam("nombree") String nombre, @RequestParam("edaad") int edad ) {
		return "Bienvenido "+nombre+", tienes "+edad+" años";
	}
}
