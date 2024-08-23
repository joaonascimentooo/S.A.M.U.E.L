package com.example.samuel.SAMUEL.repositories;

import com.example.samuel.SAMUEL.model.Tasks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TasksRepository extends JpaRepository<Tasks,String> {

    List<Tasks> findByAssignedUserId(String userId);
}
