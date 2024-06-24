package repository;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import model.reservacion;

@Repository
public class reservacionRepositoryClass implements reservacionRepository {
	
	@Autowired
	reservacionRepositoryJpa jpaR;

	@Override
	public Map<String, Object> reservacionCompleta(reservacion r) {
		Map<String, Object> response = new HashMap<>();
		try {
			reservacion rv = jpaR.save(r);
			response.put("Status", 200);
			response.put("Descripcion", "Ok");
			response.put("Registro",rv);
		}catch(Exception e) {
			response.put("Status", 200);
			response.put("Descripcion", "Ok");
		}
		
		return response;
	}

}
