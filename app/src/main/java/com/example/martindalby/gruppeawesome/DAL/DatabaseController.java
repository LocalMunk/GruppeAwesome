package com.example.martindalby.gruppeawesome.DAL;

import com.example.martindalby.gruppeawesome.DataFiles.Bruger;
import com.example.martindalby.gruppeawesome.DataFiles.KostplanData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.UserWorkoutData;
import com.firebase.client.ChildEventListener;
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
    public Bruger bruger;
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
        bruger = new Bruger();
        opskriftD = new OpskriftData();
        ovelseData = new OvelseData();

        ovelseout = new ArrayList<OvelseData>();
        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");


        //push hele test kostplan op i firebase
       // pushKostPlan(kostPlanDt);



    }

    //pusher
    public void pushOvelse(int id, String navn, int done, int sets) {

        OvelseData ovelseData = new OvelseData(id, navn, done, sets);
        String j = id + "";
        mRef.child(version).child("Ovelser").child(j).setValue(ovelseData);

    }

    public void PushBruger(Bruger bruger){
        mRef.child(version).child("brugere").child(bruger.id).setValue(bruger);
    }


    //Henter specifik bruger
    public void getUser(String UserID) {

        System.out.println("inde i bruger metode.");
        mRef.child(version).child("brugere").child(UserID).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String id = dataSnapshot.getValue(Bruger.class).getId();
                TraeningsPlanData traeningsPlanData = dataSnapshot.getValue(Bruger.class).getTræningsPlan();
                KostplanData kostplanData = dataSnapshot.getValue(Bruger.class).getKostplan();

                System.out.println("Jeg er inde og hente brugeren: " + id);

                Bruger user = new Bruger();
                user.id = id;
                user.træningsPlan = new TraeningsPlanData(traeningsPlanData.getWorkouts());
                user.kostplan = new KostplanData(kostplanData.getRetter());
                datafiles.bruger = user;

                System.out.println("Har hentet bruger:" + datafiles.bruger);

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
                datafiles.bruger.kostplan.setRetter(out);

                System.out.println("Vi har hentet de her retter:  " + out);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public ArrayList<OvelseData> getWorkout(final ArrayList<String> ids){
        mRef.child(version).child("Ovelser").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(String id : ids){
                    if(id != null){
                        ovelseout.add(dataSnapshot.child(id).getValue(OvelseData.class));
                    }
                }


                for ( OvelseData data : ovelseout) {
                    OvelseData ovels = new OvelseData();
                    String navn = data.getNavn();
                    int done = data.isDone();
                    int sets = data.getSets();
                    int id = data.getId();

                    ovels.setNavn(navn);
                    ovels.setDone(done);
                    ovels.setSets(sets);
                    ovels.setId(id);

                    out.add(ovels);
                }

                System.out.println("har hentet denne Øvelse" + ovelseData.getNavn());
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        return out;
    }

}
