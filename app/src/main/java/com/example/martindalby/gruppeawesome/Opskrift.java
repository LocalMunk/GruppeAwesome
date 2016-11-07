package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

    TextView retNavn, fremGang;
    ImageView retBillede;
    ListView ingredienser;
    Button alternativ;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        TableLayout tl = new TableLayout(this);

        retNavn = new TextView(this);
        retNavn.setText("Æggekage");
        tl.addView(retNavn);

        alternativ = new Button(this);
        alternativ.setText("Alternativ");
        tl.addView(alternativ);

        retBillede = new ImageView(this);
        retBillede.setImageResource(R.drawable.pizzalistepic);
        tl.addView(retBillede);

        ingredienser = new ListView(this);
        tl.addView(ingredienser);

        alternativ.setOnClickListener(this);

        setContentView(tl);
    }

    @Override
    public void onClick(View v) {
        if (v == alternativ) {
            Intent i = new Intent(this, OpskriftListe.class);
            startActivity(i);
        }
    }
}

