package com.feature8Demo.feature8Demo.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeId;

    private String employeeName;
    private  String employeeEmail;
    private String employeeNum;
    private Integer employeeSalary;
    private Integer employeeExp;
}
