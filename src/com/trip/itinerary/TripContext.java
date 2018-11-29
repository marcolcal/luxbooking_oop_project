package com.trip.itinerary;

import com.trip.models.Trip;

/**
 * Trip context
 * 
 * @author Marco
 * @version 25 November 2018
 *
 */
public class TripContext {

    /* Contains the trip information*/
    private Trip _trip;

    /* Trip State contains the info of the state. */
    private TripState _tripState;

    /**
     * Constructor
     */
    public TripContext() {
        _tripState = new TripStateCreate(this);
    }

    /**
     * TripContext constructor
     * 
     * @param trip
     * @throws Exception
     */
    public TripContext(Trip trip) throws Exception {
        assert _trip != null : "Trip cannot be null";
        _trip = trip;
        _tripState = TripContextStateFactory.get(this);
    }

    /**
     * @return _trip Trip
     */
    public Trip getTrip() {
        return _trip;
    }

    /**
     * @param trip Trip
     */
    public void setTrip(Trip trip) {
        _trip = trip;
    }

    /**
     * @return _tripState Trip State
     */
    public TripState getTripState() {
        return _tripState;
    }

    /**
     * changeState
     * 
     * @param newState TripState
     */
    public void changeState(TripState newState) {
        _tripState = newState;
    }

    /**
     * TripLoop.Status
     * 
     * @return TripLoop.Status
     */
    public TripLoop.Status execute() {
        return _tripState.execute();
    }

}
