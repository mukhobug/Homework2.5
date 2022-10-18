package com.example.homework2dot5.services;

import com.example.homework2dot5.Employee;

import java.util.List;
import java.util.Map;

public class Constants {
    public static Employee EMPLOYEE_1ST = new Employee("Bob", "First", 111, 1);
    public static Employee EMPLOYEE_2ND = new Employee("Bob", "Second", 222, 2);
    public static Employee EMPLOYEE_3RD = new Employee("Bob", "Third", 333, 1);
    public static Map<String, Employee> MAP_OF_EMPLOYEE_1ST = Map.of("Bob First", EMPLOYEE_1ST);
    public static Map<String, Employee> MAP_OF_EMPLOYEE_3RD = Map.of(
            "Bob First", EMPLOYEE_1ST,
            "Bob Second", EMPLOYEE_2ND,
            "Bob Third", EMPLOYEE_3RD);
    public static List<Employee> LIST_OF_1ST_DEPARTMENT = List.of(EMPLOYEE_1ST, EMPLOYEE_3RD);
    public static List<Employee> LIST_OF_2ND_DEPARTMENT = List.of(EMPLOYEE_2ND);

    public static Map<Integer, List<Employee>> MAP_OF_GROUPED_EMPLOYEES = Map.of(
            1, LIST_OF_1ST_DEPARTMENT,
            2, LIST_OF_2ND_DEPARTMENT);
}

