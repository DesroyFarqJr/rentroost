package com.techelevator.controller;

import com.techelevator.dao.MaintenanceDao;
import com.techelevator.model.Maintenance;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

    @RestController
    @RequestMapping("/maintenance")
    @CrossOrigin
    public class MaintenanceController {
        private MaintenanceDao maintenanceDao;

        public MaintenanceController(MaintenanceDao maintenanceDao) {
            this.maintenanceDao = maintenanceDao;
        }

        @RequestMapping(path = "/", method = RequestMethod.GET)
        public List<Maintenance> getMaintenance() {
            return maintenanceDao.getAllMaintenanceReqs();
        }

        @RequestMapping(path ="/newticket", method = RequestMethod.POST)
        public void createMaintenanceRequest(Principal principal, @RequestBody Maintenance maintenance) {
            System.out.println(maintenance.toString());
            maintenanceDao.createMaintenanceRequest(principal, maintenance);
        }
    }

