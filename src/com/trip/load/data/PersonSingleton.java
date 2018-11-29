/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;

import java.util.ArrayList;
import java.util.List;

import com.trip.models.Person;

/**
 * Person singleton class
 *
 */
public class PersonSingleton {
    
    private PersonSingleton personSingleton;
    private final List<Person> personList = new ArrayList<>();
    
    /**
     * Default Constructor
     */
    private PersonSingleton() {
        
    }
    
    /**
     * @return person singleton
     */
    public PersonSingleton getLoadPerson() {
        if(personSingleton == null) {
            personSingleton = new PersonSingleton();
            return personSingleton;
        }
        return null;
    }

    /**
     *
     * @return persons list
     */
    public List<Person> getPersonList() {
        return personList;
    }
}
