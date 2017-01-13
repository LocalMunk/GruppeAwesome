package com.example.martindalby.gruppeawesome.Activities;

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

import com.example.martindalby.gruppeawesome.DataFiles.BrugerData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.R;

import java.util.ArrayList;

public class LogIn_act extends AppCompatActivity implements View.OnClickListener {

    Button sub;
    TextView notsub;
    EditText bePeakedSubCode;
    MainController datafiles;
    SharedPreferences sharedPreferences;
    String createdUserID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in_test);
        datafiles = MainController.getInstans();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        datafiles.UserID = sharedPreferences.getString("UserID", "FAIL");


        System.out.println("Har været inde i login AKT");

        sub = (Button) findViewById(R.id.buttoncontinuesub);
        sub.setText("Log in");
        sub.setTextSize(20);

        notsub = (TextView) findViewById(R.id.textnotsub);
        notsub.setText("Har du ikke et login?");

        bePeakedSubCode = (EditText) findViewById(R.id.bepeakedsubcode);
        bePeakedSubCode.setHint("Indtast aktiveringsnøgle");

        sub.setOnClickListener(this);
        notsub.setOnClickListener(this);


        //Får dig forbi login hvism man er logget ind
        if(sharedPreferences.getString("UserID", "delet me").equals("delet me")){

        }
        else{
            System.out.println("Kommer forbi log in automatisk-----");

            Intent i = new Intent(this, Main_act.class);

            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);


            datafiles.getUserFromDatabase(sharedPreferences.getString("UserID", "FAIL"));

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                }
            }, 2000);

            startActivity(i);

        }

    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, Main_act.class);

        if (v == sub && bePeakedSubCode.getText().toString().equals("") == false) {
            sharedPreferences.edit().putString("UserID", bePeakedSubCode.getText().toString()).commit();
            datafiles.UserID = bePeakedSubCode.getText().toString();
            datafiles.getUserFromDatabase(bePeakedSubCode.getText().toString());

            datafiles.sub = true;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            //ProgressDialog.show(this, "", "En ProgressDialog", true).setCancelable(true);


            startActivity(i);
            finish();

        } else if (v == notsub) {


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
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            startActivity(i);
            finish();
        }


    }
}

