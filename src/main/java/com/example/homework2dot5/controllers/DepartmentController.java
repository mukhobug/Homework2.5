package com.example.homework2dot5.controllers;

import com.example.homework2dot5.Employee;
import com.example.homework2dot5.services.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RequestMapping("/departments")
@RestController
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max")
    public Employee max(@RequestParam Integer department) {
        return departmentService.maxSalary(department);
    }

    @GetMapping("/min")
    public Employee min(@RequestParam Integer department) {
        return departmentService.minSalary(department);
    }

    @GetMapping(value = "/all", params = "dep")
    public List<Employee> all(@RequestParam Integer department) {
        return departmentService.allEmployeeInDepart(department);
    }

    @GetMapping("/all")
    public Map<Integer, List<Employee>> allDepart() {
        return departmentService.allEmployeeByDepart();
    }
}
