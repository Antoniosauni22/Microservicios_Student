package com.microservice.student.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class StudentRequest {
    @NotBlank(message = "El nombre no puede estar vacio")
    private String name;

    @NotBlank(message = "El apellido no puede estar vacio")
    private String lastName;

    @NotBlank(message = "El email no puede estar vacio")
    private String email;

    private Long courseId;
}
