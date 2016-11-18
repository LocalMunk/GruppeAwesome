package com.example.martindalby.gruppeawesome;
import junit.framework.Test;

/**
 * Created by TheGeek on 14-11-2016.
 */

//x
public class TestDataWorkout {

    //her er data



    private TestDataWorkout[] workouts;
    private TestDataOvelser odata;
    private String overskrift;
    private String beskrivelse;
    private int[] ExerciseIDs;

    public TestDataWorkout(){

        int[][] x = {{1,2,3,4,5},{2,4,6,8,10},{10,11,12,13,14},{1,3,5,7,9}};

        odata = new TestDataOvelser();

        workouts = new TestDataWorkout[]{
                new TestDataWorkout("Workout A1", "Træk-A: Ben,Ryg og Biceps", x[0]),
                new TestDataWorkout("Workout A2", "Træk-A: Bryst,Skulder,Triceps & Mave", x[1]),
                new TestDataWorkout("Workout B1", "Træk-B. Ben,Ryg og Biceps", x[2]),
                new TestDataWorkout("Workout B2", "Træk-B. Bryst,Skulder,Triceps & Mave", x[3]) };
    }

    public TestDataWorkout(String overskrift, String beskrivelse, int[] IDs) {
        this.overskrift = overskrift;
        this.beskrivelse = beskrivelse;
        this.ExerciseIDs = IDs;
    }

    public TestDataWorkout[] getWorkouts() {
        return workouts;
    }
;
    public String getOverskrift() {
        return overskrift;
    }

    public void setOverskrift(String overskrift) {
        this.overskrift = overskrift;
    }

    public int[] getids(TestDataWorkout w){
        return w.ExerciseIDs;
    }

    public String getBeskrivelse() {
        return beskrivelse;
    }

    public void setBeskrivelse(String beskrivelse) {
        this.beskrivelse = beskrivelse;
    }

    public String[] getOdataOverskrift(int i){
        String[] out = new String[getids(workouts[i]).length];
        int k = 0;
        for(int j: getids(workouts[i])){
            out[k] = odata.getOvelser()[j].getOverskrift();
            k++;
        }
        return out;

    }

    public int[] getOdataSets(int i){
        int[] out = new int[getids(workouts[i]).length];
        int k = 0;
        for(int j: getids(workouts[i])){
            out[k] = odata.getOvelser()[j].getsets();
            k++;
        }
        return out;

    }
}
