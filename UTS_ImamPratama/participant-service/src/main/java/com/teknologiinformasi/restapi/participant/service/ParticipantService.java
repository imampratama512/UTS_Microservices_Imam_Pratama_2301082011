package com.teknologiinformasi.restapi.participant.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teknologiinformasi.restapi.participant.model.Participant;
import com.teknologiinformasi.restapi.participant.repository.ParticipantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    public List<Participant> getAll() {
        return participantRepository.findAll();
    }

    public Optional<Participant> getById(Long id) {
        return participantRepository.findById(id); // No need to cast to long
    }

    public Participant createParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(Long id, Participant participantDetails) {
        Participant participant = participantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Participant not found with id " + id));
        
        participant.setName(participantDetails.getName());
        participant.setEmail(participantDetails.getEmail());
        participant.setClassNumber(participantDetails.getClassNumber());
        
        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        Participant participant = participantRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Participant not found with id " + id));
        participantRepository.delete(participant);
    }
}
