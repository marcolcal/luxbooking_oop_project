/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.dao;

import java.math.BigInteger;
import java.util.List;
import com.trip.models.Person;
import com.trip.models.Traveler;


public class TestDao {

    public static void main(String[] args) {
        System.out.println("Loading data ...");
        TestDao testDao = new TestDao();
        testDao.loadData();
        System.out.println("Application Ready ...");

    }


    /**
     * loads data
     */
    public void loadData() {

        Person personOne = new Person();
        personOne.setId(10);
        personOne.setName("Samuel Jackson");
        personOne.setMobileNumber(new BigInteger("4124196875"));

        Person personTwo = new Person();
        personTwo.setId(11);
        personTwo.setName("Tim Lee");
        personTwo.setMobileNumber(new BigInteger("4121296874"));

        Person personThree = new Person();
        personThree.setId(12);
        personThree.setName("Joshua Green");
        personThree.setMobileNumber(new BigInteger("1344196875"));

        Person personFour = new Person();
        personTwo.setId(13);
        personTwo.setName("Tim Wexler");
        personTwo.setMobileNumber(new BigInteger("4124196904"));

        Person personFive = new Person();
        personOne.setId(14);
        personOne.setName("Saul Goodman");
        personOne.setMobileNumber(new BigInteger("3244196875"));

        Person personSix = new Person();
        personTwo.setId(15);
        personTwo.setName("Carolyn Red");
        personTwo.setMobileNumber(new BigInteger("1904196874"));

        Person personSeven = new Person();
        personOne.setId(16);
        personOne.setName("Monica White");
        personOne.setMobileNumber(new BigInteger("4897496875"));

        Person personEight = new Person();
        personTwo.setId(17);
        personTwo.setName("Rachel Green");
        personTwo.setMobileNumber(new BigInteger("4124196890"));

        Person[] personArray = { personOne, personTwo, personThree, personFour,
                personFive, personSix, personSeven, personEight };

        DataPersitenceContext dps = new DataPersitenceContext();

        DataPersistenceStrategy persistence = dps.getDataPersistence();

        persistence.writeData(personArray);
        
        Traveler travelerOne = new Traveler(personOne);

        List<?> personList = persistence.readData(personOne);

    }

}
