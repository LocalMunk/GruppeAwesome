package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.view.View;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;


/**
 * Created by Martin Dalby on 14-11-2016.
 */

public class Ovelse extends AppCompatActivity implements View.OnClickListener {

    OvelseSupport support;
    Button videre;
    int currentSet;
    ListView list;
    TextView ExerciseName;
    OvelseAdapter listadapt;
    GraphView graph;
    MainController datafiles;
    OvelseData ovelseData;
    EditText Reps, Weight;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ovelse);
        datafiles = MainController.getInstans();
        ovelseData = datafiles.getTræningsplan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().get(getIntent().getIntExtra("pos", 0));
        currentSet = 1;
        String[] suppdata = new String[ovelseData.getSets()];
        for(int i = 0; i < ovelseData.getSets(); i++){
            suppdata[i] = "Sæt " + (i+1) + ": ";
        }
        support = new OvelseSupport(suppdata,ovelseData.getSets());

/*
        weightPicker = (NumberPicker) findViewById(R.id.weightPicker);
        weightPicker.setMinValue(50);
        weightPicker.setMaxValue(400);
        weightPicker.setValue(100);

        number = (NumberPicker) findViewById(R.id.repsPicker);
        number.setMinValue(1);
        number.setMaxValue(30);
        number.setValue(10);
        number.setOnClickListener(this);
        */

        Reps = (EditText) findViewById(R.id.reps);
        Reps.setText("Repititioner");
        Reps.setSelectAllOnFocus(true);

        Weight = (EditText) findViewById(R.id.weight);
        Weight.setText("Vægt");
        Weight.setSelectAllOnFocus(true);

        videre = (Button) findViewById(R.id.doneButton);
        videre.setOnClickListener(this);
        videre.setText("Videre");

        list = (ListView) findViewById(R.id.list);
        listadapt = new OvelseAdapter(this);
        list.setAdapter(listadapt);

        ExerciseName = (TextView) findViewById(R.id.ExerciseName);
        ExerciseName.setTextSize(20);
        ExerciseName.setText(ovelseData.getNavn());

        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);


    }

    @Override
    public void onClick(View v) {
        if(v == videre){
            if(currentSet <= support.maxSet) {
                System.out.println("button pressed");
                support.setData(currentSet - 1, Integer.parseInt(Reps.getText().toString()), Integer.parseInt(Weight.getText().toString()));
                currentSet++;
                list.invalidateViews();
                list.refreshDrawableState();
            }
            else if(getIntent().getIntExtra("pos",0) < datafiles.getTræningsplan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().size() -1) {
                Intent i = new Intent(this, Ovelse.class);
                i.putExtra("pos", getIntent().getIntExtra("pos", 0) + 1);
                i.putExtra("workout", getIntent().getIntExtra("workout", 0));
                startActivity(i);
                ovelseData.setDone(1);
                finish();
            }
            else{
                finish();
            }
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

