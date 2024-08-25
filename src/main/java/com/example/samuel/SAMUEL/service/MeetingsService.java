package com.example.samuel.SAMUEL.service;

import com.example.samuel.SAMUEL.domain.User;
import com.example.samuel.SAMUEL.exceptions.ResourceNotFoundException;
import com.example.samuel.SAMUEL.model.Meetings;
import com.example.samuel.SAMUEL.repositories.MeetingsRepository;
import com.example.samuel.SAMUEL.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MeetingsService {

    @Autowired
    private MeetingsRepository meetingsRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Meetings> getAllMeeting(){
        return meetingsRepository.findAll();
    }

    public Meetings createMeetings(Meetings meetings) { return meetingsRepository.save(meetings); }

    public List<Meetings> getAllMeetings() { return meetingsRepository.findAll(); }
    public Meetings getMeetingById(String id) {
        return meetingsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Meeting not found"));
    }
    public Meetings updateMeetings(String id, Meetings meetingsDetails){
        Meetings meetings = getMeetingById(id);
        meetings.setName(meetingsDetails.getName());
        meetings.setDescription(meetingsDetails.getDescription());
        meetings.setCompleted(meetingsDetails.isCompleted());
        meetings.setDateMeeting(meetingsDetails.getDateMeeting());
        return meetingsRepository.save(meetings);
    }
    public void deleteMeetings(String id){
        Meetings meetings = getMeetingById(id);
        meetingsRepository.delete(meetings);
    }
    public Meetings MeetingsToUser(String meetingsId, String userId){
        Optional<Meetings> meetingsOptional = meetingsRepository.findById(meetingsId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (meetingsOptional.isPresent() && userOptional.isPresent()){
            Meetings meetings = meetingsOptional.get();
            User user = userOptional.get();
            meetings.setAssignedUser(user);

            return meetingsRepository.save(meetings);
        }else{
            throw new RuntimeException("Meeting or User not found");
        }
    }
}
