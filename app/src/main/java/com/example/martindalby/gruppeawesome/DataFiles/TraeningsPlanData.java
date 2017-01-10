package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class TraeningsPlanData {
    public ArrayList<WorkoutData> workouts;
    public double traeningsGennemsnit, traeningsMål, traeningerDenneUge;

    public TraeningsPlanData(ArrayList<WorkoutData> workouts){
        this.workouts = workouts;
    }

    public TraeningsPlanData(ArrayList<WorkoutData> workouts, double traeningsGennemsnit, double traeningsMål, double traeningerDenneUge) {
        this.workouts = workouts;
        this.traeningsGennemsnit = traeningsGennemsnit;
        this.traeningsMål = traeningsMål;
        this.traeningerDenneUge = traeningerDenneUge;
    }

    public TraeningsPlanData() {
    }

    public void setWorkouts(ArrayList<WorkoutData> workouts) {
        this.workouts = workouts;
    }

    public double getTraeningsGennemsnit() {
        return traeningsGennemsnit;
    }

    public void setTraeningsGennemsnit(double traeningsGennemsnit) {
        this.traeningsGennemsnit = traeningsGennemsnit;
    }

    public double getTraeningsMål() {
        return traeningsMål;
    }

    public void setTraeningsMål(double traeningsMål) {
        this.traeningsMål = traeningsMål;
    }

    public double getTraeningerDenneUge() {
        return traeningerDenneUge;
    }

    public void setTraeningerDenneUge(double traeningerDenneUge) {
        this.traeningerDenneUge = traeningerDenneUge;
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
