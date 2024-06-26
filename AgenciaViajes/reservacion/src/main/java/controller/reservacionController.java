package controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import model.reservacion;
import service.reservacionService;

@RestController
@RequestMapping(value="/reservacion")
public class reservacionController {
	
	@Autowired
	reservacionService s;

	@PostMapping(value="/create")
	public Map<String, Object> crearReservacion(@RequestBody reservacion r){
		return s.crearReservacion(r);
	}
}
