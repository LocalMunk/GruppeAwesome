package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.ListView;


/**
 * Created by Martin Dalby on 07-11-2016.
 */

public class Opskrift  extends AppCompatActivity implements View.OnClickListener{

    TextView retNavn, fremGang, ingredienser;
    ImageView retBillede;
    Button alternativ;
    String typeText;
    Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opskrift);

        typeText = getIntent().getStringExtra("type");

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(typeText);

        retNavn = (TextView) findViewById(R.id.retNavn);
        retNavn.setText("Type: " + typeText);

        retBillede = (ImageView) findViewById(R.id.retImg);
        retBillede.setImageResource(R.drawable.morgenmad);

        ingredienser = (TextView) findViewById(R.id.retIngrediens);
        ingredienser.setText("1 stk. ost \n2 bajer \n100g kød \n\n200g prot");

        alternativ = (Button) findViewById(R.id.alternativ);
        alternativ.setText("Alternativ");

        fremGang = (TextView) findViewById(R.id.fremMaa);
        fremGang.setText("Selvom det er nemt, så går vi ikke på kompromis med smag eller sundhed i " +
                "vores hverdagsmad. Her i dette tema har vi samlet en masse opskrifter på sund og " +
                "nem aftensmad til dig - det er fx aftensmad på 20 min, retter med svinekød, dem " +
                "med kylling, nogle med oksekød og så lige nogle med fisk.");

        alternativ.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == alternativ) {
            Intent i = new Intent(this, OpskriftListe.class);
            i.putExtra("type", typeText);
            startActivity(i);
            finish();
        }
    }
}

