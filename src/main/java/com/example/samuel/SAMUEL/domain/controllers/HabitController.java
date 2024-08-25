package com.example.samuel.SAMUEL.domain.controllers;

import com.example.samuel.SAMUEL.model.Habit;
import com.example.samuel.SAMUEL.model.Tasks;
import com.example.samuel.SAMUEL.repositories.HabitRepository;
import com.example.samuel.SAMUEL.service.HabitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/habit")
public class HabitController {

    @Autowired
    private HabitRepository habitRepository;

    @Autowired
    private HabitService habitService;


    @GetMapping
    public ResponseEntity<List<Habit>> getallHabit(){
        List<Habit> habits = habitService.getAllHabit();
        return new ResponseEntity<>(habits, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Habit> createHabit(@RequestBody Habit habit){
        Habit createdHabit = habitService.createHabit(habit);
        return new ResponseEntity<>(createdHabit,HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Habit> updateHabit(@PathVariable String id, @RequestBody Habit habitDetails){
        Habit uptadedHabit = habitService.updateHabits(id, habitDetails);
        return new ResponseEntity<>(uptadedHabit,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteHabit(@PathVariable String id){
        habitService.deleteHabit(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
