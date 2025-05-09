package com.microservice.course.client;


import com.microservice.course.controller.dto.StudentDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mcsv-student",url = "localhost:8090")

public interface StudentClient {

    @GetMapping("api/student/search-by-courseId/{courseId}")
    List<StudentDTO> findAllStudentByCourse(@PathVariable Long courseId );
}
