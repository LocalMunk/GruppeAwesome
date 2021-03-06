package com.example.martindalby.gruppeawesome.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import com.example.martindalby.gruppeawesome.DataFiles.GrafData;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.SetData;
import com.example.martindalby.gruppeawesome.R;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

import java.util.ArrayList;


/**
 * Created by Martin Dalby on 14-11-2016.
 */

public class Ovelse_act extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemLongClickListener {

    Button videre;
    int currentSet;
    ListView list;
    OvelseAdapter listadapt;
    GraphView graph;
    FloatingActionButton fb;
    MainController datafiles;
    OvelseData ovelseData;
    NumberPicker num_weight,num_reps;
    Toolbar toolbar;
    TextView RepstextView, WeighttextView, RMtextView, textReps, textWeight;
    LineGraphSeries<DataPoint> series;


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_ovelse);
        datafiles = MainController.getInstans();
        ovelseData = datafiles.bruger.getTræningsPlan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().get(getIntent().getIntExtra("pos", 0));
        currentSet = 1;



        fb = (FloatingActionButton) findViewById(R.id.ovelsefloating);

        fb.setOnClickListener(this);


        videre = (Button) findViewById(R.id.doneButton);
        videre.setOnClickListener(this);
        videre.setText(R.string.NextOvelseText);

        list = (ListView) findViewById(R.id.list);
        listadapt = new OvelseAdapter(this);
        list.setAdapter(listadapt);
        list.setOnItemLongClickListener(this);

        RepstextView = (TextView) findViewById(R.id.RepstextView);
        RepstextView.setText(R.string.repetitionsText);

        WeighttextView = (TextView) findViewById(R.id.WeighttextView);
        WeighttextView.setText(R.string.WeightText);

        RMtextView = (TextView) findViewById(R.id.RMtextView);
        RMtextView.setText("1RM");



        toolbar = (Toolbar) findViewById(R.id.toolbar3);
        toolbar.setTitle(ovelseData.getNavn());
        toolbar.setTitleTextColor(getResources().getColor(R.color.indicate));
        setSupportActionBar(toolbar);

        graph = (GraphView) findViewById(R.id.graph);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setYAxisBoundsManual(true);
        //viser ikke alt data
        drawGraph();
    }

    //skulle måske gerne bruges??
    public boolean checkInput(String reps, String Weight){
        if(reps.length() == 0 || Weight.length() == 0){
            Toast.makeText(Ovelse_act.this, R.string.OvelseToastText,
                    Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }

    public void onDestroy(){
        super.onDestroy();

        datafiles.bruger.getTræningsPlan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().remove(getIntent().getIntExtra("pos", 0));
        datafiles.bruger.getTræningsPlan().getWorkout(getIntent().getIntExtra("workout", 0)).getOvelser().add(getIntent().getIntExtra("pos", 0), ovelseData);

        datafiles.pushUser();
    }

    @Override
    public void onClick(View v) {

    if(v==fb){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.MyDialogTheme);

        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.alertdialog_ovelsedata,null);

        textReps = (TextView)view.findViewById(R.id.textReps);
        textReps.setText(R.string.repetitionsText);
        textWeight = (TextView)view.findViewById(R.id.textWeight);
        textWeight.setText(R.string.WeightText);
        num_weight = (NumberPicker)view.findViewById(R.id.numweight);
        num_reps = (NumberPicker )view.findViewById(R.id.numreps);
        num_reps.setMinValue(1);
        num_reps.setMaxValue(20);
        num_weight.setMinValue(0);
        num_weight.setMaxValue(100);

        //dialog.setMessage("Intast vægt og reps");
        dialog.setTitle(R.string.addSetDataText);
        dialog.setPositiveButton(R.string.addSetDataOKButton, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                ovelseData.setDone(1);
                try {
                    ovelseData.getGraf().getSetDatas().add(new SetData(ovelseData.getGraf().getSetDatas().size(),
                            (double) num_reps.getValue(),
                            (double) num_weight.getValue()));
                }
                catch(NullPointerException e){
                    ovelseData.setGraf(new GrafData());
                    ovelseData.getGraf().setSetDatas(new ArrayList<SetData>());
                    ovelseData.getGraf().getSetDatas().add(new SetData(ovelseData.getGraf().getSetDatas().size(), (double) num_reps.getValue(), (double) num_weight.getValue()));

                }
                datafiles.pushUser();
                list.invalidateViews();
                list.refreshDrawableState();
                drawGraph();
            }
        });

        dialog.setNegativeButton(R.string.addSetDataNotOKButton, new DialogInterface.OnClickListener() {
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
                Intent i = new Intent(this, Ovelse_act.class);
                i.putExtra("pos", getIntent().getIntExtra("pos", 0) + 1);
                i.putExtra("workout", getIntent().getIntExtra("workout", 0));
                startActivity(i);
                finish();
            }
            else{
                setResult(RESULT_OK);
                finish();
            }
        }
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        AlertDialog.Builder dialog = new AlertDialog.Builder(this, R.style.MyDialogTheme);

        LayoutInflater inflater = getLayoutInflater();
        view = inflater.inflate(R.layout.alertdialog_ovelsedata,null);

        textReps = (TextView)view.findViewById(R.id.textReps);
        textReps.setText(R.string.repetitionsText);
        textWeight = (TextView)view.findViewById(R.id.textWeight);
        textWeight.setText(R.string.WeightText);
        num_weight = (NumberPicker)view.findViewById(R.id.numweight);
        num_reps = (NumberPicker )view.findViewById(R.id.numreps);
        num_reps.setMinValue(1);
        num_reps.setMaxValue(20);
        num_weight.setMinValue(0);
        num_weight.setMaxValue(100);

        dialog.setMessage(R.string.EditorDeleteSetLong);
        dialog.setTitle(R.string.EditOrDeleteSet);
        dialog.setPositiveButton(R.string.EditSetPositiveButton, new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                try {
                    ovelseData.getGraf().getSetDatas().set(ovelseData.getGraf().getSetDatas().size() - (position+1), new SetData(ovelseData.getGraf().getSetDatas().size() - (position+1), (double) num_reps.getValue(), (double) num_weight.getValue()));
                }
                catch(NullPointerException e){
                    //ovelseData.setGraf(new GrafData());
                    //ovelseData.getGraf().setSetDatas(new ArrayList<SetData>());
                    ovelseData.getGraf().getSetDatas().set(ovelseData.getGraf().getSetDatas().size() - (position+1), new SetData(ovelseData.getGraf().getSetDatas().size() - (position+1), (double) num_reps.getValue(), (double) num_weight.getValue()));
                }
                datafiles.pushUser();
                list.invalidateViews();
                list.refreshDrawableState();
                drawGraph();
            }
        });

        dialog.setNegativeButton(R.string.EditSetNegativeButton, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int whichButton) {
                ovelseData.getGraf().getSetDatas().remove(ovelseData.getGraf().getSetDatas().size() - (position+1));
                list.invalidateViews();
                list.refreshDrawableState();
                drawGraph();
            }
        });
        dialog.setView(view);
        dialog.show();
        return true;
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
            try {
                return getDataForListView().size();
            }
            catch(NullPointerException e){
                return 0;
            }
        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflter .inflate(R.layout.listelement_setdata, null);

            TextView listreps = (TextView) view.findViewById(R.id.listReps);
            TextView listweight = (TextView) view.findViewById(R.id.listWeight);
            TextView listRM = (TextView) view.findViewById(R.id.listRM);
            listreps.setText(Integer.toString((int) getDataForListView().get(getDataForListView().size()-(position+1)).getY()));
            listweight.setText(Integer.toString((int)getDataForListView().get(getDataForListView().size()-(position+1)).getZ()));
            listRM.setText(Integer.toString((int)datafiles.calculate1RM(getDataForListView().get(getDataForListView().size()-(position+1)).getY(),
                    getDataForListView().get(getDataForListView().size()-(position+1)).getZ())));
            return view;
        }

    }

    public ArrayList<SetData> getDataForListView(){
        try{
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
        }catch(Exception e){
            return null;
        }

    }


    public void drawGraph(){
        try {
            DataPoint[] toDraw = new DataPoint[ovelseData.getGraf().getSetDatas().size()];
            for (int i = 0; i < ovelseData.getGraf().getSetDatas().size(); i++) {
                toDraw[i] = new DataPoint((double) i, datafiles.calculate1RM(ovelseData.getGraf().getSetDatas().get(i).y, ovelseData.getGraf().getSetDatas().get(i).z));
            }
            graph.removeAllSeries();
            series = new LineGraphSeries<>(toDraw);
            graph.addSeries(series);

            graph.getViewport().setMinX(0);
            graph.getViewport().setMaxX(toDraw.length);

            graph.getViewport().setMinY(0);
            graph.getViewport().setMaxY(størst1RM() * 1.2);
        }
        catch(NullPointerException e){
            e.printStackTrace();
        }
    }

    public double størst1RM () {
        double num = 0;

        for (SetData data : ovelseData.getGraf().getSetDatas())
            if (datafiles.calculate1RM(data.getY(), data.getZ()) > num) {
                num = datafiles.calculate1RM(data.getY(), data.getZ());
            }
        return num;
    }
}

