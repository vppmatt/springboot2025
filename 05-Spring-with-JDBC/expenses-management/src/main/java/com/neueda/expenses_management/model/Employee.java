package com.neueda.expenses_management.model;

import java.time.LocalDate;
import java.util.Objects;

public class Employee {

    private Long id;
    private String firstname;
    private String lastname;
    private LocalDate dateJoined;
    private Department department;
    private Integer costCenter;

    public Employee(Long id, String firstname, String lastname, LocalDate dateJoined, Department department, Integer costCenter) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.dateJoined = dateJoined;
        this.department = department;
        this.costCenter = costCenter;
    }

    public Employee() {
        // Default constructor
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public LocalDate getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(LocalDate dateJoined) {
        this.dateJoined = dateJoined;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(Integer costCenter) {
        this.costCenter = costCenter;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id) && Objects.equals(firstname, employee.firstname) && Objects.equals(lastname, employee.lastname) && Objects.equals(dateJoined, employee.dateJoined) && department == employee.department && Objects.equals(costCenter, employee.costCenter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, dateJoined, department, costCenter);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", dateJoined=" + dateJoined +
                ", department=" + department +
                ", costCenter=" + costCenter +
                '}';
    }
}
