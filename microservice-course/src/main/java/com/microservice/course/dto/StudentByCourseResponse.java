package com.microservice.course.dto;


import com.microservice.course.controller.dto.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class StudentByCourseResponse {
    private String courseName;
    private String teacher;
    private List<StudentDTO> studentDTOList;



}
