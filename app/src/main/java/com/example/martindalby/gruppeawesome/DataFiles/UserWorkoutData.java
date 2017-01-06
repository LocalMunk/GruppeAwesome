package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 05-01-2017.
 */

public class UserWorkoutData {
    public ArrayList<String> ovelseIDs;
    public String navn;

    public UserWorkoutData(ArrayList<String> IDs, String navn){
        ovelseIDs = IDs;
        this.navn = navn;
    }

    public UserWorkoutData(){}
}
