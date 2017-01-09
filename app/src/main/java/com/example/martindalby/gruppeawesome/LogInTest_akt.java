package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.martindalby.gruppeawesome.DataFiles.Bruger;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.UserWorkoutData;

import java.util.ArrayList;

public class LogInTest_akt extends AppCompatActivity implements View.OnClickListener {

    Button sub, notsub;
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

        notsub = (Button) findViewById(R.id.buttonnotsubbed);
        notsub.setText("Fortsæt uden log in");

        bePeakedSubCode = (EditText) findViewById(R.id.bepeakedsubcode);
        bePeakedSubCode.setHint("Indtast aktiveringsnøgle");

        sub.setOnClickListener(this);
        notsub.setOnClickListener(this);


        //hvad er det her? får dig forbi login hvism man er logget ind
        if(sharedPreferences.getString("UserID", "delet me").equals("delet me")){

        }
        else{
            Intent i = new Intent(this, MainActivity.class);

            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(i);
        }

    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);

        if (v == sub && bePeakedSubCode.getText().toString().equals("") == false) {
            sharedPreferences.edit().putString("UserID", bePeakedSubCode.getText().toString()).commit();

            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(i);
            finish();

        } else if (v == notsub) {
            //genererer user id
            sharedPreferences.edit().putString("UserID", datafiles.generateUserKey()).commit();
            createdUserID = sharedPreferences.getString("UserID", "fail");

            //opretter bruger først lokalt, derefter pusher til db
            datafiles.bruger = new Bruger(createdUserID, new ArrayList<UserWorkoutData>(), new ArrayList<String>());
            datafiles.pushUser(datafiles.bruger);
            datafiles.bruger.workouts = new ArrayList<UserWorkoutData>();

            //Sørger for at main act bliver øverst i backstack
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(i);
            finish();
        }


    }

}

