package com.microservice.student.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class StudentResponse {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private Long courseId;
}
