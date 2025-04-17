package com.neueda.expenses_management.service;

import com.neueda.expenses_management.model.Department;
import com.neueda.expenses_management.model.Employee;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {

    /*
    Dummy data - to be replaced soon. This is NOT production standard and is not thread-safe!
     */

    private List<Employee> employees = Arrays.asList(
            new Employee(1L, "Noah", "Lott", LocalDate.of(2020, 3, 17), Department.Finance, 101),
            new Employee(2L, "Ella", "Vator", LocalDate.of(2020, 3, 19), Department.Finance, 101),
            new Employee(3L, "Holly", "Daze", LocalDate.of(2020, 7, 1), Department.HR, 104),
            new Employee(4L, "Cliff", "Hanger", LocalDate.of(2021, 1, 9), Department.Operations, 220),
            new Employee(5L, "Willy", "Eckerslike", LocalDate.of(2022, 10, 10), Department.Legal, 155)
    );

    public List<Employee> getAllEmployeees() {
        return employees;
    }

    public Employee addEmployee(Employee employee) {
        employee.setId(employees.size()+1L);
        employees.add(employee);
        return employee;
    }

    public Employee updateEmployee(Long id, Employee employee) {
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId().equals(id)) {
                employees.set(i, employee);
                return employee;
            }
        }
        return null;
    }
}
