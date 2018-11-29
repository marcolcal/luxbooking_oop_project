/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.payment;

import java.math.BigDecimal;

/**
 * Stores payment in Cash
 *
 */
public class PaymentCash implements IPaymentType {

    private BigDecimal total;
    
    /**
     * Payment Cash
     * 
     * @param total BigDecimal
     */
    public PaymentCash(BigDecimal total) {
        this.total = total;
    }

    /* (non-Javadoc)
     * @see com.trip.payment.IPaymentType#setTotal(java.math.BigDecimal)
     */
    @Override
    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public BigDecimal getTotal() {
        return total;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Payment in Cash total is " + total;
    }
    
}
