package com.teknologiinformasi.restapi.course.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.course.model.Course;
 

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}