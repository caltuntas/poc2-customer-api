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
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author emehalt
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository repository;
    public Customer getById(String id){
        Optional<Customer> customer= repository.findById(id); 
        if(customer.isPresent())
            return customer.get();
        return null;
    }

    public Customer createCustomer(CreateCustomerRequest request) {
        Customer newCustomer = new Customer();
        newCustomer.setFirstName(request.getFirstName());
        newCustomer.setLastName(request.getLastName());
        newCustomer.setNationalId(request.getNationalId());
        return repository.save(newCustomer);        
    }

    public Customer updateCustomer(UpdateCustomerRequest request) {
        Customer existingCustomer = new Customer();
        existingCustomer.setId(request.getId());
        existingCustomer.setFirstName(request.getFirstName());
        existingCustomer.setLastName(request.getLastName());
        existingCustomer.setNationalId(request.getNationalId());
        return repository.save(existingCustomer);        
    }
}
