package com.example.homework_collections_lists;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private  final Map<String,Employee> employees;

    public EmployeeService() {
        this.employees = new HashMap<>();
    }

    public Employee addEmployee(String firstName, String lastName) {
              Employee employee = new Employee(firstName, lastName);
              if (employees.containsKey(employee.getFullName()))
                 throw new EmployeeAlreadyAddedException();
              employees.put(employee.getFullName(), employee);
              return employee;
          }
          public Employee removeEmployee (String firstName, String lastName) {
              Employee employee = new Employee(firstName, lastName);
              if (employees.containsKey(employee.getFullName())) {
                  return employees.remove(employee.getFullName());
              }
              throw new EmployeeNotFoundException();
          }
         public Employee findEmployee (String firstName, String lastName) {
             Employee employee = new Employee(firstName, lastName);
             if (employees.containsKey(employee.getFullName())) {
                 return employees.get(employee.getFullName());
             }
             throw new EmployeeNotFoundException();
         }

         public Collection<Employee> getEmployees() {
             return Collections.unmodifiableCollection(employees.values());
         }

}




