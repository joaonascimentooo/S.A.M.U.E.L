package com.example.samuel.SAMUEL.service;

import com.example.samuel.SAMUEL.exceptions.ResourceNotFoundException;
import com.example.samuel.SAMUEL.model.Meetings;
import com.example.samuel.SAMUEL.repositories.MeetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingService {

    @Autowired
    private MeetingRepository meetingRepository;

    public List<Meetings> getAllMeeting(){
        return meetingRepository.findAll();
    }

    public Meetings createMeetings(Meetings meetings) { return meetingRepository.save(meetings); }

    public List<Meetings> getAllMeetings() { return meetingRepository.findAll(); }
    public Meetings getMeetingById(String id) {
        return meetingRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meeting not found"));
    }
    public Meetings updateMeetings(String id, Meetings meetingsDetails){
        Meetings meetings = getMeetingById(id);
        meetings.setName(meetingsDetails.getName());
        meetings.setDescription(meetingsDetails.getDescription());
        meetings.setCompleted(meetingsDetails.isCompleted());
        meetings.setDateMeeting(meetingsDetails.getDateMeeting());
        return meetingRepository.save(meetings);
    }
    public void deleteMeeting(String id){
        Meetings meetings = getMeetingById(id);
        meetingRepository.delete(meetings);
    }
}
