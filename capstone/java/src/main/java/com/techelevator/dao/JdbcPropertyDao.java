package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;

public class JdbcPropertyDao implements PropertyDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Property getProperty(int propertyId) {
        Property property = null;
        String sql = "SELECT property_id, prop_name, prop_address, studio_price, one_br_price, two_br_price, three_br_price, rented, url " +
                "FROM property " +
                "WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if (results.next()) {
            property = mapRowToProperty(results);
        }
        return property;
    }

    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropertyId(rowSet.getInt("property_id"));
        property.setPropertyName(rowSet.getString("prop_name"));
        property.setPropertyAddress(rowSet.getString("prop_address"));
        property.setStudioPrice(rowSet.getInt("studio_price"));
        property.setOneBedroomPrice(rowSet.getInt("one_br_price"));
        property.setTwoBedroomPrice(rowSet.getInt("two_br_price"));
        property.setThreeBedroomPrice(rowSet.getInt("three_br_price"));
        property.setRented(rowSet.getBoolean("rented"));
        property.setPropertyUrl(rowSet.getString("url"));

        return property;
    }
}