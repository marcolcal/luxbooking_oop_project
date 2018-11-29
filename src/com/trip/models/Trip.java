/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.trip.itinerary.Bill;
import com.trip.itinerary.Status;
import com.trip.payment.IPaymentType;

/**
 * The Trip object stores the details of the trip
 *
 */
public class Trip {

    /* Trip id */
    private int id;

    /* Thank you Note */
    private String thankYouNote;

    /* Travel Agent */
    private TravelAgent travelAgent;

    /* Travelers*/
    private List<Traveler> travelerList = new ArrayList<>();

    /* The bill */
    private Bill bill;

    /* Stores the status of the trip. */
    private Status _tripStateStatus;

    /* String status message */
    private String status;

    /* List of packages*/
    private List<PackageDeal> packageList = new ArrayList<>();

    /* Payment type */
    private IPaymentType payment;

    /* Cost */
    private BigDecimal cost;

    /**
     * Default constructor
     */
    public Trip() {
    }

    /**
     * Trip constructor with the trip attributes.
     * 
     * @param id
     * @param thankYouNote
     * @param travelAgent
     * @param bill
     */
    public Trip(int id, String thankYouNote, TravelAgent travelAgent, Bill bill) {
        this.id = id;
        this.thankYouNote = thankYouNote;
        this.travelAgent = travelAgent;
        this.bill = bill;
        _tripStateStatus = Status.CREATE;
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
        Trip other = (Trip) obj;
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
     * @return the thankYouNote
     */
    public String getThankYouNote() {
        return thankYouNote;
    }

    /**
     * @param thankYouNote the thankYouNote to set
     */
    public void setThankYouNote(String thankYouNote) {
        this.thankYouNote = thankYouNote;
    }

    /**
     * @return the travelAgent
     */
    public TravelAgent getTravelAgent() {
        return travelAgent;
    }

    /**
     * @param travelAgent the travelAgent to set
     */
    public void setTravelAgent(TravelAgent travelAgent) {
        this.travelAgent = travelAgent;
    }

    public List<Traveler> getTravelerList() {
        return travelerList;
    }

    public void setTravelerList(List<Traveler> travelerList) {
        this.travelerList = travelerList;
    }

    /**
     * @return the bill
     */
    public Bill getBill() {
        return bill;
    }

    /**
     * @param bill the bill to set
     */
    public void setBill(Bill bill) {
        this.bill = bill;
    }

    /**
     * @return
     */
    public Status getTripStateStatus() {
        return _tripStateStatus;
    }

    /**
     * @param tripStateStatus
     */
    public void setTripStateStatus(Status tripStateStatus) {
        _tripStateStatus = tripStateStatus;
    }

    public List<PackageDeal> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<PackageDeal> packageList) {
        this.packageList = packageList;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public BigDecimal getCost() {
        BigDecimal cost = new BigDecimal(0);
        for (PackageDeal pd : packageList) {
            cost = cost.add(pd.getPrice());
        }
        return cost;
    }

    /**
     *
     * @return payment
     */
    public IPaymentType getPayment() {
        return payment;
    }

    /**
     *
     * @param payment
     */
    public void setPayment(IPaymentType payment) {
        this.payment = payment;
    }

    /**
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * Prints travelers
     */
    public void printTravelers() {
        int count = 1;
        for (Traveler ta : travelerList) {
            System.out.println(count + "." + ta.getName());
        }
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Trip [id=" + id + ", "
                + (travelAgent != null ? "travelAgent=" + travelAgent + ", " : "")
                + (status != null ? "status=" + status + ", " : "") + "]";
    }
}
