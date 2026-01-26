package com.springbootweb.springbootweb.dtos;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="employees")
public class EmployeeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long id;
    public String name;
    public  Integer age;
    public LocalDate dateOfJoining;
    private Boolean isActive;
}
