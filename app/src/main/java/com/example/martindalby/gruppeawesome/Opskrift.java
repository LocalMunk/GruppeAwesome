package com.example.martindalby.gruppeawesome;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;

/**
 * Created by Martin Dalby on 07-11-2016.
 */

public class Opskrift extends AppCompatActivity implements View.OnClickListener{

    TextView retNavn, fremGang, ingrediensTV;
    ImageView retBillede;
    Button alternativ;
    String typeText, overskrift, beskrivelse, ingred;
    Toolbar toolbar;
    MainController datafiles;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opskrift);
        datafiles = MainController.getInstans();

        typeText = getIntent().getStringExtra("type");
        overskrift = getIntent().getStringExtra("overskrift");
        beskrivelse = getIntent().getStringExtra("beskrivelse");
        ingred = getIntent().getStringExtra("ingrediens");

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(typeText);

        retNavn = (TextView) findViewById(R.id.retNavn);
        retNavn.setText(overskrift + " Type: " + typeText);

        retBillede = (ImageView) findViewById(R.id.retImg);
        retBillede.setImageResource(R.drawable.morgenmad);

        ingrediensTV = (TextView) findViewById(R.id.retIngrediens);
        ingrediensTV.setText(ingred);

        alternativ = (Button) findViewById(R.id.alternativ);
        alternativ.setText("Alternativ");

        fremGang = (TextView) findViewById(R.id.fremMaa);
        fremGang.setText(beskrivelse);

        alternativ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == alternativ) {
            //Intent i = new Intent(this, OpskriftListe.class);
            //i.putExtra("type", typeText);
            //startActivity(i);
            finish();
        }
    }
}

