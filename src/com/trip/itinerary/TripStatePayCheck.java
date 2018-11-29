/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.math.BigDecimal;
import java.util.Scanner;
import com.trip.models.Trip;
import com.trip.payment.IPaymentType;
import com.trip.payment.PaymentCheck;

/**
 * Trip State Pay Check
 */
public class TripStatePayCheck extends TripState {

    /**
     * Trip State Pay Check Construnctor
     * 
     * @param tripContext
     */
    protected TripStatePayCheck(TripContext tripContext) {
        super(tripContext, Status.PAYMENT_CHECK);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        Trip trip = getTripContext().getTrip();
        displayTotalPrice(trip);
        getTripContext().getTrip().setPayment(getCheck(trip));
        TripState newState =  new TripStateShowItinerary(getTripContext());
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }

    private void displayTotalPrice(Trip trip) {
        System.out.println("Cost of the Trip:" + trip.getCost());
    }

    /**
     * Get Check
     * 
     * @param trip
     * @return IPaymentType
     */
    private IPaymentType getCheck(Trip trip) {
        IPaymentType check;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Check Number:");
        Integer checkNumber = sc.nextInt();
        if (checkNumber < 100) {
            System.out.println("The check Number must be greater than 100:");
            System.out.println("Please try again:");
            return getCheck(trip);
        }
        System.out.println("Please Enter the Amount:");
        BigDecimal amount = sc.nextBigDecimal();
        if (!amount.equals(trip.getCost())) {
            System.out.println("Please pay the actual amount: " + trip.getCost());
            check = getCheck(trip);
        } else {
            check = new PaymentCheck(checkNumber, amount);
        }
        return check;
    }

}
