package org.example.service;

import org.example.dao.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public void addEmployee(Employee employee);
    public void deleteEmployee(int id);
    public Employee getEmployee(int id);
}
