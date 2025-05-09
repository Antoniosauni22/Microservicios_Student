package com.microservice.student.Service;


import com.microservice.student.dto.StudentRequest;
import com.microservice.student.dto.StudentResponse;
import com.microservice.student.entities.Student;

import java.util.List;
import java.util.Optional;


public interface StudentService {

    List<StudentResponse> findAll();
    Optional<Student> findById(Long id);
    void save(Student student);
    List<Student> findByCourseId(Long id);

}
