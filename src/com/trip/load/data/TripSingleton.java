/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trip.dao.DataPersistenceStrategy;
import com.trip.dao.DataPersitenceContext;
import com.trip.models.Trip;

/**
 * Trip singleton class
 */
public class TripSingleton {
    
    private static TripSingleton tripSingleton;

    private List<Trip> tripList = new ArrayList<>();

    /**
     * Singleton Constructor
     */
    private TripSingleton() {
        populateTripList();
    }

    /**
     * Returns the singleton object.
     * 
     * @return TripSingleton tripSingleton
     */
    public static TripSingleton getTripSingleton() {
        if (tripSingleton == null) {
            tripSingleton = new TripSingleton();
            return tripSingleton;
        }
        return null;
    }

    /**
     * Returns the list of travel agents.
     * 
     * @return List<TravelAgent> travelAgentList
     */
    public List<Trip> getTripList() {
        return tripList;
    }

    /**
     * populates trip list
     */
    private void populateTripList() {
        Trip trip = new Trip();
        DataPersitenceContext dps = new DataPersitenceContext();
        DataPersistenceStrategy persistence = dps.getDataPersistence();
        String list = persistence.readDataAsString(trip);

        // 2. Convert JSON to List of Person objects
        // Define Custom Type reference for List<Person> type
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Trip>> mapType = new TypeReference<List<Trip>>() {
        };
        try {
            System.out.println("Getting Trip List.");
            tripList = objectMapper.readValue(list, mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
