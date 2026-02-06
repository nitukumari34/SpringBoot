package com.springbootweb.springbootweb.controllers;

import com.springbootweb.springbootweb.dtos.EmployeeDTO;
import com.springbootweb.springbootweb.exceptions.ResourceNotFoundException;
import com.springbootweb.springbootweb.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    // ✅ GET employee by ID
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable long id) {

        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);

        if (employeeDTO == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(employeeDTO);
    }


    // ✅ GET all employees
    @GetMapping

    public List<EmployeeDTO> getAllEmployee(Integer age, String sortby) {

        List<EmployeeDTO> employees = employeeService.getAllEmployee(); // example

        if (employees.isEmpty()) {
            throw new ResourceNotFoundException("No employees found");
        }

        return employees;
    }
//    public ResponseEntity<List<EmployeeDTO>> getAllEmployees(
//            @RequestParam(required = false) Integer age,
//            @RequestParam(required = false) String sortby) {
//
//        return ResponseEntity.ok(employeeService.getAllEmployee());
//    }

    // ✅ CREATE new employee
    @PostMapping
    public ResponseEntity<EmployeeDTO> createNewEmployee(
            @RequestBody @Valid EmployeeDTO inputEmployee) {

        EmployeeDTO createdEmployee =
                employeeService.createNewEmployee(inputEmployee);

        return ResponseEntity.status(201).body(createdEmployee);
    }

    // ✅ UPDATE (FULL)
    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(
            @PathVariable long employeeId,
            @RequestBody EmployeeDTO employeeDTO) {

        EmployeeDTO updatedEmployee =
                employeeService.updateEmployeeById(employeeId, employeeDTO);

        if (updatedEmployee == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(updatedEmployee);
    }

    // ✅ DELETE
    @DeleteMapping("/{employeeId}")
    public ResponseEntity<Void> deleteEmployeeById(
            @PathVariable long employeeId) {

        boolean deleted = employeeService.deleteEmployeeById(employeeId);

        if (!deleted) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }

    // ✅ PATCH (PARTIAL UPDATE)
//    @PatchMapping("/{employeeId}")
//    public ResponseEntity<EmployeeDTO> updatePartialEmployee(
//            @PathVariable Long employeeId,
//            @RequestBody Map<String, Object> updates) {
//
//        EmployeeDTO updatedEmployee =
//                employeeService.updatePartialEmployeeById(employeeId, updates);
//
//        if (updatedEmployee == null) {
//            return ResponseEntity.notFound().build();
//        }
//
//        return ResponseEntity.ok(updatedEmployee);
//    }
}
