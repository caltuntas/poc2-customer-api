/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ericsson.poc2customerapi.model;

import org.springframework.data.annotation.Id;


public class Customer {

  @Id
  private String id;

  private String firstName;
  private String lastName;
  private String nationalId;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the nationalId
     */
    public String getNationalId() {
        return nationalId;
    }

    /**
     * @param nationalId the nationalId to set
     */
    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

  

}