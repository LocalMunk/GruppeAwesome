package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

        return rod;

        String[] data = {"Workout A: Ben ryg og biceps", "Workout A: Bryst skulder triceps og mave", "Workout B: Ben ryg og biceps", "Workout B: Bryst skulder triceps og mave"};

        ArrayAdapter adapter = new ArrayAdapter(this, R.id.activity_opskrift_liste,
                , data) {

            @Override
            public View getView (int position, View cachedView, ViewGroup parent) {

                View view = super.getView(position, cachedView,parent);

                TextView beskrivelse = (TextView) view.findViewById(R.id.beskrivelseTV);
                beskrivelse.setText("Jeg kan ikke vælge beskrivelsen her? (hvordan vælge billde " +
                        "spcifik til hvert objekt");

                ImageView billede = (ImageView) view.findViewById(R.id.listeImg);
                billede.setImageResource(R.drawable.pizzalistepic);

                return view;
            }

        };


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
