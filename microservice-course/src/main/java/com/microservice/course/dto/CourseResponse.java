package com.microservice.course.dto;

import jakarta.persistence.Column;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CourseResponse {
    private Long courseId;
    private String nameCourse;
    private String teacher;
}
