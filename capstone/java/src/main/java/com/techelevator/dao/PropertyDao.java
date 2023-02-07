package com.techelevator.dao;

import com.techelevator.model.Property;

import java.util.List;

public interface PropertyDao {

    Property getPropertyById(int propertyId);
    List<Property> getPropertiesByLandlord(int landlordId);
    List<Property> getAllProperties();
    void createProperty(Property property);
    boolean updateProperty(Property property);
    List<Property> searchProperties(int bedrooms, int bathrooms, double minRent, double maxRent);
//    MORE STUFF

}
