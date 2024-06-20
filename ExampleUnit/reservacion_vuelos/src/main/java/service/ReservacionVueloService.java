package service;

import org.springframework.http.ResponseEntity;

import model.ReservacionVueloModelo;


public interface ReservacionVueloService {
	ResponseEntity<String> generarReservacion(ReservacionVueloModelo reservacion);
}
