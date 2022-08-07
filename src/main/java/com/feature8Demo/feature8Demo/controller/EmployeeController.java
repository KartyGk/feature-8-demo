package com.feature8Demo.feature8Demo.controller;

import com.feature8Demo.feature8Demo.dao.Employee;
import com.feature8Demo.feature8Demo.dto.EmployeeDto;
import com.feature8Demo.feature8Demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.relational.core.sql.In;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @PostMapping("/new/emp")
    public void newEmployee(@RequestBody  EmployeeDto employeeDto){
        employeeService.newEmployee(employeeDto);
    }

    @GetMapping("/get/emp")
    public Employee getEmployee(@RequestParam String name){
        return employeeService.getEmployee(name);
    }

    @GetMapping("/getlist/emp")
    public List<Employee> getListOfEMployee(){
        return employeeService.getEmployeeList();
    }

    @PutMapping("/update/emp")
    public String updateEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.updateEmployee(employeeDto);
    }

    @GetMapping("/getnames/emp")
    public List<String> getEmployeeNmaes(){
        return employeeService.getEmployeeNames();
    }

    @GetMapping("/eligibletax/emp/{value}")
    public List<Employee> getEligibleTaxEmployee(@PathVariable ("value") String value){
        return employeeService.getEligibleTaxEmployee(value);
    }

    @GetMapping("/getASC/emp")
    public List<Employee> getEmployeeListASC(){
        return employeeService.getEmployeeListASC();
    }

    @GetMapping("/getDSC/emp")
    public List<Employee> getEmployeeListDSC(){
        return employeeService.getEmployeeListDSC();
    }

    @GetMapping("/getIDvsSalary/emp")
    public Map<String, Integer> getIDvsSalary(){
        return employeeService.getIDvsSalary();
    }

    @GetMapping("/getIDASCvsSalary/emp")
    public Map<String, Integer> getIDASCvsSalary(){
        return employeeService.getIDASCvsSalary();
    }

}
