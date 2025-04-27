package com.teknologiinformasi.restapi.instructor.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.instructor.model.Instructor;
 

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long> {
    
}