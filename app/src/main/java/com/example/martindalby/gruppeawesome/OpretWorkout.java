package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 21-11-2016.
 */

public class OpretWorkout extends AppCompatActivity implements View.OnClickListener{

    EditText navn;
    Button done;
    MainController datafiles;
    TraeningsPlanData traeningsPlanData;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opretworkout);
        datafiles = MainController.getInstans();

        navn = (EditText) findViewById(R.id.workoutname);
        navn.setHint("Navn");

        done = (Button) findViewById(R.id.createworkoutdone);
        done.setOnClickListener(this);

        traeningsPlanData = datafiles.getTræningsplan();
    }

    public void onClick(View v){
        if(v == done){
            traeningsPlanData.addWorkout(new WorkoutData(traeningsPlanData.getWorkouts().size(), navn.getText().toString(), new ArrayList<OvelseData>()));
            finish();
        }

    }
}