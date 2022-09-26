package com.example.homework2dot5;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/employee")
@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam(required = false) String firstname,
                        @RequestParam(required = false) String lastname) {
        if (employeeService.checkNull(firstname, lastname)) {
            throw new RuntimeException("Неполное Имя!");
        }
        return employeeService.addEmployee(firstname, lastname);
    }

    @GetMapping("/remove")
    public Employee remove(@RequestParam(required = false) String firstname,
                           @RequestParam(required = false) String lastname) {
        if (employeeService.checkNull(firstname, lastname)) {
            throw new RuntimeException("Неполное Имя!");
        }
        return employeeService.removeEmployee(firstname, lastname);
    }

    @GetMapping("/find")
    public Employee find(@RequestParam(required = false) String firstname,
                         @RequestParam(required = false) String lastname) {
        if (employeeService.checkNull(firstname, lastname)) {
            throw new RuntimeException("Неполное Имя!");
        }
        return employeeService.findEmployee(firstname, lastname);
    }

    @GetMapping("/all")
    public List<Employee> all() {
        return employeeService.allEmployee();
    }
}
