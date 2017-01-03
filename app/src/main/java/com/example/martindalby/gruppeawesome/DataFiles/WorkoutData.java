package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class WorkoutData {
    ArrayList<OvelseData> ovelser;

    public WorkoutData(ArrayList<OvelseData> ovelser){
        this.ovelser = ovelser;
    }

    public OvelseData getOvelse(int i){
        return ovelser.get(i);
    }

    public void addOvelse(OvelseData od){
        ovelser.add(od);
    }

}
