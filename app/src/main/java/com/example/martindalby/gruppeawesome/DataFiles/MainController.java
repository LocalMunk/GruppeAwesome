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
    public TraeningsPlanData Træningsplan;
    public KostplanData kostplan;
    private static MainController instans;
    public DatabaseController databaseControl;
    public String UserID;
    public Bruger bruger;

    private MainController(){
        Træningsplan = new TraeningsPlanData(new ArrayList<WorkoutData>());
        kostplan = new KostplanData(new ArrayList<OpskriftData>());
        databaseControl = new DatabaseController(this);
        bruger = new Bruger("", new ArrayList<UserWorkoutData>(), new ArrayList<String>());
        bruger.RetIDs = new ArrayList<String>();
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

    public double[] getTreTal(){
        double[] out = {Træningsplan.traeningsGennemsnit, Træningsplan.traeningsMål, Træningsplan.traeningerDenneUge};
        return out;
    }

    public TraeningsPlanData getTræningsplan(){
        return Træningsplan;
    }

    public KostplanData getKostplan(){
        return kostplan;
    }


    public void setTreTal(double a, double b, double c){
        Træningsplan.traeningsGennemsnit = a;
        Træningsplan.traeningsMål = b;
        Træningsplan.traeningerDenneUge = c;
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
        for(WorkoutData data: Træningsplan.getWorkouts()){
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
/*
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
                System.out.println("HAr hentet denne bruger ting?" + bruger.RetIDs.get(0) + "-----------------------------------------------");

            }
        }.execute();
        }
*/


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

    /*public void testDataGenerator(){
        if(Træningsplan.getWorkouts().size() == 0) {
            ArrayList<OvelseData> z = new ArrayList<OvelseData>();
            z.add(new OvelseData(0, "Lunges", 0, 3));
            z.add(new OvelseData(1, "Squats", 0, 3));
            z.add(new OvelseData(2, "Barbell Rows", 0, 3));
            z.add(new OvelseData(3, "Pullups", 0, 3));
            z.add(new OvelseData(4, "Preacher Curls", 0, 3));
            z.add(new OvelseData(5, "Hammer Curl", 0, 3));
            z.add(new OvelseData(6, "Calf Press", 0, 3));
            z.add(new OvelseData(7, "Pullups", 0, 3));
            Træningsplan.addWorkout(new WorkoutData(0, "Workout A", z));
            Træningsplan.addWorkout(new WorkoutData(1, "Workout B", z));
            Træningsplan.addWorkout(new WorkoutData(2, "Workout C", z));

            kostplan.setOpskrift(0, new OpskriftData("Kylling", "1 stk. ost \n 2 æg \n 100g kylling \n \n 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "1", 0));
            kostplan.setOpskrift(0, new OpskriftData("Ostemad", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "2", 0));
            kostplan.setOpskrift(1, new OpskriftData("Fisk", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "3", 1));
            kostplan.setOpskrift(1, new OpskriftData("Æg", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "4", 1));
            kostplan.setOpskrift(2, new OpskriftData("Salat", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "5", 2));
            kostplan.setOpskrift(2, new OpskriftData("God Gryde", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "6", 2));
            kostplan.setOpskrift(3, new OpskriftData("Prot Mad", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "7",3));
            kostplan.setOpskrift(3, new OpskriftData("Sund Mad", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "8", 3));
            kostplan.setOpskrift(0, new OpskriftData("Appelsin Juice", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "9", 0));
            kostplan.setOpskrift(1, new OpskriftData("Burger", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "10", 1));
            kostplan.setOpskrift(2, new OpskriftData("Gulerod", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "11", 2));
            kostplan.setOpskrift(3, new OpskriftData("Peanut butter", "1 stk. ost \n" +
                    " 2 æg \n" +
                    " 100g kylling \n" +
                    " \n" +
                    " 200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                    "\n" +
                    "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                    "\n" +
                    "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", "", "12", 3));
        }

    }

*/

    public void getKostplanFromDB () {
        try {
            kostplan.getRetter().clear();
            for (String id : bruger.RetIDs) {
                if(id != null){
                    kostplan.setOpskrift(databaseControl.getOpskrift(id));
                }

            }
            System.out.println(" VI HAR HENTET DET HER!!: " + kostplan.getRetter());
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
