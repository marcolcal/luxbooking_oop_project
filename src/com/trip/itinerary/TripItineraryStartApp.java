package com.trip.itinerary;

import java.util.List;
import java.util.Scanner;
import com.trip.load.data.ApplicationDataSetup;
import com.trip.load.data.TravelAgentSingleton;
import com.trip.models.Person;
import com.trip.models.TravelAgent;
import com.trip.models.Trip;

/**
 * This class is used to start the application.
 * 
 * @author Marco Alfaro
 * @version November 25, 2018
 */
public class TripItineraryStartApp {

    /**
     * The main method starts the application.
     * 
     * @param args
     */

    private static TravelAgent ta;

    public static void main(String[] args) {
        setupApplication();
        TripLoop tripLoop = new TripLoop();
        Trip trip = new Trip();
        trip.setTravelAgent(ta);
        while (true) {
            try {
                // Starting the application.
                tripLoop.execute();
                break;
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Sorry, there is some error in the program");
                break;
            }
        }
    }

    /**
     * Setting up the application data.
     */
    public static void setupApplication() {
        System.out.println("=== Application Startup === ");
        ApplicationDataSetup.dataSetup();
        System.out.println("=== Application Ready === ");
    }
}
