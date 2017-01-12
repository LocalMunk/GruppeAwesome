package com.example.martindalby.gruppeawesome.DataFiles;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 18-11-2016.
 */

public class Graf {
    public Graf() {
    }

    ArrayList<SetData> setDatas;

    public void setSetDatas(ArrayList<SetData> setDatas) {
        this.setDatas = setDatas;
    }

    public Graf(ArrayList<SetData> setDatas){
        this.setDatas = setDatas;
    }

    public ArrayList<SetData> getSetDatas(){
        return setDatas;
    }


}