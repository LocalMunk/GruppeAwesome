package com.example.martindalby.gruppeawesome;
import junit.framework.Test;

/**
 * Created by TheGeek on 14-11-2016.
 */


public class TestDataWorkout {

    //her er data


    private String [] morgenmad = {"Havregrød", "Omelet", "Cornflakes"};
    private String [] frokost =   {"Rugbrød", "Rugbrød med pålæg", "Chili con carne"};
    private String [] aften =     {"Lasagne", "Pizza", "Durum"};
    private String [] snack =     {"Snickers", "Gulerod", "sand"};
    private TestDataWorkout[] workouts;
    private TestDataWorkout[] data;
    private String text;
    private String overskrift;
    private String beskrivelse;
//    private Image opskIcon;

    public TestDataWorkout(){

        workouts = new TestDataWorkout[]{
                new TestDataWorkout("Workout A", "TrækA:Ben,Ryk og biceps"),
                new TestDataWorkout("Workout A", "Snickers marathon"),
                new TestDataWorkout("Workout B", "Æde en lagkage på 10mims"),

        };
    }

    public TestDataWorkout(String overskrift, /*Image opskIcon,*/ String beskrivelse) {
        this.overskrift = overskrift;
        //       this.opskIcon = opskIcon;
        this.beskrivelse = beskrivelse;
    }

    public TestDataWorkout[] getWorkouts() {
        return workouts;
    }


    public TestDataWorkout[] getdata() {
        return data;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }
}
