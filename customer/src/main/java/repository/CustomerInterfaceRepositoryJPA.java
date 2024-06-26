package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import model.CustomerModel;

public interface CustomerInterfaceRepositoryJPA extends JpaRepository<CustomerModel, Long>{
	
	@Query("SELECT c FROM CustomerModel c where c.email=?1")
	CustomerModel findByEmailCustomer(String email);

}
