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
    TextView feed1, feed2, feed3;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse);
        number = (NumberPicker) findViewById(R.id.number);
        number.setMinValue(1);
        number.setMaxValue(30);
        number.setValue(10);
        number.setOnClickListener(this);
        videre = (Button) findViewById(R.id.viderebutton);
        videre.setOnClickListener(this);
        feed1 = (TextView) findViewById(R.id.Feedbackset1);
        feed2 = (TextView) findViewById(R.id.Feedbackset2);
        feed3 = (TextView) findViewById(R.id.Feedbackset3);
        currentSet = 1;
        maxSet = 3;



    }

    @Override
    public void onClick(View v) {
        if(v == videre){
            System.out.println("button pressed");
            if(currentSet <= maxSet){
                switch(currentSet){
                    case 1: feed1.setText("Set 1: " + number.getValue() + " gentagelser");
                        break;
                    case 2: feed2.setText("Set 2: " + number.getValue() + " gentagelser");
                        break;
                    case 3: feed3.setText("Set 3: " + number.getValue() + " gentagelser");
                        break;
                }
                currentSet++;
            }
        }
    }
}

