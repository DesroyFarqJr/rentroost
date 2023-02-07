package com.techelevator.dao;

import com.sun.tools.javac.Main;
import com.techelevator.model.Maintenance;
import com.techelevator.model.Property;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcMaintenanceDao implements MaintenanceDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createMaintenanceRequest(Maintenance maintenance) {
        String sql ="INSERT INTO maintenance (property_id, request, assigned_to, repair_status) VALUES " +
                "(?,?,?,?)";
        int newMain_id;
        try {
            jdbcTemplate.update(sql,maintenance.getPropertyId(),maintenance.getMaintenanceRequest(),maintenance.getAssignedTo(), maintenance.getRepairStatus());
        } catch(DataAccessException e ){
            System.out.println("Error inserting maintenance");
        }
    }

    @Override
    public List<Maintenance> getAllMaintenanceReqs() {
        List<Maintenance> outputList = new ArrayList<>();
        String sql = "SELECT maintenance_id, property_id, request, assigned_to, repair_status " +
                "FROM maintenance";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while(results.next()) {
            Maintenance maintenance = mapRowToMaintenance(results);
            outputList.add(maintenance);
        }
        return outputList;
    }

    public boolean updateMaintenanceRequest(Maintenance maintenance) {
        String sql ="UPDATE maintenance SET request=?, assigned_to=?, repair_status=? WHERE maintenance_id=?";
        boolean success = false;
        int linesReturned = jdbcTemplate.update(sql,maintenance.getMaintenanceRequest(), maintenance.getAssignedTo(), maintenance.getRepairStatus());
        if (linesReturned == 1) {
            success = true;
        }
        return success;
    }

    @Override
    public Maintenance getMaintenanceRequest(int maintenanceId) {
        Maintenance maintenance = null;
        String sql = "SELECT maintenance_id, property_id, request, assigned_to, repair_status " +
                "FROM maintenance " +
                "WHERE maintenance_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, maintenanceId);
        if (results.next()) {
            maintenance = mapRowToMaintenance(results);
        }
        return maintenance;
    }

    @Override
    public List<Maintenance> searchTickets(int propertyId, String maintenanceRequest, int assignedTo, String repairStatus) {
        return null;
    }

    private Maintenance mapRowToMaintenance(SqlRowSet rowSet) {
        Maintenance maintenance = new Maintenance();
        maintenance.setMaintenanceId(rowSet.getInt("maintenance_id"));
        maintenance.setPropertyId(rowSet.getInt("property_id"));
        maintenance.setMaintenanceRequest(rowSet.getString("request"));
        maintenance.setAssignedTo(rowSet.getInt("assigned_to"));
        maintenance.setRepairStatus(rowSet.getString("repair_status"));

        return maintenance;
    }
}