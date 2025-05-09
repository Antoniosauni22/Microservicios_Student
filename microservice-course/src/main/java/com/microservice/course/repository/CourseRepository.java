package com.microservice.course.repository;

import com.microservice.course.entities.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepository extends JpaRepository<CourseEntity,Long> {
}
