package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

/**
 * Created by Martin Dalby on 21-11-2016.
 */

public class OpretOvelse extends AppCompatActivity implements View.OnClickListener{

    EditText navn, sets;
    Button done;
    MainController datafiles;
    WorkoutData workoutData;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opretovelse);
        datafiles = MainController.getInstans();

        navn = (EditText) findViewById(R.id.opretgetnavn);
        navn.setHint("Øvelse navn");

        sets = (EditText) findViewById(R.id.opretgetsets);
        sets.setHint("Sets");

        done = (Button) findViewById(R.id.opretovelsedone);
        done.setOnClickListener(this);

        workoutData = datafiles.getTræningsplan().getWorkout(0);
    }

    public void onClick(View v){
        if(v == done){
            OvelseData out = new OvelseData(0, navn.getText().toString(), 0, Integer.parseInt(sets.getText().toString()));
            workoutData.addOvelse(out);
            finish();
        }

    }
}