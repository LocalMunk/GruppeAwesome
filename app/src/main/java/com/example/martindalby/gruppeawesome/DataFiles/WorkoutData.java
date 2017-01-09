package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */



public class WorkoutData {
    public ArrayList<OvelseData> ovelser;
    public String workoutname;
    public int workoutid;


    public WorkoutData(int workoutid, String workoutname, ArrayList<OvelseData> ovelser) {
        this.ovelser = ovelser;
        this.workoutid = workoutid;
        this.workoutname = workoutname;
    }

    public WorkoutData(){

    }

    public ArrayList<OvelseData> getOvelser() {
        return ovelser;
    }

    public void setOvelser(ArrayList<OvelseData> ovelser) {
        this.ovelser = ovelser;
    }

    public int getWorkoutid() {
        return workoutid;
    }

    public void setWorkoutid(int workoutid) {
        this.workoutid = workoutid;
    }

    public String getWorkoutname() {
        return workoutname;
    }

    public void setWorkoutname(String workoutname) {
        this.workoutname = workoutname;
    }

    public void addOvelse(OvelseData ovelse){ ovelser.add(ovelse);}
}
