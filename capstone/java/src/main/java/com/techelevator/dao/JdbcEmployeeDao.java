package com.techelevator.dao;

import com.techelevator.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import javax.sql.DataSource;


public class JdbcEmployeeDao implements EmployeeDao {

    private JdbcTemplate jdbcTemplate;
    public JdbcEmployeeDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Employee getEmployee(int employeeId) {
        Employee employee = null;
        String sql = "SELECT employee_id, employee_name, emp_email, emp_phone " +
                "FROM employee " +
                "WHERE employee_id = ?;";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, employeeId);
        if (results.next()) {
            employee = mapRowToEmployee(results);
        }
        return employee;
    }

    private Employee mapRowToEmployee(SqlRowSet rowSet) {
        Employee employee = new Employee();
        employee.setEmployeeId(rowSet.getInt("employee_id"));
        employee.setEmployeeName(rowSet.getString("employee_name"));
        employee.setEmployeePhone(rowSet.getString("emp_phone"));
        employee.setEmployeeEmail(rowSet.getString("emp_email"));

        return employee;
    }
}