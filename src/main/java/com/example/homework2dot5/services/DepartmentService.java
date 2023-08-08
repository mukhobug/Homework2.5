package com.example.homework2dot5.services;

import com.example.homework2dot5.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee max(int dep);

    Employee min(int dep);

    List<Employee> all(int dep);

    Map<Integer, List<Employee>> allDepart();
}
