package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.BaseAdapter;

import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

/**
 * Created by frederik on 07-11-2016.
 */

public class Workout_frag extends Fragment implements AdapterView.OnItemClickListener {

    GraphView graph;
    private Button work1, work2;
    private TestDataWorkout wdata;
    private TestDataOvelser odata;


    private TextView virk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.workout_knapper, container, false);
        int[] i = {R.drawable.pizzalistepic, R.drawable.grafbb};
        wdata = new TestDataWorkout();
        odata = new TestDataOvelser();

        graph = (GraphView) rod.findViewById(R.id.graph);
        LineGraphSeries<DataPoint> series = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3),
                new DataPoint(3, 2),
                new DataPoint(4, 6)
        });
        graph.addSeries(series);


        WorkoutAdapter adapter = new WorkoutAdapter(getActivity(), wdata.getWorkouts());

        ListView workoutlist = (ListView) rod.findViewById(R.id.workoutList);
        workoutlist.setOnItemClickListener(this);
        workoutlist.setAdapter(adapter);
        return rod;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(), WorkoutList.class);
        i.putExtra("workout", position);
        startActivity(i);

    }

    public class WorkoutAdapter extends BaseAdapter {
        Context context;
        int listimg[];
        TestDataWorkout[] data;
        LayoutInflater inflter;

        public WorkoutAdapter(Context applicationContext, TestDataWorkout[] datax) {

            this.context = applicationContext;
            this.data = data;
            //  this.listimg = ListImg;
            inflter = (LayoutInflater.from(applicationContext));

        }

        @Override
        public int getCount() {
            return wdata.getWorkouts().length;
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View view, ViewGroup viewGroup) {
            view = inflter.inflate(R.layout.workout_liste, null);


            TextView workoutoverskrift = (TextView) view.findViewById(R.id.WorkoutOverskrift);
            workoutoverskrift.setText(wdata.getWorkouts()[position].getOverskrift());

            TextView workoutbeskrivelser = ( TextView) view.findViewById(R.id.WorkoutBeskrivelse);
            workoutbeskrivelser.setText(wdata.getWorkouts()[position].getBeskrivelse());

            System.out.println(workoutoverskrift.getId());

            ImageView icon = (ImageView) view.findViewById(R.id.workoutImg);
            return view;
        }



    }

}
