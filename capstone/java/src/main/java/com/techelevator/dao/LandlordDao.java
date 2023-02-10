package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;

import java.security.Principal;
import java.util.ArrayList;

public interface LandlordDao {

    Landlord getLandlord(int landlordId);
    boolean addLandlord(String firstname, String lastname, String email, String phone, int userId);

    ArrayList<Tenant> listOfLandlordsTenants(int landlordId) ;

    boolean changeTenantAddress(String address, int id);

<<<<<<< HEAD
    ArrayList<Property> getLandlordsProperties(int landlordId);
=======
    ArrayList<Property> getLandlordsProperties(Principal principal);
    Landlord getLandlordByUserId(int landlordUserId);
>>>>>>> 0f235b20790641c0e6b86467704523716da0689f

}
