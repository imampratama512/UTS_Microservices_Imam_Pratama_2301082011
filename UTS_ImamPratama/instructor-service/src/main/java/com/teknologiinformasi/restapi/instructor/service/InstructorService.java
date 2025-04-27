package com.teknologiinformasi.restapi.instructor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasi.restapi.instructor.model.Instructor;
import com.teknologiinformasi.restapi.instructor.repository.InstructorRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstructorService {

    @Autowired
    private InstructorRepository instructorRepository;

    public List<Instructor> getAll() {
        return instructorRepository.findAll();
    }

    public Optional<Instructor> getById(Long id) {
        return instructorRepository.findById(id);
    }

    public Instructor createInstructor(Instructor instructor) {
        return instructorRepository.save(instructor);
    }

    public Instructor updateInstructor(Long id, Instructor instructorDetails) {
        Instructor instructor = instructorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Instructor not found with id " + id));

        instructor.setName(instructorDetails.getName());
        instructor.setEmail(instructorDetails.getEmail());
        instructor.setExpertise(instructorDetails.getExpertise());

        return instructorRepository.save(instructor);
    }

    public void deleteInstructor(Long id) {
        Instructor instructor = instructorRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Instructor not found with id " + id));
        instructorRepository.delete(instructor);
    }
}
