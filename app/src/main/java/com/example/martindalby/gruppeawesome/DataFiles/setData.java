package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 12-01-2017.
 */

public class SetData{
    public int x;
    public double y;

    public SetData() {
    }

    public SetData(int x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public int getX() {
        return x;

    }

    public void setX(int x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double z;

    public String toString(){
        return "reps: " + y;
    }

}