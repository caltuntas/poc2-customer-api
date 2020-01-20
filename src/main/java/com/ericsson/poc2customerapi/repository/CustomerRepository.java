/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.poc2customerapi.repository;

import com.ericsson.poc2customerapi.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author emehalt
 */
public interface CustomerRepository extends MongoRepository<Customer, String> {
  

}