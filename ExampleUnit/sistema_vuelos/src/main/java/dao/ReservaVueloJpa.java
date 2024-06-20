package dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Vuelo;

public interface ReservaVueloJpa extends JpaRepository<Vuelo.DetallesReserva, Integer> {
	
}
