package com.techelevator.model;

public class Property {
    private int propertyId;
    private String propertyName;
    private String propertyAddress;
    private int studioPrice;
    private int oneBedroomPrice;
    private int twoBedroomPrice;
    private int threeBedroomPrice;
    private boolean rented;
    private String propertyUrl;

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyAddress() {
        return propertyAddress;
    }

    public void setPropertyAddress(String propertyAddress) {
        this.propertyAddress = propertyAddress;
    }

    public int getStudioPrice() {
        return studioPrice;
    }

    public void setStudioPrice(int studioPrice) {
        this.studioPrice = studioPrice;
    }

    public int getOneBedroomPrice() {
        return oneBedroomPrice;
    }

    public void setOneBedroomPrice(int oneBedroomPrice) {
        this.oneBedroomPrice = oneBedroomPrice;
    }

    public int getTwoBedroomPrice() {
        return twoBedroomPrice;
    }

    public void setTwoBedroomPrice(int twoBedroomPrice) {
        this.twoBedroomPrice = twoBedroomPrice;
    }

    public int getThreeBedroomPrice() {
        return threeBedroomPrice;
    }

    public void setThreeBedroomPrice(int threeBedroomPrice) {
        this.threeBedroomPrice = threeBedroomPrice;
    }

    public boolean isRented() {
        return rented;
    }

    public void setRented(boolean rented) {
        this.rented = rented;
    }

    public String getPropertyUrl() {
        return propertyUrl;
    }

    public void setPropertyUrl(String propertyUrl) {
        this.propertyUrl = propertyUrl;
    }


    @Override
    public String toString() {
        return String.format("%s, %s (ID: %d)", getPropertyAddress(), getPropertyUrl(), getPropertyId());

    }
}