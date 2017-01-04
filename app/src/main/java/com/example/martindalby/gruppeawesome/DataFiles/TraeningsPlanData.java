package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class TraeningsPlanData {
    ArrayList<WorkoutData> workouts;
    double traeningsGennemsnit, traeningsMål, traeningerDenneUge;

    public TraeningsPlanData(ArrayList<WorkoutData> workouts){
        this.workouts = workouts;
    }

    public ArrayList<WorkoutData> getWorkouts(){
        return workouts;
    }

    public WorkoutData getWorkout(int i){
        return workouts.get(i);
    }

    public void addWorkout(WorkoutData wd){
        workouts.add(wd);
    }
}
