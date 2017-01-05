package com.example.martindalby.gruppeawesome.DAL;

import android.content.Context;
import android.util.Log;

import com.example.martindalby.gruppeawesome.DataFiles.KostplanData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
import com.example.martindalby.gruppeawesome.Opskrift;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Map;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class DatabaseController {


   // public KostplanData kostPlanDt = MainController.getInstans().getKostplan();
    private Firebase mRef;


    public DatabaseController() {

        System.out.println("DATABASE BLIVER OPRETTET!!!!!!!!!!!!!!!!!");

        //mDatabase = FirebaseDatabase.getInstance().getReference();

        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");

        //push kostplantest op i firebase
        lavTestKostplan("navn test", "ingrediens test", "fremgangsmåde test", "img test", "id test", 222);

        //push hele test kostplan op i firebase
       // pushKostPlan(kostPlanDt);

        //henter data fra db
        mRef.child("v0").child("kostplan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.v("Måske virke?", "hente: " + dataSnapshot.getValue());

                System.out.println("Der er " + dataSnapshot.getChildrenCount() + " børn");


                for (DataSnapshot child : dataSnapshot.getChildren()) {

                    //OpskriftData opskrift = dataSnapshot.getValue(OpskriftData.class);
                    //System.out.println("Prøv at hente navn:" + opskrift.getNavn());

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

    public void lavTestKostplan (String navn, String ingrediens, String fremgangsmåde, String imglink, String id, int type) {

        OpskriftData opskriftData = new OpskriftData(navn, ingrediens, fremgangsmåde, imglink, id, type);

        mRef.child("v0").child("kostplan").child("5").setValue(opskriftData);

    }

    public void pushKostPlan (KostplanData kost) {

        mRef.child("v1").child("kostplan").setValue(kost);

    }

}
