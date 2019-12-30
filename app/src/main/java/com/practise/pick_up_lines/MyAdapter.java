package com.practise.pick_up_lines;

import android.app.FragmentManager;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class MyAdapter extends FragmentStatePagerAdapter {

    FragmentManager fragmentManager;
    int number;



    public MyAdapter(@NonNull androidx.fragment.app.FragmentManager fm, int behavior, int number) {
        super(fm, behavior);
        this.number = number;
    }


    @Override
    public int getCount() {
        return number;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ArrayListFragment.newInstance(position);
    }

}
