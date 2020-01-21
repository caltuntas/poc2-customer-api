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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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

    public List<Customer> getAll(String filter) {
        Map<String,String> filters = parseFilter(filter);
        Customer c = new Customer();
        c.setNationalId(filters.get("nationalId"));        
        c.setFirstName(filters.get("firstName"));        
        c.setLastName(filters.get("lastName"));        
        return repository.findAll(Example.of(c));        
    }
    
    private Map<String,String> parseFilter(String filter){
        String[] parts = filter.split("&");
        Map<String,String> filters = new HashMap<>();
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            String[] keyValue = part.split("=");
            filters.put(keyValue[0], keyValue[1]);
        }
        return filters;
    }
}
