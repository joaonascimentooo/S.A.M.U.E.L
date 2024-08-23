package com.example.samuel.SAMUEL.service;

import com.example.samuel.SAMUEL.domain.User;
import com.example.samuel.SAMUEL.exceptions.ResourceNotFoundException;
import com.example.samuel.SAMUEL.model.Tasks;
import com.example.samuel.SAMUEL.repositories.TasksRepository;
import com.example.samuel.SAMUEL.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TasksService {

    @Autowired
    private TasksRepository tasksRepository;

    @Autowired
    private UserRepository userRepository;

    public Tasks createTasks(Tasks tasks){
        return tasksRepository.save(tasks);
    }

    public List<Tasks> getAllTasks(){
        return tasksRepository.findAll();
    }
    public Tasks getTaskById(String id) {
        return tasksRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Task not found"));
    }
    public Tasks updateTasks(String id, Tasks tasksDetails){
        Tasks tasks = getTaskById(id);
        tasks.setTitle(tasksDetails.getTitle());
        tasks.setDescription(tasksDetails.getDescription());
        tasks.setCompleted(tasksDetails.isCompleted());
        return tasksRepository.save(tasks);
    }
    public void deleteTask(String id){
        Tasks tasks = getTaskById(id);
        tasksRepository.delete(tasks);
    }
    public Tasks TaskToUser(String tasksId, String userId){
        Optional<Tasks> tasksOptional = tasksRepository.findById(tasksId);
        Optional<User> userOptional = userRepository.findById(userId);

        if (tasksOptional.isPresent() && userOptional.isPresent()){
            Tasks tasks = tasksOptional.get();
            User user = userOptional.get();
            tasks.setAssignedUser(user);

            return tasksRepository.save(tasks);
        }else {
            throw new RuntimeException("Task or User Not Found");
        }

    }

}
