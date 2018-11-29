/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.payment;

import java.math.BigDecimal;

/**
 * Check Payment Type
 *
 */
public class PaymentCheck implements IPaymentType {

    /* Check Number */
    private int checkNumber;
    
    /* Total Cost */
    private BigDecimal total;

    /**
     * Default constructor
     */
    public PaymentCheck() {

    }

    /**
     * Constructor with params.
     * 
     * @param checkNumber
     * @param total
     */
    public PaymentCheck(int checkNumber, BigDecimal total) {
        this.checkNumber = checkNumber;
        this.total = total;
    }

    /* (non-Javadoc)
     * @see com.trip.payment.IPaymentType#setTotal(java.math.BigDecimal)
     */
    @Override
    public void setTotal(BigDecimal total) {
        this.total = total;

    }

    /* (non-Javadoc)
     * @see com.trip.payment.IPaymentType#getTotal()
     */
    @Override
    public BigDecimal getTotal() {
        return total;
    }

    /**
     * CheckNumber getter
     * 
     * @return checkNumber int
     */
    public int getCheckNumber() {
        return checkNumber;
    }

    /**
     * CheckNumber setter
     * 
     * @param checkNumber int
     */
    public void setCheckNumber(int checkNumber) {
        this.checkNumber = checkNumber;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Payment in Check. Check number is " + checkNumber + " and payment is " + total;
    }

}
