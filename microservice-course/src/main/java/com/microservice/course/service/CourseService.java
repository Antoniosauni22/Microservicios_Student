package com.microservice.course.service;


import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.dto.CourseRequest;
import com.microservice.course.dto.StudentByCourseResponse;
import com.microservice.course.entities.CourseEntity;
import com.microservice.course.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface CourseService {
   List<CourseEntity> list_course();
   Optional<CourseEntity> courseById(Long id);
   void save(CourseRequest courseRequest);
   void delete(Long id);
   StudentByCourseResponse findstudentsByCourseId(Long courseId);


}
