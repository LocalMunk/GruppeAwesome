package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;


/**
 * Created by frederik on 07-11-2016.
 */

public class Kostplan_frag extends Fragment implements View.OnClickListener {

    private Button morgen,frokost,aften,snack;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.kostplan_maaltider, container,false);

        morgen = (Button) rod.findViewById(R.id.morgenmadKnap);
        morgen.setText("Morgenmad");

        frokost = (Button) rod.findViewById(R.id.frokostKnap);
        frokost.setText("Frokost");

        aften = (Button) rod.findViewById(R.id.aftensmadKnap);
        aften.setText("Aftensmad");

        snack = (Button) rod.findViewById(R.id.snackKnap);
        snack.setText("Snack");

        morgen.setOnClickListener(this);
        frokost.setOnClickListener(this);
        aften.setOnClickListener(this);
        snack.setOnClickListener(this);

        return rod;
    }

    @Override
    public void onClick(View v) {

        if( v == snack) {
            Intent i = new Intent(getActivity(), Opskrift.class);
            startActivity(i);
        }

    }
}
