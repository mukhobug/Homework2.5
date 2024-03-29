package com.example.homework2dot5.services;

import com.example.homework2dot5.Employee;
import com.example.homework2dot5.exceptions.EmployeeAlreadyAddedException;
import com.example.homework2dot5.exceptions.EmployeeNotFoundException;
import com.example.homework2dot5.exceptions.InvalidInputException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final Map<String, Employee> employeeBook = new HashMap<>();

    @Override
    public Employee addEmployee(String firstName, String lastName, int salary, int department) {
        checkInput(firstName, lastName);
        Employee temp = new Employee(firstName, lastName, salary, department);
        if (!employeeBook.containsKey(temp.toString())) {
            employeeBook.put(temp.toString(), temp);
            return temp;
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
    }

    @Override
    public Employee removeEmployee(String firstName, String lastName) {
        checkInput(firstName, lastName);
        Employee temp = findEmployee(firstName, lastName);
        employeeBook.remove(temp.toString());
        return temp;
    }

    @Override
    public Employee findEmployee(String firstName, String lastName) {
        checkInput(firstName, lastName);
        String temp = StringUtils.capitalize(firstName.toLowerCase())
                + " " + StringUtils.capitalize(lastName.toLowerCase());
        if (employeeBook.containsKey(temp)) {
            return employeeBook.get(temp);
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    @Override
    public Map<String, Employee> allEmployee() {
        return employeeBook;
    }

    private void checkInput(String firstName, String lastName) {
        if (!(isAlpha(firstName) && (isAlpha(lastName)))) {
            throw new InvalidInputException();
        }
    }
}
