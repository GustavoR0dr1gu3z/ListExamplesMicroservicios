package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.ReservacionVueloModelo;

public interface ReservacionVueloDaoJpa extends JpaRepository<ReservacionVueloModelo, Integer>{

}
