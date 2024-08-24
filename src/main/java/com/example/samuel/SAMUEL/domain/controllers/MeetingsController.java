package com.example.samuel.SAMUEL.domain.controllers;

import com.example.samuel.SAMUEL.model.Meetings;
import com.example.samuel.SAMUEL.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetings")
public class MeetingsController {

    @Autowired
    private MeetingService meetingService;

    @GetMapping
    public ResponseEntity<List<Meetings>> getallMeetings(){
        List<Meetings> meetings = meetingService.getAllMeetings();
        return new ResponseEntity<>(meetings, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Meetings> createMeeting(@RequestBody Meetings meetings){
        Meetings createdMeeting = meetingService.createMeetings(meetings);
        return new ResponseEntity<>(createdMeeting, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Meetings> updateMeetings(@PathVariable String id, @RequestBody Meetings meetingsDetails){
        Meetings updateMeeting = meetingService.updateMeetings(id, meetingsDetails);
        return new ResponseEntity<>(updateMeeting, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeeting(@PathVariable String id){
        meetingService.deleteMeeting(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
