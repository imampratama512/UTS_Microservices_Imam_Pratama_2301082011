package com.teknologiinformasi.restapi.course.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.teknologiinformasi.restapi.course.model.Course;
import com.teknologiinformasi.restapi.course.service.CourseService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private static final Logger log = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    private CourseService courseService;


    @GetMapping
    public List<Course> getAllCourses() {
        log.info("GET /api/courses accessed");
        return courseService.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        log.info("GET /api/courses/{} accessed", id);
        return courseService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Course createCourse(@RequestBody Course course) {
        log.info("POST /api/courses accessed");
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course courseDetails) {
        log.info("PUT /api/courses/{} accessed", id);
        try {
            Course updatedCourse = courseService.updateCourse(id, courseDetails);
            return ResponseEntity.ok(updatedCourse);
        } catch (RuntimeException e) {
            log.error("Course with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCourse(@PathVariable Long id) {
        log.info("DELETE /api/courses/{} accessed", id);
        try {
            courseService.deleteCourse(id);
            return ResponseEntity.ok("Course deleted successfully");
        } catch (RuntimeException e) {
            log.error("Failed to delete course with id {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
