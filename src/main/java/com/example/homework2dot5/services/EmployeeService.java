package com.example.homework2dot5.services;

import com.example.homework2dot5.Employee;

import java.util.Map;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName, int salary, int department);

    Employee removeEmployee(String firstName, String lastName);

    Employee findEmployee(String firstName, String lastName);

    Map<String, Employee> allEmployee();
}
