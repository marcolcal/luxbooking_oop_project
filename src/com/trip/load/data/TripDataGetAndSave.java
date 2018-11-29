/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;

import java.util.ArrayList;
import java.util.List;

import com.trip.dao.DataPersistenceStrategy;
import com.trip.dao.DataPersitenceContext;
import com.trip.models.Trip;

/**
 * Saves and gets the trip data
 */
public class TripDataGetAndSave {

    private static DataPersitenceContext DPS = new DataPersitenceContext();
    private static DataPersistenceStrategy PERSISTENCE = DPS.getDataPersistence();
    private static List<Trip> tripList = new ArrayList<>();

    /**
     *
     * @return trip list
     */
    public static List<Trip> getTripList() {
        TripSingleton tripSingleton = TripSingleton.getTripSingleton();
        tripList = tripSingleton.getTripList();
        return tripList;
    }

    /**
     *
     * @param trip
     */
    public static void saveTrip(Trip trip) {
        System.out.println(trip);
        if(!tripList.contains(trip)) {
            tripList.add(trip);
        }
        else {
            for (Trip tr : tripList) {
                if (tr.equals(trip)) {
                    tr = trip;
                }
            } 
        }
        PERSISTENCE.writeData(tripList.toArray());
    }
}
