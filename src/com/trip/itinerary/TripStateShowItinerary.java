/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.util.List;

import com.trip.models.PackageDeal;
import com.trip.models.Traveler;
import com.trip.models.Trip;

/**
 * 
 * Trip State Show Itinerary.
 *
 */
public class TripStateShowItinerary extends TripState {

    /**
     * Constructor with params.
     * 
     * @param tripContext Trip Context
     */
    protected TripStateShowItinerary(TripContext tripContext) {
        super(tripContext, Status.SHOW_ITINERARY);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        System.out.println("Showing Itinerary");
        Trip trip = getTripContext().getTrip();
        trip.setStatus("AWAITING THANK YOU");
        displayItinerary(trip);
        TripState newState = new TripStateComplete(getTripContext());
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }

    /**
     * Displays the itinerary
     * 
     * @param trip Trip
     */
    private void displayItinerary(Trip trip) {
        System.out.println("Travel Agent: " + trip.getTravelAgent().getName());
        System.out.println("Itinerary by " + trip.getTravelAgent().getName() + " "
                + trip.getTravelAgent().getMobileNumber()
                + trip.getTravelerList().get(0).getName() + " – Your trip to"
                + trip.getPackageList().get(0).getFromPlace().getName()
                + " is all set. I have booked top-quality transport for every leg of your trip. "
                + "I am including a fine bottle of your favorite drink, Boones Farm Sunshine Pink, "
                + "to enjoy along the way. If you have any questions or problems, call me anytime. "
                + "Safe travels! " + trip.getTravelAgent().getName()
                + ", Certified Premium Travel Service Agent");

        List<Traveler> travelerList = trip.getTravelerList();
        System.out.println("Persons travelling are:");
        for (Traveler traveler : travelerList) {
            System.out.println(traveler);
        }

        List<PackageDeal> packageList = trip.getPackageList();

        System.out.println("The places to be traveled: ");
        for (PackageDeal pd : packageList) {
            System.out.println(pd);
        }

        System.out.println("Booking:");
        System.out.println("Every detail your trip was booked with care by "
                + trip.getTravelAgent().getName()
                + ". If you have any questions or problems, call"
                + trip.getTravelAgent().getName() + " at "
                + trip.getTravelAgent().getMobileNumber() + " anytime, 24 hours a day.");

        System.out.println("Bill Details");
        System.out.println(trip.getPayment());

    }
}
