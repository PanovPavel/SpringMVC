package org.example.service;

import org.example.dao.Employee;
import org.example.dao.EmployeeDAO;
import org.example.dao.ImplDAOEmployee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    EmployeeDAO employeeDao;
    @Override
    public List<Employee> getAllEmployee() {
        return employeeDao.getAllEmployee();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }
    @Override
    public void deleteEmployee(int id) {
        employeeDao.deleteEmployee(id);
    }

    @Override
    public Employee getEmployee(int id) {
        return employeeDao.getEmployee(id);
    }
}
