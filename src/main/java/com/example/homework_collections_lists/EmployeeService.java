package com.example.homework_collections_lists;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class EmployeeService {
     List<Employee> employees = new ArrayList<>(List.of(
             new Employee("Иван", "Бадин"),
             new Employee("Вадим", "Питун"),
             new Employee("Анжела", "Меркелова")));

          public Employee addEmployee(String firstName, String lastName) {
              Employee newEmployee = new Employee(firstName, lastName);
              if (employees.size() == 4) throw new EmployeeStorageIsFullException();
              for (Employee e: employees) {
                  if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                      throw new EmployeeAlreadyAddedException();
              }
              employees.add(newEmployee);
              return newEmployee;
          }
          public Employee removeEmployee (String firstName, String lastName) {
              for (Employee e: employees) {
                  if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName)) {
                      employees.remove(e);
                      return e;
                  }
              }
              throw new EmployeeNotFoundException();
          }
         public Employee findEmployee (String firstName, String lastName) {
             for (Employee e : employees) {
                 if (e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                     return e;
             }
             throw new EmployeeNotFoundException();
         }

}




