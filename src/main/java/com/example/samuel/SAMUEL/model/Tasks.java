package com.example.samuel.SAMUEL.model;

import com.example.samuel.SAMUEL.domain.User;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "tarefas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tasks {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String title;
    private String description;
    private  boolean completed;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;
}
