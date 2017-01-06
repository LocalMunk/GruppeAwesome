package com.example.martindalby.gruppeawesome;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.martindalby.gruppeawesome.DataFiles.Bruger;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.UserWorkoutData;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 06-01-2017.
 */

public class LoginAktivitet  extends AppCompatActivity  implements View.OnClickListener{

    Button sub, notsub;
    EditText bePeakedSubCode;
    MainController datafiles;
    SharedPreferences sharedPreferences;
    String createdUserID;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_login);
        datafiles = MainController.getInstans();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        sub = (Button) findViewById(R.id.buttoncontinuesub);
        sub.setOnClickListener(this);
        sub.setText("Fortsæt");

        notsub = (Button) findViewById(R.id.buttonnotsubbed);
        notsub.setOnClickListener(this);
        notsub.setText("Fortsæt som gratis bruger");

        bePeakedSubCode = (EditText) findViewById(R.id.bepeakedsubcode);
        bePeakedSubCode.setHint("Indtast din BePeaked kode");
    }

    @Override
    public void onClick(View v) {
        if(v == sub && bePeakedSubCode.getText().toString().equals("") == false) {
            sharedPreferences.edit().putString("UserID", bePeakedSubCode.getText().toString()).commit();

            finish();
        }
        else if(v == notsub){
            sharedPreferences.edit().putString("UserID", datafiles.generateUserKey()).commit();
            sharedPreferences.getString("userID", createdUserID);
            datafiles.pushUser(new Bruger(createdUserID, new ArrayList< UserWorkoutData>(), new ArrayList<String>()));
            finish();

        }
    }

}
