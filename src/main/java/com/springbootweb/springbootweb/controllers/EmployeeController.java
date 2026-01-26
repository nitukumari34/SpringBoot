package com.springbootweb.springbootweb.controllers;

import com.springbootweb.springbootweb.dtos.EmployeeDTO;
import com.springbootweb.springbootweb.repositories.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
//    @GetMapping(path = "/geSecretMessage")
//    public  String getSecretMessage(){
//        return "secret message: @5657bnbm";
//    }

//    @GetMapping(path="/{employeeId}")
//    public EmployeeDTO getSecretMessagebyId(@PathVariable(name="employeeId") Long id){
//        return new EmployeeDTO(
//                id,
//                "nitu",
//                24,
//                true,
//                LocalDate.of(2026, 1, 25)
//        );
//}
    public final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

//    @GetMapping
//        public String getAllEmployee(@RequestParam(required = false) Integer age,String sortby){
//              return "hi age"+age +" "+sortby;
//          }
//          @PostMapping
//    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
//            inputEmployee.setId(1);
//           return inputEmployee;
//
//          }
//          @PutMapping
//       public  String updateEmployee(){
//            return  "hello from put: hhj";
//          }

    @GetMapping
    public String getAllEmployee(@RequestParam(required = false) Integer age,String sortby){
        return "hi age"+age +" "+sortby;
    }
    @PostMapping
    public EmployeeDTO createNewEmployee(@RequestBody EmployeeDTO inputEmployee){
        inputEmployee.setId(1);
        return inputEmployee;

    }
    @PutMapping
    public  String updateEmployee(){
        return  "hello from put: hhj";
    }
}
