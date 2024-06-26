package service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.reservacion;
import repository.reservacionRepositoryClass;

@Service
public class reservacionService {

	@Autowired
	reservacionRepositoryClass repo;
	
	public Map<String, Object> crearReservacion(reservacion r){
		return repo.reservacionCompleta(r);
	}
}
