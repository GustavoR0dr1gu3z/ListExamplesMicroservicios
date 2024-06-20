package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dao.InventarioJpaRepository;
import model.InventarioModel;
import service.InventarioService;

@CrossOrigin(origins="*")
@RestController
public class InventarioController {
	
	@Autowired
	InventarioService service;
	@Autowired
	InventarioJpaRepository serviceRepo;
	
	
	//--> PRIMERO LOS GET
		//--> PRODUCTOS
			//--> PRODUCTOS CAROS
				@GetMapping(value ="producto/caro", produces=MediaType.APPLICATION_JSON_VALUE)
				public List<InventarioModel> obenerProductosCaros(){
					return serviceRepo.productoCaro();
				}
			//--> PRODUCTOS MEDIANOS
				@GetMapping(value ="producto/mediano", produces=MediaType.APPLICATION_JSON_VALUE)
				public List<InventarioModel> obenerProductosMedianos(){
					return serviceRepo.productoMedioCaro();
				}
			//--> PRODUCTOS MEDIANOS
				@GetMapping(value ="producto/barato", produces=MediaType.APPLICATION_JSON_VALUE)
				public List<InventarioModel> obenerProductosBaratos(){
					return serviceRepo.productoBarato();
				}
		//--CRUD
			//--> CREATE
				@PostMapping(value="producto/crear", produces=MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<String> crearProducto(@RequestBody InventarioModel inventario){
					return service.crearInvetarioService(inventario);
				}
			//--> READ
				@GetMapping(value="producto/{id}/{name}", produces=MediaType.APPLICATION_JSON_VALUE)
				public List<InventarioModel> obtenerProducto(@PathVariable("id") int idInventario, @PathVariable("name") String nombreInventario ){
					return service.buscarInventarioService(idInventario, nombreInventario);
				}
				
			//--> UPDATE
				@PutMapping(value="producto/actualizar", produces=MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<String> actualizarProducto(@RequestBody InventarioModel inventario){
					return service.actualizarInventarioService(inventario);
				}
				
			//--> DELETE
				@DeleteMapping(value="producto/eliminar/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
				public ResponseEntity<String> eliminarProducto(@PathVariable("id") int idInventario ){
					return service.eliminarInventarioService(idInventario);
				}
			
			

}
