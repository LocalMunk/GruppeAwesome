package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by Martin Dalby on 21-11-2016.
 */

public class OpretOvelse extends AppCompatActivity implements View.OnClickListener{

    EditText navn, sets;
    Button done;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opretovelse);
        navn = (EditText) findViewById(R.id.opretgetnavn);
        sets = (EditText) findViewById(R.id.opretgetsets);
        done = (Button) findViewById(R.id.opretovelsedone);
        done.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v == done){

        }

    }
}