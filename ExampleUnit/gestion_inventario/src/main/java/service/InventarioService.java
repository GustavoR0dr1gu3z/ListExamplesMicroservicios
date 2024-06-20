package service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import model.InventarioModel;

public interface InventarioService {
	
	// CRUD
	
		// CREATE
			ResponseEntity<String> crearInvetarioService(InventarioModel inventario);
		
		// READ
			List<InventarioModel> buscarInventarioService(int inventarioId, String nombreInventario);
		
		// UPDATE
			ResponseEntity<String> actualizarInventarioService(InventarioModel inventario);
		
		// DELETE
			ResponseEntity<String> eliminarInventarioService(int idInventario);
}
