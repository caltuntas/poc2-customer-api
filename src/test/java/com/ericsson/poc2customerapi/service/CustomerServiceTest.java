/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.poc2customerapi.service;


import com.ericsson.poc2customerapi.dto.CreateCustomerRequest;
import com.ericsson.poc2customerapi.dto.UpdateCustomerRequest;
import com.ericsson.poc2customerapi.model.Customer;
import com.ericsson.poc2customerapi.repository.CustomerRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Example;

/**
 *
 * @author emehalt
 */
@RunWith(MockitoJUnitRunner.class)
public class CustomerServiceTest {

  @Mock
  CustomerRepository mockCustomerRepository;
  
  @InjectMocks
  CustomerService customerService;

  @Test
  public void mustReturnCustomer() throws InterruptedException {
    String id = "5e269b18e49c1c042c4918ed";

    Customer fakeCustomer = new Customer();    
    fakeCustomer.setId(id);

    when(mockCustomerRepository.findById(id)).thenReturn(Optional.of(fakeCustomer));

    Customer customer = customerService.getById(id);
    assertThat(customer).isEqualTo(fakeCustomer);

    verify(mockCustomerRepository).findById(id);
  }    
  
  @Test
  public void mustCreateCustomer() throws InterruptedException {
    String id = "5e269b18e49c1c042c4918ed";

    Customer fakeCustomer = new Customer();    
    fakeCustomer.setId(id);

    when(mockCustomerRepository.save(any(Customer.class))).thenReturn(fakeCustomer);
    CreateCustomerRequest request = new CreateCustomerRequest();
    request.setFirstName("First name");
    request.setLastName("Last name");
    request.setNationalId("12345678");

    Customer customer = customerService.createCustomer(request);
    assertThat(customer).isEqualTo(fakeCustomer);

    verify(mockCustomerRepository).save(any(Customer.class));
  }    
  
  @Test
  public void mustNotUpdateCustomer() throws InterruptedException {
    String id = "5e269b18e49c1c042c4918ed";

    Customer fakeCustomer = new Customer();    
    fakeCustomer.setId(id);

    when(mockCustomerRepository.findById(id)).thenReturn(Optional.empty());    
    UpdateCustomerRequest request = new UpdateCustomerRequest();
    request.setFirstName("First name");
    request.setLastName("Last name");
    request.setNationalId("12345678");
    request.setId(id);

    Customer customer = customerService.updateCustomer(request);
    assertThat(customer).isEqualTo(null);    

    verify(mockCustomerRepository,never()).save(any(Customer.class));
  }    
  
  @Test
  public void mustUpdateCustomer() throws InterruptedException {
    String id = "5e269b18e49c1c042c4918ed";

    Customer fakeCustomer = new Customer();    
    fakeCustomer.setId(id);

    when(mockCustomerRepository.findById(id)).thenReturn(Optional.of(fakeCustomer));    
    when(mockCustomerRepository.save(any(Customer.class))).thenReturn(fakeCustomer);
    UpdateCustomerRequest request = new UpdateCustomerRequest();
    request.setFirstName("First name");
    request.setLastName("Last name");
    request.setNationalId("12345678");
    request.setId(id);

    Customer customer = customerService.updateCustomer(request);
    assertThat(customer).isEqualTo(fakeCustomer);    

    verify(mockCustomerRepository).save(any(Customer.class));
  }    
  
  @Test
  public void mustFilterCustomers() throws InterruptedException {
    List<Customer> customers = new ArrayList<>();
    Customer example = new Customer();    
    example.setNationalId("12345678");

    when(mockCustomerRepository.findAll(any(Example.class))).thenReturn(customers);       

    List<Customer> customerList = customerService.getAll("nationalId=12345678");
    assertThat(customerList).isEqualTo(customers);    
  }    
}
