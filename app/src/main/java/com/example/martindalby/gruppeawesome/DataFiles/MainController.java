package com.example.martindalby.gruppeawesome.DataFiles;

import com.example.martindalby.gruppeawesome.DAL.DatabaseController;

import java.io.Serializable;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class MainController implements Serializable{
    TraeningsPlanData Træningsplan;
    KostplanData Kostplan;
    private static MainController instans;
    DatabaseController databaseControl;

    private MainController(){
        Træningsplan = new TraeningsPlanData(null);
        Kostplan = new KostplanData(null,null,null,null);
    }

    public static MainController getInstans(){
        if(instans == null){
            instans = new MainController();
        }
            return instans;
    }

    public double[] getTreTal(){
        double[] out = {Træningsplan.traeningsGennemsnit, Træningsplan.traeningsMål, Træningsplan.traeningerDenneUge};
        return out;
    }

    public TraeningsPlanData getTræningsplan(){
        return Træningsplan;
    }

    public KostplanData getKostplan(){
        return Kostplan;
    }


    public void setTreTal(double a, double b, double c){
        Træningsplan.traeningsGennemsnit = a;
        Træningsplan.traeningsMål = b;
        Træningsplan.traeningerDenneUge = c;
    }
}
