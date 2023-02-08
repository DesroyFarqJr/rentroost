package com.techelevator.dao;

import com.techelevator.model.Employee;

import java.util.ArrayList;
import java.util.List;

public interface EmployeeDao {

        Employee getEmployee(int employeeId);

        ArrayList<Employee> listOfEmployeees();

//    MORE STUFF SOON!


    }
