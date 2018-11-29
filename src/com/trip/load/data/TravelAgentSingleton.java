/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;


import java.util.ArrayList;
import java.util.List;
import com.trip.dao.DataPersistenceStrategy;
import com.trip.dao.DataPersitenceContext;
import com.trip.models.TravelAgent;

/**
 * TravelAgentSingleton creates the list of the travel agents
 */
public class TravelAgentSingleton {

    private static TravelAgentSingleton travelAgentSingleton;
    private List<TravelAgent> travelAgentList = new ArrayList<>();

    /**
     * Singleton Constructor
     */
    private TravelAgentSingleton() {
        populateTravelAgentList();
    }

    /**
     * Returns the singleton object.
     * 
     * @return TravelAgentSingleton travelAgentSingleton
     */
    public static TravelAgentSingleton getTravelAgentSingleton() {
        if (travelAgentSingleton == null) {
            travelAgentSingleton = new TravelAgentSingleton();
            return travelAgentSingleton;
        }
        return null;
    }

    /**
     * Returns the list of travel agents.
     * 
     * @return List<TravelAgent> travelAgentList
     */
    public List<TravelAgent> getTravelAgentList() {
        return travelAgentList;
    }

    /**
     * Populates the list of travel agents
     */
    private void populateTravelAgentList() {
        TravelAgent travelAgent = new TravelAgent();
        DataPersitenceContext dps = new DataPersitenceContext();
        DataPersistenceStrategy persistence = dps.getDataPersistence();
        List<TravelAgent> list = (List<TravelAgent>) persistence.readData(travelAgent);
        for (Object o : list) {
            travelAgentList.add((TravelAgent) o);
        }
    }

}
