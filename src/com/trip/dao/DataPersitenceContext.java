/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.dao;

import com.trip.properties.reader.PropertyFileReader;

/**
 * Data Persistence Context

 */
public class DataPersitenceContext {

    private String db;
    private DataPersistenceStrategy dataPersistence;

    /**
     * Constructor
     */
    public DataPersitenceContext() {
        db = checkDatabase();
        if (db.equals("xml")) {
            dataPersistence = new XmlDataPersistenceStrategy();
        } else {
            dataPersistence = new JsonDataPersistenceStrategy();
        }
    }

    /**
     * Gets Data Persistence.
     * @return dataPersistence
     */
    public DataPersistenceStrategy getDataPersistence() {
        return dataPersistence;
    }

    /**
     * Checks Database
     * @return String
     */
    private String checkDatabase() {
        PropertyFileReader property = new PropertyFileReader();
        return property.getProperty("database");
    }
}
