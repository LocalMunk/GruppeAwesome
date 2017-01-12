package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.SetData;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;
import java.util.Set;


/**
 * Created by Martin Dalby on 14-11-2016.
 */

public class Ovelse extends AppCompatActivity implements View.OnClickListener {

    Button videre;
    int currentSet;
    ListView list;
    TextView ExerciseName;
    OvelseAdapter listadapt;
    GraphView graph;
    FloatingActionButton fb;
    MainController datafiles;
    OvelseData ovelseData;
    NumberPicker num_weight,num_reps;

//    Toolbar toolbar;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ovelse);
        datafiles = MainController.getInstans();
        ovelseData = datafiles.bruger.getTræningsPlan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().get(getIntent().getIntExtra("pos", 0));
        currentSet = 1;
        String[] suppdata = new String[ovelseData.getSets()];
        for(int i = 0; i < ovelseData.getSets(); i++){
            suppdata[i] = "Sæt " + (i+1) + ": ";
        }

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
        fb = (FloatingActionButton) findViewById(R.id.ovelsefloating);

        fb.setOnClickListener(this);

        videre = (Button) findViewById(R.id.doneButton);
        videre.setOnClickListener(this);
        videre.setText("Næste øvelse");

        list = (ListView) findViewById(R.id.list);
        listadapt = new OvelseAdapter(this);
        list.setAdapter(listadapt);

        ExerciseName = (TextView) findViewById(R.id.ExerciseName);
        ExerciseName.setTextSize(20);
        ExerciseName.setText(ovelseData.getNavn());



      //  toolbar = (Toolbar) findViewById(R.id.toolBar);
      //  toolbar.setTitle(ovelseData.getNavn());
       // setSupportActionBar(toolbar);


        DataPoint[] toDraw = new DataPoint[ovelseData.getGraf().getSetDatas().size()];
        for (int i = 0; i < ovelseData.getGraf().getSetDatas().size(); i++){
            toDraw[i] = new DataPoint((double) i, datafiles.calculate1RM(ovelseData.getGraf().getSetDatas().get(i).y, ovelseData.getGraf().getSetDatas().get(i).z));
        }
        graph = (GraphView) findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(toDraw);
        graph.addSeries(series);


    }


    public boolean checkInput(String reps, String Weight){
        if(reps.length() == 0 || Weight.length() == 0){
            Toast.makeText(Ovelse.this, "Udfyld repetitioner og vægt",
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }




    @Override
    public void onClick(View v) {

    if(v==fb){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.MyDialogTheme);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.activity_alertdialog_ovelsedata,null);

        num_weight = (NumberPicker)view.findViewById(R.id.numweight);
        num_reps = (NumberPicker )view.findViewById(R.id.numreps);
        num_reps.setMinValue(1);
        num_reps.setMaxValue(20);
        num_weight.setMinValue(0);
        num_weight.setMaxValue(100);

        //LayoutInflater li = LayoutInflater.from(this);
        //View dialogView = li.inflate(R.layout.opretworkoutdialog, null);

        dialog.setMessage("Intast vægt og reps");
        dialog.setTitle("Indtast øvelsesdata");
        dialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {

                ovelseData.getGraf().getSetDatas().add(new SetData(ovelseData.getGraf().getSetDatas().size(), (double)num_reps.getValue(), (double)num_weight.getValue()));
                //support.setData(currentSet-1,num_reps.getValue(),num_weight.getValue());
                currentSet++;

                list.invalidateViews();
                list.refreshDrawableState();
            }
        });

        dialog.setNegativeButton("Anullér", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                dialog.dismiss();
            }
        });
        dialog.setView(view);
        dialog.show();

    }
        if(v == videre){

            if(getIntent().getIntExtra("pos",0) < datafiles.bruger.getTræningsPlan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().size() -1) {
                Intent i = new Intent(this, Ovelse.class);
                i.putExtra("pos", getIntent().getIntExtra("pos", 0) + 1);
                i.putExtra("workout", getIntent().getIntExtra("workout", 0));
                startActivity(i);
                ovelseData.setDone(1);
                finish();
            }
            else if(currentSet > ovelseData.getSets()){
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
            return getDataForListView().size();
        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflter .inflate(R.layout.ovelse_list, null);

            TextView text = (TextView) view.findViewById(R.id.ovelselisttext);
            text.setText("Reps: " + (int)getDataForListView().get(position).getY() +
                    " Vægt: " + (int)getDataForListView().get(position).getZ() +
                    " 1RM: " + (int)datafiles.calculate1RM(getDataForListView().get(position).getY(),getDataForListView().get(position).getZ()));
            return view;
        }

    }

    public ArrayList<SetData> getDataForListView(){
        if(ovelseData.getGraf().getSetDatas().size() <=10){
            return ovelseData.getGraf().getSetDatas();
        }
        else{
            ArrayList out = new ArrayList<SetData>();
            for(int i = ovelseData.getGraf().getSetDatas().size() -10;
                    i < ovelseData.getGraf().getSetDatas().size();
                    i++){
                out.add(ovelseData.getGraf().getSetDatas().get(i));
            }
            return  out;
        }
    }
}

