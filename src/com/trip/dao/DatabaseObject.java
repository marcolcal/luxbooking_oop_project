/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */


package com.trip.dao;

import java.util.List;

import com.trip.models.Person;
import com.trip.models.Place;
import com.trip.models.TravelAgent;
import com.trip.models.Traveler;
import com.trip.models.Trip;

public class DatabaseObject {
    
    private List<Person> personList;
    
    private List<TravelAgent> travelAgentList;
    
    private List<Traveler> travelerList;
    
    private List<Trip> tripList;
    
    private List<Package> packageList;
    
    private List<Place> placeList;

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }

    public List<TravelAgent> getTravelAgentList() {
        return travelAgentList;
    }

    public void setTravelAgentList(List<TravelAgent> travelAgentList) {
        this.travelAgentList = travelAgentList;
    }

    public List<Traveler> getTravelerList() {
        return travelerList;
    }

    public void setTravelerList(List<Traveler> travelerList) {
        this.travelerList = travelerList;
    }

    public List<Trip> getTripList() {
        return tripList;
    }

    public void setTripList(List<Trip> tripList) {
        this.tripList = tripList;
    }

    public List<Package> getPackageList() {
        return packageList;
    }

    public void setPackageList(List<Package> packageList) {
        this.packageList = packageList;
    }

    public List<Place> getPlaceList() {
        return placeList;
    }

    public void setPlaceList(List<Place> placeList) {
        this.placeList = placeList;
    }
    
}
