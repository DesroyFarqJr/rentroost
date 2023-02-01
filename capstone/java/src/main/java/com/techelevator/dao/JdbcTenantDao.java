package com.techelevator.dao;

import com.techelevator.model.Tenant;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;


public class JdbcTenantDao implements TenantDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcTenantDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public Tenant getTenant (int tenantId) {
        Tenant tenant = null;
        String sql = "SELECT tenant_id, tenant_name, tenant_phone, tenant_email, rent, overdue, paid " +
                "FROM tenant " +
                "WHERE tenant_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, tenantId);
        if (results.next()) {
            tenant = mapRowToTenant(results);
        }
        return tenant;
    }

    private Tenant mapRowToTenant(SqlRowSet rowSet) {
        Tenant tenant = new Tenant();
        tenant.setTenantId(rowSet.getInt("tenant_id"));
        tenant.setTenantName(rowSet.getString("tenant_name"));
        tenant.setTenantPhone(rowSet.getString("tenant_phone"));
        tenant.setTenantEmail(rowSet.getString("tenant_email"));
        tenant.setRent(rowSet.getInt("rent"));
        tenant.setOverdue(rowSet.getInt("overdue"));
        tenant.setPaid(rowSet.getBoolean("paid"));

        return tenant;
    }
}