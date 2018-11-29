/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.math.BigDecimal;
import com.trip.payment.IPaymentType;

/**
 * This class is used to store the bill.
 *
 */

public class Bill {

    /* Id */
    private int id;

    /* price */
    private BigDecimal totalPrice;

    /* Payment Type */
    private IPaymentType payment;

    /**
     * The Bill constructor with the attributes as parameters.
     * 
     * @param id
     * @param totalPrice
     */
    public Bill(int id, BigDecimal totalPrice, IPaymentType payment) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.payment = payment;
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
        Bill other = (Bill) obj;
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
     * @return the totalPrice
     */
    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    /**
     * @param totalPrice the totalPrice to set
     */
    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * @return the paymentStatus
     */
    public IPaymentType getPaymentStatus() {
        return payment;
    }

    /**
     * @param payment the paymentStatus to set
     */
    public void setPaymentStatus(IPaymentType payment) {
        this.payment = payment;
    }

}
