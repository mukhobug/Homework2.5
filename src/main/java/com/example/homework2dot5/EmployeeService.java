package com.example.homework2dot5;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {
    private List<Employee> employeeService = new ArrayList<>();

    public EmployeeService(List<Employee> employeeService) {
        this.employeeService = employeeService;
    }

    public Employee addEmployee(String firstName, String lastName) {
        Employee temp = new Employee(firstName, lastName);
        if (!employeeService.contains(temp)) {
            employeeService.add(temp);
            return temp;
        } else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует!");
        }
    }

    public Employee removeEmployee(String firstName, String lastName) {
        Employee temp = findEmployee(firstName, lastName);
        employeeService.remove(temp);
        return temp;
    }

    public Employee findEmployee(String firstName, String lastName) {
        for (Employee employee : employeeService) {
            if (employee.getFirstName().equals(firstName) &&
                    employee.getLastName().equals(lastName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден!");
    }

    public List<Employee> allEmployee() {
        return Collections.unmodifiableList(employeeService);
    }

    public boolean checkNull(String firstname, String lastname) {
        return firstname == null || lastname == null;
    }
}
