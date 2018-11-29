/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.models;

import java.math.BigInteger;

/**
 * Person class
 */
public class Person {

    private int id;
    private String name;
    private BigInteger mobileNumber;

    public Person() {}

    /**
     * @param id
     * @param name
     * @param mobileNumber
     */
    public Person(int id, String name, BigInteger mobileNumber) {
        this.id = id;
        this.name = name;
        this.mobileNumber = mobileNumber;
    }

    /**
     *
     * @param id
     * @param name
     * @param mobileNumber
     */
    public Person(String id, String name, String mobileNumber) {
        this.id = Integer.parseInt(id);
        this.name = name;
        this.mobileNumber = new BigInteger(mobileNumber);
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result;
        return result;
    }

    /*
     * (non-Javadoc)
     * 
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
        Person other = (Person) obj;
        if (id != other.id)
            return false;
        if (mobileNumber != other.mobileNumber)
            return false;
        return true;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name
     *            the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the mobileNumber
     */
    public BigInteger getMobileNumber() {
        return mobileNumber;
    }

    /**
     * @param mobileNumber
     *            the mobileNumber to set
     */
    public void setMobileNumber(BigInteger mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    /*
     * (non-Javadoc)
     * 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Name: " + name + ", Mobile Number: " + mobileNumber;
    }

}
