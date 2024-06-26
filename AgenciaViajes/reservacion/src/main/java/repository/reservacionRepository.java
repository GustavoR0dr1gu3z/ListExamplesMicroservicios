package repository;

import java.util.Map;

import model.reservacion;

public interface reservacionRepository {
	
	Map<String, Object> reservacionCompleta(reservacion r);

}
