package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import model.ReservacionVueloModelo;

@Repository
public class ReservacionVueloClass implements ReservacionVueloDao {

	@Autowired
	ReservacionVueloDaoJpa jpaR;
	
	@Override
	public ResponseEntity<String> crearReservacionVuelo(ReservacionVueloModelo reservacionV) {
		try{
			jpaR.save(reservacionV);
			return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"Guardado exitosamente\"}");
		}catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"Error al guardar\"}");
		}
	}

}
