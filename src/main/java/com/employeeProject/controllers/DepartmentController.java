package com.employeeProject.controllers;

import com.employeeProject.entity.Employee;
import com.employeeProject.services.IDepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/departments")
public class DepartmentController {

    private final IDepartmentService departmentService;

    public DepartmentController(IDepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/max-salary")
    public Employee maxSalaryOfDepartment(@RequestParam(value = "departmentId") Integer departmentId) {
        return departmentService.maxSalaryOfDepartment(departmentId);
    }

    @GetMapping(path = "/min-salary")
    public Employee mimSalaryOfDepartment(@RequestParam(value = "departmentId") Integer departmentId) {
        return departmentService.minSalaryOfDepartment(departmentId);
    }

    @GetMapping(path = "/all")
    public List<Employee> allEmployees(@RequestParam(value = "departmentId", required = false) Integer departmentId) {
        return departmentService.getAllEmployees(departmentId);
    }
}