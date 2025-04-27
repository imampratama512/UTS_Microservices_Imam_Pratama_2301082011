package com.teknologiinformasi.restapi.course.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasi.restapi.course.model.Course;
import com.teknologiinformasi.restapi.course.repository.CourseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAll() {
        return courseRepository.findAll();
    }

    public Optional<Course> getById(Long id) {
        return courseRepository.findById(id);
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(Long id, Course courseDetails) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        
        course.setTitle(courseDetails.getTitle());
        course.setDescription(courseDetails.getDescription());
        course.setStartDate(courseDetails.getStartDate());

        return courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        Course course = courseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Course not found with id " + id));
        courseRepository.delete(course);
    }
}
