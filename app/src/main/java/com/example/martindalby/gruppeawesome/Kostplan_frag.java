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

import com.example.martindalby.gruppeawesome.DataFiles.MainController;


/**
 * Created by frederik on 07-11-2016.
 */

public class Kostplan_frag extends Fragment implements View.OnClickListener {

    private Button morgen,frokost,aften,snack;
    MainController datafiles;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rod = inflater.inflate(R.layout.kostplan_maaltider, container,false);
        datafiles = (MainController) getActivity().getIntent().getSerializableExtra("dataobjekt");

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

        if (v == morgen) {
            Intent i = new Intent(getActivity(), OpskriftListe.class);
            i.putExtra("type", morgen.getText().toString());
            //i.putExtra("dataobjekt", datafiles);
            startActivity(i);
        }

        if (v == frokost) {
            Intent i = new Intent(getActivity(), Opskrift.class);
            i.putExtra("type", frokost.getText().toString());
            //i.putExtra("dataobjekt", datafiles);
            startActivity(i);
        }

        if (v == aften) {
            Intent i = new Intent(getActivity(), Opskrift.class);
            i.putExtra("type", aften.getText().toString());
            //i.putExtra("dataobjekt", datafiles);
            startActivity(i);
        }

        if( v == snack) {
            Intent i = new Intent(getActivity(), Opskrift.class);
            i.putExtra("type", snack.getText().toString());
            //i.putExtra("dataobjekt", datafiles);
            startActivity(i);
        }

    }
}
