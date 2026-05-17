package com.banking.customer.services;

import com.banking.customer.model.Customer;

import java.util.List;

public interface CustomerService {
    public Customer addCustomer(Customer customer);
    public List<Customer> getAllCustomers();
    public Customer getCustomerById(Long customerId);
    public Customer updateCustomer(Long customerId, Customer customer);
    public String deleteCustomer(Long customerId);
}
