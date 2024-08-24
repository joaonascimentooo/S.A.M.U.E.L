package com.example.samuel.SAMUEL.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "habitos")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String habit;

    private String description;

    private Boolean completed;
}
