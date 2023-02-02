package com.techelevator.controller;

import com.techelevator.model.Property;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/property")
@PreAuthorize("isAuthenticated()")
public class PropertyController {

    public PropertyController() {

    }

    @RequestMapping(path = "property", method = RequestMethod.GET)
    public List<Property> getProperties() {
        return null;
    }


}
