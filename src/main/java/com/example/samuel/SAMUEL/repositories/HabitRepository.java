package com.example.samuel.SAMUEL.repositories;

import com.example.samuel.SAMUEL.model.Habit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepository extends JpaRepository<Habit,String> {

}
