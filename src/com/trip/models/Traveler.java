/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.models;

import java.math.BigInteger;

/**
 * travelers class
 */
public class Traveler extends Person {

    /**
     * Default constructor
     */
    public Traveler() {
    }

    /**
     * @param person
     */
    public Traveler(Person person) {
        this.setId(person.getId());
        this.setName(person.getName());
        this.setMobileNumber(person.getMobileNumber());
    }

    /**
     * @param id
     * @param name
     * @param mobileNumber
     */
    public Traveler(int id, String name, BigInteger mobileNumber) {
        super(id, name, mobileNumber);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Traveler other = (Traveler) obj;
        if (other.getId() != this.getId()) {
            return false;
        }

        return true;
    }
}
