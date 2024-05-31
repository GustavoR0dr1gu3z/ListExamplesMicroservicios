package dao;

import org.springframework.http.ResponseEntity;

import model.ReservacionVueloModelo;

public interface ReservacionVueloDao {
	ResponseEntity<String> crearReservacionVuelo(ReservacionVueloModelo reservacionV);
}
