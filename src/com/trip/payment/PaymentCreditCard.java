/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.payment;

import java.math.BigDecimal;

/**
 * Payment Credit Card
 */
public class PaymentCreditCard implements IPaymentType {

    /* Total */
    private BigDecimal total;

    /* Credit card number. */
    private long creditCardNumber;

    /* Expiration Date. */
    private String expirationDate;

    /**
     * Default constructor 
     */
    public PaymentCreditCard() {

    }

    /**
     * Constructor with params.
     * 
     * @param total
     * @param creditCardNumber
     * @param expirationDate
     */
    public PaymentCreditCard(BigDecimal total, long creditCardNumber,
            String expirationDate) {
        this.total = total;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = expirationDate;
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
     * Get Credit CardNumber
     * 
     * @return creditCardNumber int
     */
    public long getCreditCardNumber() {
        return creditCardNumber;
    }

    /**
     * Set Credit Card Number 
     * 
     * @param creditCardNumber int
     */
    public void setCreditCardNumber(long creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    /**
     * Get Expiration Date
     * 
     * @return expirationDate String
     */
    public String getExpirationDate() {
        return expirationDate;
    }

    /**
     * Set Expiration Date.
     * 
     * @param expirationDate String
     */
    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return " Total Payment done is " + total + "\n Credit Card Number is "
                + creditCardNumber + "\n Expiration Date is " + expirationDate;
    }
}
