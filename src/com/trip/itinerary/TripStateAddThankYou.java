/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

/**
 * Trip State Add Thank You State
 *
 */
public class TripStateAddThankYou extends TripState {

    private static String THANK_YOU_MESSAGE = "Thank you for using luxbooking Premium Travel "
            + "Services, luxury travel made simple.";

    /**
     * Constructor
     * 
     * @param tripContext
     */
    protected TripStateAddThankYou(TripContext tripContext) {
        super(tripContext, Status.ADD_THANK_YOU);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        System.out.println(THANK_YOU_MESSAGE);
        return null;
    }
   
}
