package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 18-11-2016.
 */

public class GrafData {
    public GrafData() {
    }

    ArrayList<SetData> setDatas;

    public void setSetDatas(ArrayList<SetData> setDatas) {
        this.setDatas = setDatas;
    }

    public GrafData(ArrayList<SetData> setDatas){
        this.setDatas = setDatas;
    }

    public ArrayList<SetData> getSetDatas(){
        return setDatas;
    }


}