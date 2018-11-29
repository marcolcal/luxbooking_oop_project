package com.trip.itinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.trip.load.data.TravelAgentDataGetAndSave;
import com.trip.load.data.TravelerSingleton;
import com.trip.load.data.TripDataGetAndSave;
import com.trip.models.Person;
import com.trip.models.TravelAgent;
import com.trip.models.Traveler;
import com.trip.models.Trip;

/**
 * Adding travelers state
 */
public class TripStateAddTravelers extends TripState {
    private Traveler traveler;
    private String ADD_TRAVELER_MSG = "Please Add Traveler from the List:";
    private static TravelerSingleton travelerSingleton = TravelerSingleton
            .getTravelerSingleton();   
    private static List<Person> travelerList = travelerSingleton.getTravelerList();
    private static List<Person> travelerListClone = new ArrayList<>(travelerList);

    /**
     * @param tripContext
     */
    protected TripStateAddTravelers(TripContext tripContext) {
        super(tripContext, Status.ADD_TRAVELERS);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        System.out.println(ADD_TRAVELER_MSG);
        TripState newState = new TripStateAddPackages(getTripContext());
        loadTravelerData();
        checkIfUserSaveAndQuit();
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }

    private void loadTravelerData() {
        System.out.println("Loading Traveler Profiles ...");
        System.out.println("Select the Traveler by typing the row number:");
        Trip trip = getTripContext().getTrip();
        trip.setStatus("AWAITING PACKAGES");
        
        int count = 1;
        for (Person ta : travelerListClone) {
            System.out.println(count + ". " + ta);
            count++;
        }
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();
        traveler = (Traveler) travelerListClone.get(choice - 1);
        trip.getTravelerList().add(traveler);
        travelerListClone.remove(choice - 1);
        System.out.println("Do you want to continue [y/n]?");
        String opt = sc.next();
        if (opt.equals("y")) {
            loadTravelerData();
        } else if (opt.equals("n")) {
            return;
        }

    }
    
    private void checkIfUserSaveAndQuit() {
        System.out.println("Do you want to save and quit [y/n]?");
        Scanner sc = new Scanner(System.in);
        String ans = sc.next();
        if (ans.equals("y")) {
            System.out.println("Please give the trip an id:");
            Integer id = sc.nextInt();
            Trip trip = getTripContext().getTrip();
            trip.setId(id);
            TravelAgent ta = trip.getTravelAgent();
            ta.getTripList().add(trip.getId());
            TravelAgentDataGetAndSave.saveTravelAgent(ta);
            TripDataGetAndSave.saveTrip(trip);
            System.exit(0);
        }
    }

}
