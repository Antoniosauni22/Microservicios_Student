package com.microservice.course.service.impl;

import com.microservice.course.client.StudentClient;
import com.microservice.course.controller.dto.StudentDTO;
import com.microservice.course.dto.CourseRequest;
import com.microservice.course.dto.StudentByCourseResponse;
import com.microservice.course.entities.CourseEntity;
import com.microservice.course.repository.CourseRepository;
import com.microservice.course.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class CourseServiceImp implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    // necesita inyectar o traer los metodos desde otros microservico para poder hacer esas
    // consultas y eso lo permites OpenFeign

    @Autowired
    private StudentClient studentClient;


    @Override
    public Optional<CourseEntity> courseById(Long id) {
        return courseRepository.findById(id);
    }

    @Override
    public List<CourseEntity> list_course() {
        return courseRepository.findAll();
    }


    @Override
    public void save(CourseRequest courseRequest) {
       courseRepository.findById(courseRequest.getCourseId())
               .ifPresentOrElse(course -> { throw new RuntimeException("El curso ya existe");}
                       ,() ->{ CourseEntity course = CourseEntity.builder()
                               .nameCourse(courseRequest.getNameCourse())
                               .teacher(courseRequest.getTeacher())
                               .build();
                               courseRepository.save(course);}
                               );
    }

    @Override
    public void delete(Long id) {
        courseRepository.deleteById(id);

    }

    @Override
    public StudentByCourseResponse findstudentsByCourseId(Long courseId) {
        var course= courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("El curso no existe"));
      log.info("El objeto es : {}",course);

      // obtenido el curso verificando  podemos seguir trabajando
       List<StudentDTO> studentDTOList=  studentClient.findAllStudentByCourse(course.getCourseId());

         StudentByCourseResponse studentByCourseResponse=StudentByCourseResponse.builder()
                 .courseName(course.getNameCourse())
                 .teacher(course.getTeacher())
                 .studentDTOList(studentDTOList)
                 .build();
         log.info(" studentByCourseResponse es => :{}", studentByCourseResponse);
         return studentByCourseResponse;


    }

}
