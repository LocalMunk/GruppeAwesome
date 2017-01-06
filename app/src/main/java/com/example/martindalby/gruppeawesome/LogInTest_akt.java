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

        System.out.println("Har været inde i login AKT");

        sub = (Button) findViewById(R.id.buttoncontinuesub);
        sub.setText("Log in");

        notsub = (Button) findViewById(R.id.buttonnotsubbed);
        notsub.setText("Fortsæt uden log in");

        bePeakedSubCode = (EditText) findViewById(R.id.bepeakedsubcode);
        bePeakedSubCode.setHint("Indtast aktiveringsnøgle");

        sub.setOnClickListener(this);
        notsub.setOnClickListener(this);

        //hvad er det her?
        if(!sharedPreferences.getString("UserID", "delet me").equals("delet me")){
            Intent i = new Intent(this, MainActivity.class);
            //startActivity(i);

        }
    }


    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        if (v == sub && bePeakedSubCode.getText().toString().equals("") == false) {
            sharedPreferences.edit().putString("UserID", bePeakedSubCode.getText().toString()).commit();
            startActivity(i);
            finish();

        } else if (v == notsub) {
            sharedPreferences.edit().putString("UserID", datafiles.generateUserKey()).commit();
            createdUserID = sharedPreferences.getString("UserID", "fail");
            datafiles.pushUser(new Bruger(createdUserID, new ArrayList<UserWorkoutData>(), new ArrayList<String>()));
            startActivity(i);
            finish();
        }


    }

}

