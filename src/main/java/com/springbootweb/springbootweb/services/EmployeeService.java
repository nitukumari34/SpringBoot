package com.springbootweb.springbootweb.services;

import com.springbootweb.springbootweb.dtos.EmployeeDTO;
import com.springbootweb.springbootweb.dtos.EmployeeEntity;
import com.springbootweb.springbootweb.repositories.EmployeeRepository;
import org.apache.el.util.ReflectionUtil;
import org.aspectj.util.Reflection;
import org.modelmapper.ModelMapper;
import org.springframework.data.util.ReflectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
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

    public EmployeeDTO updateEmployeeById(long employeeId, EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity=modelMapper.map(employeeDTO,EmployeeEntity.class);
        employeeEntity.setId(employeeId);
        EmployeeEntity saveEmployeeEntity=employeeRepository.save(employeeEntity);
        return  modelMapper.map(saveEmployeeEntity,EmployeeDTO.class);
    }
    public boolean isExistsEmployeeById(Long employeeId){
        return  employeeRepository.existsById(employeeId);

    }
    public boolean deleteEmployeeById(long employeeId) {

       boolean exits= isExistsEmployeeById(employeeId);
       if(!exits)return false;
       employeeRepository.deleteById(employeeId);
       return true;

    }

//    public EmployeeDTO updatePartialEmployeeById(
//            Long employeeId,
//            Map<String, Object> updates) {
//
//        EmployeeEntity employeeEntity = employeeRepository.findById(employeeId)
//                .orElseThrow(() -> new RuntimeException("Employee not found"));
//
//        for (Map.Entry<String, Object> entry : updates.entrySet()) {
//            String fieldName = entry.getKey();
//            Object value = entry.getValue();
//            Field field = ReflectionUtils.findField(EmployeeEntity.class, fieldName);
//
//            if (field != null) {
//                field.setAccessible(true);
//                ReflectionUtils.setField(field, employeeEntity, value);
//            }
//        }
//        EmployeeEntity savedEmployee = employeeRepository.save(employeeEntity);
//
//        return modelMapper.map(savedEmployee, EmployeeDTO.class);
//    }
}
