package com.springbootweb.springbootweb.dtos;

import jakarta.validation.constraints.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    private Integer age;

    private LocalDate dateOfJoining;

    @Pattern(regexp = "^(ADMIN|USER)$",message = "Role of employee can be ADMIN Or USER")
    private  String role;
    private double salary;
    private Boolean active;
}
