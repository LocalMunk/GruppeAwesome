package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.KostplanData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OpskriftData;

import java.util.ArrayList;

public class OpskriftListe extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private OpskriftData OpskriftVidere;

    private OpskriftSupport os = new OpskriftSupport();
    private KostPlanAdapter adapter;
    private ListView listView;
    private String typeText, send1, send2, send3;
    MainController datafiles;
    KostplanData kostplanData;
    private int type;
ArrayList<OpskriftData> opskrifter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        datafiles = MainController.getInstans();
        kostplanData = datafiles.getKostplan();
        typeText = getIntent().getStringExtra("type");
        System.out.println("TyperTe4xt fået fra intent: " + typeText);
        adapter = new KostPlanAdapter();

        if(typeText.equals("Morgenmad")) type = 0;
        else if(typeText.equals("Frokost")) type = 1;
        else if(typeText.equals("Aftensmad")) type = 2;
        else if(typeText.equals("Snack")) type = 3;

        opskrifter = new ArrayList<OpskriftData>();
         for( OpskriftData data:kostplanData.getRetter()){

             if(data.type ==this.type){

                 opskrifter.add(data);

             }

         }

        listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        listView.setBackgroundResource(R.drawable.bg);
        setContentView(listView);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Opskrift.class);

        OpskriftVidere = opskrifter.get(position);

        i.putExtra("ret", OpskriftVidere.getId());
        startActivity(i);
    }

    public class KostPlanAdapter extends BaseAdapter{
        //Her afgøres længde på liste ud fra hvilken knap man trykker paa
        @Override
        public int getCount() {
            return opskrifter.size();

        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.activity_opskrift_liste, null);


            TextView overskrift = (TextView) view.findViewById(R.id.overskriftTV);
            ImageView icon = (ImageView) view.findViewById(R.id.listeImg);

            overskrift.setText(opskrifter.get(position).getNavn());
            icon.setImageResource(R.drawable.pizzalistepic);

            return view;
        }

    }
}