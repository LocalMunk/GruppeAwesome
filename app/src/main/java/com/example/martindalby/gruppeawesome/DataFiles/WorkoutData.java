package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Martin Dalby on 02-01-2017.
 */



public class WorkoutData {
    public ArrayList<OvelseData> ovelser;
    public String workoutname;
    public int workoutid;
    public Date lastDate;


    public WorkoutData(int workoutid, String workoutname, ArrayList<OvelseData> ovelser, Date lastDate) {
        this.ovelser = ovelser;
        this.workoutid = workoutid;
        this.workoutname = workoutname;
        this.lastDate = lastDate;

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


    public Date getLastDate() {
        return lastDate;
    }

    public void setLastDate(Date lastDate) {
        this.lastDate = lastDate;
    }

    public String toString(){
        return this.getWorkoutname();
    }

}
