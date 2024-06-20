package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import model.InventarioModel;

@Repository
public class InventarioClass implements InventarioDao {
	
	@Autowired
	InventarioJpaRepository inventarioJpa;

	@Override
	public ResponseEntity<String> crearInvetario(InventarioModel inventario) {
		try {
			inventarioJpa.save(inventario);
			return ResponseEntity.status(HttpStatus.CREATED).body("{\"status\": \"Guardado exitosamente\"}");
		}catch (Exception e) {
			String errorMessage = "Se produjo un error al crear el recurso: " + e.getMessage();
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + errorMessage + "\"}");
		}
	}
	
	@Override
	public List<InventarioModel> buscarInventario(int inventarioId, String nombreInventario ) {
		
		List<InventarioModel> listInventario = new ArrayList<>();
		String errorMessage2 = "";
		
		try {
			listInventario =  inventarioJpa.getInventarioByNameId(inventarioId, nombreInventario);			
		} catch (Exception e) {
			errorMessage2 = "Se produjo un error al encontrar el recurso: " + e.getMessage();			
		}
		
		if (listInventario.isEmpty()) {
			InventarioModel errorMessage = new InventarioModel();
	        errorMessage.setNombre("No se encontraron inventarios para los criterios de búsqueda especificados: "+errorMessage2);
	        return Collections.singletonList(errorMessage);
	    }
		return listInventario;	
	}

	@Override
	public ResponseEntity<String> actualizarInventario(InventarioModel inventario) {
		try {
			inventarioJpa.save(inventario);
			return ResponseEntity.status(HttpStatus.OK ).body("{\"status\": \"Actualizado exitosamente\"}");	
		} catch (Exception e) {
			String errorMessage = "Se produjo un error al actualizar el recurso: " + e.getMessage();
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + errorMessage + "\"}");
		}
		
	}

	@Override
	public ResponseEntity<String> eliminarInventario(int idInventario) {
		
		try {
		    inventarioJpa.deleteById(idInventario);
		    return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"Eliminado exitosamente\"}");
		} catch (Exception e) {
			String errorMessage = "Se produjo un error al eliminar el recurso: " + e.getMessage();
		    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"error\": \"" + errorMessage + "\"}");
		}
		
	}

}
