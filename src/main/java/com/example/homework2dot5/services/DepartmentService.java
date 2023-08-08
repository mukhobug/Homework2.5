package com.example.homework2dot5.services;

import com.example.homework2dot5.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee maxSalary(int dep);

    Employee minSalary(int dep);

    List<Employee> allEmployeeInDepart(int dep);

    Map<Integer, List<Employee>> allEmployeeByDepart();
}
