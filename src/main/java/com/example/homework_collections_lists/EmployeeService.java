package com.example.homework_collections_lists;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Service
public class EmployeeService {

    private  final List<Employee> employees;

    public EmployeeService() {
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
              Employee newEmployee = new Employee(firstName, lastName);
              if (employees.contains(newEmployee))
                 throw new EmployeeAlreadyAddedException();
              employees.add(newEmployee);
              return newEmployee;
          }
          public Employee removeEmployee (String firstName, String lastName) {
              Employee employee = new Employee(firstName, lastName);
              if (employees.contains(employee)) {
                  employees.remove(employee);
                  return employee;
                  }
              throw new EmployeeNotFoundException();
          }
         public Employee findEmployee (String firstName, String lastName) {
             Employee employee = new Employee(firstName, lastName);
             if (employees.contains(employee)) {
                 return employee;
             }
             throw new EmployeeNotFoundException();
         }

         public Collection<Employee> getEmployees() {
             return Collections.unmodifiableList(employees);
         }

}




