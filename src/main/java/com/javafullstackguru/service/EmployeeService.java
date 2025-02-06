package com.javafullstackguru.service;

import com.javafullstackguru.entity.Employee;
import java.util.List;

public interface EmployeeService {

   // Create a single employee
   Employee createSingleEmployee(Employee employee);

   // Create multiple employees
   List<Employee> createEmployees(List<Employee> employeeList);

   // Get employee by ID
   Employee getEmployeeById(Integer id);

   // Get all employees
   List<Employee> getAllEmployees();

   // Update an employee
   Employee updateEmployee(Integer id, Employee employee);

   // Delete an employee
   void deleteEmployee(Integer id);
}
