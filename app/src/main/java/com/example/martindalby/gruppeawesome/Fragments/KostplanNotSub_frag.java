package com.example.martindalby.gruppeawesome.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.R;


public class KostplanNotSub_frag extends Fragment implements View.OnClickListener {

    private Button kostplan;
    private TextView funk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rod = inflater.inflate(R.layout.kostplan_ikkesub, container, false);

        funk = (TextView) rod.findViewById(R.id.ikkeadgang);
        funk.setText(R.string.cantAccessText);

        kostplan = (Button) rod.findViewById(R.id.faaKostplan);
        kostplan.setOnClickListener(this);
        kostplan.setText(R.string.getKostplanButton);

        return rod;
    }

    @Override
    public void onClick(View v) {
        Uri uri = Uri.parse("http:www.bepeaked.com/videre/");
        Intent i = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(i);
    }
}
