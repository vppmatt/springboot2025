package com.neueda.expenses_management.data;

import com.neueda.expenses_management.model.Department;
import com.neueda.expenses_management.model.Employee;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(
                rs.getLong("id"),
                rs.getString("firstname"),
                rs.getString("lastname"),
                rs.getDate("date_joined").toLocalDate(),
                Department.valueOf( rs.getString("department")),
                rs.getInt("costCenter"));
    }
}
