package com.microservice.student.Service.impl;

import com.microservice.student.Repository.StudentRepository;
import com.microservice.student.Service.StudentService;
import com.microservice.student.dto.StudentRequest;
import com.microservice.student.dto.StudentResponse;
import com.microservice.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.StreamSupport;


@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private  StudentRepository studentRepository;

    @Override
    public List<StudentResponse> findAll() {
       return studentRepository.findAll().stream().map(student -> StudentResponse.builder()
              // .courseId(student.getCourseId()) no enviamos id por seguridad
               .email(student.getEmail())
               .name(student.getName())
               .lastName(student.getLastName())
               .courseId(2l) // seteamos solo para prueba Postman
               .build()).toList();
    }

    @Override
    public Optional<Student> findById(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public void save(Student student) {
        studentRepository.save(student);
    }

    @Override
    public List<Student> findByCourseId(Long id) {
        return studentRepository.findAllByCourseId(id);
    }

}
