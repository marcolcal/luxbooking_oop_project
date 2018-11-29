/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;

import java.util.ArrayList;
import java.util.List;

import com.trip.dao.DataPersistenceStrategy;
import com.trip.dao.DataPersitenceContext;
import com.trip.models.Place;
import com.trip.models.TravelAgent;

/**
 * Place singleton class
 */
public class PlaceSingleton {
 
    private PlaceSingleton placeSingleton;
    
    private final List<Place> placeList = new ArrayList<>();
    
    /**
     * Default constructor
     */
    private PlaceSingleton() {
        
    }
    
    /**
     * @return place
     */
    public PlaceSingleton getPlaceSingleton() {
        if(placeSingleton == null) {
            placeSingleton = new PlaceSingleton();
            return placeSingleton;
        }
        return null;
    }

    /**
     *
     * @return place list
     */
    public List<Place> getPlaceList() {
        return placeList;
    }
    
  
}
