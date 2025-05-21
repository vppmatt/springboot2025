package com.neueda.expenses_management.control;

import com.neueda.expenses_management.model.Employee;
import com.neueda.expenses_management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@CrossOrigin
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


    //eg /api/employee?cc=101
    @GetMapping()
    public List<Employee> getAllEmployees(@RequestParam("cc") Optional<Integer> cc) {
        System.out.println("cc was " + (cc.isPresent() ? cc.get() : "null"));

        return employeeService.getAllEmployeees();
    }


     @PostMapping()
     public Employee addEmployee(@RequestBody Employee employee) {
         return employeeService.addEmployee(employee);
     }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable("id") Integer employeeId) {
        return employeeService.getEmployee(employeeId);
    }

     @PutMapping("/{id}")
     public Employee updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
         return employeeService.updateEmployee(id, employee);
     }
}
