package com.microservice.course.controller;

import com.microservice.course.dto.CourseRequest;
import com.microservice.course.dto.CourseResponse;
import com.microservice.course.entities.CourseEntity;
import com.microservice.course.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/course")
@Slf4j
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("")
    public ResponseEntity<List<?>> list_course(){
        return ResponseEntity.ok(courseService.list_course());

    }

    @GetMapping("v2/{id}")
    public ResponseEntity<CourseResponse> courseById2(@PathVariable Long id){
        return courseService.courseById(id).map(course -> ResponseEntity.ok(
                CourseResponse.builder()
                        .courseId(course.getCourseId())
                        .nameCourse(course.getNameCourse())
                        .teacher(course.getTeacher())
                        .build()))
                .orElse(ResponseEntity.notFound().build());
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> courseById(@PathVariable("id") Long id){
        log.info("curso: {}", courseService.courseById(id));
        return courseService.courseById(id).map(response -> {
                    log.info("curso int: {}", response);
                    return ResponseEntity.ok(response);
        })
                .orElse(ResponseEntity.notFound().build());

    }


    @PostMapping("/created")
    public ResponseEntity<String> saveCourse(@RequestBody CourseRequest courseRequest){
         courseService.save(courseRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body("Curso creado");

    }


    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id){
        courseService.delete(id);
        return ResponseEntity.accepted().body("El curso a sido Eliminado");

    }



    @GetMapping("search-students/{courseId}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<?> findStudentByCourseId(@PathVariable Long courseId){
        return ResponseEntity.ok(courseService.findstudentsByCourseId(courseId));

    }


}
