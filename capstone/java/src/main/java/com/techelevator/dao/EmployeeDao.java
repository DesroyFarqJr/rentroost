package com.techelevator.dao;

import com.techelevator.model.Employee;

public interface EmployeeDao {

    Employee getEmployee(int employeeId);
    boolean addEmployee(String firstname, String lastname, String email, String phone, int userId);
    
    }