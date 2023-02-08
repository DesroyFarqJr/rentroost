package com.techelevator.controller;

import com.techelevator.dao.LandlordDao;
import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
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

    public PropertyController(PropertyDao propertyDao, RestGeocodingService restGeocodingService, LandlordDao landlordDao) {
        this.propertyDao = propertyDao;
        this.restGeocodingService = restGeocodingService;
        this.landlordDao = landlordDao;
    }

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public List<Property> getProperties() {
        return propertyDao.getAllProperties();
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
        // TODO landlord ID from principal once we can tie a user to a landlord
        // return propertyDao.getPropertiesByLandlord(landlordId)
        return null;
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
        return propertyDao.searchProperties(bedrooms, bathrooms, minrent, maxrent);
    }
    @RequestMapping(path="/geocode", method = RequestMethod.GET)
    public Map<String, Double> getGeocode(@RequestParam(defaultValue = "") String address) {
        return restGeocodingService.getGeocode(address);
    }

    @RequestMapping(path = "/updateTenantUnit/{propertyName}/{tenantId}", method = RequestMethod.PUT)
    public boolean updateTenantUnit(@PathVariable String propertyName, @PathVariable int tenantId) {

        return landlordDao.changeTenantAddress(propertyName, tenantId);
    }


    @RequestMapping(path = "/landlordstenants", method = RequestMethod.GET)
    public List<Tenant> getLandlordsTenants(Principal principal) {
        System.out.println("Search Performed On: " + principal.getName());
        return landlordDao.listOfLandlordsTenants(principal);
    }

    @RequestMapping(path = "/landlordsproperties", method = RequestMethod.GET)
    public List<Property> getLandlordsProperties(Principal principal) {
        System.out.println("Search Performed On: " + principal.getName());
        return landlordDao.getLandlordsProperties(principal);
    }


}
