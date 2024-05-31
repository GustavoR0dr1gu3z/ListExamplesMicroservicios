package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.ReservacionVueloModelo;
import service.ReservacionVueloService;


@CrossOrigin(origins="*")
@RestController
public class ReservacionVueloController {

	@Autowired
	ReservacionVueloService serviceRV;
	
	@PostMapping(value="vuelos/reservacion/crear/",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> generarReservacion(@RequestBody ReservacionVueloModelo reservacion){
		return serviceRV.generarReservacion(reservacion);
	}
	
}
