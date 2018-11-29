/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.dao;

import java.util.List;

/**
 * Data Persistence Strategy Interface
 */
public interface DataPersistenceStrategy {
    
    /**
     * Reads Data
     * 
     * @param obj
     * @return List<?>
     */
    public List<?> readData(Object obj);
    
    /**
     * Writes Data
     * 
     * @param arr Object[]
     */
    public void writeData(Object[] arr);
    
    /**
     * Reads Data As String
     * 
     * @param obj Object
     * @return String
     */
    public String readDataAsString(Object obj);
}
