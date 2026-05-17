package com.banking.customer.services;
import com.banking.customer.exception.CustomerDoesNotExistException;
import com.banking.customer.model.Customer;
import com.banking.customer.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImps implements   CustomerService{

    private final CustomerRepository customerRepository;

    public CustomerServiceImps(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(Long customerId) {
        if(!customerRepository.existsById(customerId)){
            throw new CustomerDoesNotExistException("Customer does not exist");
        }
        return customerRepository.findById(customerId).get();
    }

    @Override
    public Customer updateCustomer(Long customerId, Customer customer) {
        if(!customerRepository.existsById(customerId)){
            throw new CustomerDoesNotExistException("Customer does not exist");
        }
        Customer oldCustomer = customerRepository.findById(customerId).get();
        oldCustomer.setFirstName(customer.getFirstName());
        oldCustomer.setLastName(customer.getLastName());
        oldCustomer.setEmail(customer.getEmail());
        oldCustomer.setPhoneNumber(customer.getPhoneNumber());
        oldCustomer.setAddress(customer.getAddress());
        oldCustomer.setGender(customer.getGender());
        oldCustomer.setDateOfBirth(customer.getDateOfBirth());
        oldCustomer.setNominee(customer.getNominee());
        oldCustomer.setCitizenId(customer.getCitizenId());
        return customerRepository.save(oldCustomer);
    }

    @Override
    public String deleteCustomer(Long customerId) {
        if(!customerRepository.existsById(customerId)){
            throw new CustomerDoesNotExistException("Customer does not exist");
        }
        customerRepository.deleteById(customerId);
        return "Customer has been deleted successfully!";
    }
}
