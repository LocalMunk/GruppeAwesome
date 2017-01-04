package com.example.martindalby.gruppeawesome.DAL;

import android.content.Context;
import android.util.Log;

import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
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

    private DatabaseReference mDatabase;


    private Firebase mRef;

    public DatabaseController() {

        mDatabase = FirebaseDatabase.getInstance().getReference();

        mRef = new Firebase("https://firefred-e8090.firebaseio.com/kostplan");

        mDatabase.child("kostplan").addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {

                Map<String, String> map = dataSnapshot.getValue(Map.class);

                String a1 = map.get("a1");
                String a2 = map.get("a2");
                String a3 = map.get("a3");

                Log.v("E_VALUE", "a1 : " + a1);
                Log.v("E_VALUE", "a2 : " + a2);
                Log.v("E_VALUE", "a3 : " + a3);

                OpskriftData opskrift = dataSnapshot.getValue(OpskriftData.class);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });



    }


}
