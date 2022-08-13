package com.feature8Demo.feature8Demo.service;

import com.feature8Demo.feature8Demo.dao.Employee;
import com.feature8Demo.feature8Demo.dto.EmployeeDto;



import java.util.List;
import java.util.Map;

public interface EmployeeService {

    void newEmployee(EmployeeDto employeeDto);
    Employee getEmployee(String name);
    List<Employee> getEmployeeList();
    String updateEmployee(EmployeeDto employeeDto);

    List<String> getEmployeeNames();

    List<Employee> getEligibleTaxEmployee(String value);

    List<Employee> getEmployeeListASC();

    List<Employee> getEmployeeListDSC();

    Map<String,Integer> getIDvsSalary();

    Map<String,Integer> getIDASCvsSalary();
}
