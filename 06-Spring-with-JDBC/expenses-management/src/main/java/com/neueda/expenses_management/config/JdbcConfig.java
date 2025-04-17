package com.neueda.expenses_management.config;

import com.neueda.expenses_management.model.Department;
import com.neueda.expenses_management.model.Employee;
import com.neueda.expenses_management.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@Configuration
public class JdbcConfig {

//    @Bean
//    public DataSource getDataSource() {
//        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        dataSource.setDriverClassName(env.getProperty("db.driver"));
//        dataSource.setUrl(env.getProperty("db.url"));
//        dataSource.setUsername(env.getProperty("db.username"));
//        dataSource.setPassword(env.getProperty("db.password"));
//        return dataSource;
//    }

    @Bean
    public CommandLineRunner seedDatabase(EmployeeService employeeService) {

        return args -> {
            if (employeeService.getAllEmployeees().size() > 0) {
                return;
            };
            List<Employee> employees = Arrays.asList(
                    new Employee(1L, "Noah", "Lott", LocalDate.of(2020, 3, 17), Department.Finance, 101),
                    new Employee(2L, "Ella", "Vator", LocalDate.of(2020, 3, 19), Department.Finance, 101),
                    new Employee(3L, "Holly", "Daze", LocalDate.of(2020, 7, 1), Department.HR, 104),
                    new Employee(4L, "Cliff", "Hanger", LocalDate.of(2021, 1, 9), Department.Operations, 220),
                    new Employee(5L, "Willy", "Eckerslike", LocalDate.of(2022, 10, 10), Department.Legal, 155)
            );
            employees.stream().forEach(employeeService::addEmployee);
        };
    }
}
