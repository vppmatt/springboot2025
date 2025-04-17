package com.neueda.expenses_management.service;

import com.neueda.expenses_management.data.EmployeeDao;
import com.neueda.expenses_management.model.Department;
import com.neueda.expenses_management.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    public List<Employee> getAllEmployeees() {
        return employeeDao.getAll();
    }

    public Employee addEmployee(Employee employee) {
        return employeeDao.add(employee);
    }

    public Employee updateEmployee(Long id, Employee employee) {
        return employeeDao.update(id, employee);
    }
}
