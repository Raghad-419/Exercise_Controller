package com.example.exercise_controllerlayerrestcrud.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Task {
    private String ID ;
    private String title;
    private String description;
    private String status;

}
