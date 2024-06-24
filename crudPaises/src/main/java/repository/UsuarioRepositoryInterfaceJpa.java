package repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Paises;

@Repository
public interface UsuarioRepositoryInterfaceJpa extends JpaRepository<Paises, Long> {
	
	@Query("SELECT u FROM Paises u WHERE u.namePais = ?1")
	Paises findByNamePais(String email);
}
