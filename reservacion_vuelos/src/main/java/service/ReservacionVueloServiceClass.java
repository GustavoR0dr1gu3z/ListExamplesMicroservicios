package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import dao.ReservacionVueloDao;
import model.ReservacionVueloModelo;

@Service
public class ReservacionVueloServiceClass implements ReservacionVueloService {
	
	@Autowired
	ReservacionVueloDao dao;

	@Override
	public ResponseEntity<String> generarReservacion(ReservacionVueloModelo reservacion) {
		if( (reservacion.getDestino().length())>0 || (reservacion.getDestino().length())>0 ) {
			try{				
				dao.crearReservacionVuelo(reservacion);
				return ResponseEntity.status(HttpStatus.OK).body("{\"status\": \"Guardado exitosamente\"}");
			}catch(Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"Error al guardar\"}");
			}
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("{\"status\": \"Datos incompletos/incorrectos\"}");
		}
	}
	
}
