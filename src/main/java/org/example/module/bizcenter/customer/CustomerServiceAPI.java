package org.example.module.bizcenter.customer;

public interface CustomerServiceAPI {
    void createCustomer(Long tenantId,String name,String type);
    Long getCustomerCount(Long serviceManagerId);
}
