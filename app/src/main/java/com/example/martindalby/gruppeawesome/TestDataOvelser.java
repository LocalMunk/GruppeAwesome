package com.example.martindalby.gruppeawesome;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class TestDataOvelser {

    //her er data



    private TestDataOvelser[] Exercises;
    private String overskrift;
    private int sets, id;
//    private Image opskIcon;

    public TestDataOvelser(){

        Exercises = new TestDataOvelser[]{
                new TestDataOvelser("Squat", 3,1),
                new TestDataOvelser("Lunges", 3,2),
                new TestDataOvelser("Barbell Rows", 3,3),
                new TestDataOvelser("Pullups", 3,4),
                new TestDataOvelser("Preacher Curls", 3,5),
                new TestDataOvelser("Hammer Curl", 3,6),
                new TestDataOvelser("Calf Press", 3,7),
                new TestDataOvelser("Flat Bench-press", 3,8),
                new TestDataOvelser("Incline Dumbbell Press", 3,9),
                new TestDataOvelser("Cable Crossover", 3,10),
                new TestDataOvelser("Military Press", 3,11),
                new TestDataOvelser("Pullups", 3,12),
                new TestDataOvelser("Preacher Curls", 3,13),
                new TestDataOvelser("Hammer Curl", 3,14),
                new TestDataOvelser("Calf Press", 3,15),
                new TestDataOvelser("Fla Bench-press", 3,16),




        };
    }

    public TestDataOvelser(String overskrift, int sets, int id) {
        this.overskrift = overskrift;
        this.sets = sets;
        this.id = id;
    }

    public TestDataOvelser[] getOvelser() {
        return Exercises;
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
