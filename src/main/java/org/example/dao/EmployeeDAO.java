package org.example.dao;


import java.util.List;

public interface EmployeeDAO {
    List<Employee> getAllEmployee();
    void addEmployee(Employee employee);
    void deleteEmployee(int id);

    Employee getEmployee(int id);
}