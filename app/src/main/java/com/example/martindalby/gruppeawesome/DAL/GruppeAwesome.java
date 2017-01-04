package com.example.martindalby.gruppeawesome.DAL;

import android.app.Application;

import com.firebase.client.Firebase;


/**
 * Created by frederik on 04-01-2017.
 */

public class GruppeAwesome extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Firebase.setAndroidContext(this);

    }
}
