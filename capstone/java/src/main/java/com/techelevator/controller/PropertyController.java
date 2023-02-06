package com.techelevator.controller;

import com.techelevator.dao.PropertyDao;
import com.techelevator.model.Property;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/property")
@CrossOrigin
public class PropertyController {
    private PropertyDao propertyDao;

    public PropertyController(PropertyDao propertyDao) {
        this.propertyDao = propertyDao;
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

    @RequestMapping(path="/search")
    public List<Property> searchProperties(@RequestParam(defaultValue = "0") int bedrooms, @RequestParam(defaultValue = "0") int bathrooms, @RequestParam(defaultValue = "0.00") double minrent, @RequestParam(defaultValue = "99999.00") double maxrent) {
        return propertyDao.searchProperties(bedrooms, bathrooms, minrent, maxrent);
    }
}
