package com.teknologiinformasi.restapi.participant.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import com.teknologiinformasi.restapi.participant.model.Participant;
import com.teknologiinformasi.restapi.participant.service.ParticipantService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    private static final Logger log = LoggerFactory.getLogger(ParticipantController.class);

    @Autowired
    private ParticipantService participantService;

    // GET all participants
    @GetMapping
    public List<Participant> getAllParticipants() {
        log.info("GET /api/participants accessed");
        return participantService.getAll();
    }

    // GET participant by id
    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipantById(@PathVariable Long id) {
        log.info("GET /api/participants/{} accessed", id);
        return participantService.getById(id)
                .map(participant -> ResponseEntity.ok(participant))
                .orElse(ResponseEntity.notFound().build());
    }

    // POST create new participant
    @PostMapping
    public Participant createParticipant(@RequestBody Participant participant) {
        log.info("POST /api/participants accessed");
        return participantService.createParticipant(participant);
    }

    // PUT update existing participant
    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipant(@PathVariable Long id, @RequestBody Participant participantDetails) {
        log.info("PUT /api/participants/{} accessed", id);
        try {
            Participant updatedParticipant = participantService.updateParticipant(id, participantDetails);
            return ResponseEntity.ok(updatedParticipant);
        } catch (RuntimeException e) {
            log.error("Participant with id {} not found", id);
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE participant
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteParticipant(@PathVariable Long id) {
        log.info("DELETE /api/participants/{} accessed", id);
        try {
            participantService.deleteParticipant(id);
            return ResponseEntity.ok("Participant deleted successfully");
        } catch (RuntimeException e) {
            log.error("Failed to delete participant with id {}", id);
            return ResponseEntity.notFound().build();
        }
    }
}
