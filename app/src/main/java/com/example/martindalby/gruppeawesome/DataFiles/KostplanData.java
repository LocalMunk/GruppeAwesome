package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class KostplanData {
    public ArrayList<OpskriftData> retter;

    public KostplanData() {
    }

    public KostplanData(ArrayList<OpskriftData> retter) {
        this.retter = retter;
    }

    public OpskriftData getOpskrift(int j){
        return retter.get(j);
    }

    public void setOpskrift(OpskriftData od){
        retter.add(od);
    }

    public ArrayList<OpskriftData> getRetter() {
        return retter;
    }


    public void setRetter(ArrayList<OpskriftData> retter) {
        this.retter = retter;
    }
}
