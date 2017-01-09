package com.example.martindalby.gruppeawesome.DAL;

import android.content.Context;
import android.util.Log;

import com.example.martindalby.gruppeawesome.DataFiles.Bruger;
import com.example.martindalby.gruppeawesome.DataFiles.KostplanData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
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
    private Firebase mRef;


    public DatabaseController() {

        System.out.println("DATABASE BLIVER OPRETTET!!!!!!!!!!!!!!!!!");



        morgenTest = new ArrayList<>();


        bruger = new Bruger();
        opskriftD = new OpskriftData();
        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");


        //push hele test kostplan op i firebase
       // pushKostPlan(kostPlanDt);



    }

    //pusher
    public void pushOvelse(int id, String navn, int done, int sets, int i) {

        OvelseData ovelseData = new OvelseData(id, navn, done, sets);
        String j = i + "";
        mRef.child("v0").child("Ovelser").child(j).setValue(ovelseData);

    }

    public void PushBruger(Bruger bruger){
        mRef.child("v0").child("brugere").child(bruger.id).setValue(bruger);
    }


    //Henter specifik bruger
    public Bruger getUser(String UserID){

        System.out.println("inde i bruger metode.");
        mRef.child("v0").child("brugere").child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bruger.id = dataSnapshot.getValue(Bruger.class).id;
                bruger.workouts = dataSnapshot.getValue(Bruger.class).workouts;
                bruger.RetIDs = dataSnapshot.getValue(Bruger.class).RetIDs;
                System.out.println("Jeg er inde og hente brugeren: " + bruger);
                System.out.println("retid størrelse   " + bruger.RetIDs.size());
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });
        return bruger;
    }

    public OpskriftData getOpskrift (String id) {

        //henter data fra db
        mRef.child("v0").child("kostplan").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //henter børn ned
                opskriftD.setNavn(dataSnapshot.getValue(OpskriftData.class).getNavn());
                opskriftD.setFremgangsmåde(dataSnapshot.getValue(OpskriftData.class).getFremgangsmåde());
                opskriftD.setId(dataSnapshot.getValue(OpskriftData.class).getId());
                opskriftD.setImglink(dataSnapshot.getValue(OpskriftData.class).getImglink());
                opskriftD.setIngrediens(dataSnapshot.getValue(OpskriftData.class).getIngrediens());
                opskriftD.setType(dataSnapshot.getValue(OpskriftData.class).getType());

                System.out.println("Henter denne ret: " + opskriftD.getNavn());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return opskriftD;
    }

}
