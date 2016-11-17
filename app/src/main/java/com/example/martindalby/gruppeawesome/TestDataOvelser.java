package com.example.martindalby.gruppeawesome;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class TestDataOvelser {

    //her er data



    private TestDataOvelser[] workouts;
    private String overskrift;
    private int sets;
//    private Image opskIcon;

    public TestDataOvelser(){

        workouts = new TestDataOvelser[]{
                new TestDataOvelser("Squat", 4),
                new TestDataOvelser("Barbell Rows", 3),
                new TestDataOvelser("Flat Benchpress", 3),
                new TestDataOvelser("Dumbbell Shoulder Press", 3),
                new TestDataOvelser("EZ-Barbell Curl", 3),
                new TestDataOvelser("Tricepspushdowns - Flat", 3),
                new TestDataOvelser("Calf Press", 3),
                new TestDataOvelser("Cable Crunch", 3),

        };
    }

    public TestDataOvelser(String overskrift, /*Image opskIcon,*/ int sets) {
        this.overskrift = overskrift;
        //       this.opskIcon = opskIcon;
        this.sets = sets;
    }

    public TestDataOvelser[] getOvelser() {
        return workouts;
    }

    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public int getsets() {
        return sets;
    }

    public void setsets(int sets) {
        this.sets = sets;
    }

}
