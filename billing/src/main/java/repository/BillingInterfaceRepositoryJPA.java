package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import model.BillingModel;

public interface BillingInterfaceRepositoryJPA extends JpaRepository<BillingModel, Long>{

}
