package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Martin Dalby on 17-11-2016.
 */

public class WorkoutList extends AppCompatActivity implements AdapterView.OnItemClickListener {

    TestDataOvelser data;
    WorkoutListAdapter adapter;
    ListView listView;

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_workoutlist);
        data = new TestDataOvelser();
        adapter = new WorkoutListAdapter(this);

        listView = (ListView) findViewById(R.id.Ovelselistview);
        listView.setOnItemClickListener(this);
        listView.setAdapter(adapter);
        System.out.println("1 check");
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(this, Ovelse.class);
        i.putExtra(data.getOvelser()[position].getOverskrift(), data.getOvelser()[position].getsets());
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
            return data.getOvelser().length;
        }
        @Override
        public Object getItem(int position) {return null;} //bruges ikke
        @Override
        public long getItemId(int position) {return 0;} //bruges ikke

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            view = inflter.inflate(R.layout.workoutlist_list, null);

            TextView exerciseName = (TextView) view.findViewById(R.id.exercisename);
            exerciseName.setText(data.getOvelser()[position].getOverskrift());

            TextView sets = (TextView) findViewById(R.id.setsview);
            sets.setText(data.getOvelser()[position].getsets() + " sets");

            ImageView img = (ImageView) findViewById(R.id.ovelsebutton);
            return view;
        }

    }
}
