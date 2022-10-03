package com.example.homework2dot5.controllers;

import com.example.homework2dot5.Employee;
import com.example.homework2dot5.services.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RequestMapping("/employees")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam String firstname,
                        @RequestParam String lastname,
                        @RequestParam Integer salary,
                        @RequestParam Integer department) {
        return employeeService.addEmployee(firstname, lastname, salary, department);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam String firstname,
                           @RequestParam String lastname) {
        return employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam String firstname,
                         @RequestParam String lastname) {
        return employeeService.findEmployee(firstname, lastname);
    }

    @GetMapping("/all")
    public Map<String, Employee> all() {
        return employeeService.allEmployee();
    }
}
