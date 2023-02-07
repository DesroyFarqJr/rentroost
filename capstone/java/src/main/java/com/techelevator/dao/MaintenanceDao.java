package com.techelevator.dao;

import com.techelevator.model.Maintenance;
import com.techelevator.model.Property;

import java.util.List;

public interface MaintenanceDao {


    List<Maintenance> getAllMaintenanceReqs();
    boolean updateMaintenanceRequest(Maintenance maintenance);

    void createMaintenanceRequest(Maintenance maintenance);
    Maintenance getMaintenanceRequest(int maintenanceId);
    List<Maintenance> searchTickets(int propertyId, String maintenanceRequest, int assignedTo, String repairStatus);
//    MORE STUFF SOON!

}