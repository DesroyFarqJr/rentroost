package com.techelevator.model;
import javax.validation.constraints.NotBlank;

public class Maintenance {

    private int maintenanceId;
    @NotBlank(message = "Field cannot be empty")
    private int propertyId;
    @NotBlank(message = "Field cannot be empty")
    private String maintenanceRequest;
    @NotBlank(message = "Field cannot be empty")
    private int assignedTo;
    @NotBlank(message = "Field cannot be empty")
    private String repairStatus;

    public int getMaintenanceId() {
        return maintenanceId;
    }

    public void setMaintenanceId(int maintenanceId) {
        this.maintenanceId = maintenanceId;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getMaintenanceRequest() {
        return maintenanceRequest;
    }

    public void setMaintenanceRequest(String maintenanceRequest) {
        this.maintenanceRequest = maintenanceRequest;
    }

    public int getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(int assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getRepairStatus() {
        return repairStatus;
    }

    public void setRepairStatus(String repairStatus) {
        this.repairStatus = repairStatus;
    }

    @Override
    public String toString() {
        return String.format("%d, %s (ID: %d)", getAssignedTo(), getMaintenanceRequest(), getMaintenanceId());
    }
}