package com.example.martindalby.gruppeawesome;

/**
 * Created by Martin Dalby on 15-11-2016.
 */

public class OvelseSupport {

    String[] data;
    int maxSet;
    public OvelseSupport(String[] data, int max){
        this.data = data;
        maxSet = max;

    }

    public String getData(int x){
        return data[x];
    }

    public void setData(int dataset, int reps){
        int x = dataset+1
        data[dataset] = "Sæt " + x + ": " + reps + " gentagelser";
    }
}
