package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

/**
 * Created by frederik on 07-11-2016.
 */

public class Workout_frag extends Fragment implements View.OnClickListener{

    private ImageView graf;
    private Button work1, work2;

    private TextView virk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.workout_knapper, container,false);

        graf = (ImageView) rod.findViewById(R.id.grafWorkout);

        work1 = (Button) rod.findViewById(R.id.work1);
        work1.setText("Workout A");

        work2 = (Button) rod.findViewById(R.id.work2);
        work2.setText("Workout B");

        work1.setOnClickListener(this);
        work2.setOnClickListener(this);

        return rod;

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
    }


    @Override
    public void onClick(View v) {



    }
}
