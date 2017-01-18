package com.example.martindalby.gruppeawesome.Activities;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.martindalby.gruppeawesome.DataFiles.BrugerData;
import com.example.martindalby.gruppeawesome.DataFiles.KostplanData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.R;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.version;

public class LogIn_act extends AppCompatActivity implements View.OnClickListener {

    Button sub;
    TextView notsub;
    EditText bePeakedSubCode;
    MainController datafiles;
    SharedPreferences sharedPreferences;
    String createdUserID;
    Firebase mRef;
    ProgressDialog pd;
    Context con;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_test);

        datafiles = MainController.getInstans();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        mRef = new Firebase("https://boodybook-a85b7.firebaseio.com/");
        datafiles.UserID = sharedPreferences.getString("UserID", "FAIL");
        con = this;


        //til reset pf
        sharedPreferences.edit().putString("UserID", "delet me").commit();

        sub = (Button) findViewById(R.id.buttoncontinuesub);
        sub.setText(R.string.logintext);
        sub.setTextSize(15);

        notsub = (TextView) findViewById(R.id.textnotsub);
        notsub.setText(R.string.ikkelogintext);

        bePeakedSubCode = (EditText) findViewById(R.id.bepeakedsubcode);
        bePeakedSubCode.setHint(R.string.aktiveringsnøgle);
        bePeakedSubCode.setTextSize(15);

        sub.setOnClickListener(this);
        notsub.setOnClickListener(this);

        pd = new ProgressDialog(this);
        pd.setIndeterminate(true);
        pd.setMessage("Loading...");
        pd.setProgressStyle(android.R.style.Animation_Dialog);
        pd.setCancelable(false);


        //Får dig forbi login hvism man er logget ind
        if(sharedPreferences.getString("UserID", "delet me").equals("delet me")){

        }
        else{
            pd.show();
            System.out.println("Kommer forbi log in automatisk-----");
            Intent i = new Intent(this, Main_act.class);
            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            try {

                getUser(sharedPreferences.getString("UserID", "delet me"), i);
            }
            catch(NullPointerException e){
                e.printStackTrace();
            }

        }

    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Main_act.class);

        if (v == sub && bePeakedSubCode.getText().toString().equals("") == false) {
            pd.show();
            sharedPreferences.edit().putString("UserID", bePeakedSubCode.getText().toString()).commit();
            datafiles.UserID = bePeakedSubCode.getText().toString();

            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            getUser(bePeakedSubCode.getText().toString(), i);
        }

        else if (v == notsub) {
            //genererer user id
            sharedPreferences.edit().putString("UserID", datafiles.generateUserKey()).commit();
            //gemmer brugers ID lokalt
            createdUserID = sharedPreferences.getString("UserID", "fail");
            datafiles.UserID = createdUserID;

            //Laver bruger med tom data
            ArrayList<WorkoutData> out = new ArrayList<WorkoutData>();
            datafiles.bruger = new BrugerData(new TraeningsPlanData(out, 1.0, 1.0, 1.0),
            null, createdUserID);
            System.out.println(datafiles.bruger);
            //lægger bruger om i DB
            datafiles.pushUser(datafiles.bruger);

            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            datafiles.sub = false;

            startActivity(i);
            finish();
        }

        //login findes ikke
        else {
            System.out.println("findes ikke leleelelelele");
        }


    }
    public void getUser(String UserID, final Intent i) throws NullPointerException{

        System.out.println("inde i bruger metode.");
        mRef.child(datafiles.databaseControl.getVersion()).child("brugere").child(UserID).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String id;

                try {
                    id = dataSnapshot.getValue(BrugerData.class).getId();
                }
                catch(Exception e){
                    e.printStackTrace();
                    pd.dismiss();
                    Toast toast = Toast.makeText(con, "Aktiveringsnøgle findes ikke", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                }
                TraeningsPlanData traeningsPlanData = dataSnapshot.getValue(BrugerData.class).getTræningsPlan();
                KostplanData kostplanData = dataSnapshot.getValue(BrugerData.class).getKostplan();

                System.out.println("Jeg er inde og hente brugeren: " + id);

                BrugerData user = new BrugerData();
                user.id = id;
                user.træningsPlan = new TraeningsPlanData(traeningsPlanData.getWorkouts());
                try {
                    user.kostplan = new KostplanData(kostplanData.getRetter());
                }
                catch(NullPointerException e){
                    user.kostplan = null;
                }
                datafiles.bruger = user;
                pd.dismiss();
                startActivity(i);
                finish();
                System.out.println("Har hentet bruger:" + datafiles.bruger);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }


        });
    }


}

