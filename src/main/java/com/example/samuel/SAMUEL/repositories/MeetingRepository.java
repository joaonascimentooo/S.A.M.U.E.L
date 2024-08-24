package com.example.samuel.SAMUEL.repositories;

import com.example.samuel.SAMUEL.model.Meetings;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingRepository extends JpaRepository<Meetings, String> {

}
