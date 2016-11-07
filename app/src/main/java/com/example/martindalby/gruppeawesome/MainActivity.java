package com.example.martindalby.gruppeawesome;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener*/ {

//    private Button knap;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = new ViewPager(this);
        viewPager.setId(R.id.viewPager);
        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setPageTransformer(false,new ZoomOutPageTransformer());

        PagerSlidingTabStrip slideStrip = new PagerSlidingTabStrip(this);
        slideStrip.setViewPager(viewPager);

        LinearLayout ll = new LinearLayout(this);
        ll.setOrientation(LinearLayout.VERTICAL);
        ll.addView(slideStrip);
        ll.addView(viewPager);
        ((LinearLayout.LayoutParams) viewPager.getLayoutParams()).weight = 1;
        setContentView(ll);

        setTitle("Body Book");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
}
