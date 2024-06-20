package Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import model.PaisesModel;
import service.PaisesServiceImplementacion;

@RestController
public class PaisesController {

	@Autowired
	PaisesServiceImplementacion service;
	
	@GetMapping(value="/paises/listado", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<String, Object>> obtenerPaises() {
	//public List<PaisesModel> getPaises(){
		//return service.obtenerPaises();
		Map<String, Object> response = service.obtenerPaises();
		return ResponseEntity.ok(response);
	}
	
	@GetMapping(value="paises/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
	//public List<PaisesModel> getPaisesByName(@PathVariable("name") String name){
	public ResponseEntity<Map<String, Object>> getPaisesByName(@PathVariable("name") String name){
		Map<String, Object> response = service.buscarPaises(name);
		return ResponseEntity.ok(response);
	}
	
}
