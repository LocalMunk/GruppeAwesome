package com.example.martindalby.gruppeawesome.DataFiles;

import com.example.martindalby.gruppeawesome.Opskrift;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class KostplanData {
    ArrayList<OpskriftData> morgen;
    ArrayList<OpskriftData> frokost;
    ArrayList<OpskriftData> aften;
    ArrayList<OpskriftData> snacks;

    public KostplanData(ArrayList<OpskriftData> morgen, ArrayList<OpskriftData> frokost, ArrayList<OpskriftData> aften, ArrayList<OpskriftData> snacks) {
        this.morgen = morgen;
        this.frokost = frokost;
        this.aften = aften;
        this.snacks = snacks;
    }

    public OpskriftData getOpskrift(int i, int j){
        if(i == 0) return morgen.get(j);
        else if(i == 1) return frokost.get(j);
        else if(i == 2) return aften.get(j);
        else if(i == 3) return snacks.get(j);
        else return null;
    }

    public void setOpskrift(int i, OpskriftData od){
        if(i == 0) morgen.add(od);
        if(i == 1) frokost.add(od);
        if(i == 2) aften.add(od);
        if(i == 3) snacks.add(od);
    }
}
