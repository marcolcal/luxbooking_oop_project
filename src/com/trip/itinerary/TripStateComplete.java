/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

/**
 * Trip State Complete, the last One
 */
public class TripStateComplete extends TripState {

    /**
     * @param tripContext
     */
    protected TripStateComplete(TripContext tripContext) {
        super(tripContext, Status.COMPLETE);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        TripState newState = null;
        getTripContext().changeState(newState);
        return TripLoop.Status.STOP;
    }
}
