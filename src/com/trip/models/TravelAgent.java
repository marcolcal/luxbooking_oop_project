/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.models;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * Travel Agent
 *
 *
 */
public class TravelAgent extends Person {

    private List<Integer> tripIdList = new ArrayList<>();
    
    /**
     * Default constructor.
     */
    public TravelAgent() {
        super();
    }

    /**
     * Constructors with params.
     * 
     * @param person
     */
    public TravelAgent(Person person) {
        this(person.getId(), person.getName(), person.getMobileNumber());
    }

    /**
     * Constructors with params.
     * 
     * @param id
     * @param name
     * @param mobileNumber
     */
    public TravelAgent(int id, String name, BigInteger mobileNumber) {
        super(id, name, mobileNumber);
    }
    
    public TravelAgent(int id, String name, BigInteger mobileNumber, List<Integer> tripIdList) {
        super(id, name, mobileNumber);
        this.tripIdList = tripIdList;
    }


    /**
     *
     * @return trip id list
     */
    public List<Integer> getTripList() {
        return tripIdList;
    }

    /**
     *
     * @param tripIdList
     */
    public void setTripList(List<Integer> tripIdList) {
        this.tripIdList = tripIdList;
    }

    /**
     *
     * @return to string
     */
    @Override
    public String toString() {
        return "Travel Agent id:" + super.getId() + ", name: " + super.getName()
                + ", Mobile Number: " + super.getMobileNumber();
    }
}
