/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import com.trip.models.Trip;

/**
 * The Loop is responsible for looping through the application.
 *
 */
public class TripLoop {

    /**
     * @return
     * @throws Exception
     */
    public Trip execute() throws Exception {
        return execute(null);
    }

    /**
     * The execute() method keeps the application running.
     * 
     * @param trip
     * @return
     * @throws Exception
     */
    public Trip execute(Trip trip) throws Exception {
        TripContext tripContext = trip == null ? new TripContext()
                : new TripContext(trip);

        while (tripContext.execute() == Status.CONTINUE) {
            TripState tripState = TripContextStateFactory.get(tripContext);
        }

        System.out.println(System.lineSeparator());
        System.out.println("*** Trip Itinerary Stopped ***");
        System.out.println(System.lineSeparator());

        return tripContext.getTrip();
    }

    /**
     * This is what allows each state to stop or continue
     */
    public enum Status {
        CONTINUE, STOP
    }

}
