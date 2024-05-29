package com.moto.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.moto.service.entidad.Moto;
import com.moto.service.servicio.MotoServicio;


@RestController
@RequestMapping("/moto")
public class MotoController {
	@Autowired
	private MotoServicio motoServicio;
	
	@GetMapping
	public ResponseEntity <List <Moto>> listarMotos(){
		List<Moto> motos = motoServicio.getAll();
		if(motos.isEmpty()) {			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Moto> obtenerMotos(@PathVariable("id") int idMoto) { //ESTO LISTA USUARIOS POR ID
		Moto moto = motoServicio.getMotoById(idMoto);
		if(moto == null){
			return ResponseEntity.notFound().build();				
		}
		return ResponseEntity.ok(moto);
	}
	
	@PostMapping
	public ResponseEntity<Moto> guardarMotos(@RequestBody Moto moto){
		Moto nuevaMoto = motoServicio.saveMoto(moto);
		return ResponseEntity.ok(nuevaMoto);
	}
	
	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity <List<Moto>> buscarCarroByIdUsuario(@PathVariable("idUsuario") int idUsuarioo){
		List<Moto> moto = motoServicio.motoByIdUsuario(idUsuarioo);
		if(moto == null || moto.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto);
	}
	
}
