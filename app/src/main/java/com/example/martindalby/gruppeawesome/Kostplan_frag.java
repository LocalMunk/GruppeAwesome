package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
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

    SharedPreferences sharedPreferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

           View rod = inflater.inflate(R.layout.kostplan_maaltider, container, false);


        datafiles = MainController.getInstans();

        //midlertidig til at reset login
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(getActivity());

        morgen = (Button) rod.findViewById(R.id.morgenmadKnap);
        morgen.setText("Morgenmad");
        morgen.setTextSize(20);

        frokost = (Button) rod.findViewById(R.id.frokostKnap);
        frokost.setText("Frokost");
        frokost.setTextSize(20);

        aften = (Button) rod.findViewById(R.id.aftensmadKnap);
        aften.setText("Aftensmad");
        aften.setTextSize(20);

        snack = (Button) rod.findViewById(R.id.snackKnap);
        snack.setText("Snack");
        snack.setTextSize(20);

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
            startActivity(i);
        }

        if (v == frokost) {
            Intent i = new Intent(getActivity(), OpskriftListe.class);
            i.putExtra("type", frokost.getText().toString());
            startActivity(i);
        }

        if (v == aften) {
            Intent i = new Intent(getActivity(), OpskriftListe.class);
            i.putExtra("type", aften.getText().toString());
            startActivity(i);
        }

        if( v == snack) {
            Intent i = new Intent(getActivity(), OpskriftListe.class);
            i.putExtra("type", snack.getText().toString());
            startActivity(i);
        }

    }
}
