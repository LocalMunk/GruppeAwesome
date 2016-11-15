package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.NumberPicker;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Martin Dalby on 14-11-2016.
 */

public class Ovelse extends AppCompatActivity implements View.OnClickListener {

    NumberPicker number;
    Button videre;
    int maxSet, currentSet;
    TextView[] feed;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse);
        currentSet = 1;
        maxSet = 3;
        number = (NumberPicker) findViewById(R.id.number);
        number.setMinValue(1);
        number.setMaxValue(30);
        number.setValue(10);
        number.setOnClickListener(this);
        videre = (Button) findViewById(R.id.viderebutton);
        videre.setOnClickListener(this);
        feed = new TextView[maxSet];
        feed[0] = (TextView) findViewById(R.id.Feedbackset1);
        feed[1] = (TextView) findViewById(R.id.Feedbackset2);
        feed[2] = (TextView) findViewById(R.id.Feedbackset3);




    }

    @Override
    public void onClick(View v) {
        if(v == videre){
            System.out.println("button pressed");
            if(currentSet <= maxSet){
                feed[currentSet-1].setText("sæt " + currentSet + ": " + number.getValue() + " gentagelser.");
                currentSet++;
            }
        }
    }
}

