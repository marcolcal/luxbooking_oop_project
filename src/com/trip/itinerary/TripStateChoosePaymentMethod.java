/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.util.Scanner;

import com.trip.load.data.TravelAgentDataGetAndSave;
import com.trip.load.data.TripDataGetAndSave;
import com.trip.models.TravelAgent;
import com.trip.models.Trip;

/**
 * Choosing payment method state
 *
 */
public class TripStateChoosePaymentMethod extends TripState {

    /**
     * @param tripContext
     */
    protected TripStateChoosePaymentMethod(TripContext tripContext) {
        super(tripContext, Status.CHOOSE_PAYMENT_METHOD);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        checkIfUserSaveAndQuit();
        System.out.println();
        System.out.println(
                "Total cost of the trip = " + getTripContext().getTrip().getCost());
        System.out.println("*** Now You can Choose the Payment method ***");
        System.out.println("Choose from the following:");
        System.out.println("1. Cash.");
        System.out.println("2. Check.");
        System.out.println("3. Credit Card.");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        TripState newState = null;


        if (choice == 1) {
            newState = new TripStatePayCash(getTripContext());
        }

        else if (choice == 2) {
            newState = new TripStatePayCheck(getTripContext());
        }

        else if (choice == 3) {
            newState = new TripStatePayCreditCard(getTripContext());
        }

        else {
            System.out.println("Please choose a correct option fom: 1, 2, 3");
            newState = new TripStateChoosePaymentMethod(getTripContext());
        }
        getTripContext().getTrip().setStatus("AWAITING ITINERARY");
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }

    /**
     * checks if the user want to quit and save the trip by id
     */
    private void checkIfUserSaveAndQuit() {
        System.out.println("Do you want to save and quit the application [y/n]?");
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
