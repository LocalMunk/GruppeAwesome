package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import junit.framework.Test;

public class OpskriftListe extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TestDataMad data = new TestDataMad();
    private TestDataMad randomRet;
    private OpskriftSupport os = new OpskriftSupport();
    private KostPlanAdapter adapter;
    private ListView listView;
    private String typeText, send1, send2, send3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        typeText = getIntent().getStringExtra("type");
        System.out.println("TyperTe4xt fået fra intent: " + typeText);
        adapter = new KostPlanAdapter();

        listView = new ListView(this);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        setContentView(listView);
        randomRet = os.randomRet(typeText, data);
        send1 = randomRet.getOverskrift();
        send2 = randomRet.getBeskrivelse();
        send3 = randomRet.getIngredienser();
        test();
    }

    public void test() {
        Intent i = new Intent(this, Opskrift.class);
        i.putExtra("overskrift", send1)
                .putExtra("beskrivelse", send2)
                .putExtra("ingrediens", send3)
                .putExtra("type", typeText);
        startActivity(i);
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Opskrift.class);
        i.putExtra("type", typeText);
        startActivity(i);
    }

    public class KostPlanAdapter extends BaseAdapter{
        //Her afgøres længde på liste ud fra hvilken knap man trykker paa
        @Override
        public int getCount() {
            return os.maaltidLaengde(data, typeText);
        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.activity_opskrift_liste, null);

            os.alternativListe(typeText, view, data, position);

            return view;
        }

    }
}