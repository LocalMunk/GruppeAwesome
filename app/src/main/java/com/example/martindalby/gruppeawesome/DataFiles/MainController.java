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

    public MainController(){
        Træningsplan = new TraeningsPlanData();
        Kostplan = new KostplanData();
    }

    public static MainController getInstans(){
        if(instans == null){
            instans = new MainController();
        }
            return instans;
    }

    public int[] getTreTal(){
        int[] out = {Træningsplan.traeningsGennemsnit, Træningsplan.traeningsMål, Træningsplan.traeningerDenneUge};
        return out;
    }

    public TraeningsPlanData getTræningsplan(){
        return Træningsplan;
    }

    public KostplanData getKostplan(){
        return Kostplan;
    }


    public void setTreTal(int a, int b, int c){
        Træningsplan.traeningsGennemsnit = a;
        Træningsplan.traeningsMål = b;
        Træningsplan.traeningerDenneUge = c;
    }
}
