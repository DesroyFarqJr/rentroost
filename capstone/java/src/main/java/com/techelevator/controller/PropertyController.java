package com.techelevator.controller;

import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.dao.UserDao;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import com.techelevator.model.User;
import com.techelevator.service.GeocodingService;
import com.techelevator.service.RestGeocodingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/property")
@CrossOrigin
public class PropertyController {
    private PropertyDao propertyDao;
    private RestGeocodingService restGeocodingService;
    private LandlordDao landlordDao;
    private UserDao userDao;

    public PropertyController(PropertyDao propertyDao, RestGeocodingService restGeocodingService, UserDao userDao) {
        this.propertyDao = propertyDao;
        this.restGeocodingService = restGeocodingService;
        this.userDao = userDao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Property> getProperties() {
        List<Property> newList = propertyDao.getAllProperties();
        System.out.println("SIZE OF RETURNING LIST: " + newList.size());
        return newList;
    }

    @RequestMapping(path = "/{propertyId}", method = RequestMethod.GET)
    public Property getPropertyById(@PathVariable int propertyId) {
        return propertyDao.getPropertyById(propertyId);
    }

    @RequestMapping(path = "/{propertyId}", method = RequestMethod.PUT)
    public boolean updateProperty(@PathVariable int propertyId, @RequestBody Property property) {
        return propertyDao.updateProperty(property);
    }

    @RequestMapping(path = "/landlord/{landlord}", method = RequestMethod.GET)
    public List<Property> getPropertyByLandlord(@PathVariable int landlord) {
        return propertyDao.getPropertiesByLandlord(landlord);
    }
    @RequestMapping(path = "/landlord/myproperties", method = RequestMethod.GET)
    public List<Property> getMyProperties(Principal principal) {
        String principalName = principal.getName();
        System.out.println(principalName);
        // get landlord id from principalName
        User authenticatedUser = userDao.findByUsername(principalName);
        return propertyDao.getPropertiesByLandlord(authenticatedUser.getId());
    }
    @RequestMapping(path ="/addproperty", method = RequestMethod.POST)
    public void addProperty(@RequestBody Property property) {
        System.out.println(property.toString());
        Map <String,Double> newMap = restGeocodingService.getGeocode(property.getPropertyAddress());
        property.setPropertyLat(newMap.get("lat"));
        property.setPropertyLng(newMap.get("lng"));
        propertyDao.createProperty(property);

    }

    @RequestMapping(path="/search")
    public List<Property> searchProperties(@RequestParam(defaultValue = "0") int bedrooms, @RequestParam(defaultValue = "0") int bathrooms, @RequestParam(defaultValue = "0.00") double minrent, @RequestParam(defaultValue = "99999.00") double maxrent) {
        List<Property> newList = propertyDao.searchProperties(bedrooms, bathrooms, minrent, maxrent);
        System.out.println("SIZE OF RETURNING SEARCH LIST: " + newList.size());
        return newList;
    }
    @RequestMapping(path="/geocode", method = RequestMethod.GET)
    public Map<String, Double> getGeocode(@RequestParam(defaultValue = "") String address) {
        return restGeocodingService.getGeocode(address);
    }


    @RequestMapping(path = "/landlordstenants", method = RequestMethod.GET)
    public List<Tenant> getLandlordsTenants(Principal principal) {
        return landlordDao.listOfLandlordsTenants(principal);
    }

}
