package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import entities.CustomerEntity;

@Repository
public interface CustomerInterface extends JpaRepository<CustomerEntity, Long>{

}
