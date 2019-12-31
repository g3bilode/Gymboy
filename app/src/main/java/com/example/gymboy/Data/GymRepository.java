package com.example.gymboy.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GymRepository {

    final List<String> muscles = new ArrayList<>(Arrays.asList(
            "Chest",
            "Tricep",
            "Back",
            "Bicep",
            "Trap",
            "Abs",
            "Legs"
    ));

    final static List<List<String>> exercises = new ArrayList<List<String>>(Arrays.asList(
            Arrays.asList("Chest EX1", "Chest EX2"),
            Arrays.asList("Tricep EX1", "Tricep EX2"),
            Arrays.asList("Back EX1", "Back EX2"),
            Arrays.asList("Bicep EX1", "Bicep EX2"),
            Arrays.asList("Trap EX1", "Trap EX2"),
            Arrays.asList("Abs EX1", "Abs EX2"),
            Arrays.asList("Legs EX1", "Legs EX2")
    ));

    public static List<String> getExercisesPerMuscle(int muscle_idx) {
        return exercises.get(muscle_idx);
    }
}
