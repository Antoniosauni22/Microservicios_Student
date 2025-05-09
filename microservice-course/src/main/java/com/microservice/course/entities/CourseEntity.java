package com.microservice.course.entities;


import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course_entity")
@ToString
public class CourseEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "course_id")
    private Long courseId;

    @Column(name = "name_course")
    private String nameCourse;

    private String teacher;
}
