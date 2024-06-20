package dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import model.InventarioModel;
public interface InventarioDao {
	
	
	// CRUD
	
	// CREATE
		ResponseEntity<String> crearInvetario(InventarioModel inventario);
	
	// READ
		List<InventarioModel> buscarInventario(int inventarioId, String nombreInventario);
	
	// UPDATE
		ResponseEntity<String> actualizarInventario(InventarioModel inventario);
	
	// DELETE
		ResponseEntity<String> eliminarInventario(int idInventario);
	

}
