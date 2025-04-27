package com.teknologiinformasi.restapi.participant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.teknologiinformasi.restapi.participant.model.Participant;
 

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    
}