package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Tenant;

import java.security.Principal;
import java.util.ArrayList;

public interface LandlordDao {

    Landlord getLandlord(int landlordId);
Landlord addLandlord(int landlord_id);

    ArrayList<Tenant> listOfLandlordsTenants(Principal principal) ;
//    MORE STUFF SOON!


}
