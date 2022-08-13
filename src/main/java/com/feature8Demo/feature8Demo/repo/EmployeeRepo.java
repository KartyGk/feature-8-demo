package com.feature8Demo.feature8Demo.repo;

import com.feature8Demo.feature8Demo.dao.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {
    Employee findByEmployeeName(String name);
}
