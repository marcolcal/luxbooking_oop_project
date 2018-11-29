/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


import com.trip.load.data.PackageSingleton;
import com.trip.load.data.TravelAgentDataGetAndSave;
import com.trip.load.data.TripDataGetAndSave;
import com.trip.models.PackageDeal;
import com.trip.models.TravelAgent;
import com.trip.models.Trip;

/**
 * Add packages state
 */
public class TripStateAddPackages extends TripState {

    private static PackageSingleton packageSingleton = PackageSingleton
            .getPackageSingleton();
    private PackageDeal packageDeal;
    private static List<PackageDeal> packageList = packageSingleton.getPackageList();
    private static List<PackageDeal> newPackageList = new ArrayList<>(packageList);

    /**
     * @param tripContext
     */
    protected TripStateAddPackages(TripContext tripContext) {
        super(tripContext, Status.ADD_PACKAGES);
    }

    /* (non-Javadoc)
     * @see com.trip.itinerary.TripState#execute()
     */
    @Override
    public TripLoop.Status execute() {
        System.out.println("");
        System.out.println("Add Packages from the following list:");
        loadPackageData();
        checkIfUserSaveAndQuit();
        TripState newState = new TripStateChoosePaymentMethod(getTripContext());
        getTripContext().changeState(newState);
        return TripLoop.Status.CONTINUE;
    }

    /**
     * loads data into packages
     */
    private void loadPackageData() {
        System.out.println("Loading Package Profiles ...");
        System.out.println(
                "Select the package from the following by typing the row number:");
        Trip trip = getTripContext().getTrip();
        trip.setStatus("AWAITING PAYMENT");
        int count = 1;
        for (PackageDeal pd : newPackageList) {
            System.out.println(count + ". " + pd);
            count++;
        }
        Scanner sc = new Scanner(System.in);
        Integer choice = sc.nextInt();
        packageDeal = (PackageDeal) newPackageList.get(choice - 1);
        System.out.println("Added package " + packageDeal);
        trip.getPackageList().add(packageDeal);
        newPackageList.remove(choice - 1);
        System.out.println("Do you want to continue [y/n]?");
        String opt = sc.next();
        if (opt.equals("y")) {
            loadPackageData();
        } else if (opt.equals("n")) {
            return;
        }
    }

    /**
     * checks if user wants to stop or continue
     * Asks the user to give a trip Id
     */
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
