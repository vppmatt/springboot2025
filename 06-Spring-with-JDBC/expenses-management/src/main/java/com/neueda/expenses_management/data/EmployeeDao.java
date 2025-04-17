package com.neueda.expenses_management.data;

import com.neueda.expenses_management.model.Employee;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

@Component
public class EmployeeDao extends JdbcDaoSupport
{
    @Autowired
    DataSource dataSource;

    @PostConstruct
    private void initialize() {
        super.setDataSource(dataSource);
    }


    public List<Employee> getAll() {
        JdbcTemplate jdbcTemplate = super.getJdbcTemplate();
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, new EmployeeRowMapper());
    }

    public Employee getById(Long id) {
        JdbcTemplate jdbcTemplate = super.getJdbcTemplate();
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new EmployeeRowMapper());
    }

    public Employee update(Long id, Employee employee) {
        JdbcTemplate jdbcTemplate = super.getJdbcTemplate();
        String sql = "UPDATE employees SET firstname = ?, lastname = ?, dateJoined = ?, department = ?, costCenter = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getFirstname(), employee.getLastname(), employee.getDateJoined(), employee.getDepartment().name(), employee.getCostCenter(), id);
        return getById(id);
    }

    public Employee add(Employee employee) {
        JdbcTemplate jdbcTemplate = super.getJdbcTemplate();
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(jdbcTemplate).withTableName("employees").usingGeneratedKeyColumns("id");
        Map<String,Object> params = Map.of(
                "firstname", employee.getFirstname(),
                "lastname", employee.getLastname(),
                "dateJoined", employee.getDateJoined(),
                "department", employee.getDepartment().name(),
                "costCenter", employee.getCostCenter()
        );
        Long id = simpleJdbcInsert.executeAndReturnKey(params).longValue();
        return getById(id);
    }

}
