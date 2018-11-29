/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.models;

import java.math.BigDecimal;

/**
 * Package Deal stores the package details.
 *
 *
 */
public class PackageDeal {

    /* Stores the place to go. */
    private Place fromPlace;
    private int id;
    private Place toPlace;
    private BigDecimal price;
    private int hoursOfTravel;
    private String transport;

    /**
     * Constructor
     * 
     * @param fromPlace
     * @param id
     * @param toPlace
     * @param price
     * @param hoursOfTravel
     * @param transport
     */
    public PackageDeal(Place fromPlace, int id, Place toPlace, BigDecimal price,
            int hoursOfTravel, String transport) {
        this.fromPlace = fromPlace;
        this.id = id;
        this.toPlace = toPlace;
        this.price = price;
        this.hoursOfTravel = hoursOfTravel;
        this.transport = transport;
    }

    /**
     * Constructor
     */
    public PackageDeal() {
    }

    /**
     *
     * @return results
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PackageDeal other = (PackageDeal) obj;
        if (id != other.id)
            return false;
        return true;
    }

    /**
     * @return hours that the travel takes
     */
    public int getHoursOfTravel() {
        return hoursOfTravel;
    }

    /**
     * @param hoursOfTravel
     */
    public void setHoursOfTravel(int hoursOfTravel) {
        this.hoursOfTravel = hoursOfTravel;
    }

    /**
     * @return the from place
     */
    public Place getFromPlace() {
        return fromPlace;
    }

    /**
     * @param fromPlace
     */
    public void setFromPlace(Place fromPlace) {
        this.fromPlace = fromPlace;
    }

    /**
     * @return the to place
     */
    public Place getToPlace() {
        return toPlace;
    }

    /**
     * @param toPlace
     */
    public void setToPlace(Place toPlace) {
        this.toPlace = toPlace;
    }

    /**
     * @return price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * @param price
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * @return transport type
     */
    public String getTransport() {
        return transport;
    }

    /**
     * @param transport
     */
    public void setTransport(String transport) {
        this.transport = transport;
    }

    /**
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Package is from " + fromPlace.getName() + " to " + toPlace.getName()
                + ", transport taken is " + transport + " price is " + price
                + " and travel duration is " + hoursOfTravel + " hours";
    }

}
