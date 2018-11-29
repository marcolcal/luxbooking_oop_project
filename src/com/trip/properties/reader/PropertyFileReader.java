/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.properties.reader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertyFileReader {

    private Properties prop;
    private static String PROPERTY_FILE_NAME = "config.properties";

    /**
     *
     */
    public PropertyFileReader() {
        prop = new Properties();
        InputStream inputStream;
        inputStream = getClass().getClassLoader().getResourceAsStream(PROPERTY_FILE_NAME);
        if (inputStream != null) {
            try {
                prop.load(inputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                throw new FileNotFoundException("property file '" + PROPERTY_FILE_NAME
                        + "' not found in the classpath");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    /**
     * @param property
     * @return
     */
    public String getProperty(String property) {
        return prop.getProperty(property);
    }

}
