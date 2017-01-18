package com.example.martindalby.gruppeawesome.DataFiles;

import com.example.martindalby.gruppeawesome.Database.DatabaseController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.UUID;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class MainController implements Serializable{

    private static MainController instans;
    public DatabaseController databaseControl;
    public String UserID;
    public BrugerData bruger;
    public boolean sub;

    private MainController(){
        databaseControl = new DatabaseController(this);
        bruger = new BrugerData(new TraeningsPlanData(), new KostplanData(), "");
    }

    public static MainController getInstans(){
        if(instans == null){
            instans = new MainController();

            /*
            instans.testDataGenerator();
            */
        }
            return instans;
    }


    public void pushUser(BrugerData user){
        databaseControl.PushBruger(user);
    }

    public void pushUser() {databaseControl.PushBruger(bruger); }

    public void getUserFromDatabase(final String UserID){
        databaseControl.getUser(UserID);
    }

    public double calculate1RM(double reps, double weight){
        double out = 37 - reps;
        out = 36/out;
        out = weight*out;
        return out;
    }


    public String generateUserKey(){
        String out = "FU";
        String uuid = UUID.randomUUID().toString();
        out = out + uuid;
        System.out.println("SE HER     " + out);
        return out;
    }

    public ArrayList<WorkoutData> sortByDate(ArrayList<WorkoutData> in){
        ArrayList out = new ArrayList<WorkoutData>();
        System.out.println("Indholdet af in i starten   " + in);
        WorkoutData ny = new WorkoutData();
        ny.setLastDate(Calendar.getInstance().getTime());
        int j = in.size();
        for(int i = 0; i < j; i++) {
            for (WorkoutData data : in) {
                if (data.getLastDate().before(ny.getLastDate())) {
                    ny = data;
                }
            }
            in.remove(ny);
            System.out.println("Dette er i IN: " + in);
            out.add(ny);
            System.out.println("Dette er i out: " + out);
            ny = new WorkoutData();
            ny.setLastDate(Calendar.getInstance().getTime());
        }
        System.out.println("indholdet af out til sidst   " + out);
        return out;
    }
}
