package com.banking.customer.services;

import com.banking.customer.model.Customer;
import com.banking.customer.repository.CustomerRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CustomerServiceImpsTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImps customerServiceImps;

    private static Customer customer = null;

    /*
    * Create a Customer object before Testing
    * */
    @BeforeAll
    public static void setUpCustomer(){
        customer = new Customer();
        customer.setCustomerId(1L);
        customer.setFirstName("First");
        customer.setLastName("Last");
        customer.setEmail("email");
        customer.setPhoneNumber("123456789");
        customer.setDateOfBirth("10/10/1001");
        customer.setCitizenId("GGDS8763");
        customer.setAddress("address");
        customer.setNominee("nominee");
    }

    /*
    * Add Customer Test Case
    * */
    @Test
    void addCustomer() {
        Mockito.when(customerRepository.save(customer)).thenReturn(customer);
        Customer savedCustomer = customerServiceImps.addCustomer(customer);
        assertNotNull(savedCustomer);
        assertEquals(savedCustomer.getCitizenId(), customer.getCitizenId());
    }

    @Test
    void getAllCustomers() {

    }

    @Test
    void getCustomerById() {
    }

    @Test
    void updateCustomer() {
    }

    /*
    * Delete test case Customer
    * */
    @Test
    void deleteCustomer() {
        Mockito.when(customerRepository.existsById(1L))
                .thenReturn(true);
        String value = customerServiceImps.deleteCustomer(1L);
        Mockito.verify(customerRepository,Mockito.times(1)).deleteById(1L);
        assertEquals("Customer has been deleted successfully!", value);
    }
}