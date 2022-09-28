package com.example.homework2dot5;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    private final Map<String, Employee> employeeBook = new HashMap<>();

    public Employee addEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (!employeeBook.containsKey(temp.toString())) {
            employeeBook.put(temp.toString(), temp);
            return temp;
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee temp = findEmployee(firstName, lastName);
        employeeBook.remove(temp.toString());
        return temp;
    }

    public Employee findEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (employeeBook.containsKey(temp.toString())) {
            return temp;
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    public Map<String, Employee> allEmployee() {
        return employeeBook;
    }

    public boolean checkNull(String firstname, String lastname) {
        return firstname == null || lastname == null;
    }
}
