package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dao.InventarioDao;
import model.InventarioModel;


@Service
public class InventarioClassService implements InventarioService {
	
	@Autowired
	InventarioDao dao;

	@Override
	public ResponseEntity<String> crearInvetarioService(InventarioModel inventario) {
		return dao.crearInvetario(inventario);
	}

	@Override
	public List<InventarioModel> buscarInventarioService(int inventarioId, String nombreInventario) {
		return dao.buscarInventario(inventarioId, nombreInventario);
	}

	@Override
	public ResponseEntity<String> actualizarInventarioService(InventarioModel inventario) {
		return dao.actualizarInventario(inventario);  //actualizarInventarioService(inventario);
	}

	@Override
	public ResponseEntity<String> eliminarInventarioService(int idInventario) {
		return dao.eliminarInventario(idInventario);//eliminarInventarioService(idInventario);
	}

}
