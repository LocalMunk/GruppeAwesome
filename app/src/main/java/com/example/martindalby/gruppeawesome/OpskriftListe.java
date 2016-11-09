package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OpskriftListe extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TestData[] data;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Data
        this.data = new TestData[]{
                new TestData("Pizza", "Denne ret smager godt"),
                new TestData("Æggemad", "En lækker mad med æd... og brød"),
                new TestData("Fisk", "Det er godt med fisk"),
                new TestData("Æg", "Lidt af det gode"),
                new TestData("Burger", "kød og kød og kød og kød..."),
                new TestData("Salat", "Jk det er salat... med kød istedet for salat #Prot"),
        };

        //Adapter der opretter hele listen
        ArrayAdapter adapter = new ArrayAdapter(this, R.layout.activity_opskrift_liste,
                R.id.overskriftTV, data) {

            @Override
            public View getView (int position, View cachedView, ViewGroup parent) {

                View view = super.getView(position, cachedView,parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.beskrivelseTV);
                beskrivelse.setText("Jeg kan ikke vælge beskrivelsen her? (hvordan vælge billde " +
                        "spcifik til hvert objekt");

                ImageView billede = (ImageView) view.findViewById(R.id.listeImg);
                billede.setImageResource(R.drawable.pizzalistepic);

                return view;
            }

        };

        ListView listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);


        setContentView(listView);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Opskrift.class);
        startActivity(i);
    }
}