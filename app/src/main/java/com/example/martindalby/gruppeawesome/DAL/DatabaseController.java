package com.example.martindalby.gruppeawesome.DAL;

import android.content.Context;
import android.util.Log;

import com.example.martindalby.gruppeawesome.DataFiles.Bruger;
import com.example.martindalby.gruppeawesome.DataFiles.KostplanData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.UserWorkoutData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.Opskrift;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class DatabaseController {

    public ArrayList<String> morgenTest;
    public ArrayList<String> userID;
    public Bruger bruger;
    public OpskriftData opskriftD;
    public OvelseData ovelseData;
    public ArrayList<OpskriftData> opskriftout;
    private Firebase mRef;
    private String version;
    public MainController datafiles;


    public DatabaseController(MainController main) {

        System.out.println("DATABASE BLIVER OPRETTET!!!!!!!!!!!!!!!!!");

        datafiles = main;

        morgenTest = new ArrayList<>();
        opskriftout = new ArrayList<OpskriftData>();
        version = "v0";
        bruger = new Bruger();
        opskriftD = new OpskriftData();
        ovelseData = new OvelseData();
        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");


        //push hele test kostplan op i firebase
       // pushKostPlan(kostPlanDt);



    }

    //pusher
    public void pushOvelse(int id, String navn, int done, int sets, int i) {

        OvelseData ovelseData = new OvelseData(id, navn, done, sets);
        String j = i + "";
        mRef.child(version).child("Ovelser").child(j).setValue(ovelseData);

    }

    public void PushBruger(Bruger bruger){
        mRef.child(version).child("brugere").child(bruger.id).setValue(bruger);
    }


    //Henter specifik bruger
    public void getUser(String UserID){

        System.out.println("inde i bruger metode.");
        mRef.child(version).child("brugere").child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String id = dataSnapshot.getValue(Bruger.class).id;
                ArrayList<UserWorkoutData> workouts = dataSnapshot.getValue(Bruger.class).workouts;
                ArrayList<String> RetIDs = dataSnapshot.getValue(Bruger.class).RetIDs;
                System.out.println("Jeg er inde og hente brugeren: " + id);
                try {
                    System.out.println("retid størrelse   " + RetIDs.size());
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
                Bruger user = new Bruger();
                user.id = id;
                user.workouts = workouts;
                user.RetIDs = RetIDs;
                datafiles.bruger = user;

            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });

    }

    public void getOpskrift (final ArrayList<String> ids) {

        //henter data fra db
        mRef.child(version).child("kostplan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //henter børn ned
                for(String i : ids){
                    if(i != null){
                        opskriftout.add(dataSnapshot.child(i).getValue(OpskriftData.class));
                    }
                }
                /*
                opskriftD.setNavn(dataSnapshot.child(id).getValue(OpskriftData.class).getNavn());
                opskriftD.setFremgangsmåde(dataSnapshot.child(id).getValue(OpskriftData.class).getFremgangsmåde());
                opskriftD.setId(dataSnapshot.child(id).getValue(OpskriftData.class).getId());
                opskriftD.setImglink(dataSnapshot.child(id).getValue(OpskriftData.class).getImglink());
                opskriftD.setIngrediens(dataSnapshot.child((id)).getValue(OpskriftData.class).getIngrediens());
                opskriftD.setType(dataSnapshot.child(id).getValue(OpskriftData.class).getType());
                System.out.println("Henter denne ret: " + opskriftD.getNavn());
                */
                ArrayList<OpskriftData> out = new ArrayList<OpskriftData>();
                for (OpskriftData data : opskriftout){
                    OpskriftData newData = new OpskriftData();
                    String id = data.getId();
                    String navn = data.getNavn();
                    int type = data.getType();
                    String ingrediens = data.getIngrediens();
                    String imgLink = data.getImglink();
                    String frem =data.getFremgangsmåde();
                    newData.setId(id);
                    newData.setNavn(navn);
                    newData.setFremgangsmåde(frem);
                    newData.setImglink(imgLink);
                    newData.setIngrediens(ingrediens);
                    newData.setType(type);
                    out.add(newData);
                }
                datafiles.kostplan.setRetter(out);

                System.out.println("Vi har hentet de her retter:  " + out);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public OvelseData getOvelse(String id){
        mRef.child(version).child("Ovelser").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ovelseData.setId(dataSnapshot.getValue(OvelseData.class).getId());
                ovelseData.setDone(dataSnapshot.getValue(OvelseData.class).isDone());
                ovelseData.setNavn(dataSnapshot.getValue(OvelseData.class).getNavn());
                ovelseData.setGraf(dataSnapshot.getValue(OvelseData.class).getGraf());

                System.out.println("har hentet denne Øvelse" + ovelseData.getNavn());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return ovelseData;
    }

}
