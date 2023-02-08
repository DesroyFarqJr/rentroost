package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Property;
import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.security.Principal;
import java.util.ArrayList;
@Component
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





    @Override
    public ArrayList<Tenant> listOfLandlordsTenants(Principal principal) {
        ArrayList<Tenant> tenants = new ArrayList<>();
        String landlordName = principal.getName();
        String sql = "SELECT * FROM tenant t " +
                "LEFT JOIN tenant_unit tu ON t.tenant_id = tu.tenant_id " +
                "LEFT JOIN property_landlord pl ON tu.property_id = pl.property_id " +
                "LEFT JOIN landlord l ON pl.landlord_id = l.landlord_id " +
                "LEFT JOIN property ON pl.property_id = property.property_id " +
                "WHERE l.landlord_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlordName);
        if (results.next()) {
            tenants.add(mapRowToTenantWithAddress(results));
        }
        return tenants;
    }

    @Override
    public boolean changeTenantAddress(String newAddress, int tenantId) {
        String sql = "UPDATE tenant_unit " +
                "SET property_id = (SELECT property_id FROM property WHERE prop_address = ?) " +
                "WHERE tenant_id = ?";
        jdbcTemplate.update(sql, newAddress, tenantId);
        return true;
    }

    @Override
    public ArrayList<Property> getLandlordsProperties(Principal principal) {
        String landlordName = principal.getName();
        ArrayList<Property> properties = new ArrayList<>();
        String sql = "SELECT * FROM property p " +
                "LEFT JOIN property_landlord pl ON p.property_id = pl.property_id " +
                "LEFT JOIN landlord l ON pl.landlord_id = l.landlord_id " +
                "WHERE landlord_name = ?";
        SqlRowSet returnedProperties = jdbcTemplate.queryForRowSet(sql, landlordName);
        if(returnedProperties.next()) {
            properties.add(mapLandlordToProperty(returnedProperties));
        }
        return properties;
    }


    private Tenant mapRowToTenantWithAddress(SqlRowSet rowSet) {
        Tenant tenant = new Tenant();
        tenant.setTenantId(rowSet.getInt("tenant_id"));
        tenant.setTenantName(rowSet.getString("tenant_name"));
        tenant.setTenantPhone(rowSet.getString("tenant_phone"));
        tenant.setTenantEmail(rowSet.getString("tenant_email"));
        tenant.setRent(rowSet.getInt("rent"));
        tenant.setOverdue(rowSet.getInt("overdue"));
        tenant.setPaid(rowSet.getBoolean("paid"));
        tenant.setTenantLandlord(rowSet.getInt("landlord_id"));
        tenant.setTenantAddress(rowSet.getString("prop_address"));

        return tenant;
    }

    private Property mapLandlordToProperty(SqlRowSet rowSet) {
        Property property = new Property();
        property.setPropertyAddress(rowSet.getString("prop_address"));
        property.setLandlordId(rowSet.getInt("landlord_id"));
        property.setPropertyId(rowSet.getInt("property_id"));
        return property;
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

