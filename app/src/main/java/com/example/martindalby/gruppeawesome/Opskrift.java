package com.example.martindalby.gruppeawesome;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ListView;


/**
 * Created by Martin Dalby on 07-11-2016.
 */

public class Opskrift  extends AppCompatActivity implements View.OnClickListener{

    TextView retNavn, fremGang;
    ImageView retBillede;
    ListView ingredienser;
    Button alternativ;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        retNavn = new TextView(this);
        retNavn.setText("Æggekage");

        retBillede = new ImageView(this);
        ingredienser = new ListView(this);

        alternativ = new Button(this);
    }

    @Override
    public void onClick(View v) {
    }
}

