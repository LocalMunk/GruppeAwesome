package com.example.martindalby.gruppeawesome;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import junit.framework.Test;

/**
 * Created by frederik on 17-11-2016.
 */

public class OpskriftSupport {

    //Soerger for den korrekte liste bliver vist ud fra hvilken maaltidsknap der vaelges
    public void alternativListe (String str, View view, TestDataMad data, int position) {

        TextView overskrift = (TextView) view.findViewById(R.id.overskriftTV);
        TextView beskrivelse = (TextView) view.findViewById(R.id.beskrivelseTV);
        ImageView icon = (ImageView) view.findViewById(R.id.listeImg);

        if(str.equals("Aftensmad")) {
            overskrift.setText(data.getAftensmad()[position].getOverskrift());
            beskrivelse.setText(data.getAftensmad()[position].getBeskrivelse());
            icon.setImageResource(R.drawable.pizzalistepic);
        }
        if(str.equals("Frokost")) {
            overskrift.setText(data.getFrokost()[position].getOverskrift());
            beskrivelse.setText(data.getFrokost()[position].getBeskrivelse());
            icon.setImageResource(R.drawable.pizzalistepic);
        }
        if(str.equals("Morgenmad")) {
            overskrift.setText(data.getMorgenmad()[position].getOverskrift());
            beskrivelse.setText(data.getMorgenmad()[position].getBeskrivelse());
            icon.setImageResource(R.drawable.morgenmad);
        }
        if(str.equals("Snack")) {
            overskrift.setText(data.getSnack()[position].getOverskrift());
            beskrivelse.setText(data.getSnack()[position].getBeskrivelse());
            icon.setImageResource(R.drawable.foodicon_grey);
        }
    }

    //Afgoerer længde på opskriftliste
    public int maaltidLaengde(TestDataMad data, String str) {
        int i =0;
        if(str.equals("Morgenmad")) {
            i = data.getMorgenmad().length;
            System.out.println("Morgenmad længdre: " + i);
        }else if (str.equals("Frokost")) {
            i = data.getFrokost().length;
            System.out.println("Frokost længdre: " + i);
        }else if (str.equals("Aftensmad")) {
            i = data.getAftensmad().length;
            System.out.println("Aftensmad længdre: " + i);
        }else if (str.equals("Snack")){
            i = data.getSnack().length; //snack
        }
        return i;
    }

    public TestDataMad randomRet (String type, TestDataMad data) {
        TestDataMad mad = null;
        int i = maaltidLaengde(data, type);

        if (type.equals("Morgenmad")) {
            mad = data.getMorgenmad()[(int) Math.floor(Math.random() * i)];
            System.out.println("længde på array: " + (int) Math.floor(Math.random() * i));
        }
        else if (type.equals("Frokost")) {
            mad = data.getFrokost()[(int) Math.floor(Math.random() * i)];
            System.out.println("længde på array: " + (int) Math.floor(Math.random() * i));
        }
        else if (type.equals("Aftensmad")) {
            mad = data.getAftensmad()[(int) Math.floor(Math.random() * i)];
            System.out.println("længde på array: " + (int) Math.floor(Math.random() * i));
        }
        else {
            mad = data.getSnack()[(int) Math.floor(Math.random() * i)];
            System.out.println("længde på array: " + (int) Math.floor(Math.random() * i));
        }
        System.out.println("random mad " + mad.getOverskrift());
        return mad;
    }
}
