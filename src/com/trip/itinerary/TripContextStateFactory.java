package com.trip.itinerary;

/**
 * TripContextFactory
 * 
 * Flow:
 * AddTravelers
 * AddPackages
 * ChosePayment
 * ThankYouNote
 * ShowItinerary
 * 
 * @author Marco
 *
 */
public class TripContextStateFactory {

    public static TripState get(TripContext context) throws Exception {

        assert context != null;
        assert context.getTrip() != null;

        Status tripStateStatus = context.getTrip().getTripStateStatus();

        switch (tripStateStatus) {
        case CREATE:
            return new TripStateCreate(context);

        case ADD_TRAVELERS:
            return new TripStateAddTravelers(context);

        case ADD_PACKAGES:
            return new TripStateAddPackages(context);

        case CHOOSE_PAYMENT_METHOD:
            return new TripStateChoosePaymentMethod(context);

        case PAYMENT_CASH:
            return new TripStatePayCash(context);

        case PAYMENT_CHECK:
            return new TripStatePayCheck(context);

        case PAYMENT_CREDIT_CARD:
            return new TripStatePayCreditCard(context);

        case ADD_THANK_YOU:
            return new TripStateAddThankYou(context);

        case SHOW_ITINERARY:
            return new TripStateShowItinerary(context);

        case COMPLETE:
            return new TripStateComplete(context);

        default:
            throw new Exception(tripStateStatus + " is an invalid state");
        }
    }

}
