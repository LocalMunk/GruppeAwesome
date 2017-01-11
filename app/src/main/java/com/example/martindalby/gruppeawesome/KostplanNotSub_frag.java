package com.example.martindalby.gruppeawesome;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.martindalby.gruppeawesome.DataFiles.MainController;


public class KostplanNotSub_frag extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


           View rod = inflater.inflate(R.layout.kostplan_ikkesub, container, false);



        return rod;
    }


}
