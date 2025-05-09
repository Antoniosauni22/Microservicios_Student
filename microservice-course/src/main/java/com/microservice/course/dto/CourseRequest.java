package com.microservice.course.dto;


import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CourseRequest {
    private Long courseId;
    private String nameCourse;
    private String teacher;
}
