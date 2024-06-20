package service;

import java.util.List;
import java.util.Map;

import model.PaisesModel;


public interface PaisesServiceInterface {
	//List<PaisesModel> obtenerPaises();
	
	
	//List<PaisesModel> buscarPaises(String nombre);
	Map<String, Object> buscarPaises(String nombre);
	
	
	
	
	Map<String, Object> obtenerPaises();

}
