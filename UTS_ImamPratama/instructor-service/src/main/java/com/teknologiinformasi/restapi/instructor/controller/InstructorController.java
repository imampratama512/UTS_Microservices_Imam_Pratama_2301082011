package com.teknologiinformasi.restapi.instructor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.teknologiinformasi.restapi.instructor.model.Instructor;
import com.teknologiinformasi.restapi.instructor.service.InstructorService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/instructors")
public class InstructorController {

    private static final Logger log = LoggerFactory.getLogger(InstructorController.class);

    @Autowired
    private InstructorService instructorService;

    // GET semua instructor
    @GetMapping
    public List<Instructor> getAllInstructors() {
        log.info("GET /api/instructors accessed");
        return instructorService.getAll();
    }

    // GET instructor berdasarkan id
    @GetMapping("/{id}")
    public ResponseEntity<Instructor> getInstructorById(@PathVariable Long id) {
        log.info("GET /api/instructors/{} accessed", id);
        return instructorService.getById(id)
                .map(instructor -> ResponseEntity.ok(instructor))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST membuat instructor baru
    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor instructor) {
        log.info("POST /api/instructors accessed");
        return instructorService.createInstructor(instructor);
    }

    // PUT update instructor yang ada
    @PutMapping("/{id}")
    public ResponseEntity<Instructor> updateInstructor(@PathVariable Long id, @RequestBody Instructor instructorDetails) {
        log.info("PUT /api/instructors/{} accessed", id);
        try {
            Instructor updatedInstructor = instructorService.updateInstructor(id, instructorDetails);
            return ResponseEntity.ok(updatedInstructor);
        } catch (RuntimeException e) {
            log.error("Instructor with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE instructor
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteInstructor(@PathVariable Long id) {
        log.info("DELETE /api/instructors/{} accessed", id);
        try {
            instructorService.deleteInstructor(id);
            return ResponseEntity.ok("Instructor deleted successfully");
        } catch (RuntimeException e) {
            log.error("Failed to delete instructor with id {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
