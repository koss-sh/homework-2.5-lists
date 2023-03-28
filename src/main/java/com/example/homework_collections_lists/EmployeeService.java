package com.example.homework_collections_lists;

import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
     List<Employee> employees = new ArrayList<>(List.of(
             new Employee("Иван", "Бадин"),
             new Employee("Вадим", "Питун"),
             new Employee("Анжела", "Меркелова")));

          public void addEmployee(String firstName, String lastName) {
          Employee newEmployee = new Employee(firstName, lastName);
              if (employees.size() == 5) throw new EmployeeStorageIsFullException();
              for (Employee e: employees) {
                  if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                      throw new EmployeeAlreadyAddedException();
              }
          employees.add(newEmployee);

          }
          public void removeEmployee (String firstName, String lastName) {
              for (Employee e: employees) {
                  if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                      employees.remove(e);
              }
          }
         public Employee findEmployee (String firstName, String lastName) {
             for (Employee e : employees) {
                 if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                     return e;
             }
             throw new EmployeeNotFoundException();
         }
    }




