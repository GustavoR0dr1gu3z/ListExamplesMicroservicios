package dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import model.InventarioModel;


public interface InventarioJpaRepository extends JpaRepository<InventarioModel, Integer>{

	@Query("SELECT i FROM InventarioModel i WHERE i.precio>=99")
	List<InventarioModel> productoCaro();
	
	@Query("SELECT i FROM InventarioModel i WHERE i.precio>50")
	List<InventarioModel> productoMedioCaro();
	
	@Query("SELECT i FROM InventarioModel i WHERE i.precio<=49")
	List<InventarioModel> productoBarato();
	
	 @Query("SELECT i FROM InventarioModel i WHERE i.idInventario = :inventarioId OR i.nombre = :nombreInventario")
	 List<InventarioModel> getInventarioByNameId(@Param("inventarioId") int inventarioId, @Param("nombreInventario") String nombreInventario);
	
	
}
