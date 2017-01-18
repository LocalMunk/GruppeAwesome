package com.example.martindalby.gruppeawesome.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import com.crashlytics.android.Crashlytics;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.OvelseData;
import com.example.martindalby.gruppeawesome.DataFiles.TraeningsPlanData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;
import com.example.martindalby.gruppeawesome.Fragments.KostplanNotSub_frag;
import com.example.martindalby.gruppeawesome.Fragments.Kostplan_frag;
import com.example.martindalby.gruppeawesome.R;
import com.example.martindalby.gruppeawesome.Fragments.Workout_frag;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import io.fabric.sdk.android.Fabric;

public class Main_act extends AppCompatActivity /*implements View.OnClickListener*/ {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private MainController datafiles;
    private String currUser;
    static int workoutNum = 0;
    public SharedPreferences sharedPreferences;
    //private ViewPager viewPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main2);


        //midlertidig brugt til id reset
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);


        //henter bruger info
        currUser = sharedPreferences.getString("UserID", "fail");
        datafiles = MainController.getInstans();

        datafiles.getUserFromDatabase(currUser);

        toolbar = (Toolbar) findViewById(R.id.toolBar);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager2);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        setSupportActionBar(toolbar);


        final TabLayout.Tab workout=tabLayout.newTab();
        final TabLayout.Tab kostplan=tabLayout.newTab();

        workout.setIcon(R.drawable.exerciseiconwhite);
        kostplan.setIcon(R.drawable.foodicon_grey);

        //starter ikke med at sætte title til workouts??

        toolbar.setTitle(R.string.maintabworkout);
        tabLayout.addTab(workout, 0);
        tabLayout.addTab(kostplan, 1);

        tabLayout.setTabTextColors(ContextCompat.getColorStateList(this, R.color.tab_selector));
        tabLayout.setSelectedTabIndicatorColor(ContextCompat.getColor(this, R.color.indicate));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        workout.setIcon(R.drawable.exerciseiconwhite);
                        kostplan.setIcon(R.drawable.foodicon_grey);
                        toolbar.setTitle(R.string.maintabworkout);
                        break;
                    case 1:
                        workout.setIcon(R.drawable.exerciseicongrey);
                        kostplan.setIcon(R.drawable.foodicon_white);
                        toolbar.setTitle(R.string.maintabkostplan);
                        break;
                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
            }
            @Override
            public void onTabReselected(TabLayout.Tab tab) {
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        System.out.println("inde i onActivityResult i workout frag");
        System.out.println(datafiles.bruger.getTræningsPlan().getWorkouts());
        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);

    }

//    @Override hvad bliver der gjort her?
    public boolean onOptionItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    //Indre klasse
    private class ViewPagerAdapter extends FragmentPagerAdapter {

        public ViewPagerAdapter (FragmentManager fm) {
            super(fm);
        }

        //Titel på faner
        @Override
        public CharSequence getPageTitle(int position) {
           if (position == 0)
               return "Workout";
            else
               return "kostplan";
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            if (position == 0)
                f = new Workout_frag();
            else if (position == 2)
                f = new Workout_frag();
            //tjekker om du er subscriber eller ej, derudfra bestemmer kostplanview
            else {
                if (datafiles.bruger.getId().substring(0, 2).equals("FU")) f = new KostplanNotSub_frag();
                else f = new Kostplan_frag();
            }

            Bundle b = new Bundle();
            b.putInt("position", position);
            f.setArguments(b);

            return f;
        }

        //Antal faner???
        @Override
        public int getCount() {
            return 2;
        }
    }

}
