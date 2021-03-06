package com.example.martindalby.gruppeawesome;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.martindalby.gruppeawesome.Fragments.Kostplan_frag;
import com.example.martindalby.gruppeawesome.Fragments.Workout_frag;

/**
 * Created by frederik on 16-11-2016.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
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

    @Override
    public int getCount() {
        return 2;
    }
}
