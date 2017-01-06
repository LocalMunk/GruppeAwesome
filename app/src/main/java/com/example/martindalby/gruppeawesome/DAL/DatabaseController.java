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
    private Firebase mRef;


    public DatabaseController() {

        System.out.println("DATABASE BLIVER OPRETTET!!!!!!!!!!!!!!!!!");



        morgenTest = new ArrayList<>();

        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");

        getUserID();
        //push kostplantest op i firebase
        //lavTestKostplan("navn test", "ingrediens test", "fremgangsmåde test", "img test", "id test", 222, 1);

        //push hele test kostplan op i firebase
       // pushKostPlan(kostPlanDt);






        //henter data fra db
        mRef.child("v0").child("kostplan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.v("Måske virke?", "hente: " + dataSnapshot.getValue());

                System.out.println("Der er " + dataSnapshot.getChildrenCount() + " børn");

                //henter børn ned
                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    System.out.print("Prøv at konvertere til OpskriftData, kostplankey: " + child.getKey());
                    OpskriftData opskrift = child.getValue(OpskriftData.class);
                    System.out.print(" - Type nr: " + opskrift.getType());
                    System.out.print(" - Navn:" + opskrift.getNavn());

                    //tilføjer navn at barn hvis type er = 0 altså morgenmad
                    if (opskrift.getType() == 0) {
                        morgenTest.add(opskrift.getNavn());
                        System.out.print(" - Er tilføjet til morgen liste: " + opskrift.getNavn());

                    }
                    System.out.println();

                }



                /*
                String a1 = map.get("a1");
                String a2 = map.get("a2");
                String a3 = map.get("a3");

                Log.v("E_VALUE", "a1 : " + a1);
                Log.v("E_VALUE", "a2 : " + a2);
                Log.v("E_VALUE", "a3 : " + a3);
                */

                //OpskriftData opskrift = dataSnapshot.getValue(OpskriftData.class);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });


    }

    public void lavTestKostplan (String navn, String ingrediens, String fremgangsmåde, String imglink, String id, int type, int i) {

        OpskriftData opskriftData = new OpskriftData(navn, ingrediens, fremgangsmåde, imglink, id, type);
        String j = i + "";
        mRef.child("v0").child("kostplan").child(j).setValue(opskriftData);

    }

    public void PushOvelse(int id, String navn, int done, int sets, int i) {

        OvelseData ovelseData = new OvelseData(id, navn, done, sets);
        String j = i + "";
        mRef.child("v0").child("Ovelser").child(j).setValue(ovelseData);

    }

    public void PushBruger(Bruger bruger){
        mRef.child("v0").child("brugere").child(bruger.id).setValue(bruger);
    }

    public ArrayList<String> getUserID(){
        System.out.println("inde i bruger metode.");
        userID = new ArrayList<String>();
        mRef.child("v0").child("brugere").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                System.out.println("key??? " + dataSnapshot.getKey());

                System.out.println("Der er " + dataSnapshot.getChildrenCount() + " børn");

                //henter børn ned
                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    System.out.print("Prøv at konvertere til userID, userIDkey: " + child.getValue());
                    Bruger bruger = child.getValue(Bruger.class);

                    System.out.print(" - Bruger id: " + bruger.id);
                    userID.add(bruger.id);
            }

                System.out.print("Antal brugere i array: " + userID.size());


        }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });
        return userID;
    }


    public Bruger getUser(String UserID){
        System.out.println("inde i bruger metode.");
        mRef.child("v0").child("brugere").child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                bruger = dataSnapshot.getValue(Bruger.class);
                System.out.println("Jeg er inde og hente brugeren til dig men måske bliver det ikke gemt");
            }
            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });
        return bruger;
    }

}
