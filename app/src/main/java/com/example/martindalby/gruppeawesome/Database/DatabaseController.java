package com.example.martindalby.gruppeawesome.Database;

import com.example.martindalby.gruppeawesome.DataFiles.BrugerData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 02-01-2017.
 */

public class DatabaseController {

    public ArrayList<String> morgenTest;
    public ArrayList<String> userID;
    public BrugerData bruger;
    public OpskriftData opskriftD;
    public OvelseData ovelseData;
    public ArrayList<OpskriftData> opskriftout;
    public ArrayList<OvelseData> ovelseout;
    public ArrayList<OvelseData> out;
    private Firebase mRef;
    private String version;
    public MainController datafiles;


    public DatabaseController(MainController main) {

        System.out.println("DATABASE BLIVER OPRETTET!!!!!!!!!!!!!!!!!");

        datafiles = main;

        out = new ArrayList<OvelseData>();
        morgenTest = new ArrayList<>();
        opskriftout = new ArrayList<OpskriftData>();
        version = "Martins Test";
        bruger = new BrugerData();
        opskriftD = new OpskriftData();
        ovelseData = new OvelseData();

        ovelseout = new ArrayList<OvelseData>();
        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");

    }

    public void PushBruger(BrugerData bruger){
        mRef.child(version).child("brugere").child(bruger.id).setValue(bruger);
    }

    public String getVersion() {
        return version;
    }

    //Henter specifik bruger
    public void getUser(String UserID) {

        System.out.println("inde i bruger metode.");
        mRef.child(version).child("brugere").child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                datafiles.bruger = dataSnapshot.getValue(BrugerData.class);
                System.out.println("Har hentet bruger:" + datafiles.bruger);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {
            }
        });
    }
}
