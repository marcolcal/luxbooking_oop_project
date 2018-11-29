/*
 * Created by Marco Alfaro
 * Copyright (c) 2018.
 */

package com.trip.itinerary;

/**
 * enum class used across the states of the app
 */
public enum Status {
    CREATE, 
    ADD_TRAVELERS,
    ADD_PACKAGES,
    ADD_DESTINATIONS,
    CHOOSE_PAYMENT_METHOD, 
    PAYMENT_CASH, 
    PAYMENT_CHECK,
    PAYMENT_CREDIT_CARD,
    SHOW_ITINERARY,
    ADD_THANK_YOU,
    COMPLETE
}
