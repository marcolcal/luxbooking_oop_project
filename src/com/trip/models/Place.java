/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.models;

/**
 * Place is used to store the details of a place.
 *
 */
public class Place {
    /* Id*/
    private int id;
    
    /* Name of the place */
    private String name;
    
    /**
     * Default no argument Constructor
     */
    public Place() {
        
    }


    /**
     * Constructor with arguments
     * 
     * @param id
     * @param name
     */
    public Place(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
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
        Place other = (Place) obj;
        if (id != other.id)
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
     * @param id the id to set
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
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }
    
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return " " + name + " ";
    } 

}
