package com.techelevator.dao;

import com.techelevator.model.Landlord;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcLandlordDao implements LandlordDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcLandlordDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Landlord getLandlord(int landlordId) {
        Landlord landlord = null;
        String sql = "SELECT landlord_id, landlord_name, landlord_email, landlord_phone " +
                "FROM landlord " +
                "WHERE landlord_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlordId);
        if (results.next()) {
            landlord = mapRowToLandlord(results);
        }
        return landlord;
    }

    public Landlord getLandlordByName(String principalName) {
        // TODO implement get landlord from name after models have been updated
        return null;
    }


    private Landlord mapRowToLandlord(SqlRowSet rowSet) {
        Landlord landlord = new Landlord();
        landlord.setLandlordId(rowSet.getInt("landlord_id"));
        landlord.setLandlordName(rowSet.getString("landlord_name"));
        landlord.setLandlordPhone(rowSet.getString("landlord_phone"));
        landlord.setLandlordEmail(rowSet.getString("landlord_email"));

        return landlord;
    }
    }