package com.app.bgodriver.model;

public class TripModel {
    int carImage;
    String currentLocation,destinationLocation,tripTime,roundTrip,tripPassenger,airCondition;

    public TripModel(int carImage, String currentLocation, String destinationLocation, String tripTime, String roundTrip, String tripPassenger, String airCondition) {
        this.carImage = carImage;
        this.currentLocation = currentLocation;
        this.destinationLocation = destinationLocation;
        this.tripTime = tripTime;
        this.roundTrip = roundTrip;
        this.tripPassenger = tripPassenger;
        this.airCondition = airCondition;
    }

    public int getCarImage() {
        return carImage;
    }

    public void setCarImage(int carImage) {
        this.carImage = carImage;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(String destinationLocation) {
        this.destinationLocation = destinationLocation;
    }

    public String getTripTime() {
        return tripTime;
    }

    public void setTripTime(String tripTime) {
        this.tripTime = tripTime;
    }

    public String getRoundTrip() {
        return roundTrip;
    }

    public void setRoundTrip(String roundTrip) {
        this.roundTrip = roundTrip;
    }

    public String getTripPassenger() {
        return tripPassenger;
    }

    public void setTripPassenger(String tripPassenger) {
        this.tripPassenger = tripPassenger;
    }

    public String getAirCondition() {
        return airCondition;
    }

    public void setAirCondition(String airCondition) {
        this.airCondition = airCondition;
    }
}
