package com.trip.itinerary;

/**
 * @author Marco
 *
 */
public abstract class TripState {
    private TripContext _tripContext;

    /**
     * Constructor
     * 
     * @param tripContext
     * @param tripStatus
     */
    protected TripState(TripContext tripContext, Status tripStatus) {
        _tripContext = tripContext;

        if (_tripContext.getTrip() != null) {
            tripContext.getTrip().setTripStateStatus(tripStatus);
        }
    }

    /**
     * Returns Trip Context
     * 
     * @return _tripContext TripContext
     */
    public TripContext getTripContext() {
        return _tripContext;
    }

    /**
     * @param tripContext
     */
    public void setshoppingCartContext(TripContext tripContext) {
        _tripContext = tripContext;
    }

    /**
     * @return
     */
    public abstract TripLoop.Status execute();

    /**
     * @param answer
     * @return
     */
    protected boolean returnLater(String answer) {
        boolean returnLater = answer.toLowerCase().equals("later");
        if (returnLater) {
            System.out.println();
            System.out.println("*** RETURN LATER TO FINISH ***");
        }
        return returnLater;
    }

}
