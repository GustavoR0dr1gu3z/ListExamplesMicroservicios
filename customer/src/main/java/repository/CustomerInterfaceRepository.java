package repository;

import java.util.Map;

import model.CustomerModel;

public interface CustomerInterfaceRepository {
	Map<String, Object> createCustomer(CustomerModel customer) throws Exception;
	Map<String, Object> readCustomer(Long idCustomer);
	Map<String, Object> readCustomerAll();
	Map<String, Object> updateCustomer(Long idCustomer, CustomerModel customer);
	Map<String, Object> deleteCustomer(Long idCustomer);
}
