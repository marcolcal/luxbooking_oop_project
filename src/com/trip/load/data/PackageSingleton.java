/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.load.data;

import java.util.ArrayList;
import java.util.List;

import com.trip.dao.DataPersistenceStrategy;
import com.trip.dao.DataPersitenceContext;
import com.trip.models.PackageDeal;

/**
 * Package Data Singleton.
 */
public class PackageSingleton {

    private static PackageSingleton packageSingleton;
    private List<PackageDeal> packageList = new ArrayList<>();

    /**
     * Private Constructor
     */
    private PackageSingleton() {
        populatePackageList();
    }

    /**
     * Get Package Singleton.
     * 
     * @return packageSingleton
     */
    public static PackageSingleton getPackageSingleton() {
        if (packageSingleton == null) {
            packageSingleton = new PackageSingleton();
            return packageSingleton;
        }
        return null;
    }

    /**
     *
     * @return packages list
     */
    public List<PackageDeal> getPackageList() {
        return packageList;
    }

    /**
     * populates the list
     */
    private void populatePackageList() {
        PackageDeal packageObject = new PackageDeal();
        DataPersitenceContext dps = new DataPersitenceContext();

        DataPersistenceStrategy persistence = dps.getDataPersistence();

        List<PackageDeal> list = (List<PackageDeal>) persistence.readData(packageObject);

        for (Object o : list) {
            packageList.add((PackageDeal) o);
        }  
    }
}
