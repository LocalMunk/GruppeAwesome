package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;

import junit.framework.Test;

/**
 * Created by frederik on 07-11-2016.
 */

public class Workout_frag extends Fragment implements OnItemClickListener {

    private ImageView graf;
    private Button work1, work2;
    private TestData data;


    private TextView virk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.workout_knapper, container, false);

        data = new TestData();
        graf = (ImageView) rod.findViewById(R.id.grafWorkout);


        //  data = {"Workout A: Ben ryg og biceps", "Workout A: Bryst skulder triceps og mave", "Workout B: Ben ryg og biceps", "Workout B: Bryst skulder triceps og mave"};

        ArrayAdapter adapter = new ArrayAdapter(getActivity(), R.layout.workout_liste, R.id.WorkoutOverskrift, data.getFisk()) {

            @Override
            public View getView(int position, View cachedView, ViewGroup parent) {

                View view = super.getView(position, cachedView, parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.beskrivelseTV);
                beskrivelse.setText("Jeg kan ikke vælge beskrivelsen her? (hvordan vælge billde " +
                        "spcifik til hvert objekt");



                return view;
            }


            //Programatisk layout
//        TableLayout tl = new TableLayout(getActivity());
//
//        virk = new TextView(getActivity());
//        virk.setText("Hej det her er nice");
//        virk.setTextSize(30);
//
//        tl.addView(virk);
//
//        return tl;
        };

        ListView workoutlist = new ListView(getActivity());
        workoutlist.setOnItemClickListener(this);
        workoutlist.setAdapter(adapter);
        return rod;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
