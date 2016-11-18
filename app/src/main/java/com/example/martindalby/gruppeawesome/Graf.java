package com.example.martindalby.gruppeawesome;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 18-11-2016.
 */

public class Graf {

    public ArrayList<DataPoint> list;

    public Graf(ArrayList<DataPoint> list){
        this.list = list;
    }

    public void addDataPoint(int x,int y){
        DataPoint z = new DataPoint(x,y);
        list.add(z);
    }

    public ArrayList<DataPoint> getList(){
        return list;
    }

    public class DataPoint{
        int x, y;

        public DataPoint(int x, int y){
            this.x=x;this.y=y;
        }
        public void setDataPoint(int x, int y){
            this.x=x;this.y=y;
        }

        public DataPoint getDataPoint(){
            return this;
        }
    }
}