package com.microservice.course.controller.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StudentDTO {

    private String name;
    private String lastName;
    private String email;
    private Long courseId;
}
