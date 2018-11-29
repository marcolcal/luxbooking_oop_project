/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.math.BigDecimal;
import java.util.Scanner;
import com.trip.models.Trip;
import com.trip.payment.IPaymentType;
import com.trip.payment.PaymentCash;

/**
 * Pay Cash State
 *
 */
public class TripStatePayCash extends TripState {

    /**
     * Trip State Pay Cash
     * 
     * @param tripContext
     */
    protected TripStatePayCash(TripContext tripContext) {
        super(tripContext, Status.PAYMENT_CASH);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        Trip trip = getTripContext().getTrip();
        displayTotalPrice(trip);
        System.out.println("Please Pay the whole amount in cash:");
        
        trip.setPayment(getCash(trip));
        TripState newState = new TripStateShowItinerary(getTripContext());
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }
    
    /**
     * Display Total Price
     * 
     * @param trip
     */
    private void displayTotalPrice(Trip trip) {
        System.out.println("Cost of the Trip:$" + trip.getCost());
    }

    /**
     * Gets the cash from user.
     * 
     * @param trip Trip
     * @return cash IPaymentType
     */
    public IPaymentType getCash(Trip trip) {
        IPaymentType cash;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Amount:$");
        BigDecimal amount = sc.nextBigDecimal();
        if (!amount.equals(trip.getCost())) {
            System.out.println("Please pay the actual amount:$" + trip.getCost());
            cash = getCash(trip);
        } else {
            cash = new PaymentCash(amount);
        }
        return cash;
    }
}
