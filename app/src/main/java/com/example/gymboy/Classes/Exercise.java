package com.example.gymboy.Classes;

import java.io.Serializable;

public class Exercise implements Serializable {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getSets() {
        return sets;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public int getReps() {
        return reps;
    }

    public void setReps(int reps) {
        this.reps = reps;
    }

    private String name;
    private int weight;
    private int sets;
    private int reps;

    public Exercise() {
    }

    /**
     *
     * @param name
     * @param weight
     * @param sets
     * @param reps
     */
    public Exercise(String name, int weight, int sets, int reps) {
        this.name = name;
        this.weight = weight;
        this.sets = sets;
        this.reps = reps;
    }
}
