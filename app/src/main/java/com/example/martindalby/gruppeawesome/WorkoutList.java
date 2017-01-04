package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Button;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class WorkoutList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] ovelser;
    int[] setsArray;
    WorkoutListAdapter adapter;
    TestDataWorkout wdata;
    ListView listView;
    Toolbar toolbar;
    MainController datafiles;
    WorkoutData workoutData;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        datafiles = MainController.getInstans();
        workoutData = datafiles.getTræningsplan().getWorkout(getIntent().getIntExtra("workout", 0));
        wdata = new TestDataWorkout();
        adapter = new WorkoutListAdapter(this);
        int i = getIntent().getIntExtra("workout", 0);
        ovelser = wdata.getOdataOverskrift(i);
        setsArray = wdata.getOdataSets(i);
        listView = (ListView) findViewById(R.id.Ovelselistview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        System.out.println("1 check");

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(getIntent().getStringExtra("title"));
        toolbar.setNavigationIcon(R.drawable.icaddwhite);

    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Ovelse.class);
        i.putExtra("titles",ovelser);
        i.putExtra("sets",setsArray);
        i.putExtra("pos", position);
        i.putExtra("workout", getIntent().getIntExtra("workout", 0));
        startActivity(i);
    }

    public class WorkoutListAdapter extends BaseAdapter {
        Context context;
        LayoutInflater inflter;

        public WorkoutListAdapter(Context applicationContext) {

            this.context = applicationContext;
            //  this.listimg = ListImg;
            inflter = (LayoutInflater.from(applicationContext));
            System.out.println("check 2");


        }

        //Her afgøres længde på liste ud fra hvilken knap man trykker paa
        @Override
        public int getCount() {
            return ovelser.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        } //bruges ikke

        @Override
        public long getItemId(int position) {
            return 0;
        } //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflter.inflate(R.layout.workoutlist_list, null);

            TextView exerciseName = (TextView) view.findViewById(R.id.exercisename);
            exerciseName.setText(ovelser[position]);

            ImageView img = (ImageView) view.findViewById(R.id.ovelsebutton);
            return view;
        }

    }
}
