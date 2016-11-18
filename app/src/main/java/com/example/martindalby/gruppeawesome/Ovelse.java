package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.view.View;
import android.widget.TextView;


/**
 * Created by Martin Dalby on 14-11-2016.
 */

public class Ovelse extends AppCompatActivity implements View.OnClickListener {

    NumberPicker number, weightPicker;
    OvelseSupport support;
    Button videre;
    int currentSet;
    ListView list;
    TextView ExerciseName, setsText, weightText;
    OvelseAdapter listadapt;
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse);
        currentSet = 1;
        String[] suppdata = new String[getIntent().getIntExtra("sets", 4)];
        for(int i = 0; i < getIntent().getIntExtra("sets", 4); i++){
            suppdata[i] = "Sæt " + (i+1) + ": ";
        }
        support = new OvelseSupport(suppdata,getIntent().getIntExtra("sets", 4));
        weightPicker = (NumberPicker) findViewById(R.id.weightPicker);
        weightPicker.setMinValue(50);
        weightPicker.setMaxValue(400);
        weightPicker.setValue(100);
        number = (NumberPicker) findViewById(R.id.repsPicker);
        number.setMinValue(1);
        number.setMaxValue(30);
        number.setValue(10);
        number.setOnClickListener(this);
        setsText = (TextView) findViewById(R.id.textReps);
        weightText = (TextView) findViewById(R.id.textWeights);
        setsText.setText("Vælg gentagelser:");
        weightText.setText("Vælg vægt:");
        videre = (Button) findViewById(R.id.viderebutton);
        videre.setOnClickListener(this);
        list = (ListView) findViewById(R.id.listview);
        listadapt = new OvelseAdapter(this);
        list.setAdapter(listadapt);
        ExerciseName = (TextView) findViewById(R.id.ExerciseName);
        ExerciseName.setTextSize(20);
        ExerciseName.setText(getIntent().getStringExtra("title"));

    }

    @Override
    public void onClick(View v) {
        if(v == videre){
            System.out.println("button pressed");
            support.setData(currentSet - 1, number.getValue(), weightPicker.getValue());
            currentSet++;
            list.invalidateViews();
            list.refreshDrawableState();

        }
    }

    public class OvelseAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflter;

        public OvelseAdapter(Context applicationContext) {

            this.context = applicationContext;
            //  this.listimg = ListImg;
            inflter = (LayoutInflater.from(applicationContext));


        }
        //Her afgøres længde på liste ud fra hvilken knap man trykker paa
        @Override
        public int getCount() {
            return support.maxSet;
        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflter .inflate(R.layout.ovelse_list, null);

            TextView text = (TextView) view.findViewById(R.id.ovelselisttext);
            text.setText(support.getData(position));
            return view;
        }

    }
}

