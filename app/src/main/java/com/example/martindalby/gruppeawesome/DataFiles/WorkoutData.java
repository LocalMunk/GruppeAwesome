package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */



public class WorkoutData {
    private int ovelsesid,ovelsesid2,ovelsesid3,ovelsesid4,ovelsesid5,ovelsesid6,ovelsesid7,ovelsesid8;
    private String workoutname;
    private int workoutid;


    public WorkoutData(int workoutid, String workoutname,int ovelsesid, int ovelsesid2, int ovelsesid3, int ovelsesid4,int ovelsesid5, int ovelsesid6, int ovelsesid7, int ovelsesid8  ) {
        this.ovelsesid2 = ovelsesid2;
        this.ovelsesid3 = ovelsesid3;
        this.ovelsesid4 = ovelsesid4;
        this.ovelsesid5 = ovelsesid5;
        this.ovelsesid6 = ovelsesid6;
        this.ovelsesid7 = ovelsesid7;
        this.ovelsesid8 = ovelsesid8;
        this.ovelsesid = ovelsesid;
        this.workoutid = workoutid;
        this.workoutname = workoutname;
    }

    public int getOvelsesid2() {
        return ovelsesid2;
    }

    public void setOvelsesid2(int ovelsesid2) {
        this.ovelsesid2 = ovelsesid2;
    }

    public int getOvelsesid3() {
        return ovelsesid3;
    }

    public void setOvelsesid3(int ovelsesid3) {
        this.ovelsesid3 = ovelsesid3;
    }

    public int getOvelsesid4() {
        return ovelsesid4;
    }

    public void setOvelsesid4(int ovelsesid4) {
        this.ovelsesid4 = ovelsesid4;
    }

    public int getOvelsesid5() {
        return ovelsesid5;
    }

    public void setOvelsesid5(int ovelsesid5) {
        this.ovelsesid5 = ovelsesid5;
    }
    public int getOvelsesid6() {
        return ovelsesid6;
    }

    public void setOvelsesid6(int ovelsesid6) {
        this.ovelsesid6 = ovelsesid6;
    }

    public int getOvelsesid7() {
        return ovelsesid7;
    }

    public void setOvelsesid7(int ovelsesid7) {
        this.ovelsesid7 = ovelsesid7;
    }

    public int getOvelsesid8() {
        return ovelsesid8;
    }

    public void setOvelsesid8(int ovelsesid8) {
        this.ovelsesid8 = ovelsesid8;
    }

    public int getOvelsesid() {
        return ovelsesid;
    }

    public void setOvelsesid(int ovelsesid) {
        this.ovelsesid = ovelsesid;
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
}
