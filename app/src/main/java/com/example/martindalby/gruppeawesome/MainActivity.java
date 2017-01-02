package com.example.martindalby.gruppeawesome;

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
import com.example.martindalby.gruppeawesome.DataFiles.MainController;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    MainController datafiles;


    //private ViewPager viewPagers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main2);

        datafiles = new MainController();

        toolbar = (Toolbar) findViewById(R.id.toolBar);

        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        viewPager = (ViewPager) findViewById(R.id.viewPager2);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        setSupportActionBar(toolbar);
        final TabLayout.Tab workout=tabLayout
.newTab();
        final TabLayout.Tab kostplan=tabLayout.newTab();

        //workout.setText("Workouts");
        //kostplan.setText("Kostplan");

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




    }
        return true;
    }
}
