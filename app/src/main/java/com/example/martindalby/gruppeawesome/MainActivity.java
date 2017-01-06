package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import com.crashlytics.android.Crashlytics;
import com.example.martindalby.gruppeawesome.DataFiles.Bruger;
import com.example.martindalby.gruppeawesome.DataFiles.MainController;
import com.example.martindalby.gruppeawesome.DataFiles.UserWorkoutData;
import com.example.martindalby.gruppeawesome.DataFiles.WorkoutData;

import java.util.ArrayList;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private MainController datafiles;
    public SharedPreferences sharedPreferences;
    //private ViewPager viewPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main2);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);



        datafiles = MainController.getInstans();
        datafiles.testDataGenerator();

        toolbar = (Toolbar) findViewById(R.id.toolBar);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager2);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        setSupportActionBar(toolbar);
        final TabLayout.Tab workout=tabLayout
.newTab();
        final TabLayout.Tab kostplan=tabLayout.newTab();

        /*   Prøver at hente bruger ned fra databasen
        if(datafiles.bruger == null){
            datafiles.getUserFromDatabase(sharedPreferences.getString("UserID", "FAIL"));
            System.out.println("jeg kan sku ikke helt hente brugeren til dig");
        }
        else{
            System.out.println("Den er helt gal bro");
        }

        datafiles.bruger.id = sharedPreferences.getString("UserID", "FAIL");
        */


        //workout.setText("Workouts");
        //kostplan.setText("Kostplan");


        /*     LAVER EN TEST BRUGER TIL DATABASEN.
        ArrayList<String> ovelseids = new ArrayList<String>();
        ArrayList<String> ovelseids2 = new ArrayList<String>();
        ArrayList<String> ovelseids3 = new ArrayList<String>();
        ovelseids.add("0"); ovelseids.add("1"); ovelseids.add("2"); ovelseids.add("3");
        ovelseids2.add("4");ovelseids2.add("5");ovelseids2.add("6");
        ovelseids3.add("7");ovelseids3.add("8");ovelseids3.add("9");

        UserWorkoutData wod1 = new UserWorkoutData(ovelseids, "Workout A");
        UserWorkoutData wod2 = new UserWorkoutData(ovelseids2, "Workout B");
        UserWorkoutData wod3 = new UserWorkoutData(ovelseids3, "Workout C");

        ArrayList<UserWorkoutData> wod = new ArrayList<UserWorkoutData>();
        wod.add(wod1);wod.add(wod2);wod.add(wod3);

        ArrayList<String> retter = new ArrayList<String>();
        retter.add("0");retter.add("1");retter.add("2");retter.add("3");
        retter.add("4");retter.add("5");retter.add("6");retter.add("7");
        retter.add("8");retter.add("9");retter.add("10");retter.add("11");

        Bruger bob = new Bruger("Bob Nielsen testeren", wod, retter);
        datafiles.pushUser(bob);
        */







        workout.setIcon(R.drawable.exerciseiconwhite);
        kostplan.setIcon(R.drawable.foodicongrey);
        //starter ikke med at sætte title til workouts??
        toolbar.setTitle("Workouts");

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
                        kostplan.setIcon(R.drawable.foodicongrey);
                        toolbar.setTitle("Workouts");
                        break;
                    case 1:
                        workout.setIcon(R.drawable.exerciseicongrey);
                        kostplan.setIcon(R.drawable.foodiconwhite);
                        toolbar.setTitle("Kostplan");
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
               return "Kostplan";
        }

        @Override
        public Fragment getItem(int position) {
            Fragment f = null;
            if (position == 0)
                f = new Workout_frag();
            else if (position == 2)
                f = new Workout_frag();
            else
                f = new Kostplan_frag();

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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)

    {    if(item.getItemId() == R.id.action_plus){
        Intent i = new Intent(this, OpretWorkout.class);
        startActivity(i);



    }
        return true;
    }

    public void DBTestData () {

        //datafiles.getTræningsplan().

        //DBCon.getDBH().addOvelse();
    }


}
