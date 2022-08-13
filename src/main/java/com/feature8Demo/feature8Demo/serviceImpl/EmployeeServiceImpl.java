package com.feature8Demo.feature8Demo.serviceImpl;

import com.feature8Demo.feature8Demo.dao.Employee;
import com.feature8Demo.feature8Demo.dto.EmployeeDto;
import com.feature8Demo.feature8Demo.repo.EmployeeRepo;
import com.feature8Demo.feature8Demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    public EmployeeRepo employeeRepo;

    @Override
    public void newEmployee(EmployeeDto employeeDto) {

        Employee employee=new Employee();
        employee.setEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setEmployeeExp(employeeDto.getEmployeeExp());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        employee.setEmployeeNum(employeeDto.getEmployeeNum());

        employeeRepo.save(employee);

    }

    @Override
    public Employee getEmployee(String name) {


        return employeeRepo.findByEmployeeName(name);
    }

    @Override
    public List<Employee> getEmployeeList() {
        return employeeRepo.findAll();
    }

    @Override
    public String updateEmployee(EmployeeDto employeeDto) {

        Employee employee=employeeRepo.findByEmployeeName(employeeDto.getEmployeeName());
        employee.setEmployeeEmail(employeeDto.getEmployeeEmail());
        employee.setEmployeeExp(employeeDto.getEmployeeExp());
        employee.setEmployeeSalary(employeeDto.getEmployeeSalary());
        employee.setEmployeeNum(employeeDto.getEmployeeNum());

        return "updated";
    }

    @Override
    public List<String> getEmployeeNames() {

       return employeeRepo.findAll().stream().map(Employee::getEmployeeName).collect(Collectors.toList());

    }

    @Override
    public List<Employee> getEligibleTaxEmployee(String value) {


        return (value.equalsIgnoreCase("tax"))
                ?employeeRepo.findAll().stream().filter(employee -> employee.getEmployeeSalary()>50000).collect(Collectors.toList())
                :employeeRepo.findAll().stream().filter(employee -> employee.getEmployeeSalary()<60000).collect(Collectors.toList()) ;
    }

    @Override
    public List<Employee> getEmployeeListASC() {
        return employeeRepo.findAll().stream().sorted(Comparator.comparing(Employee::getEmployeeSalary)).collect(Collectors.toList());
    }

    @Override
    public List<Employee> getEmployeeListDSC() {

        return employeeRepo.findAll().stream().sorted(Comparator.comparing(Employee::getEmployeeSalary).reversed()).collect(Collectors.toList());
    }

    @Override
    public Map<String, Integer> getIDvsSalary() {

        Map<String, Integer> employee=new HashMap<>();

        for(Employee entry : employeeRepo.findAll()){

            employee.put(entry.getEmployeeEmail(),entry.getEmployeeSalary());
        }

        return employee;
    }

    @Override
    public Map<String, Integer> getIDASCvsSalary() {

        Map<String, Integer> employee=new HashMap<>();

        for(Employee entry : employeeRepo.findAll()){
            employee.put(entry.getEmployeeEmail(),entry.getEmployeeSalary());
        }

       // employee.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(emp::new HashMap<>());

        return  employee;
    }
}
