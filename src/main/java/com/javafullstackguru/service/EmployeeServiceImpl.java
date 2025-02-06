package com.javafullstackguru.service;

import com.javafullstackguru.entity.Employee;
import com.javafullstackguru.exception.EmployeeAlreadyExistException;
import com.javafullstackguru.exception.EmployeeNotFoundException;
import com.javafullstackguru.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final String EMPLOYEE_NOT_FOUND_MSG = "Employee Not Available With ID : ";

    @Autowired
    private EmployeeRepository employeeRepository;

    // Create a single employee
    @Override
    public Employee createSingleEmployee(Employee employee) {
        if (employeeRepository.existsById(employee.getId())) {
            throw new EmployeeAlreadyExistException("Employee already exists with ID: " + employee.getId());
        }
        return employeeRepository.save(employee);
    }

    // Create multiple employees
    @Override
    public List<Employee> createEmployees(List<Employee> employees) {
        for (Employee emp : employees) {
            if (employeeRepository.existsById(emp.getId())) {
                throw new EmployeeAlreadyExistException("Employee already exists with ID: " + emp.getId());
            }
        }
        return employeeRepository.saveAll(employees);
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException(EMPLOYEE_NOT_FOUND_MSG + id));
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Integer id, Employee employee) {
        if (!employeeRepository.existsById(id)) {
            throw new EmployeeNotFoundException("Can't Update, Employee Not Found with ID: " + id);
        }
        employee.setId(id);
        return employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Can't Delete, Employee Not Found With ID: " + id));
        employeeRepository.delete(employee);
    }
}
