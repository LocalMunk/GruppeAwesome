package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.content.Intent;
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

/**
 * Created by frederik on 07-11-2016.
 */

public class Workout_frag extends Fragment implements AdapterView.OnItemClickListener {

    private ImageView graf;
    private Button work1, work2;
    private TestDataWorkout testdata;

    private TextView virk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.workout_knapper, container, false);
        int[] i = {R.drawable.pizzalistepic, R.drawable.grafbb};
        testdata = new TestDataWorkout();
        graf = (ImageView) rod.findViewById(R.id.grafWorkout);


        //  data = {"Workout A: Ben ryg og biceps", "Workout A: Bryst skulder triceps og mave", "Workout B: Ben ryg og biceps", "Workout B: Bryst skulder triceps og mave"};

        WorkoutAdapter adapter = new WorkoutAdapter(getActivity(), testdata.getdata());
        //  ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.workout_liste, R.id.WorkoutOverskrift, testdata.getFisk()) {


        ListView workoutlist = (ListView) rod.findViewById(R.id.workoutList);
        workoutlist.setOnItemClickListener(this);
        workoutlist.setAdapter(adapter);
        return rod;

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent i = new Intent(getActivity(),WorkoutList.class);
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
            return testdata.getWorkouts().length;
        }
//banan
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
            workoutoverskrift.setText(testdata.getWorkouts()[position].getOverskrift());
            TextView workoutbeskrivelser = ( TextView) view.findViewById(R.id.WorkoutBeskrivelse);
            workoutbeskrivelser.setText(testdata.getWorkouts()[position].getBeskrivelse());

            System.out.println(workoutoverskrift.getId());

            ImageView icon = (ImageView) view.findViewById(R.id.workoutImg);
            return view;
        }



    }

}
