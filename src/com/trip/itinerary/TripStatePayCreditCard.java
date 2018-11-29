/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.math.BigDecimal;
import java.util.Scanner;

import com.trip.models.Trip;
import com.trip.payment.IPaymentType;
import com.trip.payment.PaymentCreditCard;

/**
 * Trip State Pay Credit Card
 *
 */
public class TripStatePayCreditCard extends TripState {

    /**
     * Constructor with params
     * 
     * @param tripContext
     */
    protected TripStatePayCreditCard(TripContext tripContext) {
        super(tripContext, Status.PAYMENT_CREDIT_CARD);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        System.out.println("You chose to pay by Credit Card.");
        Trip trip = getTripContext().getTrip();
        displayTotalPrice(trip);
        getTripContext().getTrip().setPayment(getCreditCard(trip));
        TripState newState = new TripStateShowItinerary(getTripContext());
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
    private IPaymentType getCreditCard(Trip trip) {
        IPaymentType creditCard;
        Scanner sc = new Scanner(System.in);
        System.out.println("Please Enter the Credit Card Number:");
        Long creditCardNumber = sc.nextLong();
        
        // Has to be in 16 digits 
        if (creditCardNumber < 1000000000000000L
                || creditCardNumber > 9999999999999999L) {
            System.out.println("The Credit Card Number must be of 16 digits:");
            System.out.println("Please try again:");
            return getCreditCard(trip);
        }
        System.out.println("Please Enter the Amount:");
        BigDecimal amount = sc.nextBigDecimal();
        if (!amount.equals(trip.getCost())) {
            System.out.println("Please pay the actual amount: " + trip.getCost());
            creditCard = getCreditCard(trip);
        }
        System.out.println("Please Enter the Expiration date (mm/dd/yy):");
        String expirationDate = sc.next();
        creditCard = new PaymentCreditCard(amount, creditCardNumber, expirationDate);
        return creditCard;
    }
}
