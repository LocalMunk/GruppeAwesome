package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 05-01-2017.
 */

public class Bruger {
    public String id;
    public ArrayList<UserWorkoutData> workouts;
    public ArrayList<String> RetIDs;

    public Bruger(String id, ArrayList<UserWorkoutData> workouts, ArrayList<String> RetIDs){
        this.id = id;
        this.workouts = workouts;
        this.RetIDs = RetIDs;
    }

    public Bruger(){}

    public String toString(){
        return "id: " + id + "Første Workout: " + workouts.get(0).navn;
    }
}
