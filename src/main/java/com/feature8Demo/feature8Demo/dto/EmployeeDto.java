package com.feature8Demo.feature8Demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {

    private String employeeName;
    private  String employeeEmail;
    private String employeeNum;
    private Integer employeeSalary;
    private Integer employeeExp;
}
