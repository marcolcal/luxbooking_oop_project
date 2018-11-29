/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.trip.dao.DataPersistenceStrategy;
import com.trip.dao.DataPersitenceContext;
import com.trip.models.Person;
import com.trip.models.Place;
import com.trip.models.TravelAgent;
import com.trip.models.Traveler;
import com.trip.models.PackageDeal;

/**
 * ApplicationDataSetup sets up all the required data for the application.
 * Creates the data files to store the data
 */

public class ApplicationDataSetup {

    private static DataPersitenceContext DPS = new DataPersitenceContext();

    private static DataPersistenceStrategy PERSISTENCE = DPS.getDataPersistence();

    public static void dataSetup() {
        System.out.println("=== Started setting up data ===");
        createPersonData();
        createTravelAgentData();
        createTravelerData();
        createPlaceData();
        createPackageData();
        System.out.println("=== Finished data setup ===");
    }

    /**
     * createPersonData() is used to set up Person data
     */
    public static void createPersonData() {

        System.out.println("--- Setting Up Person Data ---");
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
        personFour.setId(13);
        personFour.setName("Tim Wexler");
        personFour.setMobileNumber(new BigInteger("4124196904"));

        Person personFive = new Person();
        personFive.setId(14);
        personFive.setName("Mr. Poe Pickles");
        personFive.setMobileNumber(new BigInteger("3244196875"));

        Person personSix = new Person();
        personSix.setId(15);
        personSix.setName("Carolyn Red");
        personSix.setMobileNumber(new BigInteger("1904196874"));

        Person personSeven = new Person();
        personSeven.setId(16);
        personSeven.setName("Monica White");
        personSeven.setMobileNumber(new BigInteger("4897496875"));

        Person personEight = new Person();
        personEight.setId(17);
        personEight.setName("Rachel Green");
        personEight.setMobileNumber(new BigInteger("4124196890"));

        Person[] personArray = { personOne, personTwo, personThree, personFour,
                personFive, personSix, personSeven, personEight };

        PERSISTENCE.writeData(personArray);

        System.out.println("--- Finished Setting Up Person Data ---");

    }

    /**
     * createTravelAgentData() sets up travel Agent Data
     */
    public static void createTravelAgentData() {

        System.out.println("--- Setting Up Travel Agent Data ---");
        Person travelAgentOne = new TravelAgent();
        travelAgentOne.setId(10);
        travelAgentOne.setName("Samuel Jackson");
        travelAgentOne.setMobileNumber(new BigInteger("4124196875"));

        Person travelAgentTwo = new TravelAgent();
        travelAgentTwo.setId(11);
        travelAgentTwo.setName("Tim Lee");
        travelAgentTwo.setMobileNumber(new BigInteger("4121296874"));

        Person travelAgentThree = new TravelAgent();
        travelAgentThree.setId(12);
        travelAgentThree.setName("Joshua Green");
        travelAgentThree.setMobileNumber(new BigInteger("1344196875"));

        Person travelAgentFour = new TravelAgent();
        travelAgentFour.setId(13);
        travelAgentFour.setName("Tim Wexler");
        travelAgentFour.setMobileNumber(new BigInteger("4124196904"));

        Person[] travelAgentArray = { travelAgentOne, travelAgentTwo, travelAgentThree,
                travelAgentFour };

        PERSISTENCE.writeData(travelAgentArray);
        System.out.println("--- Finished Setting Up Travel Agent Data ---");
    }

    /**
     *  createTravelerData() creates traveler data
     */
    public static void createTravelerData() {

        System.out.println("--- Setting Up Traveler Data ---");

        Person personFive = new Traveler();
        personFive.setId(14);
        personFive.setName("Mr. Poe Pickles");
        personFive.setMobileNumber(new BigInteger("3244196875"));

        Person personSix = new Traveler();
        personSix.setId(15);
        personSix.setName("Carolyn Red");
        personSix.setMobileNumber(new BigInteger("1904196874"));

        Person personSeven = new Traveler();
        personSeven.setId(16);
        personSeven.setName("Monica White");
        personSeven.setMobileNumber(new BigInteger("4897496875"));

        Person personEight = new Traveler();
        personEight.setId(17);
        personEight.setName("Rachel Green");
        personEight.setMobileNumber(new BigInteger("4124196890"));

        Person[] personArray = { personFive, personSix, personSeven, personEight };

        PERSISTENCE.writeData(personArray);

        System.out.println("--- Finished Setting Up Traveler Data ---");
    }

    public static void createPlaceData() {
        System.out.println("--- Setting Up Places Data ---");

        Place placeOne = new Place(1, "Los Angeles");
        Place placeTwo = new Place(2, "San Fransisco");
        Place placeThree = new Place(3, "Portland");
        Place placeFour = new Place(4, "San Diego");
        Place placeFive = new Place(5, "New York City");
        Place placeSix = new Place(6, "Buffalo");
        Place placeSeven = new Place(7, "Chicago");
        Place placeEight = new Place(8, "Las Vegas");
        Place placeNine = new Place(9, "Mexico");
        Place placeTen = new Place(10, "Miami");

        Place placeArray[] = { placeOne, placeTwo, placeThree, placeFour, placeFive,
                placeSix, placeSeven, placeEight, placeNine, placeTen };

        PERSISTENCE.writeData(placeArray);
        System.out.println("--- Finished Setting Up Places Data ---");

    }

    public static void createPackageData() {
        System.out.println("--- Setting Up Package Deals ---");

        Place placeOne = new Place(1, "Los Angeles");
        Place placeTwo = new Place(2, "San Fransisco");
        Place placeThree = new Place(3, "Portland");
        Place placeFour = new Place(4, "San Diego");
        Place placeFive = new Place(5, "New York City");
        Place placeSix = new Place(6, "Buffalo");
        Place placeSeven = new Place(7, "Chicago");
        Place placeEight = new Place(8, "Las Vegas");
        Place placeNine = new Place(9, "Mexico");
        Place placeTen = new Place(10, "Miami");

        PackageDeal packageOne = new PackageDeal(placeOne, 1, placeNine,
                new BigDecimal("300.50"), 5, "Helicopter");
        PackageDeal packageTwo = new PackageDeal(placeTwo, 2, placeThree,
                new BigDecimal("200.50"), 6, "Car");
        PackageDeal packageThree = new PackageDeal(placeEight, 3, placeFive,
                new BigDecimal("550.50"), 9, "Train");
        PackageDeal packageFour = new PackageDeal(placeFour, 4, placeSix,
                new BigDecimal("350.50"), 2, "Yacht");
        PackageDeal packageFive = new PackageDeal(placeTen, 5, placeSeven,
                new BigDecimal("370.50"), 3, "limousine");

        PackageDeal packageArray[] = { packageOne, packageTwo, packageThree, packageFour,
                packageFive };

        PERSISTENCE.writeData(packageArray);
        System.out.println("--- Finished Setting Up Package Deals ---");

    }
}
