package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button knap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        knap = (Button) findViewById(R.id.button2);
        knap.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        if (v == knap) {
            Intent i = new Intent(this, OpskriftListe.class);
            startActivity(i);
        }

    }
}
