package com.example.martindalby.gruppeawesome;

import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;

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
    OpskriftData opskriftData;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opskrift);
        datafiles = MainController.getInstans();
        opskriftData = datafiles.bruger.getKostplan().getOpskrift(getIntent().getIntExtra("ret", 0));
        typeText = getIntent().getStringExtra("type");
        overskrift = getIntent().getStringExtra("overskrift");
        beskrivelse = getIntent().getStringExtra("beskrivelse");
        ingred = getIntent().getStringExtra("ingrediens");
        /*
        retNavn = (TextView) findViewById(R.id.retNavn);
        retNavn.setText(opskriftData.getNavn() + " Type: " + typeText);
        */
        retBillede = (ImageView) findViewById(R.id.retImg);
        retBillede.setImageResource(R.drawable.morgenmad);

        ingrediensTV = (TextView) findViewById(R.id.retIngrediens);
        ingrediensTV.setText(opskriftData.getIngrediens());

        alternativ = (Button) findViewById(R.id.alternativ);
        alternativ.setText("Alternativ");

        fremGang = (TextView) findViewById(R.id.fremMaa);
        fremGang.setText(opskriftData.getFremgangsmåde());

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(opskriftData.getNavn());

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

