package com.example.martindalby.gruppeawesome;

import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 18-11-2016.
 */

public class Graf {


    public LineGraphSeries<DataPoint> series;

    public Graf(LineGraphSeries<DataPoint> series){
        this.series = series;
    }

    public void addDataPoint(int x,int y){

        DataPoint z = new DataPoint(x,y);
    }

    public LineGraphSeries<DataPoint> getList(){
        return series;
    }

    public class DataPoint implements DataPointInterface {
        int x, y;

        public DataPoint(int x, int y){
            this.x=x;this.y=y;
        }
        public void setDataPoint(int x, int y){
            this.x=x;this.y=y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }
}