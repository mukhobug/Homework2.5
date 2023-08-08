package com.example.homework2dot5.services;

import com.example.homework2dot5.Employee;
import com.example.homework2dot5.exceptions.EmployeeNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeService employeeService;

    public DepartmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee max(int dep) {
        return employeeService.allEmployee().values().stream()
                .filter(employee -> employee.getDepartment() == dep)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found!"));
    }

    @Override
    public Employee min(int dep) {
        return employeeService.allEmployee().values().stream()
                .filter(employee -> employee.getDepartment() == dep)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(()-> new EmployeeNotFoundException("Employee not found!"));
    }

    @Override
    public List<Employee> all(int dep) {
        return employeeService.allEmployee().values().stream()
                .filter(employee -> employee.getDepartment() == dep)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> allDepart() {
        return employeeService.allEmployee().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
