package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Property;
import com.techelevator.service.GeocodingService;
import com.techelevator.service.RestGeocodingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/property")
@CrossOrigin
public class PropertyController {
    private PropertyDao propertyDao;
    private RestGeocodingService restGeocodingService;

    public PropertyController(PropertyDao propertyDao, RestGeocodingService restGeocodingService) {
        this.propertyDao = propertyDao;
        this.restGeocodingService = restGeocodingService;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Property> getProperties() {
        return propertyDao.getAllProperties();
    }

    @RequestMapping(path = "/{propertyId}", method = RequestMethod.GET)
    public Property getPropertyById(@PathVariable int propertyId) {
        return propertyDao.getPropertyById(propertyId);
    }

    @RequestMapping(path = "/landlord/{landlord}", method = RequestMethod.GET)
    public List<Property> getPropertyByLandlord(@PathVariable int landlord) {
        return propertyDao.getPropertiesByLandlord(landlord);
    }
    @RequestMapping(path ="/addproperty", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property) {
        //Set lat and long via address --> Google API
        System.out.println(property.toString());
        Map <String,Double> newMap = restGeocodingService.getGeocode(property.getPropertyAddress());
        property.setPropertyLat(newMap.get("lat"));
        property.setPropertyLng(newMap.get("lng"));
        propertyDao.createProperty(property);



    }



    @RequestMapping(path="/search")
    public List<Property> searchProperties(@RequestParam(defaultValue = "0") int bedrooms, @RequestParam(defaultValue = "0") int bathrooms, @RequestParam(defaultValue = "0.00") double minrent, @RequestParam(defaultValue = "99999.00") double maxrent) {
        return propertyDao.searchProperties(bedrooms, bathrooms, minrent, maxrent);
    }
    @RequestMapping(path="/geocode", method = RequestMethod.GET)
    public Map<String, Double> getGeocode(@RequestParam(defaultValue = "") String address) {
        return restGeocodingService.getGeocode(address);
    }

}
