package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

import java.util.ArrayList;

/**
 * Created by Martin Dalby on 05-01-2017.
 */

public class OpretWorkout  extends AppCompatActivity implements View.OnClickListener{

    MainController datafiles;
    Button create;
    EditText name;
    TraeningsPlanData traeningsPlanData;




    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.activity_opretworkout);
        datafiles = MainController.getInstans();

        name = (EditText) findViewById(R.id.workoutname);
        name.setHint("Workout navn");

        create = (Button) findViewById(R.id.createworkoutdone);
        create.setOnClickListener(this);

        traeningsPlanData = datafiles.getTræningsplan();

    }

    @Override
    public void onClick(View v) {
        if(v == create && name.getText().toString().equals("") == false){
            int i = traeningsPlanData.getWorkouts().size();
            WorkoutData out = new WorkoutData(i, name.getText().toString(), new ArrayList<OvelseData>());
            traeningsPlanData.addWorkout(out);
        }
    }
}

