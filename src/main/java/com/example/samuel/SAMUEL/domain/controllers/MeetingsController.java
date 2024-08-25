package com.example.samuel.SAMUEL.domain.controllers;

import com.example.samuel.SAMUEL.model.Meetings;
import com.example.samuel.SAMUEL.service.MeetingsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingsController {

    @Autowired
    private MeetingsService meetingsService;

    @GetMapping
    public ResponseEntity<List<Meetings>> getallMeetings(){
        List<Meetings> meetings = meetingsService.getAllMeetings();
        return new ResponseEntity<>(meetings, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Meetings> createMeetings(@RequestBody Meetings meetings){
        Meetings createdMeeting = meetingsService.createMeetings(meetings);
        return new ResponseEntity<>(createdMeeting, HttpStatus.CREATED);
    }
   @PutMapping("/{id}")
   public ResponseEntity<Meetings> updateMeetings(@PathVariable String id, @RequestBody Meetings meetingsDetails){
        Meetings uptadedMeeting = meetingsService.updateMeetings(id, meetingsDetails);
        return new ResponseEntity<>(uptadedMeeting, HttpStatus.OK);
   }
    @PutMapping("/{meetingId}/assign/{userId}")
    public Meetings assignMeetingsToUser(@PathVariable String meetingsId, @PathVariable String userId){
        return meetingsService.MeetingsToUser(meetingsId, userId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeetings(@PathVariable String id){
        meetingsService.deleteMeetings(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
