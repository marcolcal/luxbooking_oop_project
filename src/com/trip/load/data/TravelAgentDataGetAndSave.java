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
 * Save travel agent data persistence writes
 */
public class TravelAgentDataGetAndSave {

    private static DataPersitenceContext DPS = new DataPersitenceContext();
    private static DataPersistenceStrategy PERSISTENCE = DPS.getDataPersistence();
    private static List<TravelAgent> travelAgentList = new ArrayList<>();

    public static List<TravelAgent> getTravelAgentList() {
        TravelAgentSingleton travelAgentSingleton = TravelAgentSingleton
                .getTravelAgentSingleton();
        travelAgentList = travelAgentSingleton.getTravelAgentList();
        return travelAgentList;
    }

    public static void saveTravelAgent(TravelAgent travelAgent) {
        System.out.println(travelAgent);
        for (TravelAgent ta : travelAgentList) {
            if (travelAgent.equals(ta)) {
                ta.setTripList(travelAgent.getTripList());
            }
        }
        PERSISTENCE.writeData(travelAgentList.toArray());
    }

}
