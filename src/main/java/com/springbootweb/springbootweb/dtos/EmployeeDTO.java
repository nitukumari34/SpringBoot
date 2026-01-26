package com.springbootweb.springbootweb.dtos;

import java.time.LocalDate;
import java.util.Date;

public class EmployeeDTO {
    public long id;
    public String name;
    public  Integer age;
    public LocalDate dateOfJoining;
    private Boolean isActive;

    public EmployeeDTO(){

    }
    public EmployeeDTO(long id, String name, Integer age, Boolean isActive, LocalDate dateOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isActive = isActive;
        this.dateOfJoining = dateOfJoining;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(LocalDate dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
