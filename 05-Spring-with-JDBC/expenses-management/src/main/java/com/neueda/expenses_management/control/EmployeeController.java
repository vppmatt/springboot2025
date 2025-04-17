package com.neueda.expenses_management.control;

import com.neueda.expenses_management.model.Employee;
import com.neueda.expenses_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


     @GetMapping()
     public List<Employee> getAllEmployees() {
         return employeeService.getAllEmployeees();
     }


     @PostMapping()
     public Employee addEmployee(@RequestBody Employee employee) {
         return employeeService.addEmployee(employee);
     }


     @PutMapping("/{id}")
     public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
         return employeeService.updateEmployee(id, employee);
     }
}
