package com.carro.service.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carro.service.entidad.Carro;
import com.carro.service.servicio.CarroServicio;

@RestController
@RequestMapping("/carro")
public class CarroController {
	@Autowired
	private CarroServicio carroServicio;
	
	@GetMapping
	public ResponseEntity <List <Carro>> listarCarros(){
		List<Carro> carros = carroServicio.getAll();
		if(carros.isEmpty()) {			
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carros);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Carro> obtenerCarros(@PathVariable("id") int idCarro) { //ESTO LISTA USUARIOS POR ID
		Carro carro = carroServicio.getCarroById(idCarro);
		if(carro == null){
			return ResponseEntity.notFound().build();				
		}
		return ResponseEntity.ok(carro);
	}
	
	@PostMapping
	public ResponseEntity<Carro> guardarUsuarios(@RequestBody Carro carro){
		Carro nuevoCarro = carroServicio.saveCarro(carro);
		return ResponseEntity.ok(nuevoCarro);
	}
	
	@GetMapping("/usuario/{idUsuario}")
	public ResponseEntity <List<Carro>> buscarCarroByIdUsuario(@PathVariable("idUsuario") int idUsuarioo){
		List<Carro> carro = carroServicio.carroByIdUsuario(idUsuarioo);
		if(carro == null || carro.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(carro);
	}
	
	
}
