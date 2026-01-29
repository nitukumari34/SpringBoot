package com.springbootweb.springbootweb.dtos;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDTO {

    private Long id;
    private String name;
    private Integer age;
    private LocalDate dateOfJoining;
    private Boolean active;
}
