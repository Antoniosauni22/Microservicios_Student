package com.microservice.student.Controller;


import com.microservice.student.Service.StudentService;
import com.microservice.student.dto.StudentResponse;
import com.microservice.student.entities.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void  saveStudent(@RequestBody Student student){
        studentService.save(student);
    }


    @GetMapping("/all")
    public ResponseEntity<List<StudentResponse>> listEstudent(){
        return ResponseEntity.ok(studentService.findAll());

    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> findbyId(@PathVariable(name = "id") Long id){
        return studentService.findById(id).map(student -> ResponseEntity.ok(student))
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search-by-courseId/{courseId}")
    public ResponseEntity<?> findByCourseId(@PathVariable(name = "courseId") Long courseId){
        return ResponseEntity.ok(studentService.findByCourseId(courseId));

    }






}
