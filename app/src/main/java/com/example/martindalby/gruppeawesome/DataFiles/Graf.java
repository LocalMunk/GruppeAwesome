package com.example.martindalby.gruppeawesome.DataFiles;

import android.provider.ContactsContract;

import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 18-11-2016.
 */

public class Graf {

    ArrayList<DataPoint> dataPoints;

    public Graf(ArrayList<DataPoint> dataPoints){
        this.dataPoints = dataPoints;
    }

    public ArrayList<DataPoint> getDataPoints(){
        return dataPoints;
    }

    public void addDataPoint(double weight, double reps, int date){
        DataPoint z = new DataPoint(date, (int)(weight * (36/(37 - reps))));
        if(dataPoints.size() >= 20) dataPoints.remove(0);
        dataPoints.add(z);
    }

    public class DataPoint{
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