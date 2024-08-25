package com.example.samuel.SAMUEL.service;

import com.example.samuel.SAMUEL.exceptions.ResourceNotFoundException;
import com.example.samuel.SAMUEL.model.Habit;
import com.example.samuel.SAMUEL.repositories.HabitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitService {

    @Autowired
    private HabitRepository habitRepository;

    public Habit createHabit(Habit habit){
        return habitRepository.save(habit);
    }
    public List<Habit> getAllHabit(){
        return habitRepository.findAll();
    }
    public Habit getHabitById(String id){
        return habitRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Habit Not Found"));
    }
    public Habit updateHabits(String id, Habit habitDetails){
        Habit habit = getHabitById(id);
        habit.setHabit(habitDetails.getHabit());
        habit.setDescription(habitDetails.getDescription());
        habit.setCompleted(habitDetails.getCompleted());
        return habitRepository.save(habit);
    }
    public void deleteHabit(String id){
        Habit habit = getHabitById(id);
        habitRepository.delete(habit);
    }
}
