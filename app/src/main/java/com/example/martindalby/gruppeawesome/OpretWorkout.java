package com.example.martindalby.gruppeawesome;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.UserWorkoutData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 21-11-2016.
 */

public class OpretWorkout extends AppCompatActivity implements View.OnClickListener{

    static int workoutNum = 0;
    EditText navn;
    Button done;
    MainController datafiles;
    TraeningsPlanData traeningsPlanData;
    SharedPreferences sharedPreferences;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opretworkout);
        datafiles = MainController.getInstans();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        navn = (EditText) findViewById(R.id.workoutname);
        navn.setHint("Navn");

        done = (Button) findViewById(R.id.createworkoutdone);
        done.setOnClickListener(this);

        traeningsPlanData = datafiles.getTræningsplan();


        System.out.println("brugeren er " + datafiles.bruger.id);

    }

    public void onClick(View v){
        if(v == done){
            traeningsPlanData.addWorkout(new WorkoutData(traeningsPlanData.getWorkouts().size(), navn.getText().toString(), new ArrayList<OvelseData>()));
            if (datafiles.bruger.workouts == null){
                datafiles.bruger.workouts.add(workoutNum, new UserWorkoutData(new ArrayList<String>(), navn.getText().toString()));
                workoutNum++;
            }
            else{
                datafiles.bruger.workouts.add(datafiles.bruger.workouts.size(), new UserWorkoutData(new ArrayList<String>(), navn.getText().toString()));
            }
            datafiles.pushUser(datafiles.bruger);
            finish();
        }

    }
}