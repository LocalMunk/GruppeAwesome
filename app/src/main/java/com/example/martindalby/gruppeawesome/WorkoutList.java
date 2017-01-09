package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class WorkoutList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    String[] ovelser;
    int[] setsArray;
    WorkoutListAdapter adapter;
    ListView listView;
    Toolbar toolbar;
    MainController datafiles;
    WorkoutData workoutData;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        datafiles = MainController.getInstans();
        workoutData = datafiles.getTræningsplan().getWorkout(getIntent().getIntExtra("workout", 0));
        adapter = new WorkoutListAdapter(this);
        int i = getIntent().getIntExtra("workout", 0);
        listView = (ListView) findViewById(R.id.Ovelselistview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        System.out.println("1 check");


        toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle(workoutData.getWorkoutname());
        setSupportActionBar(toolbar);


    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Ovelse.class);
        i.putExtra("titles",ovelser);
        i.putExtra("sets",setsArray);
        i.putExtra("pos", position);
        i.putExtra("workout", getIntent().getIntExtra("workout", 0));

        startActivity(i);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.workoutlistmenu, menu);

        return true;


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)

    {    if(item.getItemId() == R.id.ooknap){
        Intent i = new Intent(this, OpretOvelse.class);
        startActivity(i);



    }
        return true;
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
            return workoutData.getOvelser().size();
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
            view = inflter.inflate(R.layout.ovelselist_element, null);

            TextView exerciseName = (TextView) view.findViewById(R.id.exercisename);
            exerciseName.setText(workoutData.getOvelser().get(position).getNavn());

            ImageView img = (ImageView) view.findViewById(R.id.ovelsebutton);
            if(workoutData.getOvelser().get(position).isDone() != 1){
                img.setImageResource(R.drawable.fluebengraa);
            }
            else{
                img.setImageResource(R.drawable.fluebenhvid);
            }
            return view;
        }
    }
}