/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.payment;

import java.math.BigDecimal;

/**
 * This interface is used by the different payment types  
 *
 */
public interface IPaymentType {

    /**
     * @param total
     */
    public void setTotal(BigDecimal total);

    /**
     * @return
     */
    public BigDecimal getTotal();

}
