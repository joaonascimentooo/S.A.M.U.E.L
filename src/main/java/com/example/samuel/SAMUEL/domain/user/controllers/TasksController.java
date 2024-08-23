package com.example.samuel.SAMUEL.domain.user.controllers;

import com.example.samuel.SAMUEL.model.Tasks;
import com.example.samuel.SAMUEL.service.TasksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TasksController {

    @Autowired
    private TasksService tasksService;

    @GetMapping
    public ResponseEntity<List<Tasks>> getallTasks(){
        List<Tasks> tasks = tasksService.getAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);

    }
    @PostMapping
    public ResponseEntity<Tasks> createTask(@RequestBody Tasks tasks){
        Tasks createdTask = tasksService.createTasks(tasks);
        return new ResponseEntity<>(createdTask,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tasks> updateTask(@PathVariable String id, @RequestBody Tasks taskDetails){
        Tasks uptadedTask = tasksService.updateTasks(id, taskDetails);
        return new ResponseEntity<>(uptadedTask,HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id){
        tasksService.deleteTask(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
