package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import model.reservacion;

@Repository
public interface reservacionRepositoryJpa extends JpaRepository<reservacion, Long>{

}
