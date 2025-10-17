package com.batch.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PersonDto {
    private String firstName;
    private String lastName;
    private int age;
    private String documentNumber;
    private Double salary;
}
