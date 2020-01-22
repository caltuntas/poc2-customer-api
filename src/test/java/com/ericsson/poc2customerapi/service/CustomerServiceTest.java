/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.poc2customerapi.service;


import com.ericsson.poc2customerapi.model.Customer;
import com.ericsson.poc2customerapi.repository.CustomerRepository;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.MockitoJUnitRunner;

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
}
