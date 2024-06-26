package repository;

import java.util.Map;

import model.BillingModel;

public interface BillingInterfaceRepository {
	Map<String, Object> createBilling(BillingModel billing);
	Map<String, Object> readBilling(Long idBilling);
	Map<String, Object> readBillingAll();
	Map<String, Object> updateBilling(Long idBilling, BillingModel billing);
	Map<String, Object> deleteBilling(Long idBilling);
}
