package service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;

import model.PaisesModel;

@Service
public class PaisesServiceImplementacion implements PaisesServiceInterface {

	
	String urlServicio = "https://restcountries.com/v2/all";
	
	@Autowired
	RestTemplate template;
	
	@Override
	//public List<PaisesModel> obtenerPaises() {
	public Map<String, Object> obtenerPaises(){
		String resultado = template.getForObject(urlServicio, String.class); // un string de toda la data
		ObjectMapper maperCreado = new ObjectMapper();
		List<PaisesModel> paisCreado = new ArrayList<>();
		ArrayNode arrayCreado ;
		Integer status 		= 200;
		String  descripcion	= "";
		try{
			arrayCreado = (ArrayNode)maperCreado.readTree(resultado);
			 String nombre 		= "";
			 String capital 	= "";
			 String poblacion 	= "";
			 String bandera		= "";
			 status				= 200;
			 descripcion		= "Lista cargada correctamente";
			 
			for(Object ob:arrayCreado) {
				// Obtenemos JSON de la api y obtenemos lo que necesitamos
				ObjectNode jsonCreado = (ObjectNode)ob;
				
				if (jsonCreado.get("name") != null) {
					nombre = jsonCreado.get("name").asText();
				}
				
				if (jsonCreado.get("capital") != null) {
					capital = jsonCreado.get("capital").asText();
				}
				
				if (jsonCreado.get("population") != null) {
					poblacion = jsonCreado.get("population").asText();
				}
				
				if (jsonCreado.get("flag") != null) {
					bandera = jsonCreado.get("flag").asText();
				}
				
				paisCreado.add(new PaisesModel(nombre, capital, poblacion, bandera));
			}
		}catch(JsonProcessingException e) {
			e.printStackTrace();
			descripcion = "Error procesando la solicitud: "+e.getMessage();
            status = 500;
		}
		
		Map<String, Object> response = new HashMap<>();
        response.put("Status", status);
        response.put("Descripcion", descripcion);
        response.put("Data", paisCreado);
        response.put("Count", paisCreado.size());

        return response;
		//return paisCreado;
		
	}


	 @Override
	// public List<PaisesModel> buscarPaises(String nombre) {
	 public Map<String, Object> buscarPaises(String nombre) {
		 
		Integer status 		= 200;
		String  descripcion	= "";
		List<PaisesModel> paisModel = new ArrayList<>();
		List<PaisesModel> paisModel2 = new ArrayList<>();
		 
		paisModel.addAll( 
				(Collection<? extends PaisesModel>) 
					obtenerPaises().get("Data")
		);
		
		paisModel2.addAll( (paisModel).stream().filter(p->p.getNombre().contains(nombre)).collect(Collectors.toList()) );
		
		Map<String, Object> response = new HashMap<>();
        response.put("Status", status);
        response.put("Descripcion", descripcion);
        response.put("Data", paisModel2 );
        response.put("Count", paisModel2.size());

	        return response;
	  }

}
