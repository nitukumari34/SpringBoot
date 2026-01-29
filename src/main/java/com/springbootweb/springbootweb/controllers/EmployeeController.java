package com.springbootweb.springbootweb.controllers;

import com.springbootweb.springbootweb.dtos.EmployeeDTO;
import com.springbootweb.springbootweb.services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ✅ GET employee by ID
    @GetMapping("/{id}")
    public EmployeeDTO getEmployeeById(@PathVariable long id) {
        return employeeService.getEmployeeById(id);
    }

    // ✅ GET all employees
    @GetMapping
    public List<EmployeeDTO> getAllEmployees(
            @RequestParam(required = false) Integer age,
            @RequestParam(required = false) String sortby) {

        // (age, sortby can be used later)
        return employeeService.getAllEmployee();
    }

    // ✅ CREATE new employee
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee) {
        return employeeService.createNewEmployee(inputEmployee);
    }

    // ✅ UPDATE (dummy for now)
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable long id) {
        return "Employee updated with id: " + id;
    }
}
