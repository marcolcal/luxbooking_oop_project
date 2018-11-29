/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.trip.models.PackageDeal;
import com.trip.models.Person;
import com.trip.models.TravelAgent;
import com.trip.models.Trip;
import com.trip.properties.reader.PropertyFileReader;

/**
 * Json Data Persistence
 */
public class JsonDataPersistenceStrategy implements DataPersistenceStrategy {

    private PropertyFileReader propFileReader = new PropertyFileReader();
    private static String FILE_PATH;

    /**
     * Constructor
     */
    public JsonDataPersistenceStrategy() {
        FILE_PATH = propFileReader.getProperty("jsonPath");
    }

    /* (non-Javadoc)
     * @see com.trip.dao.DataPersistenceStrategy#readData(java.lang.Object)
     */
    @Override
    public List<?> readData(Object obj) {

        ObjectMapper objectMapper = new ObjectMapper();

        String jsonInput = FILE_PATH + "/" + obj.getClass().getSimpleName() + ".json";
        List<?> myObjects = new ArrayList<>();
        try {

            if (obj.getClass().getSimpleName().equals("Person")) {
                myObjects = objectMapper.readValue(new File(jsonInput),
                        new TypeReference<List<Person>>() {
                        });
            }
            else if(obj.getClass().getSimpleName().equals("TravelAgent")) {
                myObjects = objectMapper.readValue(new File(jsonInput),
                        new TypeReference<List<TravelAgent>>() {
                        });
            }
            else if(obj.getClass().getSimpleName().equals("Traveler")) {
                myObjects = objectMapper.readValue(new File(jsonInput),
                        new TypeReference<List<TravelAgent>>() {
                        });
            }
            else if(obj.getClass().getSimpleName().equals("Trip")) {
                myObjects = objectMapper.readValue(new File(jsonInput),
                        new TypeReference<List<Trip>>() {
                        });
            }
            
            else if(obj.getClass().getSimpleName().equals("PackageDeal")) {
                myObjects = objectMapper.readValue(new File(jsonInput),
                        new TypeReference<List<PackageDeal>>() {
                        });
            }

            // deleting file
            File file = new File(jsonInput);
            if (file.delete()) {
                System.out.println(file.getCanonicalPath() + " is deleted!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return myObjects;
    }



    /* (non-Javadoc)
     * @see com.trip.dao.DataPersistenceStrategy#readDataAsString(java.lang.Object)
     */
    public String readDataAsString(Object obj) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        String jsonInput = FILE_PATH + "/" + obj.getClass().getSimpleName() + ".json";
        Scanner scanner;
        String text = "";
        try {
            scanner = new Scanner(new File(jsonInput));
            text = scanner.nextLine();
            // 2. JSON to Array
            // Define Custom Type reference for map type
            String arrayToJson = text;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Print array output using Java 8
        return text;
    }

    /* (non-Javadoc)
     * @see com.trip.dao.DataPersistenceStrategy#writeData(java.lang.Object[])
     */
    @Override
    public void writeData(Object[] arr) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            FileOutputStream fos = new FileOutputStream(
                    FILE_PATH + "/" + arr[0].getClass().getSimpleName() + ".json", true);
            String arrayToJson = objectMapper.writeValueAsString(arr);
            objectMapper.writeValue(fos, arr);
        } catch (JsonProcessingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
