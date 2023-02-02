package com.techelevator.dao;

import com.techelevator.model.Property;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class JdbcPropertyDao implements PropertyDao {

    private JdbcTemplate jdbcTemplate;

    public JdbcPropertyDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Property getPropertyById(int propertyId) {
        Property property = null;
        String sql = "SELECT property_id, prop_name, prop_address, prop_description, prop_bedrooms, prop_bathrooms, prop_rent, rented, url " +
                "FROM property " +
                "WHERE property_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, propertyId);
        if (results.next()) {
            property = mapRowToProperty(results);
        }
        return property;
    }

    @Override
    public List<Property> getPropertiesByLandlord(int landlord) {
        List<Property> outputList = new ArrayList<>();
        String sql = "SELECT p.property_id, p.prop_name, p.prop_address, p.prop_description, p.prop_bedrooms, p.prop_bathrooms, p.prop_rent, p.rented, p.url FROM property p LEFT JOIN property_landlord pl ON p.property_id = pl.property_id WHERE pl.landlord_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlord);
        while (results.next()) {
            Property property = mapRowToProperty(results);
            outputList.add(property);
        }
        return outputList;
    }

    @Override
    public List<Property> getAllProperties() {
        List<Property> outputList = new ArrayList<>();
        String sql = "SELECT p.property_id, p.prop_name, p.prop_address, p.prop_description, p.prop_bedrooms, p.prop_bathrooms, p.prop_rent, p.rented, p.url " +
                "FROM property p LEFT JOIN property_landlord pl ON p.property_id = pl.property_id;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
        while (results.next()) {
            Property property = mapRowToProperty(results);
            outputList.add(property);
        }
        return outputList;
    }


    private Property mapRowToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropertyId(rowSet.getInt("property_id"));
        property.setPropertyName(rowSet.getString("prop_name"));
        property.setPropertyAddress(rowSet.getString("prop_address"));
        property.setPropertyDescription(rowSet.getString("prop_description"));
        property.setPropertyBedrooms(rowSet.getInt("prop_bedrooms"));
        property.setPropertyBathrooms(rowSet.getInt("prop_bathrooms"));
        property.setPropertyRent(rowSet.getDouble("prop_rent"));
        property.setRented(rowSet.getBoolean("rented"));
        property.setImageUrl(rowSet.getString("url"));

        return property;
    }
}