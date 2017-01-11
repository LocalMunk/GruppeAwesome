package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 05-01-2017.
 */

public class    Bruger {
    public TraeningsPlanData træningsPlan;
    public KostplanData kostplan;
    public String id;

    public Bruger(TraeningsPlanData træningsPlan, KostplanData kostplan, String id) {
        this.træningsPlan = træningsPlan;
        this.kostplan = kostplan;
        this.id = id;
    }

    public Bruger(String id, ArrayList<UserWorkoutData> workouts, ArrayList<String> RetIDs){
        this.id = id;

        træningsPlan = new TraeningsPlanData(new ArrayList<WorkoutData>());
        kostplan = new KostplanData(new ArrayList<OpskriftData>());

    }

    public void setTræningsPlan(TraeningsPlanData træningsPlan) {
        this.træningsPlan = træningsPlan;
    }

    public void setKostplan(KostplanData kostplan) {
        this.kostplan = kostplan;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Bruger(){}

    public String toString(){
        return "id: " + id;
    }



    public TraeningsPlanData getTræningsPlan(){
        return træningsPlan;
    }

    public KostplanData getKostplan(){
        return kostplan;
    }


}
