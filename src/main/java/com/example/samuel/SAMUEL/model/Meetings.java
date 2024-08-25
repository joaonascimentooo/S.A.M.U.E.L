package com.example.samuel.SAMUEL.model;

import com.example.samuel.SAMUEL.domain.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Entity
@Table(name = "Reunioes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Meetings {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;
    private String description;
    private boolean completed;

    @JsonFormat(pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime DateMeeting;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User assignedUser;

}
