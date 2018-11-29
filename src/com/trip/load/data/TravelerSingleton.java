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
import com.trip.models.Person;
import com.trip.models.Traveler;

/**
 * Traveler Singleton class
 */
public class TravelerSingleton {
    
    private static TravelerSingleton travelerSingleton;

    private List<Person> travelerList = new ArrayList<>();

    /**
     * Singleton Constructor
     */
    private TravelerSingleton() {
        populateTravelerList();
    }

    /**
     * Returns the singleton object.
     * 
     * @return TravelerSingleton travelerSingleton
     */
    public static TravelerSingleton getTravelerSingleton() {
        if (travelerSingleton == null) {
            travelerSingleton = new TravelerSingleton();
            return travelerSingleton;
        }
        return null;
    }

    /**
     * Returns the list of travel agents.
     * 
     * @return List<TravelAgent> travelAgentList
     */
    public List<Person> getTravelerList() {
        return travelerList;
    }

    private void populateTravelerList() {
        Traveler traveler = new Traveler();
        DataPersitenceContext dps = new DataPersitenceContext();
        DataPersistenceStrategy persistence = dps.getDataPersistence();
        String list = persistence.readDataAsString(traveler);
        // 2. Convert JSON to List of Person objects
        // Define Custom Type reference for List<Person> type
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Traveler>> mapType = new TypeReference<List<Traveler>>() {
        };
        try {
            System.out.println("Getting Travel Agent List");
            travelerList = objectMapper.readValue(list, mapType);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
