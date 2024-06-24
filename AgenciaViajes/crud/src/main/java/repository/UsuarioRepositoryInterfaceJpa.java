package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import model.Usuario;

@Repository
public interface UsuarioRepositoryInterfaceJpa extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT u FROM Usuario u WHERE u.email = ?1")
	Usuario findByEmail(String email);
}