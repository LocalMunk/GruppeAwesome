package com.example.martindalby.gruppeawesome;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OpskriftListe extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        TestData[] data = new TestData[]{
                new TestData("Pizza", "Denne ret smager godt"),
                new TestData("Æggemad", "En lækker mad med æd... og brød"),
                new TestData("Fisk", "Det er godt med fisk"),
                new TestData("Æg", "Lidt af det gode"),
                new TestData("Burger", "kød og kød og kød og kød..."),
                new TestData("Salat", "Jk det er salat... med kød istedet for salat #Prot"),

        };




        setContentView(R.layout.activity_opskrift_liste);
    }
}
