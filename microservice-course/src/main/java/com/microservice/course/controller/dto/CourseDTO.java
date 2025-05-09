package com.microservice.course.controller.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;


@Builder
@Getter
public class CourseDTO {
    private Long courseId;
    private String nameCourse;
    private String description;
}
