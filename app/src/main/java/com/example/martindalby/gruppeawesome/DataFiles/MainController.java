package com.example.martindalby.gruppeawesome.DataFiles;

import android.os.AsyncTask;

import com.example.martindalby.gruppeawesome.DAL.DatabaseController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class MainController implements Serializable{

    private static MainController instans;
    public DatabaseController databaseControl;
    public String UserID;
    public Bruger bruger;

    private MainController(){
        databaseControl = new DatabaseController(this);
        bruger = new Bruger("", new ArrayList<UserWorkoutData>(), new ArrayList<String>());
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




/*
    public void pushKostplan(){
        int i = 0;
        for(OpskriftData data: kostplan.getRetter()){
            databaseControl.lavTestKostplan(data.navn, data.ingrediens, data.fremgangsmåde, data.imglink, data.id, data.type, i);
            i++;
        }


    }

    public void pushOvelser(){
        int i = 0;
        for(WorkoutData data: træningsPlan.getWorkouts()){
            for(OvelseData data2: data.getOvelser()){
                databaseControl.pushOvelse(data2.getId(), data2.getNavn(), data2.isDone(), data2.getSets(), i);
                i++;
            }
        }
    }
*/

    public void pushUser(Bruger user){
        databaseControl.PushBruger(user);
    }

    public void getUserFromDatabase(final String UserID){

        new AsyncTask() {
            @Override
            protected Object doInBackground(Object... arg0) {
                try {
                    databaseControl.getUser(UserID);
                    return "Blev hentet korrekt";
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("Blev ikke hentet korrekt: ");
                    return "Blev ikke hentet korrekt: "+e;
                }
            }

            @Override
            protected void onPostExecute(Object resultat) {

            }
        }.execute();
    }



        public boolean getUserFromDB(String UserID){
        databaseControl.getUser(UserID);
        return false;
    }






    public String generateUserKey(){
        String out = "FU";
        String uuid = UUID.randomUUID().toString();
        out = out + uuid;
        System.out.println("SE HER     " + out);
        return out;
    }


    /*
    public void getKostplanFromDB () {
        try {
            bruger.kostplan.getRetter().clear();
            databaseControl.getOpskrift(bruger.RetIDs);

            System.out.println(" VI HAR HENTET DET HER!!: " + bruger.kostplan.getRetter());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void getTraeningsplanFromDB() {
        try {
            int i = 0;
            for (UserWorkoutData uwd : bruger.workouts) {
                if(uwd.ovelseIDs.size() != 0) {
                    WorkoutData data = new WorkoutData();
                    data.setWorkoutid(i);
                    data.setWorkoutname(uwd.navn);
                    data.setOvelser(databaseControl.getWorkout(uwd.ovelseIDs));
                    bruger.træningsPlan.addWorkout(data);
                    i++;
                }
                else{
                    WorkoutData data = new WorkoutData();
                    data.setWorkoutid(i);
                    data.setWorkoutname(uwd.navn);
                    data.setOvelser(new ArrayList<OvelseData>());
                    bruger.træningsPlan.addWorkout(data);
                    i++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    */
}
