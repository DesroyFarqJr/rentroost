package com.techelevator.dao;

import com.techelevator.model.Landlord;
import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
    public boolean addLandlord(String firstname, String lastname, String email, String phone, int userId) {
        String insertUserSql = "INSERT INTO landlord (landlord_name, landlord_email, landlord_phone, landlord_user_id) values (?,?,?,?)";
        return jdbcTemplate.update(insertUserSql, "" + firstname + " " + lastname, email, phone, userId) == 1;
    }

    public Landlord getLandlordByName(String principalName) {
        // TODO implement get landlord from name after models have been updated
        return null;
    }




    @Override
    public ArrayList<Tenant> listOfLandlordsTenants(Principal principal) {
        ArrayList<Tenant> tenants = new ArrayList<>();
        String landlordName = principal.getName();
        String sql = "SELECT * FROM tenant t " +
                "LEFT JOIN tenant_unit tu ON t.tenant_id = tu.tenant_id " +
                "LEFT JOIN property_landlord pl ON tu.property_id = pl.property_id " +
                "LEFT JOIN landlord l ON pl.landlord_id = l.landlord_id " +
                "WHERE l.landlord_name = ?";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, landlordName);
        if (results.next()) {
            tenants.add(mapRowToTenantWithAddress(results));
        }
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

        return tenant;
    }

    }
