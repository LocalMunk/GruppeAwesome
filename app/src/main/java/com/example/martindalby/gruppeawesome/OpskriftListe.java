package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class OpskriftListe extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private TestData data = new TestData();
    private TestData[] mad;
    private KostPlanAdapter adapter;
    private ListView listView;
    private String typeText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        typeText = getIntent().getStringExtra("type");
        adapter = new KostPlanAdapter();

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

    public class KostPlanAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            int i;
            if(typeText=="Morgenmad") i = data.getMorgenmad().length;
            else if (typeText=="Frokost") i = data.getFrokost().length;
            else if (typeText=="Aftensmad") i = data.getAften().length;
            else i = data.getSnack().length; //snack
            return i;
        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = getLayoutInflater().inflate(R.layout.activity_opskrift_liste, null);

            TextView overskrift = (TextView) view.findViewById(R.id.overskriftTV);
            overskrift.setText(data.getAftensmad()[position].getOverskrift());

            TextView beskrivelse = (TextView) view.findViewById(R.id.beskrivelseTV);
            beskrivelse.setText(data.getAftensmad()[position].getBeskrivelse());

            ImageView icon = (ImageView) view.findViewById(R.id.listeImg);
            icon.setImageResource(R.drawable.pizzalistepic);

            return view;
        }

    }

}