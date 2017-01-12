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

    TextView fremGang, ingrediensTV;
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

        for (OpskriftData data : datafiles.bruger.getKostplan().getRetter()){
            if(data.getNavn().equals(getIntent().getStringExtra(("ret")))){
                opskriftData = data;
            }
        }

        typeText = getIntent().getStringExtra("type");
        overskrift = getIntent().getStringExtra("overskrift");
        beskrivelse = getIntent().getStringExtra("beskrivelse");
        ingred = getIntent().getStringExtra("ingrediens");

        retBillede = (ImageView) findViewById(R.id.retImg);
        retBillede.setImageResource(R.drawable.morgenmad);

        ingrediensTV = (TextView) findViewById(R.id.retIngrediens);
        ingrediensTV.setText(opskriftData.getIngrediens());

        fremGang = (TextView) findViewById(R.id.fremMaa);
        fremGang.setText(opskriftData.getFremgangsmåde());

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(opskriftData.getNavn());
    }

    @Override
    public void onClick(View v) {

    }
}

