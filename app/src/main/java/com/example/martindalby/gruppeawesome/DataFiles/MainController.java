package com.example.martindalby.gruppeawesome.DataFiles;

import com.example.martindalby.gruppeawesome.DAL.DatabaseController;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class MainController implements Serializable{
    TraeningsPlanData Træningsplan;
    KostplanData Kostplan;
    private static MainController instans;
    DatabaseController databaseControl;

    private MainController(){
        Træningsplan = new TraeningsPlanData(new ArrayList<WorkoutData>());
        Kostplan = new KostplanData(new ArrayList<OpskriftData>(),new ArrayList<OpskriftData>(),new ArrayList<OpskriftData>(),new ArrayList<OpskriftData>());
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

    public void testDataGenerator(){
        ArrayList<OvelseData> z = new ArrayList<OvelseData>();
        z.add(new OvelseData(0, "Lunges", 3, 3));
        z.add(new OvelseData(1, "Squats", 3, 3));
        z.add(new OvelseData(2, "Barbell Rows", 3, 3));
        z.add(new OvelseData(3, "Pullups", 3, 3));
        z.add(new OvelseData(4, "Preacher Curls", 3, 3));
        z.add(new OvelseData(5, "Hammer Curl", 3, 3));
        z.add(new OvelseData(6, "Calf Press", 3, 3));
        z.add(new OvelseData(7, "Pullups", 3, 3));
        Træningsplan.addWorkout(new WorkoutData(0, "Workout A", z));
        Træningsplan.addWorkout(new WorkoutData(1, "Workout B", z));
        Træningsplan.addWorkout(new WorkoutData(2, "Workout C", z));

        Kostplan.setOpskrift(0, new OpskriftData("Kylling", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(0, new OpskriftData("Ostemad", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(1, new OpskriftData("Fisk", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(1, new OpskriftData("Æg", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(2, new OpskriftData("Salat", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(2, new OpskriftData("God Gryde", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(3, new OpskriftData("Prot Mad", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(3, new OpskriftData("Sund Mad", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(0, new OpskriftData("Appelsin Juice", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(1, new OpskriftData("Burger", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(2, new OpskriftData("Gulerod", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));
        Kostplan.setOpskrift(3, new OpskriftData("Peanut butter", "1 stk. ost \\n2 æg \\n100g kylling \\n\\n200g prot", "Lad en tykbundet gryde blive varm. Tilsæt ris, løg og hvidvin. Bring det i kog og kog det ved jævn varme i ca. 2 min. Tilsæt vand og bouillonterning og lad retten koge ved svag varme i ca. 20 min. - rør af og til. Tilsæt squash og æble og vend det godt sammen. Lad risottoen koge ved svag varme i yderligere ca. 5 min. - rør af og til.\n" +
                "\n" +
                "Tilsæt hytteost, jordskokker, persille, limesaft og salt. Varm risottoen igennem og smag til.\n" +
                "\n" +
                "Lad imens olien blive godt varm i en pande. Steg kylling og gulerødder i ca. 3 min. ved kraftig varme. Skru ned til jævn varme og steg i yderligere ca. 7 min. under omrøring. Anret kylling på risottoen sammen med serrano skinke. Pynt med persille.", ""));

    }

}
