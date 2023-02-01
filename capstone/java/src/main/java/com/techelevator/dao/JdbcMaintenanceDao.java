package com.techelevator.dao;

import com.techelevator.model.Maintenance;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcMaintenanceDao implements MaintenanceDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcMaintenanceDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
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