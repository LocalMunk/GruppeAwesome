package com.example.martindalby.gruppeawesome.DataFiles;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class MainController {
    TraeningsPlanData Træningsplan;
    KostplanData Kostplan;

    int[] getTreTal(){
        int[] out = {Træningsplan.traeningsGennemsnit, Træningsplan.traeningsMål, Træningsplan.traeningerDenneUge};
        return out;
    }
}
