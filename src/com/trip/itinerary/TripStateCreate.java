/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;



import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import com.trip.load.data.TravelAgentDataGetAndSave;
import com.trip.load.data.TripDataGetAndSave;
import com.trip.models.Person;
import com.trip.models.TravelAgent;
import com.trip.models.Trip;



/**
 * The TripStateCreate class creates the Trip and is the first step of the application.
 */
public class TripStateCreate extends TripState {

    private String TRIP_CREATE_MSG = "*** NEW TRIP CREATED ***";
    private TravelAgent ta;
    private Map<String, TripState> stateMap = new HashMap<>();

    /**
     *
     * @param tripContext
     */
    protected TripStateCreate(TripContext tripContext) {

        super(tripContext, Status.CREATE);
        Trip trip = new Trip();
        trip.setTripStateStatus(Status.CREATE);
        getTripContext().setTrip(trip);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        populateStateMap();
        System.out.println(System.lineSeparator());
        TripState newState = loadTravelAgentData();
        getTripContext().getTrip().setTravelAgent(ta);
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }


    /**
     * Loads Travel Agent Data
     *
     * @return TripState
     */
    public TripState loadTravelAgentData() {
        System.out.println("Loading Travel Agent Profiles ...");
        System.out.println("Select the Travel Agent by choosing the number:");
        List<TravelAgent> travelAgentList = TravelAgentDataGetAndSave
                .getTravelAgentList();
        int count = 1;
        for (Person ta : travelAgentList) {
            System.out.println(count + ". " + ta);
            count++;
        }
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();
        ta = (TravelAgent) travelAgentList.get(choice - 1);
        if (ta.getTripList().size() > 0) {
            System.out.println("Please choose one of the trips from the following [type the id]:");
            List<Integer> tripIdList = ta.getTripList();
            List<Trip> tripList = TripDataGetAndSave.getTripList();
            for (Trip tr : tripList) {
                if (tripIdList.contains(tr.getId())) {
                    System.out.println(tr);
                }
            }
            int chosenTripId = sc.nextInt();
            Trip choseTrip = new Trip();
            for (Trip tr : tripList) {
                if (tr.getId() == chosenTripId) {
                    System.out.println("Trip Selected is " + tr);
                    TripState newState = stateMap.get(tr.getStatus());
                    getTripContext().setTrip(tr);
                    getTripContext().changeState(newState);
                    return newState;
                }
            }
        }

        Trip trip = getTripContext().getTrip();
        trip.setTravelAgent(ta);
        trip.setStatus("AWAITING TRAVELERS");
        getTripContext().setTrip(trip);
        return new TripStateAddTravelers(getTripContext());
    }


    /**
     * populates state map
     */
    private void populateStateMap() {
        stateMap.put("AWAITING PACKAGES", new TripStateAddPackages(getTripContext()));
        stateMap.put("AWAITING TRAVELERS", new TripStateAddTravelers(getTripContext()));
        stateMap.put("AWAITING PAYMENT",
                new TripStateChoosePaymentMethod(getTripContext()));
        stateMap.put("AWAITING THANK YOU", new TripStateAddThankYou(getTripContext()));
        stateMap.put("AWAITING ITINERARY", new TripStateShowItinerary(getTripContext()));
    }
}

