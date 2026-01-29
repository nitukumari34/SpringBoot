package com.springbootweb.springbootweb.services;

import com.springbootweb.springbootweb.dtos.EmployeeDTO;
import com.springbootweb.springbootweb.dtos.EmployeeEntity;
import com.springbootweb.springbootweb.repositories.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepository employeeRepository,
                           ModelMapper modelMapper) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
    }

    // ✅ GET ALL
    public List<EmployeeDTO> getAllEmployee() {
        return employeeRepository.findAll()
                .stream()
                .map(entity -> modelMapper.map(entity, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    // ✅ CREATE
    public EmployeeDTO createNewEmployee(EmployeeDTO inputEmployeeDto) {

        EmployeeEntity employeeEntity =
                modelMapper.map(inputEmployeeDto, EmployeeEntity.class);

        EmployeeEntity savedEmployee =
                employeeRepository.save(employeeEntity);

        return modelMapper.map(savedEmployee, EmployeeDTO.class);
    }

    // ✅ GET BY ID
    public EmployeeDTO getEmployeeById(long id) {
        EmployeeEntity employeeEntity = employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));

        return modelMapper.map(employeeEntity, EmployeeDTO.class);
    }
}
